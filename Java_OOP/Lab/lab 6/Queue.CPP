#include<iostream>
#include<conio.h>
using namespace std;
class queue1
{
struct node
{
int ele;
node*next;
};
node*front1=NULL;
node*rear=NULL;
node*newnode(int x)
{
node*ptr;
ptr=new node;
ptr->ele=x;
ptr->next=NULL;
return ptr;
}
public:

void operator +(int &ele)
{
node*n;
n=newnode(ele);
if (rear==NULL)
{
	front1=rear=n;
}
else
{
rear->next=n;
rear=n;
}
}

void operator --()
{
if (front1==NULL)
{
cout<<"\nUNDERFLOW";return;
}
node*temp=front1;
if(front1==rear)
{
front1=rear=NULL;
cout<<"\n DELETED ELEMENT:"<<temp->ele;
delete temp;
}
else
{
front1=front1->next;
cout<<"\n DELETED ELEMENT:"<<temp->ele;
delete temp;
}
}

void display() //cannot overload << problem in temp
{
cout<<"\nELEMENT OF QUEUE ARE:\n";
node*temp=front1;
if(temp==NULL)
cout<<"\nEMPTY QUEUE" ;
else
while(temp)
{
cout<<temp->ele;
temp=temp->next;
}
}

};
int main()
{
queue1 q;
int x,y,n=1;
cout<<"\nENTER NUMBER OF ELEMENT YOU WANT TO INSERT:";
cin>>x;
cout<<"\nENTER THE ELEMENT:\n";
for(int i=0;i<x;i++)
{
cin>>y;
q+y;
}
cout<"ELEMENT IN QUEUE:";
q.display();
while(n)
{
n=0;
--q;
cout<<"\n";
q.display();
cout<<"\nDO YOU WANT TO CONTNUE(1/0):";
cin>>n;
}
}