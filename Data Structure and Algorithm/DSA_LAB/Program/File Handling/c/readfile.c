/* Read a character by character from a datafile
   Author : Sanjay Chaudhary, DA-IICT */

# include <stdio.h>
/*# define NULL 0 */
int main(void)
{
FILE *fpt;
char chr;
if (( fpt = fopen("sample.dat","r"))==NULL)
	printf("\n sample.dat file does not exists... \n");
else
do
       putchar( chr = getc(fpt)) ;
       while ( chr != '\n' );
fclose(fpt);
}
