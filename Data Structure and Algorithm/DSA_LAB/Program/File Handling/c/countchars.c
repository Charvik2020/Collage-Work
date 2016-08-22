/* count characters in a file */
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

#define BUFSIZE  521

main()
{
	char buffer[BUFSIZE];
	int filedes;
	ssize_t nread;
	long total = 0;
	
	/* open a file in read only mode */
	if (( filedes = open("sample.dat", O_RDONLY)) == -1)
	{
		printf("error in opening sample.dat file\n");
		exit(1);
	}
	
	/* loop until end-of-file (EOF) is reached */
	while ((nread = read(filedes, buffer, BUFSIZE)) > 0)
		total += nread;
		
		printf(total number of characters in sample.dat: %d\n", total);
		exit(0);
	}
	
