/* copyfile - copy file1 to file2 *?
#include <unistd.h>
#include <fcntl.h>

#define BUFSIZE	512 /* size of chunk to be read */
#define PERM	0644 /* file permission for a new file */

/* copy file1 to file2 */
int copyfile( const *filename1, const char filename2)
{
	int infile, outfile;
	ssize_t nread;
	char buffer[BUFSIZE];
	
	if((infile = open(filename1, ORDONLY)) == -1)
		return (-1);
		
	if((outfile = open(filename2, O_WRONLY | O_CREAT | O_TRUNC, PERM) == -1)
	{
		close(infile);
		return(-2);
	}
	
	/* read from filename1 BUFSIZE chars at a time */
	while((nread = read(infile, buffer, BUFSIZE))>0
	{
	/*write buffer to output file*/
	if (write(outfile, buffer, nread) < nread)
	{
		close(infile);
		close(outfile);
		return (-3);	/*write error*/
	}
}

close (infile);
close(outfile);

if (nread == -1)
	return (-4);	/*error on last read*/
	else
		return (0);
}

main()

retcode = copyfile("sample.dat","anothersample.dat");

