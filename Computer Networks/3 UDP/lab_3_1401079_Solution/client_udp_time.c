#include"netinet/in.h"
#include"sys/socket.h"
#include"stdio.h"
main()
{
	struct sockaddr_in sa,cli;
	int n,sockfd;
	int len;char buff[100];
	sockfd=socket(AF_INET,SOCK_STREAM,0);
	if(sockfd<0){ 
		printf("\nError in Socket");
		exit(0);
	}
	else printf("\nSocket is Opened");
	bzero(&sa,sizeof(sa));
	sa.sin_family=AF_INET;
	sa.sin_port=htons(5600);
	if(connect(sockfd,(struct sockaddr*)&sa,sizeof(sa))<0)
	{
		printf("\nError in connection failed");
		exit(0);
	}
	else
		printf("\nconnected successfully\n");
		 printf("Enter Your Message:");
		    bzero(buff,256);
		    fgets(buff,255,stdin);
	    	n = write(sockfd,buff,strlen(buff));
	    	
	    	if (n < 0) 
	 	 error("ERROR reading from socket");
	    	printf("%s\n",buff);
		  
		if(n=read(sockfd,buff,sizeof(buff))<0)
		{
			printf("\nError in Reading");
			exit(0);
		}
		else
		printf("\nMessage Read time-> %s",buff);
		
		exit(0);
}
