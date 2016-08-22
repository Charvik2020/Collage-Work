/* To create a data file of marks of students of 1st semester.
   Author : Sanjay Chaudhary */

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

stud_file = fopen(filename1,"a+");

answer = 'Y';
while (!(answer == 'N'))
{
       printf("\nEnter Student ID    : ");
       scanf("%lu", &student.stud_id);
       printf("\nEnter Marks of AIS  : ");
       scanf("%u", &student.ais);
       printf("\nEnter Marks of CAL  : ");
       scanf("%u", &student.cal);
       printf("\nEnter Marks of CSO  : ");
       scanf("%u", &student.cso);
       printf("\nEnter Marks of EICT : ");
       scanf("%u", &student.eict);
       printf("\nEnter Marks of SPC : ");
       scanf("%u", &student.spc);
fprintf(stud_file,"%lu%3u%3u%3u%3u%3u",student.stud_id,student.ais, student.cal, student.cso, student.eict, student.spc);
	printf("\n Do you want to insert another record ? Y/N");
	scanf("%s", &answer);
}
fclose(stud_file);
exit(0);
}
