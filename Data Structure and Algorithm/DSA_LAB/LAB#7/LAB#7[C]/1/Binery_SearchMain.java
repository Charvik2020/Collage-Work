import java.util.*;

class Link
{
	 public int iData;
    public Link next;
	public Link(int id) // constructor
	{
		iData = id; // initialize data
		// (‘next’ is automatically // set to null)
	}
	public void displayLink() // display ourself
	{
		System.err.print("{" + iData  + "}");
	}
}
class LinkList
{
	private Link first; // ref to first link on list
	public int size=0; //red to size of linkedlist
	public LinkList() // constructor
	{
		first = null; // no items on list yet
	}
	public boolean isEmpty() // true if list is empty
	{
		return (first==null);
	}
	// insert at start of list
	public void insertFirst(int id)
	{ // make new link
		Link newLink = new Link(id);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}
	public void displayList()
	{
		System.out.print("List (first-->last):");
		Link current = first; // start at beginning of list
		while(current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
	
	
	 public Link MiddleLink(Link first,Link end)
	{
		if(first==null)
		{
			return null;
		}
		Link slowPtr=first;
		Link fastPtr=first.next;
		while(fastPtr!=end)
		{
			fastPtr=fastPtr.next;
			if(fastPtr!=end)
			{
				slowPtr=slowPtr.next;
				fastPtr=fastPtr.next;
			}
			
		}
		return slowPtr;
	}

		public Link Search(int value)
		{
		
			Link start=first;
			Link end =null;
			Link middle;
		do{
			
			 middle= MiddleLink(start,end);
			if(middle==null)
			{
				return null;
			}
			if(middle.iData==value)
			{
				return middle;
			}
			else if(middle.iData<value)
			{
				start=middle.next;
			}
			else
			{
				end=middle;
				
			}
		}while(end==null||end.next!=start);
		return null;
	}

}
class Binery_Searchmain
{
	public static void main(String []args)
	{
		int choice;
		Scanner sc=new Scanner(System.in);
		LinkList Ll = new LinkList(); // make list
	//	Binery_Search Bs=new Binery_Search();
	Link f;
		
		for(;;)
		{
			System.out.println("****IET-AU****");
			System.out.println("1. Insert");
			choice=sc.nextInt();
			if(choice==1)
			{
					System.out.println("Enter Number in Dessending Order(larger-->smaller):");
					int Key=sc.nextInt();
					Ll.insertFirst(Key);
				continue;
			}
			
			else{
			System.out.println("2. Display");
			System.out.println("3. Binery Search");
			System.out.println("4. Exit");
			System.out.println("Enter Choice:");
			choice=sc.nextInt();
			switch(choice)
			{
				
				case 2:
					Ll.displayList();
				break;
				case 3:
					System.out.println("Enter number To Be Search :");
					int num=sc.nextInt();
					f=Ll.Search(num);
					if(f!=null)
					{
						System.out.println("Found Data "+f.iData);
					}
					else{
						System.out.println("Not Found Data "+num);
					}
				break;
				case 4:
					System.exit(0);
				
				
			}
			
			
			
		}
	}
}
}