#include <fcntl.h>
#include <unistd.h>

int main(void)
{
	int fd;
	ssize_t nread;
	char buf[1024];
	char *filename="marks.dat";

	/*open file for reading */
	fd = open(filename, O_RDONLY);
	if (fd == -1)
	{
		printf("Coundn't open %s\n", filename);
		exit(1);
	}
	/* read the data */
	nread = read(fd, buf, 1024);
	
	/*Processing on data*/	

	/*close the file */
	close(fd);

	exit(0);
}

