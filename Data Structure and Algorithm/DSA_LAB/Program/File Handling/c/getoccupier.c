/* getoccupier -- get occupier's name from residents file */

#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

#define NAMELENGTH 41

char namebuf(NAMELENGTH);	/* buffer to hold name */
int infile = -1;

char *getoccupier(int roomno)
{
	off_t offset;
	ssize_t nread;
	
	/*open the file first time */
	if (infile == -1 &&
		(infile = open("residents", O_RDONLY)) == -1)
		{
			return (NULL);	/* could not open file */
		}
		
	offset = (roomno - 1) * NAMELENGTH;
	
	/* find room slot and read occupier's name*/
	if (lseek(infile, offset, SEEK_SET) == -1)
		return (NULL);
		
	if((nread = read(infile, namebuf, NAMELENGTH)) <=0)
		return (NULL);
		
	/* creae a string by replacing the newline character with the null terminator */
	namebuf[nread - 1] = '\0';
		return(namebuf);
	}

/* assumption: number of rooms in a hotel = 10*/
#define NROOMS	10

main()
{
	int j;
	char *getoccupier(int), *p);
	
	for( j = 1; j <= NROOMS; j++)
	{
		if (p = getoccupier(j))
			printf("Room %2d, %s\n", j, p);
		else
			printf("Error on room %d\n", j);
	}
}

	
			