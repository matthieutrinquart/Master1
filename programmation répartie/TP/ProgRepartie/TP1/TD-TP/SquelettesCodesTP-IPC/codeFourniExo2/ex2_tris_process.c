#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdlib.h>
#include "calcul.h"
#include <time.h>    // time()

/*
 exemple de cr�taion d'un tableau de s�maphores, dont le nombre
 d'�l�ments et la valeur initiale est pass�e en param�tre du
 programme (dans cet exemple, les �lements sont initialis�s � la m�me valeur)

 */

int main(int argc, char * argv[]){

  if (argc!=3) {
    printf("Nbre d'args invalide, utilisation :\n");
    printf("%s fichier-pour-cle-ipc entier-pour-clé-ipc \n", argv[0]);
    exit(0);
  }

  //Creation du sémaphore unique

  int clesem = ftok(argv[1], atoi(argv[2]));

  int idSem = semget(clesem, 1, 0600);

  if(idSem == -1){
    perror("erreur semget : ");
    exit(-1);
  }

  printf("sem id : %d \n", idSem);

  union semun{
    int val;
    struct semid_ds * buf;
    ushort * array;
  } valinit;

  /* test affichage valeurs des sémaphores du tableau */
  valinit.array = (ushort*)malloc(1 * sizeof(ushort)); // pour montrer qu'on r�cup�re bien un nouveau tableau dans la suite
  if (semctl(idSem, 1, GETALL, valinit) == -1){
    perror("erreur initialisation sem : ");
    exit(1);
  }

  printf("Valeurs du sempahore apres démarrage : ");
  printf("%d\n", valinit.array[0]);

  /*---------------------------------------------------------------------------------------
  On a deux manières de procéder, dans tout les cas il faut créer nos opérations P, V et Z
  ----------------------------------------------------------------------------------------*/

  //Méthode 1 : On déclare chaque opération séparément et proprement

  //Opération P, on demande un jeton, et on reste en attente d'un jeton libre
  //Déclare une structure de fonction de sémaphore, ici P
  struct sembuf opp;
  // TODO : POURQUOI 0 ?
  opp.sem_num=0;
  //Quand on envois -1, on tente de décrémenter le sémaphore de 1, donc de prendre un jeton
  opp.sem_op=-1;
  //Flags optionnels cf http://manpagesfr.free.fr/man/man2/semop.2.html, ici rien du tout
  opp.sem_flg=0;

  //Opération V, on rends un jeton au sémaphore, et par propagation, réveille les programme en attente d'un jeton
  struct sembuf opv;
  opv.sem_num=0;
  opv.sem_op=+1; //On mets + explicitement pour bien montrer qu'on ajoute un jeton
  opv.sem_flg=0;

  //Opération Z, on attends que le sémaphore soit à 0 pour continuer l'exécution du programme
  struct sembuf opz;
  opz.sem_num=0;
  opz.sem_op=0; //Avec 0 on bloque le programme jusqu'à ce que le sémaphore soit à 0
  opz.sem_flg=0;

  //Méthode 2 : On réduit nos déclarations en faisant un tableau de sembuf et en utilisant l'ordre des propriétés plutôt que les spécifier explicitement
  struct sembuf op[]={
    {(u_short)0,(short)-1,0}, //P : Demande jeton
    {(u_short)0,(short)+1,0}, //V : Rends jeton
    {(u_short)0,(short)0,0}   //Z : Attends sémaphore à 0
  };

  //On simule un calcul de temps aléatoire
  srand(time(NULL));
  int r = 1 + rand()%5; //Entier entre 1 et 5
  calcul(r);

  //Une fois que notre fonction fini son exécution, on veut attendre que les autres "threads" soient aussi terminé
  //On fait donc l'opération P pour prendre un jeton et dire qu'on a fini
  semop(idSem,&opp,1); //OU semop(idSem, op, 1); avec la méthode 2
  if (semctl(idSem, 1, GETALL, valinit) == -1){
    perror("erreur initialisation sem : ");
    exit(1);
  }

  printf("Valeurs du sempahore apres démarrage : ");
  printf("%d\n", valinit.array[0]);

  //Puis on se mets en attente avec Z pour se synchroniser
  printf("J'attends mes collègues\n");
  semop(idSem,&opz,1);

  //Le programme s'est débloqué, on peut le terminer
  printf("C'est fini\n");

  return 0;
}
