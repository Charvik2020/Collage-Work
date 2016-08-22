/* Read a character by character from a datafile
   Author : Sanjay Chaudhary, DA-IICT */

# include <stdio.h>
int main(void)
{
FILE *fpt;
char chr;
char filename[21];

printf("\nEnter a file name : ");
gets(filename);

if (( fpt = fopen(filename,"r"))==NULL)
	printf("\n %s file does not exist... \n", filename);
else
do
       putchar( chr = getc(fpt)) ;
       while ( chr != EOF );
fclose(fpt);
}
