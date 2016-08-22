/* pthread.c
   This is a simple example to show POSIX thread creation and waiting for
   a normal termination of sibling threads.
   This program creates threads depending on the number of command-line 
   arguments given (up to MAX). Each thread will print the actual value
   of the command-line argument it has received in turn.

   Some pthread APIs
   1. to create a thread
      int pthread_create(pthread_t *thread,  const pthread_attr_t *attr,
                         void *(*start_routine)(void *), void *arg);
          return status 0: success, nonzero: failure

   2. to wait for a thread to terminate
      int pthread_join(pthread_t thread, void **value_ptr);
          return status 0: success, nonzero: failure

   3. to get calling thread's tid
      pthread_t pthread_self(void);

   To compile: gcc pthread.c -lpthread
*/

#define _REENTRANT

#include <stdio.h>
#include <pthread.h>
#define MAX  10
int sum=0;
int main(int argc, char *argv[])
{
  int i, status, *status_ptr = &status; 
  pthread_t thread[MAX];
  void *prt_arg(void *);

  for (i = 0; i < (argc - 1); i++) {      /* creating threads */
     if (pthread_create(&thread[i], NULL, prt_arg, (void *)argv[i+1]) != 0) {
         fprintf(stderr, "Failed to create a thread\n"); 
         exit(1);
     }
  }
  for (i = 0; i < (argc - 1); i++) {     /* waiting for thread terminations */
     if (pthread_join(thread[i], (void **)status_ptr) != 0) {
         fprintf(stderr, "Failed to terminate a thread\n"); 
         exit(2);
     }
     printf("Thread %d returns %d\n", thread[i], status);
  }
  exit(0);
//return(0);
}

void *prt_arg(void *arg)
{
  pthread_t tid = pthread_self();      /* to get tid for itself */
  //sleep(2);
  sum = sum + 10;
  printf("Thread %d got %s\n", tid, (char *)arg);
  printf("Value of sum : %d\n", sum);
  return (void *)NULL;
}
