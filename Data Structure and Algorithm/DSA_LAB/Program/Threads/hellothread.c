/**************************************************/
/* This is the program that shows the basics of   */
/* multithreading in POSIX                        */
/**************************************************/

/**************************************************/
/* We are using the thread package in POSIX.      */
/* Solaris has its own thread package.            */
/**************************************************/

/**************************************************/
/* hello.c -- a hello world program (in pthread)  */
/**************************************************/

/* The header files                               */
#include <stdio.h>
#include <sys/types.h>
#include <pthread.h>
#include <time.h>

/* The maximum number of threads                  */
#define MAX_THREADS 5
 
/**************************************************/
/* The thread functions that are used in the      */
/* sample.                                       */
/*                                                */
/* pthread_create                                 */
/* pthread_self                                   */
/* pthread_join                                   */
/**************************************************/


/**************************************************/
/* Other important functions that are used in the */
/* sample.                                        */
/*                                                */
/* sleep(...)                                     */
/* time(...)                                      */
/* srand48(...)                                   */
/* lrand48(...)                                   */
/**************************************************/

/**************************************************/
/* This function will print a message on the      */
/* screen, sleep for seconds and then wake        */
/* up.                                            */
/**************************************************/
void *hello_world(void *arg)
{
  int sleep_time = (int)arg;
  /* Use man pthread_self to see what it does.    */
  printf("Hello world from thread %d. I need to sleep for %d second(s).\n", pthread_self(), sleep_time);
  /* Use man -s 3c sleep to see what it does.     */
  sleep(sleep_time);
  printf("Thread %d is awakening.\n", pthread_self());

  return NULL;
}

/**************************************************/
/* The main function                              */
/* The main process will create 5 threads, and    */
/* give each thread a random number between 1 to  */
/* 5 to sleep. The main process will then wait    */
/* for the termination of all threads before it   */
/* exits.                                         */
/**************************************************/
int main() {
  int i;
  int sleep_time;
  pthread_t threads[MAX_THREADS];
  time_t t1;

  /* srand48() sets the seed for the random number generator.  */
  /* It is important to have different seeds when we call the  */
  /* functions otherwise the same set of pseudo-random numbers */
  /* will generated. time() always provides a unique seed.     */

  /* Use man -s 2 time to see what it does.                    */
  time(&t1);
  /* Use time in seconds to set seed, initialize the generator */
  /* Use man srand48 to see what it does.                      */
  srand48((long) t1);

  printf("I am generating %d threads.\n", MAX_THREADS);				

  /* Start up threads.*/
  for (i = 0; i < MAX_THREADS; i++) {
    /* Generate the random sleep time for each thread.*/
    /* Use man lrand48 to see what it does.*/
    /* sleep_time is between 1 and 5.*/
    sleep_time = 1 + lrand48() % 5;
    /* Use man pthread_create to see what it does.*/
    pthread_create(&threads[i], NULL, hello_world, (void *)sleep_time);
  }

  /* Synchronize the completion of each thread.   */
  for (i = 0; i < MAX_THREADS; i++) {
    /* Use man pthread_join to see what it does.  */
    pthread_join(threads[i], NULL);
  }

  /* Main process prints the last message, indicating */
  /* all threads are gone.                            */
  printf("All my threads are gone. I am exiting, too.\n");
  exit(0);
}
