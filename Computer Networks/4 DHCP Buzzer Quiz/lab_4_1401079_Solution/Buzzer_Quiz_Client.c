#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h> 

void error(char *msg)
{
    perror(msg);
    exit(0);
}

int main(int argc, char *argv[])
{
    int sockfd, portno, n;

    struct sockaddr_in serv_addr;
    struct hostent *server;

    char buffer[256];
    if (argc < 3) {
       fprintf(stderr,"usage %s hostname port\n", argv[0]);
       exit(0);
    }
    portno = atoi(argv[2]);
    
    /* Create a reliable, stream socket using TCP */
    sockfd = socket(AF_INET, SOCK_STREAM, 0);	//AF : Address Family, PF : Protocol Family 
    if (sockfd < 0) 
        error("ERROR opening socket");

    //Getting server info from argument
    server = gethostbyname(argv[1]);
    if (server == NULL) {
        fprintf(stderr,"ERROR, no such host\n");
        exit(0);
    }	

    
    bzero((char *) &serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;		/* Internet address family */
    bcopy((char *)server->h_addr, 		
         (char *)&serv_addr.sin_addr.s_addr,	
         server->h_length);			/* Server IP address*/
    serv_addr.sin_port = htons(portno);		/* Server port */

    //Establish connection
    if (connect(sockfd,(struct sockaddr *)&serv_addr,sizeof(serv_addr)) < 0) 
        error("ERROR connecting");

    //Getting message input
    printf("Welcome to Buzzer quiz\nEnter your name-> ");
    bzero(buffer,256);
    fgets(buffer,255,stdin);
    printf("\n Connecting to server");
    //writing to server
    n = write(sockfd,buffer,strlen(buffer));
    if (n < 0) 
         error("ERROR writing to socket");

    //reading responce of server and displaying
    bzero(buffer,256);
    n = read(sockfd,buffer,255);
    if (n < 0) 
         error("ERROR reading from socket");
    printf("%s\n Enter your choice->",buffer);


    bzero(buffer,256);
    fgets(buffer,255,stdin);
    //writing to server
    n = write(sockfd,buffer,strlen(buffer));
    if (n < 0) 
         error("ERROR writing to socket");

    //reading responce of server and displaying
    bzero(buffer,256);
    n = read(sockfd,buffer,255);
    if (n < 0) 
         error("ERROR reading from socket");
    printf("%s\n Enter your choice->",buffer);
	

    close(sockfd);
    return 0;
}
