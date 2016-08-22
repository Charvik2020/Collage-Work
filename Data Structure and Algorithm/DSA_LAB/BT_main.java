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
    public node root;
    
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
		
        if(n==null)
        {
            n=new node(data);
        }
        else	
        {
			
			//n=new node(data);
            if(n.left==null)
            {
				n=root;
                n.left=insert(n.left,data);
				
				//n=n.left;
            }
            else if(n.right==null)
            {
				n=root;
                n.right=insert(n.right,data);
				//n=n.right;
            }
        }
        return n;
    }
    public void inorder()
    {
		inorder(root);
		    
    }
    public void inorder(node n)
    {
        if(n==null)
			return ;
        
            inorder(n.left);
            System.out.println(n.data+" ");
            inorder(n.right);
        
    }
    public void preorder()
    {
        preorder(root);
    }
    public void preorder(node n)
    {
        if(n==null)
        return ;
            System.out.println(n.data+" ");
            preorder(n.left);
            preorder(n.right);
        
    }
    public void postorder()
    {
        postorder(root);
    }
    public void postorder(node n)
    {
        if(n==null)
        return ;
            postorder(n.left);
            postorder(n.right);
            System.out.println(n.data+" ");
            
    }
}
public class BT_main
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
			//node n=bt.root;
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