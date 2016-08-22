import java.util.*;
class Queue
{

    int [] arrQueue;
    int Rear,size;
    int Front;
  public Queue(int s)
  {
    size=s;
    arrQueue=new int[size];
    Rear=-1;
    Front=-1;
  }
  public void Insert()
  {
    Scanner sc=new Scanner(System.in);
    int inserted_item;
    if(Rear==size-1)
    {
        System.out.printf("\n**QUEUE IS OVERFLOW**\n");
    }
    else
    {
        if(Front==-1)
        Front=0;
        System.out.printf("\nINPUT ELEMENT IN QUEUE:");
        inserted_item=sc.nextInt();
        Rear=Rear+1;
        arrQueue[Rear]=inserted_item;

    }
  }
  public void Delete()
  {
    if(Front==-1||Front>Rear)
    {
        System.out.printf("\n**QUEUE IS UNDERFLOW**\n");
        return;
    }
    else
    {
        System.out.printf("\n|||||||||||||||||||||||||||||||||||||||");
        System.out.printf("\n|ELEMENT DELETED FROM THE QUEUE IS: %d |\n",arrQueue[Front]);
        System.out.printf("|||||||||||||||||||||||||||||||||||||||");
        Front=Front+1;
    }

  }
  public void Display()
  {

    int i;
    if(Front==-1)
    {
        System.out.printf("\nQUEUE IS EMPTY");
    }
    else
    {
        System.out.printf("QUEUE IS:\n");
        for(i=Front;i<=Rear;i++)
        {
            System.out.printf("%d",arrQueue[i]);
            System.out.printf("\n");
        }
    }

  }
}
class QueueMain
{
  public static void main(String[] args) {
      Queue theQueue=new Queue(10);
      int choice;
      Scanner sc =new Scanner(System.in);
    for(;;)            //infinate for loop for manu dreven program
    {
        System.out.printf("\n****IET-AU****");
        System.out.printf("\n1.Insert\n");
        System.out.printf("2.Delete\n");
        System.out.printf("3.display\n");
        System.out.printf("4.exit\n");
        System.out.printf("ENTER YOUR CHOICE:");
        choice=sc.nextInt();
        switch(choice)
        {
        case 1:
            theQueue.Insert();         //calling of the INSERT function
            break;
        case 2:
            theQueue.Delete();          //calling of thE DELETE function
            break;
        case 3:
            theQueue.Display();      //callng of display function
            break;
        case 4:
            System.exit(0);
        default:
            System.out.printf("ENTER CORRECT CHOICE\n");
        }
   }
  }
}
