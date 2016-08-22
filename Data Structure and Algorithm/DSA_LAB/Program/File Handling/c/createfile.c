# include <stdio.h>
/* creating a datafile
   read in a line of lowercase text,
   convert characters into uppercase and
   store in a data file
   Author : Sanjay Chaudhary, DA-IICT */
int main(void)
{
FILE *fpt;
char chr;
fpt = fopen("sample.dat","w");
do
putc(toupper(chr = getchar()),fpt);
while ( chr != '\n' );
fclose(fpt);
}
