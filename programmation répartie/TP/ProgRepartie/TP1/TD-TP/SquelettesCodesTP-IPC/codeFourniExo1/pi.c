#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/ipc.h>
#include <stdlib.h>
#include <sys/msg.h>
#include <string.h>
/*
Files de messages avec labels
 */

int main(int argc, char * argv[]){

  if (argc!=3) {
    printf("Nbre d'args invalide, utilisation :\n");
    printf("%s fichier-pour-cle-ipc entier-pour-clé-ipc\n", argv[0]);
    exit(0);
  }

  //Création de la clé
  int cle = ftok(argv[1], atoi(argv[2]));

  //Identification de la file
  int f_id = msgget(cle, 0666);

  if(f_id == -1){
    perror("erreur file_get : ");
    exit(-1);
  }

  printf("file id : %d \n", f_id);

  //Get the maximum PID for the current system
  FILE* fp = fopen("/proc/sys/kernel/pid_max", "r"); // read mode
  long MAX_PID = 0;

  if (fp == NULL) {
    perror("Error reading max pid.\n");
    exit(1);
  }

  fscanf(fp, "%li", &MAX_PID);
  printf("The contents of file is :%li\n", MAX_PID);
  fclose(fp);

  int size_pid = floor(log10(abs(MAX_PID))) + 1;


  // initialisation d'une structure pour stocker nos messages
  struct msgbuf {
    long label; /* message type, must be>0 here its the pid*/
    char message[30];
  } message_pid;

  int pid = getpid();
  char * mypid = malloc(size_pid + 1);
  snprintf(mypid, size_pid, "%d", pid);

  strcpy(message_pid.message, mypid);


  //On demande a Pctrl une ressource, puis on attends
  int snd = msgsnd(f_id, &message_pid, (size_t)sizeof(message_pid), 0);
  if (snd == -1){
    perror("erreur envoi message : ");
    exit(1);
  }


  //On attends de récupérer un message avec notre pid
  int rec = msgrcv(f_id, &message_pid, (size_t)sizeof(message_pid.message), (long) pid, 0);
  if (rec == -1){
    perror("erreur reception message : ");
    exit(1);
  }


  printf("The message was : %s", message_pid.message);

  //
  // /* test affichage valeurs des sémaphores du tableau */
  // valinit.array = (ushort*)malloc(1 * sizeof(ushort)); // pour montrer qu'on r�cup�re bien un nouveau tableau dans la suite
  //
  // if (semctl(idSem, 1, GETALL, valinit) == -1){
  //   perror("erreur initialisation sem : ");
  //   exit(1);
  // }
  //
  // printf("Valeurs du sempahores apres initialisation : ");
  // printf("%d\n", valinit.array[0]);
  //
  //
  // free(valinit.array);
  return 0;
}
