import java.util.*;
import java.math.*;
class Link
{
	public int info;
	public Link link;
}

class Stack {

	private Link Top=null;
  public void push(int pushed_item){
		Scanner sc =new Scanner(System.in);
		Link tmp = new Link();
		tmp.info=pushed_item;
		tmp.link=Top;
		Top=tmp;

	}
	public int pop() {

		Link tmp=new Link();
		if(Top==null)
		{
			System.out.printf("Stack is empty\n");
		}
		else
		{
			tmp=Top;
			//            System.out.printf("Poped item is %d\n",tmp.info);
			Top=Top.link;
		}
		return (int)tmp.info;
	}
	public int peek() {

		if(Top==null)
		{
			System.out.printf("Stack is empty\n");

		}
		else
		{

			return Top.info;

		}
		return Top.info;
	}
	public boolean isStackEmpty() {
		if(Top==null)
			return true;
		else
			return false;


	}
}

class towersOfHanoi
{
	private static Stack[] tower;
  static int count=0;
	public static void towersOfHanoi(int n)
	{
		tower = new Stack[n+1];
		for (int i = 0; i <= n; i++)
		{
			tower[i] = new Stack();
		}
		for (int d = n; d > 0; d--)
		{
			tower[1].push(new Integer(d));
		}
		showTowerStates(n, 1, 2, 3);
    //System.out.println(tower.count);
	}
	public static void showTowerStates(int n, int x, int y, int z) {

		if (n > 0) {
      try{
			showTowerStates(n - 1, x, z, y);
			// move d from top of tower x
			Integer d = (Integer) tower[x].pop();
			// to top of tower y
			tower[y].push(d);
			System.out.println("Move disk " + d+ " from tower "+ x + " to top of tower " + y);
			showTowerStates(n - 1, z, y, x);
    }
    catch(Exception e){}
		}
	}
}
class TowersOfHanoiImpl {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;double noofmoves=0;
		towersOfHanoi toh=new towersOfHanoi();
		do{
			System.out.println("No Of Disc :");
			int nDisc=sc.nextInt();
			System.out.println("Running "+ nDisc+" disk problem:");
			toh.towersOfHanoi(nDisc);
      for(int i=1;i<=nDisc;i++)
      {
         noofmoves=Math.pow(2,nDisc)-1;
      }
      System.out.println("No of Moves : "+noofmoves);
			System.out.println("Do you want to continue ?(1/0)");
			choice =sc.nextInt();
		}while(choice==1);
	}
}
