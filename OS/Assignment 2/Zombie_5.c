#include <stdio.h>
#include <stdlib.h>
int main ()
{
  pid_t pid;// intalizing process id
 
  pid = fork ();// making an child process
  if (pid == 0) {// parent 
 
	printf ("child Created\n");
        
  }
  else if(pid== -1){// child successfully not created
 	printf("child not created\n");
}
else{
	printf("Parent process\n");
    	sleep(30);
 }
  return 0;
}

//ps -e -o pid,ppid,stat,cmd -> to see the zombie process
