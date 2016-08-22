

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
	public void displayLink() // display ourself
	{
		System.err.print("{" + info  + "}");
	}

} 

class Binary_search
{
	public Link root;

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
				} // end else go right
			} // end while
		} // end else not root
		
		
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
        inorder(root);
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
			System.out.println("6. EXIT");
			
			
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
				System.exit(0);
			default:
				System.out.println("Select Correct Choice");
				break;
			}
		}
	}

}
