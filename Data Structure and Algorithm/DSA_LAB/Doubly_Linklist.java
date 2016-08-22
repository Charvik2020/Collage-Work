import java.util.*;
class Link
{
  public int data; // data item
  public Link next; // next link in list
  public Link previous; // previous link in list

  public Link(int num) // constructor
  {
   data = num;
  }
  public void displayLink() // display this link
  {
    System.out.print("["+data +"]");
  }
}
class DoublyLinkedList
{
  private Link first; // ref to first item
  private Link last; // ref to last item
  public int size=0;
  public DoublyLinkedList() // constructor
  {
    first = null; // no items on list yet
    last = null;
  }
  public boolean isEmpty() // true if no links
  {
     return first==null;
  }
  public void insertFirst(int num) // insert at front of list
  {
    Link newLink = new Link(num); // make new link
    if( isEmpty() ) // if empty list,
      last = newLink; // newLink <-- last
    else
      first.previous = newLink; // newLink <-- old first
    newLink.next = first; // newLink --> old first
    first = newLink; // first --> newLink
    size++;
  }
  public void insertLast(int num) // insert at end of list
  {
      Link newLink = new Link(num); // make new link
      if( isEmpty() ) // if empty list,
        first = newLink; // first --> newLink
      else
      {
        last.next = newLink; // old last --> newLink
        newLink.previous = last; // old last <-- newLink
      }
    last = newLink; // newLink <-- last
    size++;
  }
  public Link deleteFirst() // delete first link
  {
    Link temp = first;
    if(first.next == null) // if only one item
      last = null; // null <-- last
    else
      first.next.previous = null; // null <-- old next
      first = first.next; // first --> old next
      size--;
    return temp;
  }
  public Link deleteLast()
  {
     Link temp = last;
     if(first.next == null) // if only one item
      first = null; // first --> null
     else
      last.previous.next = null; // old previous --> null
      last = last.previous; // old previous <-- last
      size--;
     return temp;
  }
  public void insertPosition(int pos,int num)
  {
    Link newLink =new Link(num);
    Link current=first;

    for(int i=0;i<pos-1;i++)
    {
      current=current.next;//increment of pointer
      if(current==null)//if current null
      {
        return;
      }
    }
    newLink.next=current.next;//newlink.next<--current.next
    newLink.data=num;//num<--newlink.data
    current.next.previous=newLink;//newlink<--current.next.previous
    current.next=newLink;//newlink<--current.next
    newLink.previous=current;//making new node at the position given and data to that node
    size++;
  }
  public boolean insertAfter(int key, int num)
  {
  Link current = first; // start at beginning
  while(current.data != key) // until match is found,
  {
  current = current.next; // move to next link
  if(current == null)
  return false; // didn’t find it
  }
  Link newLink = new Link(num); // make new link
  if(current==last) // if last link,
  {
  newLink.next = null; // newLink --> null
  last = newLink; // newLink <-- last
  }
  else // not last link,
  {
  newLink.next = current.next; // newLink --> old next
  current.next.previous = newLink;
  }
  newLink.previous = current; // old current <-- newLink
  current.next = newLink; // old current --> newLink
  size++;
  return true; // found it, did insertion

  }
public Link Search(int key) // delete item w/ given key
{
  Link current = first; // start at beginning
  while(current.data != key) // until match is found,
  {
    current = current.next; // move to next link
    if(current == null)
    return null; // didn’t find it
  }
  return current;
}
public void swap(Link a,Link b)//swapping the two number parameter(link of number1,link of number 2)
{
  int tmp=a.data;
  a.data=b.data;
  b.data=tmp;
}
public void Sort(int tmpsize)//sorting mean while its booble sorting  parameter(link of start pointer)
{
  Link tmp;
  Link nexttone;
  Link current;
  for(int i=0;i<tmpsize;i++)//for loop till size of link
  {
    current=first;//first<--current
    for(int j=0;j<tmpsize-1-i;j++)
    {
      if(current.data<current.next.data)
      {
        swap(current,current.next);
      }
      tmp=current;
      current=current.next;
    }
  }
  displayForward();// dispaly an list after sorting
}
  public Link deleteKey(int key) // delete item w/ given key
  {
    Link current = first; // start at beginning
    while(current.data != key) // until match is found,
    {
      current = current.next; // move to next link
      if(current == null)
      return null; // didn’t find it
    }
    if(current==first)                    // found it; first item?
    first = current.next; // first --> old next
    else // not first
    current.previous.next = current.next;
    if(current==last) // last item?
      last = current.previous; // old previous <-- last
    else // not last
      current.next.previous = current.previous;
      size--;
  return current; // return value
  }
  public void displayForward()
  {
	System.out.print("List (first-->last): ");
	Link current = first; // start at beginning
	while(current != null) // until end of list,
	{
		current.displayLink(); // display data
		current = current.next; // move to next link
	}
	System.out.println("");
  }
  public void Reverse_List()
  {
    Link p1=first;
    Link p2;
    p2=p1.next;//p1.next<--p2
    p1.next=null;//p1.next<--null
    p1.previous=p2;//p2<--p1.previous
    while(p2!=null)
    {
      p2.previous=p2.next;//p2.next<--p2.previous
      p2.next=p1;//p1<--p2.next
      p1=p2;//p2<--p1
      p2=p2.previous;//p2.previous<--p2
    }
first=p1;//p1<--first
System.out.println("List After Reverseing");
displayForward();
  }
}
class Doubly_Linklist
	{
	public static void main(String[] args)
	{
		DoublyLinkedList Dll=new DoublyLinkedList();
		Scanner sc=new Scanner(System.in);
		for(;;)
		{
			System.out.println("****IET-AU****");
			System.out.println("1->Insert");
			System.out.println("2->Insert Last");
			System.out.println("3->Delete Last");
			System.out.println("4->Delete First");
			System.out.println("5->Delete Key");
			System.out.println("6->Display");
			System.out.println("7->Sort");
			System.out.println("8->Insert At Position");
			System.out.println("9->Search Key");
			System.out.println("10->Insert After Key");
      System.out.println("11->Reverse List");
			System.out.println("12->Exit");
			System.out.println("Enter your Choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
          System.out.println("Enter Data:");
          Dll.insertFirst(sc.nextInt());
				break;
				case 2:
          System.out.println("Enter Data:");
          Dll.insertLast(sc.nextInt());
				break;
        case 3:
          Dll.deleteLast();
				break;
				case 4:
          Dll.deleteFirst();
				break;
				case 5:
          System.out.println("Enter Data to be deleted:");
          Link d=Dll.deleteKey(sc.nextInt());
          if(d!=null)
          {
            System.out.println("Found Link And Deleted"+ d.data);
          }
          else
          {
            System.out.println("Data Link not Found");
          }
				break;
				case 6:
          Dll.displayForward();
				break;
				case 7:
        System.out.println("List After Sorting");
          Dll.Sort(Dll.size);
				break;
				case 8:
          System.out.println("Enter Index:");
          int index=sc.nextInt();
          System.out.println("Enter data:");
          int data=sc.nextInt();
          Dll.insertPosition(index,data);
				break;
				case 9:
          System.out.println("Enetr Data to Search:");
          int index1=sc.nextInt();
  				Link f = Dll.Search(index1);
  				if( f != null)
  					System.out.println("Found link with Data"+ f.data);
  				else
  					System.out.println("Can’t find link");
				break;
				case 10:
          System.out.println("Enter Key after which you want to enter data:");
          int beforeData=sc.nextInt();
          System.out.println("Enter data:");
          int afterData=sc.nextInt();
          Dll.insertAfter(beforeData,afterData);
  			break;
        case 11:
          Dll.Reverse_List();
        break;
				case 12:
          System.exit(0);
				break;
				default:
        System.out.println("|_____________________|");
					System.out.println("|Enter Correct Choice|");
          System.out.println("|_____________________|");
				break;
			}
		}

	}
}
