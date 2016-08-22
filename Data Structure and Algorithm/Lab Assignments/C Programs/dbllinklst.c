#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#include<ctype.h>
/* This program is written by Sanjay Chaudhary
   This program will maintain a doubly linked list */

struct emp
{ unsigned emp_no;
float basic_pay;
struct emp *next;
struct emp *prev;
} my_emp;

struct emp *temp, *first, *last, *prev, *nextnode, *prevnode, *listtemp;

char answer;
char choice;
char found;
unsigned l_emp_no=0;
float l_basic_pay=0.0;

void insert_node(void);
void delete_node(void);
void list_noder(void);
void list_nodef(void);

void main(void)
{
	while (!(choice == 'X'))
	{
/*	clrscr(); */
	printf("\n");
	printf("\nDoubly Linked List Maintenance Module");
	printf("\nI. Insert a node in a doubly linked list");
	printf("\nD. Delete a node from a doubly linked list");
	printf("\nF. List nodes of a doubly linked list in a forward direction");
	printf("\nR. List nodes of a doubly linked list in a reversed direction");
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
	else if (choice == 'R')
		{
		if (!(first == NULL))
			{
			list_noder();
			}
		else
			{
			printf("\nLinked List is empty...");
			}
		}
	else if (choice == 'F')
		{
		if (!(first == NULL))
			{
			list_nodef();
			}
		else
			{
			printf("\nLinked List is empty...");
			}
		}
	}
return;
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
	temp->prev=NULL;
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
		temp->prev=last;
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
void list_noder(void)
{
	listtemp=last;
	while (!(listtemp == NULL))
	{
	printf("\n%u \t %.2f",listtemp->emp_no, listtemp->basic_pay);
	listtemp=listtemp->prev;
	}
}
void list_nodef(void)
{
	listtemp=first;
	while (!(listtemp == NULL))
	{
	printf("\n%u \t %.2f",listtemp->emp_no, listtemp->basic_pay);
	listtemp=listtemp->next;
	}
}
void delete_node(void)
{
	printf("\nEnter Emp Number to delete a node : ");
	scanf("%u", &l_emp_no);
	found = 'N';

	if (first->emp_no == l_emp_no)
		{
		if (first->next == NULL)
			{
				free(first);
				first = NULL;
				found = 'Y';
			}
		else
		{
			temp = first;
			found = 'Y';
			first = first->next;
			first->prev == NULL;
			free(temp);
		}
		}
	else
	{
	temp = first->next;
	prevnode = first;

	while (!(temp == NULL))
	{
	if (temp->emp_no == l_emp_no)
		{
		found = 'Y';
		if (temp == last)
			{
			last = prevnode;
			prevnode->next = NULL;
			free(temp);
			break;
			}
		else
		{
			prevnode->next = temp->next;
			nextnode = temp->next;
			nextnode->prev = prevnode;
			free(temp);
			break;
		}
		}
	else
		{
		prevnode = temp;
		temp = temp->next;
		}
	}
	}
	if (found == 'N')
	{
		printf("\nNo such node is existing in a linked list");
	}
}

