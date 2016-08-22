/**************************************************/
/* This is the program that shows the basics of   */
/* multithreading in POSIX                        */
/**************************************************/

/**************************************************/
/* We are using the thread package in POSIX.      */
/* Solaris has its own thread package.            */
/**************************************************/

/**************************************************/
/* multihello.c -- a multi-hello program          */
/* (in pthread)                                   */
/**************************************************/

/**************************************************/
/* Thread 0 receives "hello"  from the other four */
/* threads.                                       */
/* There is one receiver and 4 writers.           */
/* There are two shared variables.                */
/* token - will be used to see whose turn it is   */
/*         to use the shared array for message.   */
/* token = 0 -> it's the writer's turn.           */
/* token = 1 -> it's the receiver's turn.         */
/* The header files                               */
/**************************************************/

/* The header files                               */
#include <stdio.h>
#include <sys/types.h>
#include <pthread.h>
#include <time.h>

typedef struct
{
  int id;
  int sleep_time;
} parm;

/* The maximum number of threads                  */
#define MAX_THREADS 5

/* Initialize the mutex which is used to protect  */
/* the two shared variables.                      */
pthread_mutex_t msg_mutex = PTHREAD_MUTEX_INITIALIZER;

/* The two shared variables.                      */
char message[128];
int token = 0;
 
/**************************************************/
/* The thread functions that are used in the      */
/* sample                                         */
/*                                                */
/* pthread_create				  */
/* pthread_join                                   */
/* pthread_mutex_lock                             */
/* pthread_mutex_unlock                           */
/**************************************************/

/**************************************************/
/* The mutex used in the pthread package          */
/* pthread_mutex_t                                */
/**************************************************/


/**************************************************/
/* Other important functions that are used in the */
/* sample                                         */
/*                                                */
/* sleep(...)                                     */
/* time(...)                                      */
/* srand48(...)                                   */
/* lrand48(...)                                   */
/**************************************************/

/**************************************************/
/* This function will generate a message or       */
/* receive a message.                             */
/**************************************************/
void *hello_world(void *arg)
{
  parm *p = (parm *) arg;
  int  id = p->id;
  int  sleep_time = p->sleep_time;
  int  i;


  if (id != 0) { /* Message creator */
    while (1) {

      pthread_mutex_lock(&msg_mutex); 
      if (token  == 0) {
        /* If you want to create a situation that token  */
        /* can be accessed without any mutual exclusion, */
	/* you can comment the statements for msg_mutex  */
	/* and uncomment the following statement.        */
        /* You may want to print out the current value   */
	/* of token to see what's inside it.             */
	/* See what happens after doing so.              */
        /* sleep(1);  */
	sprintf(message, "Hello from thread %d!", id);
	token++;
	pthread_mutex_unlock(&msg_mutex);
	break;
      }
      pthread_mutex_unlock(&msg_mutex);
      sleep(sleep_time);
    }
  } 
  else { /* Message receiver */
    for (i = 1; i < MAX_THREADS; i++) {
      while (1) {
	pthread_mutex_lock(&msg_mutex);
	if (token == 1) {
	  printf("Thread 0 receives %s\n", message);
	  token--;
	  pthread_mutex_unlock(&msg_mutex);
	  break;
	}    
	pthread_mutex_unlock(&msg_mutex);

        sleep(sleep_time);
      }
    }
  }
}

/**************************************************/
/* The main function.                             */
/* The main process will create 5 threads, and    */
/* give each thread a random number between 1 to  */
/* 5 to sleep. The main process will then wait    */
/* for the termination of all threads before it   */
/* exits.                                         */
/**************************************************/
int main() {
  int       i;
  int       sleep_time;
  pthread_t threads[MAX_THREADS];
  parm      p[MAX_THREADS];
  time_t    t1;
  int       ret;


  /* srand48() sets the seed for the random number generator.  */
  /* It is important to have different seeds when we call the  */
  /* functions otherwise the same set of pseudo-random numbers */
  /* will generated. time() always provides a unique seed.     */

  /* Use man -s 2 time to see what it does.                    */
  time(&t1);
  /* Use time in seconds to set seed, initialize the generator */
  /* Use man srand48 to see what it does.                      */
  srand48((long) t1);

  printf("The process is generating %d threads.\n", MAX_THREADS);			 
  /* Start up thread */
  for (i = 0; i < MAX_THREADS; i++) {
    /* Generate the random sleep time for each thread.        */
    /* Use man lrand48 to see what it does.                   */
    /* sleep_time is between 1 and 5.                         */
    sleep_time = 1 + lrand48() % 3;
    p[i].id = i;
    p[i].sleep_time = sleep_time;

    /* Use man pthread_create to see what it does.            */
    pthread_create(&threads[i], NULL, hello_world, (void *)&p[i]); 
  }
 
  /* Synchronize the completion of each thread.   */
  for (i = 0; i < MAX_THREADS; i++) {
    /* Use man pthread_join to see what it does.  */
    pthread_join(threads[i], NULL);
  }

  exit(0);
}
