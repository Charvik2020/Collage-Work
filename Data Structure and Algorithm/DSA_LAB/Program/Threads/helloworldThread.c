#include <stdio.h>
#include <pthread.h>
void *thread(void *vargp);

int main() {
  pthread_t tid[5];
  int i, status, *status_ptr = &status;
for (i = 0; i < 5; i++) {      /* creating threads */

  	if (pthread_create(&tid, NULL, thread, NULL) !=0)
	{
         fprintf(stderr, "Failed to create a thread\n");
         exit(1);
     }
  }
  for (i = 0; i < 5; i++) {     /* waiting for thread terminations */
     if (pthread_join(tid[i], (void **)status_ptr) != 0) {
         fprintf(stderr, "Failed to terminate a thread\n");
         exit(2);
     }
     printf("Thread %d returns %d\n", tid[i], status);
  }
  return(0);

/*  pthread_create(&tid, NULL, thread, NULL);
  pthread_join(tid, NULL);
  exit(0);
*/
}

/* thread routine */
void *thread(void *vargp) {
  printf("Hello, world!\n"); 
  return (void *NULL);
}
