
import java.util.*;
class Link
{
	double info;
	int size;
	Link next;
	Link Prev;
	Scanner sc=new Scanner(System.in);
	public Link(double num) // constructor
	{
		info = num;

		
	}
	public Link (int s)
	{
		size=s;
	}
	public void displayLink() // display this link
	{
		System.out.print("["+info +"]");
	}

}
class Circular_Que
{
	private Link first; // ref to first item
	private Link last; // ref to last item
	int size;
	int counter=0;
	Scanner sc=new Scanner(System.in);
	public Circular_Que() {
		first = null; // no items on list yet
		last = null;
		System.out.println("Enter Size of List:");
		size=sc.nextInt();
		Link newLink = new Link(size); // make new link
		

	}
	
		public void EnQueue(double num) // insert at front of list
	{
			
			Scanner sc=new Scanner(System.in);
			Link newLink = new Link(num); // make new link
				
		if(size>counter)
		{
		if(isEmpty() ) // if empty list,

		{

			first=last = newLink; // newLink <-- last
			first.Prev=null;
			last.next=null;
		}
		else
		{
			last.next=newLink;
			newLink.Prev=last;

		}
		first.Prev = newLink; // newLink <-- old first 
		last = newLink; // first --> newLink
		last.next=first;
		counter++;
		}
		else
		{
			System.out.println("Overflow");
		}

	
	}

	  public Link DeQueue() // delete first link
	  {
	    Link temp = first;
	    if(size>=counter)
	    {
	    if(first.next == temp) // if only one item
	    {
	    	first=last = null; // null <-- last
	    }
	    else
	    {
	      first.next.Prev = null; // null <-- old next
	      last.next=first.next;
	      first = first.next; // first --> old next  
	    }
	    
	    displayForward();
	    counter--;
	    }
	    else
	    {
	    	System.out.println("underflow");
	    }
	    return temp;
	  }
	public boolean isEmpty() // true if no links
	{
		return first==null;
	}
	public void displayForward()
	{
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning
		
		
		do
		{
			current.displayLink();
			current = current.next; // move to next link
			
		}while(current!=first);// until end of list
		System.out.println("");
	}
}
class Circular_Queue_DoublyLLMain
{
	public static void main(String[] args) {
		int choice,info;
		Scanner sc=new Scanner(System.in);
		Circular_Que Cq=new Circular_Que();
		for(;;)
		{
			System.out.println("****IET-AU****");
			System.out.println("1.EnQueue");
			System.out.println("2.DeQueue");
			System.out.println("3.Display");
			System.out.println("4.Exit");
			System.out.println("Enter Choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter number :");
				info=sc.nextInt();
				Cq.EnQueue(info);
				break;
			case 2:
				Cq.DeQueue();
				break;
			case 3:
				Cq.displayForward();
				break;
			case 4:
				System.exit(0);
			}
		}
	}
}