/* To create a mark statement of students of 1st semester.
   Author : Sanjay Chaudhary, DA-IICT */

# include <stdio.h>
int main(void)
{
FILE *stud_file;
char chr;
char filename1[35];
struct stud {
unsigned long stud_id;
unsigned short int  ais;
unsigned short int  cal;
unsigned short int  cso;
unsigned short int  eict;
unsigned short int  spc;} student;
char answer;

printf("\nEnter a name of result file of students : ");
gets(filename1);

stud_file = fopen(filename1,"r");
if ( stud_file == NULL)
	{
	printf("\n%s file does not exist...",filename1);
	exit(1);
	}

       printf("\nDA-IICT");
       printf("\nMark Statement, Semester - I");
       printf("\n------------------------------------");
       printf("\nStudent     Marks of courses");
       printf("\nID          AIS  CAL  CSO  EICT  SPC");
       printf("\n------------------------------------");
       fread(&student, sizeof(struct stud), 1, stud_file);
       while (!feof(stud_file))
       {
       printf("\n%10lu  %3u  %3u  %3u   %3u  %3u",student.stud_id,
	      student.ais, student.cal, student.cso, student.eict, student.spc);
       fread(&student, sizeof(struct stud), 1, stud_file);
	}
	printf("\n------------------------------------\n");
fclose(stud_file);
exit(0);
}
