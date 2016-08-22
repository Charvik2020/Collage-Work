/* Copy one file onto another file.
   Author : Sanjay Chaudhary, DA-IICT */

# include <stdio.h>
int main(void)
{
FILE *fpt, *fout;
char chr;
char filename1[21], filename2[21];

printf("\nEnter a name of source file : ");
gets(filename1);
printf("\nEnter a name of target file : ");
gets(filename2);

if (( fpt = fopen(filename1,"r"))==NULL)
	printf("\n %s file does not exist... \n", filename1);
else

fout = fopen(filename2,"w");

do
       {
       putchar( chr = getc(fpt)) ;
       putc(chr, fout);
       }
       while ( chr != EOF );
fclose(fpt);
}
