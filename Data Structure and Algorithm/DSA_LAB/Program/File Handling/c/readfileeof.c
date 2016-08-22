/* Read a character by character from a data file till the end of a file
   Author : Sanjay Chaudhary, DA-IICT */

# include <stdio.h>
int main(void)
{
FILE *fpt;
char chr;
if (( fpt = fopen("readfileeof.c","r"))==NULL)
	printf("\n readfileeof file does not exists... \n");
else
do
       putchar( chr = getc(fpt)) ;
       while ( chr != EOF );
fclose(fpt);
}
