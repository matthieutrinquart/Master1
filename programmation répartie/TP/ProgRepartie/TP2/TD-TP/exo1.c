#include <string.h>
#include <stdio.h>//perror
#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
#include <iostream>
#include <pthread.h>

#include "calcul.h"


//Structure globale pour le passage de paramètres
struct paramsFonctionThread {
  //Pas le PID, mais un indice donné arbitrairement (thread 1, 2, 3, etc...)
  int idThread;

  // si d'autres paramètres, les ajouter ici.

};

//Tjrs void * avec void * params pour création de thread
void * fonctionThread (void * params){

  //On cast notre params dans la bonne structure, et puis on lui donne une nouvelle variable pour y accéder
  struct paramsFonctionThread * args = (struct paramsFonctionThread *) params;

  //Affichage du PID et de l'identifiant donné plus tôt manuellement (de 0 à nbThreads)
  printf("monThread : %li\n", pthread_self());
  printf("idThread : %i\n", args->idThread);

  //Simulation d'une fonction longue et affichage de chaque tour de boucle
  for(int i=0; i<3; i++) {
    printf("Compteur : %i\n", i);
    calcul(0.1);
  }

  //Préviens le processus principal que le thread est terminé
  pthread_exit(NULL);
}

/*
* Sur l'exemple : ./monProg file.txt 23 -h
* argc : entier donnant le nombre de paramètres invoqués (ici 4, la commande du prog compte)
* argv[] : tableau de String contenant les paramètres ici :
* {"monProg", "file.txt", "23", "-h"}
*/
int main(int argc, char * argv[]){

  if (argc < 2 ){
    printf("utilisation: %s  nombre_threads  \n", argv[0]);
    return 1;
  }

  //Transformation du nombre de threads de string à int
  int nbThreads = atoi(argv[1]);

  //Tableau du nombre de threads à créer
  //Initialise automatiquement un PID non utilisé
  pthread_t threads[nbThreads];

  // Solution 1 pour passer des paramètres à notre thread, tout en s'assurant que chaque thread recoivent bien le paramètre dédiée
  // struct paramsFonctionThread* listeParam[atoi(argv[1])];
  // for(int i=0; i<atoi(argv[1]); i++) {
  //   listeParam[i] = (paramsFonctionThread*) malloc(sizeof(paramsFonctionThread));
  //   listeParam[i]->idThread = i;
  // }

  // Solution 2 : Plus jolie, plus courte
  // Idée : On déclare une zone de mémoire partagée contenant l'identifiant d'un thread défini plus bas
  // Le problème c'est que si un thread mets du temps à se lancer, alors la boucle de création des threads passera à l'instruction suivante et mettra à jour l'identifiant du thread
  // Pour régler ça, on fait un tableau de nos structures paramètres avec une variable unique pour chaque thread
  // Par ailleurs on la définit en dehors de la boucle pour qu'elle soit persistente
  struct paramsFonctionThread p[nbThreads];

  //Création des threads
  for (int i = 0; i < nbThreads; i++){
    // Le passage de paramétre est fortement conseillé (éviter les
    // variables globles).

    // On donne un identifiant manuel à notre thread
    p[i].idThread = i;

    //On crée le thread avec nos paramètres en prenant bien la bonne structure du tableau de paramètres
    if (pthread_create(&threads[i], NULL, fonctionThread, (void*) &p[i]) != 0){
      perror("erreur creation thread");
      exit(1);
    }
  }

  //pthread_join attends que le pthread_exit() d'un thread soit invoqué, indiquant donc la fin d'un thread
  //L'appel est bloquant, le programme ne continue pas du temps que le thread désigné n'est pas terminé
  //Ainsi pour tout nos threads crées on se mets en attente de la fin de leur exécution
  //Note : On utilise aussi pthread_join pour récupérer une valeur de retour si elle est autre que NULL (via un pointeur)
  for(int i = 0; i<nbThreads; i++) {
    if(pthread_join(threads[i], NULL) != 0) {
      perror("erreur join thread");
      exit(1);
    };
  }

  printf("All threads are finished");
  //Q1 : Pour avoir une exécution parallèle on utilise pthread. (Si on doit découper 4 légumes et qu'on a 4 personnes, plutôt que de dire à une personne de découper chaque légumes un par un, on dit aux 4 personnes de découper 1 légumes)
  //Q2 : Si la tâche principale se termine sans attendre, comme pthread_create n'est pas bloquant, les threads vont s'éxecuter et pendant ce temps là le programme principal va aussi poursuivre son exécution, ainsi si on arrive à la fin du programme principal, les threads non terminés seront tués avant la fin de leur exécution car ils dépendent du parent.
  //Q3 : Si une des tâches (thread) fait appel à exit() alors tout le programme s'arrête (tout les threads, et le programme principal)
  //Q4 : C'est le problème avec le passage de paramètres à un thread, prenons l'exemple suivant :
  /* monThread(param) {
    attendre 10 secondes
    afficher(param)
  }

  int p;

  for(int i = 0; i<10; i++) {
    p = i;
    create_thread(mon_thread, &p)
  }
  * Ici on crée 10 threads, numérotés de 0 à 9 par p, qui prends la valeur de i pour chaque tour de boucle
  * Comme on utilise nécessairement un pointeur, chaque changement de p est répercuté dans toutes les fonctions qui utilisent p
  * Le thread numéro va se créer, attendre 10 secondes puis afficher p, son identifiant, sauf que pendant ce temps, la boucle de création de threads a continuer de s'éxécuter, et maintenant p vaut 9, alors qu'on voulait 1
  * SOLUTION : On crée un tableau d'entier de taille 10, puis on passe tableau[i] à nos threads, comme ça on est sûr de ne pas avoir la mauvaise valeur.
  */
  //Q5 : Oui, il faudra s'assurer que tout les threads soient terminés pour terminer le programme principal (avec pthread_join donc).
  return 0;

}
