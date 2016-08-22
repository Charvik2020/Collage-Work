import java.util.*;
class node
{
    node left,right;
    int data;
    
    public node(int n)
    {
        left=null;
        right=null;
        data=n;
    }
}
class BT
{
    private node root;
	static boolean left;
    //node x;
    public BT()
    {
        root=null;
    }
    public void insert(int data)
    {
		
        root=insert(root,data);
		
    }
    public node insert (node n,int data)
    {
		
		//node n=root;
		if(n==null)
        {
			n=new node(data);
			left=true;
			//n.left=null;
			//n.right=null;
        }
		else{
			while(root!=null){
			if(n.data>data)
            {
				n.left=insert(n.left,data);
				//n.left=n.left.left;
                
            }
			else
			{
				n.right=insert(n.right,data);
				//n.right=n.right.right;
                
				
			}
			
			}
			//return parent;
		}
        
        return n;
    }
    public void inorder()
    {
        inorder(root);
    }
    public void inorder(node n)
    {
        if(n!=null)
        {
            inorder(n.left);
            System.out.println(n.data+" ");
            inorder(n.right);
        }
    }
    public void preorder()
    {
        preorder(root);
    }
    public void preorder(node n)
    {
        if(n!=null)
        {
            System.out.println(n.data+" ");
            preorder(n.left);
            preorder(n.right);
        }
    }
    public void postorder()
    {
        postorder(root);
    }
    public void postorder(node n)
    {
        if(n!=null)
        {
            postorder(n.left);
            postorder(n.right);
            System.out.println(n.data+" ");
        }    
    }
}
class BT_main
{
    static Scanner in=new Scanner(System.in);
    public static void main(String Args[])
    {
        int temp;
        BT bt=new BT();
        while(true)
        {
            System.out.println("Enter the element:");
            bt.insert(in.nextInt());
            System.out.println("Inorder:");
            bt.inorder();
            System.out.println("Postorder:");
            bt.postorder();
            System.out.println("Preorder:");
            bt.preorder();
            System.out.println("Do you want enter another element(1/0)");
            temp=in.nextInt();
            if(temp!=1)
            break;
        }
    }
}