#include<sys/ioctl.h>
#include<arpa/inet.h>
#include<stdio.h>
#include<stdlib.h>
#include<net/if_arp.h>
#include<sys/stat.h>
#include<fcntl.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<netdb.h>
#include<string.h>
#define FNAME file1
#define PORT 3447
#define BUFSIZE 128
int main(int argc, char **argv)
{
	int sockfd, fd, n, size,count=0,fd1,i;
	long int size1,size2;
	char buf[BUFSIZE], fname[50],buf1[BUFSIZE],content[30],uname[30];
	struct sockaddr_in servaddr;
	if (argc != 2) {
		printf("Usage: %s server_address", argv[0]);
		exit(1);
	}
	if ( (sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
	exit(1);
	bzero(&servaddr, sizeof(servaddr));
	servaddr.sin_family = AF_INET;
	servaddr.sin_port
	= htons(PORT);
	if (inet_pton(AF_INET, argv[1], &servaddr.sin_addr) <= 0)
	exit(1);
	< 0)
	if (connect(sockfd, (struct sockaddr*) &servaddr, sizeof(servaddr))
	exit(1);
	printf("connection established\n");
	printf("Enter the User-name : ");
	scanf("%s",uname);
	strcpy(fname,"questions");
	send(sockfd,fname,sizeof(fname),0);
	send(sockfd,uname,sizeof(uname),0);
	fd=open(fname,O_WRONLY|O_CREAT,S_IRWXU);while ( (n = read(sockfd, buf, BUFSIZE-1)) > 0)
	{
		buf[n] = '\0';
		printf("%s\n",buf);
		write(fd,buf,n);
		if( n < BUFSIZE-2)
		break;
	}
	//.................................................................
	if(fork())
	{
	//printf("\nEnter the data to be send type exit for stop:\n");
		scanf("%s",content);
	}
	else
	{
	while(strcmp(content,"exit")!=0)
	{
	send(sockfd,content,30,0);
	scanf("%s",content);
	}
	send(sockfd,"exit",5,0);
	i=recv(sockfd,content,30,0);
	while(strcmp(content,"exit")!=0)
	{
	printf("\nServer: %s\n",content);
	i=recv(sockfd,content,30,0);
	}
	send(sockfd,"exit",5,0);
	}
	//................................................................
	close(sockfd);
	close(fd);
	close(fd1);
	exit(0);
}

