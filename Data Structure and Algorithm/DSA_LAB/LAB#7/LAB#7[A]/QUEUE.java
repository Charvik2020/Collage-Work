import java.util.*;
class Link
{
	int info;
	Link link;

}
class Queue
{
	Link Front=null;
	Link Rear=null;

	Scanner sc=new Scanner(System.in);
	void Insert()
	{
		Link tmp=new Link();
		int Inserted_item;
		System.out.println("\nINPUT THE ELEMENT IN QUEUE:");
		Inserted_item=sc.nextInt();
		tmp.info=Inserted_item;
		tmp.link=null;
		if(Front==null)
		{
			Front=tmp;
		}
		else
		{
			Rear.link=tmp;
		}
		Rear=tmp;
	}
	void Delete()
	{
		Link tmp;
		if(Front==null)
		{
			System.out.println("\nQUEUE IS UNDERFLOW");
		}
		else
		{
			tmp=Front;
			System.out.println("\n|||||||||||||||||||||||||||||||||||||||");
			System.out.println("\n|ELEMENT DELETED FROM THE QUEUE IS: "+tmp.info+"  |");
			System.out.println("|||||||||||||||||||||||||||||||||||||||");
			Front=Front.link;

		}
	}
	void Display()
	{
		Link ptr;
		ptr=Front;
		if(Front==null)
		{
			System.out.println("\nQUEUE IS EMPTY");
		}
		else
		{
			System.out.println("QUEUE ELEMENTS:\n");
			while(ptr!=null)
			{
				System.out.println(ptr.info);
				ptr=ptr.link;
			}
		}
		System.out.println();
	}
	void peak()
	{
		Link ptr=Front;
		if(Front==null)
		{
			System.out.println("\nQUEUE IS EMPTY");
		}
		else
		{
			System.out.println("Peek of Queue is :"+Front.info);
		}
	}

}
class QueueMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
		Queue Que=new Queue();
		for(;;)
		{
			System.out.println("\n**QUEUE USING LINKLIST**");
			System.out.println("1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.display");
			System.out.println("4.exit");
			System.out.println("5.Peak");
			System.out.println("ENTER YOUR CHOICE:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				Que.Insert();         //calling of the INSERT function
				break;
			case 2:
				Que.Delete();          //calling of thE DELETE function
				break;
			case 3:
				Que.Display();      //callng of display function
				break;
			case 4:
				System.exit(0);
			case 5:
				Que.peak();
			default:
				System.out.println("ENTER CORRECT CHOICE\n");
			}

		}

	}

}