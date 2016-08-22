

import java.util.*;

class Link
{
	public int info; // data item (key)
	Link leftChild; // this node’s left child
	Link rightChild; // this node’s right child
	public Link(int num) // constructor
	{
		info = num; // initialize data
		// (‘next’ is automatically // set to null)
	} 

} 

class Binary_search
{
	public Link root;
	public boolean delete(int key) // delete node with given key
	{ // (assumes non-empty list)
		Link current = root;
		Link parent = root;
	boolean isLeftChild = true;
	
	while(current.info != key) // search for node
	{
	parent = current;
	if(key < current.info) // go left?
	{
	isLeftChild = true;
	current = current.leftChild;
	}
	else // or go right?
	{
		isLeftChild = false;
		current = current.rightChild;
	}
	if(current == null) // end of the line,
	return false; // didn’t find it
	} // end while
	
	if(current.leftChild==null && current.rightChild==null)
	{
		if(current == root) // if root,
		root = null; // tree is empty
	else if(isLeftChild)
		parent.leftChild = null; // disconnect
	else // from parent
		parent.rightChild = null;
	}
	else if(current.rightChild==null)
	if(current == root)
		root = current.leftChild;
	else if(isLeftChild)
		parent.leftChild = current.leftChild;
	else
		parent.rightChild = current.leftChild;
	else if(current.leftChild==null)	
		if(current == root)
	root = current.rightChild;
	else if(isLeftChild)
		parent.leftChild = current.rightChild;
	else
		parent.rightChild = current.rightChild;
	else // two children, so replace with inorder successor
	{
		Link successor = Successor(current);
	if(current == root)
		root = successor;
	else if(isLeftChild)
		parent.leftChild = successor;
	else
		parent.rightChild = successor;
		successor.leftChild = current.leftChild;
	} // end else two children
	
  return true; // success
} 
	private Link Successor(Link delNode)
	{
	Link successorParent = delNode;
	Link successor = delNode;
	Link current = delNode.rightChild; // go to right child
	while(current != null) 
	{ // left children,
		successorParent = successor;
		successor = current;
		current = current.leftChild; // go to left child
	}
	if(successor != delNode.rightChild) // right child,
	{ 
		successorParent.leftChild = successor.rightChild;
		successor.rightChild = delNode.rightChild;
	}
	return successor;
}



	public void insert(int num)
	{
		Link newNode = new Link(num); // make new node
		newNode.info = num; // insert data
		if(root==null) // no node in root
			root = newNode;
		else // root occupied
		{
			Link current = root; // start at root
			Link parent;
			while(root!=null) // (exits internally)
			{
				parent = current;
				if(num < current.info) // go left?
				{
					current = current.leftChild;
					if(current == null) // if end of the line,
					{ 
						parent.leftChild = newNode;
						return;
					}
				} 
				else // or go right?
				{
					current = current.rightChild;
					if(current == null) // if end of the line
					{ // insert on right
						parent.rightChild = newNode;
						return;
					}
				} 
			} 
		} 
		
		
	}
	public void inorder()
    {
		inorder(root);
		    
    }
    public void inorder(Link n)
    {
		
	    if(n==null)
			return ;
			
            inorder(n.leftChild);
            System.out.print(n.info+" |");
	        inorder(n.rightChild);
	}
	public void preorder()
    {
        preorder(root);
    }
    public void preorder(Link n)
    {
        if(n==null)
        return ;
            System.out.print(n.info+" |");
            preorder(n.leftChild);
            preorder(n.rightChild);
        
    }
    public void postorder()
    {
        postorder(root);
    }
    public void postorder(Link n)
    {
        if(n==null)
        return ;
            postorder(n.leftChild);
            postorder(n.rightChild);
            System.out.print(n.info+" |");
            
    }
	public Link Search(int n)
	{
		Link current=root; // start at beginning of list
		while(current.info != n) // while no match,
		{
			if(n < current.info) // go left?
			{
				current = current.leftChild;
			}
			else
			{
				current = current.rightChild; // or go right?
			}
			if(current == null) // if no child,
				return null; // didn’t find it
		}
		return current; // found it

	}


}


class Binery_SearchMain {
	public static void main(String[] args) {
		int key;
		Scanner sc=new Scanner(System.in);
		Binary_search pre=new Binary_search();
		for(;;)
		{
			
			System.out.println("\n****IET-AU****");
			System.out.println("1. INSERT");
			System.out.println("2. SEARCH BY BINERY");
			System.out.println("3. INORDER");
			System.out.println("4. POSTORDER");
			System.out.println("5. PREORDER");
			System.out.println("6. DELETE BY KEY");
			System.out.println("7. Sort");
			System.out.println("8. EXIT");
			key=sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter an element:");
				int Element=sc.nextInt();
				pre.insert(Element);
				break;
			case 2:
				System.out.println("Enter Element to be Search:");
				int Key1=sc.nextInt();
				Link f=pre.Search(Key1);
				if(f!=null)
				{
					System.out.println("Data Found "+f.info);
				}
				else
				{
					System.out.println("Data Not Found ");
				}
				break;
			case 3:
					
				pre.inorder();
				break;
			case 4:
				pre.postorder();
				break;
			case 5:
				pre.preorder();
				break;
			case 6:
				System.out.println("Enter Key To Be Deleted :");
				System.out.println(pre.delete(sc.nextInt()));
				break;
			case 7:
				pre.inorder();
				break;
			case 8:
				System.exit(0);
			default:
				System.out.println("Select Correct Choice");
				break;
			}
		}
	}

}
