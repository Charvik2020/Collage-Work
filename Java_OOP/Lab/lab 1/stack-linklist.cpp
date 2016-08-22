/*the program below is of stack by linklist
*NAME: "Charvik Patel"
*ROLLNO:1401079
*BRANCH:ICT*/

#include<iostream>
#include<conio.h>
using namespace std;

class node                      //CLASS TO IMPLEMENT STACK
{
    int number;                //STORES ELEMENT VALUE
    node*next;                //STORE ADDRESS OF NEXT ELEMENT
    node*top;                //STORES TOP OF THE STACK
    public:
node()
        {
            top=NULL;
        }
node*newnode(int x)          //CREATES A NEW NODE
{
node*ptr;
ptr=new node;
ptr->number=x;
ptr->next=NULL;
return ptr;
}

void push(int number)       //PUSH ELEMENT
{
node*n;
n=newnode(number);
if (top==NULL)
{
    top=n;
}
else
{
n->next=top;
top=n;
}
}
void pop()                 //PULL ELEMENT
{
if (top==NULL)
{
cout<<"\n   UNDERFLOW....";
return;
}
node*n=top;
top=top->next;
cout<<"\n ELEMENT DELETED:"<<n->number;
delete n;
}
void display()                   //DISPLAY STACK
{
cout<<"\n ELEMENT OF STACKS ARE::\n";
node*x=top;
if(top==NULL)
cout<<"\n UNDERFLOW" ;
else
{
while(x)
{
cout<<x->number<<"\n";
x=x->next;
}
}
}
};


int main()
{
    node n;
    int no,variable;
    do{
    cout<<"STACK:";
    cout<<"\n1.PUSH";
    cout<<"\n2.PULL";
    cout<<"\n3.DISPLAY";
    cout<<"\n4.EXIT";
    cout<<"\n\nENTER YOUR CHOICE:";
    cin>>no;
    switch(no)
    {
        case 1:cout<<"\nENTER ELEMENT:";
               cin>>variable;
               n.push(variable);
               break;
        case 2:n.pop();
               break;
        case 3:n.display();
               break;
        case 4:
            {
               return 0;

            }
                }
    cout<<"\nDO YOU WANT TO PERFORM ANY OTHER OPERATION(1/0):";
    cin>>no;

    }while(no);
}
