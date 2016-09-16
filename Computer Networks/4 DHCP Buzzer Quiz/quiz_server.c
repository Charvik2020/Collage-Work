#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <fcntl.h>
#define FNAME file1;
#define PORT 3447;
#define BUFSIZE 128;
#define	LISTENQ 5;

int main(int argc, char **argv)
{
	int listenfd, connfd, fd, pid, n, size,i,count=10;
	//
	FILE *fp;
	struct sockaddr_in
	servaddr;
	char buf[BUFSIZE],fname[50],content[30],content1[30],uname[30];
	struct stat stat_buf;
	listenfd = socket(AF_INET, SOCK_STREAM, 0);
	bzero(&servaddr, sizeof(servaddr));
	servaddr.sin_family
	= AF_INET;
	servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
	servaddr.sin_port
	= htons(PORT);
	bind(listenfd, (struct sockaddr *) &servaddr, sizeof(servaddr));
	listen(listenfd, LISTENQ);
	printf("listening\n");
	for ( ; ; )
	{
		connfd = accept(listenfd, (struct sockaddr *) NULL, NULL);
		pid=fork();
		if(pid==0)
		{
			printf("Handling connection request\n");
			recv(connfd,fname,50,0);
			recv(connfd,uname,30,0);
			printf("File name is %s : ", fname);
			printf("user name is:%s\n",uname);
			fd=open(fname,O_RDONLY,S_IRUSR);
			fstat(fd, &stat_buf);
			size = stat_buf.st_size;
			printf(" size is %d\n", size);
			printf("\nopened file\n");
			while ( (n = read(fd, buf, BUFSIZE-1)) > 0)
			{
			buf[n] = '\0';
			//printf("%s\n",buf);
			write(connfd,buf,n);
			}printf("file transfer completed \n");
			//............................................
			/*if(fork())
			{
			//printf("\nEnter the data to be send type exit for stop:\n");
			scanf("%s",content);
			while(strcmp(content,"exit")!=0)
			{
			send(connfd,content,30,0);
			scanf("%s",content);
			}
			send(connfd,"exit",5,0);
			}
			else*/
			i = recv(connfd,content,30,0);
			//while(strcmp(content,"result")!=0)
			//{
			printf("\nClient: %s\n",content);
			strcpy(content1,content);
			//i=recv(connfd,content,30,0);
			//}
			printf("\nMarks sent to client:");
			// write(connfd,&count,sizeof(count));
			//int A = 5;
			//const char* pBytesOfA = (const char*)&A;
			//int lengthOfBytes = sizeof(A);
			//send(connfd,pBytesOfA,lengthOfBytes,0);
			strcpy(content,uname);
			if(content1[0]=='b'&&content1[1]=='b')
			strcat(content," score is : 2");
			else if(content1[0]=='b'||content1[1]=='b')
			strcat(content," score is : 1");
			else
			strcat(content," score is : 0");
			send(connfd,content,30,0);
			close(connfd);
			close(fd);
			exit(0);
		}
		printf("now child process killed");
	}
}



