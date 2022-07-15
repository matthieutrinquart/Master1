#include <iostream>
#include <sys/types.h>
#include <pthread.h>
#include <unistd.h>
#include "calcul.h"

struct predicatRdv {

  // regroupes les données partagées entres les threads participants aux RdV :

  int threadsRemaining;
  int nbThreads;
  pthread_mutex_t lock;
  pthread_cond_t cond;
};

struct params {

  // structure pour regrouper les paramètres d'un thread.

  int idThread; // un identifiant de thread, de 1 à N (N le nombre
		// total de theads secondaires
  struct predicatRdv * varPartagee;


};

// fonction associée a chaque thread participant au RdV.

void * participant (void * p){

  struct params * args = (struct params *) p;
  struct predicatRdv * predicat = args -> varPartagee;
  ...

  // simulation d'un long calcul pour le travail avant RdV
  calcul(args -> idThread + rand() % 10); // c'est un exemple.

  // RdV
  //On demande a modifier threadsRemaining
  pthread_mutex_lock(&predicat->lock);
  predicat->threadsRemaining -= 1;
  int thRemain = predicat->threadsRemaining;
  pthread_mutex_unlock(&predicat->lock);


  while (thRemain>0) {  // attention : le dernier arriv� ne doit pas attendre. Il doit r�veiller tous les autres.
    pthread_cond_wait(&predicat->cond);
    pthread_mutex_lock(&predicat->lock);
    thRemain = predicat;
    pthread_mutex_unlock(&predicat->lock);
  }


  ...
  calcul ( ...); // reprise et poursuite de l'execution.


  ...
  pthread_exit(NULL); // fortement recommand�.
}




int main(int argc, char * argv[]){

  if (argc!=2) {
    cout << " argument requis " << endl;
    cout << "./prog nombre_Threads" << endl;
    exit(1);
  }


  // initialisations
  int nbThreads = atoi(argv[1]);
  pthread_t threads[nbThreads];
  struct params tabParams[nbThreads];

  struct varPartagee vp;
  vp.threadsRemaining = nbThreads;
  vp.nbThreads = nbThreads;
  pthread_mutex_init(vp.lock, NULL);
  vp.cond = PHTREAD_COND_INITIALIZER;

  srand(nbThreads);  // initialisation de rand pour la simulation de longs calculs

  // création des threads
  for (int i = 0; i < atoi(argv[1]); i++){
    tabParams[i].idThread = i;
    tabParams[i].varPartagee = &vp;

    if (pthread_create(&threads[i], NULL, participant, &tabParams[i]) != 0){
      perror("erreur creation thread");
      exit(1);
    }
  }

  // attente de la fin des  threards. Partie obligatoire
  for (int i = 0; i < atoi(argv[1]); i++){
    pthread_join(&threads[i], NULL);
    }
  cout << "thread principal : fin de tous les threads secondaires" << endl;

  // terminer "proprement".
  if(pthread_cond_destroy(vp.cond)!=0) {
    perror("erreur destruction cond");
    exit(1);
  }

}
