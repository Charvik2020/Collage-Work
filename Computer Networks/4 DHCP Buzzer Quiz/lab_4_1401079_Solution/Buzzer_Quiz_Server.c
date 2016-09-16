#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <netdb.h>
#include <netinet/in.h>
#include <unistd.h>
#include <string.h>

void doprocessing (int sock);

static int *glob_var;

int main( int argc, char *argv[] ) {
   int sockfd, newsockfd, portno, clilen;
   char buffer[256];
   struct sockaddr_in serv_addr, cli_addr;
   int n, pid;
   glob_var = mmap(NULL, sizeof *glob_var, PROT_READ | PROT_WRITE, 
                    MAP_SHARED | MAP_ANONYMOUS, -1, 0);

   *glob_var = 0;

   /* First call to socket() function */
   sockfd = socket(AF_INET, SOCK_STREAM, 0);
   
   if (sockfd < 0) {
      perror("ERROR opening socket");
      exit(1);
   }
   
   /* Initialize socket structure */
   bzero((char *) &serv_addr, sizeof(serv_addr));
   portno = 5001;
   
   serv_addr.sin_family = AF_INET;
   serv_addr.sin_addr.s_addr = INADDR_ANY;
   serv_addr.sin_port = htons(portno);
   
   /* Now bind the host address using bind() call.*/
   if (bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) {
      perror("ERROR on binding");
      exit(1);
   }
   
   /* Now start listening for the clients, here
      * process will go in sleep mode and will wait
      * for the incoming connection
   */
   
   listen(sockfd,5);
   clilen = sizeof(cli_addr);
   
   while (1) {
      newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr, &clilen);
		
      if (newsockfd < 0) {
         perror("ERROR on accept");
         exit(1);
      }
      
      /* Create child process */
      pid = fork();
		
      if (pid < 0) {
         perror("ERROR on fork");
         exit(1);
      }
      
      if (pid == 0) {
         /* This is the client process */
         close(sockfd);
         doprocessing(newsockfd);
         exit(0);
      }
      else {
         close(newsockfd);
      }
		
   } /* end of while */
}


void doprocessing (int sock) {
   int n;
   char buffer[256],user_name[30];
   bzero(user_name,256);
   n = read(sock,user_name,30);
   user_name[strcspn(user_name, "\n")] = 0;
   printf("%s connected", user_name);
   if (n < 0) {
      perror("ERROR reading from socket");
      exit(1);
   }
   
   printf("Here is the message: %s\n",buffer);
   n = write(sock,"Connected to server, here you go\n 1. What is 5*2 ?\n\nA) 10\nB) 7\nC) 9\nD) I don\'t know",122);
   
   if (n < 0) {
      perror("ERROR writing to socket");
      exit(1);
   }

   //reading data from client and printing it
     bzero(buffer,256);
     n = read(sock,buffer,255);
     if (n < 0) error("ERROR reading from socket");
     printf("%s Answered: %s\n",user_name, buffer);

     if(buffer[0] == 'A' || buffer[0] == 'a' )
     {
        if(*glob_var == 0)
	{
		*glob_var = 1;
		printf("%s Answered Correctly.\n", user_name);
		n = write(sock,"Correct Answer!\n Thank you for taking test.\n",46);
	     	if (n < 0) error("ERROR writing to socket");	
	}
	else
	{
		printf("%s Answered Correctly, but late\n", user_name);
		n = write(sock,"You are correct but late!\n Thank you for taking test.\n",46);
	     	if (n < 0) error("ERROR writing to socket");	
	}
	
     }
     else{
        printf("%s Answered wrong.\n", user_name);
	 n = write(sock,"Wrong Answer!\nCorrect answer is A) 10\n Thank you for taking test.\n",68);
     	if (n < 0) error("ERROR writing to socket");	
     }
	
}
