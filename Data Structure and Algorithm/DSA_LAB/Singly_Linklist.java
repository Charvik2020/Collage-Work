import java.util.*;
class Link
{
	public int iData; // data item (key)
	public Link next; // next link in list
	public Link(int id) // constructor
	{
		iData = id; // initialize data
		// (‘next’ is automatically // set to null)
	}
	public void displayLink() // display ourself
	{
		System.err.print("{" + iData  + "}");
	}
} // end class Link
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
		size++;
	}
	public Link deleteFirst() // delete first item
	{ // (assumes list not empty)
		Link temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		size--;
		return temp; // return deleted link
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
	public Link find(int key) // find link with given key
	{ // (assumes non-empty list)
		Link current = first; // start at ‘first’
		while(current.iData != key) // while no match,
		{
			if(current.next == null) // if end of list,
				return null; // didn’t find it
			else // not end of list,
				current = current.next; // go to next link
		}
		return current; // found it
	}
	public Link delete(int pos) // delete link with given position
	{ // (assumes non-empty list)
		Link current = first; // search for link
		Link previous = first;
		int pos_temp=0;
		while(pos_temp!= pos)
		{
			if(current.next == null)
				return null; // didn’t find it
			else
			{
				previous = current; // go to next link
				current = current.next;
				pos_temp++;
			}
		} // found it
		size--;
		if(current == first) // if first link,
			first = first.next; // change first
		else // otherwise,
			previous.next = current.next; // bypass it
		return current;
	}
	public Link deletelast()//delete last
	{
		size--;//decrement of size of list
		return delete(size);
	}
	public void insertlast(int id)//inserting an item at last
	{
		Link newLink = new Link(id);//creating node
		Link current = first;//inalization of temparary node by frist
		while(current.next!=null)//while loop for geting last position
			current=current.next;//incrementing the position
		current.next=newLink;//giving item to the last position
		size++;//increment of size of list
	}
	public void insertatpostion(int id,int pos)//insertion at position parameter(item,position where to put)
	{
		Link newLink = new Link(id);//creating new node
		Link current = first;//intalization of current pointer as frist
		int i;
		for(i=0;i<pos-1;i++)//loop for geting upto position
		{
			current=current.next;//incrementing pointer
			if(current==null)//if  statement for if some one enter position out of index then it will return
			{
				System.out.println("There are less then "+pos+" elements");
				return;
			}
		}
		newLink.next=current.next;//pointing to previous node
		newLink.iData=id;//getting data to the node
		current.next=newLink;//privious node will pointing to insered node
		size++;//incrmenting size of list
	}
	public void swap(Link a,Link b)//swapping the two number parameter(link of number1,link of number 2)
	{
		int tmp=a.iData;
		a.iData=b.iData;
		b.iData=tmp;
	}
	public void Sort()//sorting mean while its booble sorting  parameter(link of start pointer)
	{
		int i;
		Link ptr1=first;//tmp pointer initialize by frist
		Link ptr_1=null;//tmp pointer iniatalize by null
		if(ptr1==null)//if frist is null there will no list existest so it will retun
		{
			return;
		}
		do
		{
			while(ptr1.next!=ptr_1)//whill  loop will run untill ptr1 will be equal to null
			{

				if(ptr1.iData < ptr1.next.iData)//if number is less then its next node number then this will run
				{
					swap(ptr1,ptr1.next);

				}
				ptr1=ptr1.next;//incrementing pointer
			}
			ptr_1=ptr1;//changeing ptr_1 to the value of ptr1
		}while(ptr1.next!=null);
		displayList();// dispaly an list after sorting
	}
	public void ReverseLink()
	{

		Link current = first;

		Link Previous = null;

		Link temp = null;

		while(current!=null)
		{

				if(current==first)
				{
					temp = current.next;
				}
					else
					{
					temp=current.next;
					}
					if(temp==null)
					{
						first = current;
					}
					current.next=Previous;
					Previous=current;
					current = temp;

	}

	}
}

class SinglyLinklist1
{
	public static void main(String[] args)
	{
		int choice,data;
		Link start=null;
		Scanner sc=new Scanner(System.in);
		LinkList theList = new LinkList(); // make list
		for(;;)
		{
			System.out.println("****IET-AU****");
			System.out.println("1. InsertFirst");
			System.out.println("2. Search");
			System.out.println("3. Display");
			System.out.println("4. DeleteAtPosition");
			System.out.println("5. DeleteFirst");
			System.out.println("6. DeleteLast");
			System.out.println("7. InsertLast");
			System.out.println("8. InsertPosition");
			System.out.println("9. Sort");
			System.out.println("10.Reverse LinkList");
			System.out.println("11.Exit");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("ENTER VALUE:");
				data=sc.nextInt();
				theList.insertFirst(data);
				break;
			case 2:
				System.out.println("ENTER VALUE:");
				int index1=sc.nextInt();
				Link f = theList.find(index1);
				if( f != null)
					System.out.println("Found link with Data"+ f.iData);
				else
					System.out.println("Can’t find link");
				break;
			case 3:
				theList.displayList();
				break;
			case 4:
				System.out.println("ENTER INDEX:");
				int index=sc.nextInt();

				Link d =  theList.delete(index);
				if( d != null )
					System.out.println("Deleted link with position " + d.iData);
				else
					System.out.println("Can’t delete link");

				break;
			case 5:
				theList.deleteFirst();
				break;
			case 6:
				theList.deletelast();
				break;
			case 7:
				System.out.println("ENTER VALUE:");
				data=sc.nextInt();
				theList.insertlast(data);
				break;
			case 8:
				System.out.println("Enter Value And Index:");
				theList.insertatpostion(sc.nextInt(),sc.nextInt());
				break;
			case 9:
				System.out.println("List After Sorting:");
				theList.Sort(start);
				break;
			case 11:
				System.exit(0);
				break;
				case 10:
				theList.ReverseLink();
				break;
			default:
				System.out.println("Enter correct Choice|");
				break;
			}
		}

	}
}
