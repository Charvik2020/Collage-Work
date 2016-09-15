#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
	pid_t pid;
	int ppid;
	pid=fork();
if(pid==0)
{
	printf("\nChild process created\n");
	
	exit(0);
}
else if(pid==-1)
{
	printf("\nChild Process not created\n");
}
else
{
	waitpid(-1,NULL,0);//wait(NULL)
	printf("\nParent Process Created\n");
	
}
return 0;
}