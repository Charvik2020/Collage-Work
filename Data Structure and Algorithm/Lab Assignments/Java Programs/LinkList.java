class LinkList
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public void insertFirst(int id)
      {                           // make new link and make it point to
				  // the old first
      Link newLink = new Link(id, first);
      first = newLink;            // now first points to this
      }
// -------------------------------------------------------------
   public Link find(int key)      // find link with given key
      {                          
      // if empty linked list, then return null
      if(first == null)
	return null;

      // otherwise scan list until a node with key is found
      Link current = first;              // start at 'first'
      while(current.iData != key)        // while no match,
         {
         if(current.next == null)        // if end of list,
            return null;                 // didn't find it
         else                            // not end of list,
            current = current.next;      // go to next link
         }
      return current;                    // found it
      }
// -------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
      {                           // (assumes non-empty list)
      Link current = first;              // search for link
      Link previous = first;
      while(current.iData != key)
         {
         if(current.next == null)
            return null;                 // didn't find it
         else
            {
            previous = current;          // go to next link
            current = current.next;
            }
         }                               // found it
      if(current == first)               // if first link,
         first = first.next;             //    change first
      else                               // otherwise,
         previous.next = current.next;   //    bypass it
      return current;
      }
// -------------------------------------------------------------
   public void displayList()      // display the list
      {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
// void insertLast(int x)
	{
		// Make a new node containing x
		Link newNode = new Link(x, null);
		
		// If list is empty, then make first point to the new node
		if(first == null)
			first = newNode;

		// otherwise scan to the end of the list
		Link current = first;
		while(current.next != null)
			current = current.next;

		// connect the new node after current
		current.next = newNode;

	}
// -------------------------------------------------------------
// Removes all of the elements from this list.
	void clear()
	{
		first = null;
	}
// -------------------------------------------------------------
// Retrieves, but does not remove, the first (first element) of this list.
	int element()
	{
		if(first != null)
			return first.iData;

		return 0;
	}
// -------------------------------------------------------------
// Returns the element at the specified position in this list.
	int get(int index)
	{
	
		// Initialize current and initialize a counter
		Link current = first;
		int count = 0;

		// Scan as many nodes as specified by index
		while(count < index)
		{
			// check to make sure that we have not scanned
			// past the end of the list; if not move 
			// current and increment counter
			if(current != null)
			{
				current = current.next;
				count++;
			}
			else
				return 0;
		}

		// We have reached index
       		if(current != null)
			return current.iData;
                else
                	return 0;
	}	
// -------------------------------------------------------------
	int deleteFirst()
	{
		Link temp = first;

		if(first != null)
		{
			first = first.next;
			return temp.iData;
		}
		else
			return 0;
	}

// -------------------------------------------------------------
        public static void main(String[] args) {
	
		LinkList L = new LinkList();
	
		L.insertFirst(5);
		L.insertFirst(15);
		L.insertFirst(25);

		// Should see 25, 15, 5
		L.displayList();

		// Looking for an item that should be found
		Link a = L.find(15);
		if(a != null)
		{
			a.displayLink();
			System.out.println("");
		}
		else
			System.out.println("15 not found");
	

		// Looking for an item that should be not found
		Link b = L.find(17);
		if(b != null)
		{
			b.displayLink();
			System.out.println("");
		}
		else
			System.out.println("17 not found");
		
		// Deleting in the middle
		L.delete(15);
		// Should see 25-5
		L.displayList();

		L.insertFirst(50);

		// Deleting from the end
		L.delete(5);
		// Should see 50-25
		L.displayList();

		// Deleting from the front
		L.delete(50);
		// Should see 25
		L.displayList();

		L.addLast(30);
		L.addLast(22);
		// Should see 25-30-22
		L.displayList();

		// Should see 25
		System.out.println(L.element());

		// should see 25-30-22-0-0-0...
		for(int i = 0; i < 10; i++)
			System.out.println(L.get(i));

		// should see 25
		System.out.println(L.removeFirst());

		// should see 30
		System.out.println(L.removeFirst());

		// should see 22
		System.out.println(L.removeFirst());

		// Should see an empty list
		L.displayList();
	}
   }  // end class LinkList
