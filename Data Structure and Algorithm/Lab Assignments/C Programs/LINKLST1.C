#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<ctype.h>
/* This program is written by Sanjay Chaudhary.
   This program will maintain a linked list */

struct emp
{ unsigned emp_no;
float basic_pay;
struct emp *next;
} my_emp;

struct emp *temp, *first, *last, *prev;

char answer;
char choice;
char found;
unsigned l_emp_no=0;
float l_basic_pay=0.0;

void insert_node(void);
void delete_node(void);
void list_node(void);

int main()
{
	while (!(choice == 'X'))
	{
/*	clrscr(); */
	printf("\n");
	printf("\nLinked List Module");
	printf("\nI. Insert a node in a linked list");
	printf("\nD. Delete a node from a linked list");
	printf("\nL. List nodes of a linked list");
	printf("\nX. Exit ");
	printf("\nEnter your choice : ");
	scanf("%s", &choice);

	if (choice == 'I')
                {
                answer = ' ';
		insert_node();
                }
	else if (choice == 'D')
		{
		if (!(first == NULL))
			{
			delete_node();
			}
		else
			{
			printf("\nLinked List is empty...");
			}
		}
	else if (choice == 'L')
		{
		if (!(first == NULL))
			{
			list_node();
			}
		else
			{
			printf("\nLinked List is empty...");
			}
		}
	}
return 0;
}
void insert_node(void)
{
while (!(answer == 'N'))
{
	if (first == NULL)
	{
	printf("\nEnter the value of Emp Number :");
	scanf("%u",&l_emp_no);
	printf("\nEnter the value of Basic Pay :");
	scanf("%f",&l_basic_pay);
	temp=(struct emp *)malloc(sizeof(struct emp));
	temp->emp_no=l_emp_no;
	temp->basic_pay=l_basic_pay;
	temp->next=NULL;
	first=temp;
	last=temp;
	}
	else
	{
	temp=(struct emp *)malloc(sizeof(struct emp));
	if (!(temp == NULL))
		{
		printf("\nEnter the value of Emp number :");
		scanf("%u",&l_emp_no);
		printf("\nEnter the value of Basic Pay :");
		scanf("%f",&l_basic_pay);
		temp->emp_no=l_emp_no;
		temp->basic_pay=l_basic_pay;
		temp->next=NULL;
		last->next=temp;
		last=temp;
		}
	else
		{
		printf("\nSpace is exhausted, insertion not possible...");
		}
	}
printf("\nDo you want to continue ? Y/N");
scanf("%s",&answer);
}

}
void list_node(void)
{
	temp=first;
	while (!(temp == NULL))
	{
	printf("\n%u \t %.2f",temp->emp_no, temp->basic_pay);
	temp=temp->next;
	}
}
void delete_node(void)
{
	printf("\nEnter Emp Number to delete a node : ");
	scanf("%u", &l_emp_no);
	found = 'N';

	if (first->emp_no == l_emp_no)
		{
		temp = first;
		found = 'Y';
		first = first->next;
		free(temp);
		}
	else
	{
	temp = first->next;
	prev = first;

	while (!(temp == NULL))
	{
	if (temp->emp_no == l_emp_no)
		{
		found = 'Y';
		if (temp == last)
			{
			last = prev;
			}
		prev->next = temp->next;
		free(temp);
		break;
		}
	else
		{
		prev = temp;
		temp = temp->next;
		}
	}
	}
	if (found == 'N')
	{
		printf("\nNo such node is existing in a linked list");
	}
return ;
}



