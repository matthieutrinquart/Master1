#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdlib.h>
#include <pthread.h>
/*
 exemple de cr�taion d'un tableau de s�maphores, dont le nombre
 d'�l�ments et la valeur initiale est pass�e en param�tre du
 programme (dans cet exemple, les �lements sont initialis�s � la m�me valeur)

 */

int main(int argc, char * argv[]){

  if (argc!=4) {
    printf("Nbre d'args invalide, utilisation :\n");
    printf("%s fichier-pour-cle-ipc entier-pour-clé-ipc nombre-processus\n", argv[0]);
    exit(0);
  }

  //Creation du sémaphore unique

  int clesem = ftok(argv[1], atoi(argv[2]));

  int idSem=semget(clesem, 1, IPC_CREAT | IPC_EXCL | 0600);

  if(idSem == -1){
    perror("erreur semget : ");
    exit(-1);
  }

  printf("sem id : %d \n", idSem);

  // initialisation du sémaphore au nombre de processus à créer

  ushort tabinit[1];
  tabinit[0] = atoi(argv[3]);;


  union semun{
    int val;
    struct semid_ds * buf;
    ushort * array;
  } valinit;

  valinit.array = tabinit;

  if (semctl(idSem, 1, SETALL, valinit) == -1){
    perror("erreur initialisation sem : ");
    exit(1);
  }

  /* test affichage valeurs des sémaphores du tableau */
  valinit.array = (ushort*)malloc(1 * sizeof(ushort)); // pour montrer qu'on r�cup�re bien un nouveau tableau dans la suite

  if (semctl(idSem, 1, GETALL, valinit) == -1){
    perror("erreur initialisation sem : ");
    exit(1);
  }

  printf("Valeurs du sempahores apres initialisation : ");
  printf("%d\n", valinit.array[0]);


  free(valinit.array);
  return 0;
}
