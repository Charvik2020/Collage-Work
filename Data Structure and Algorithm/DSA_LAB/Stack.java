import java.util.*;
class Stack
{
  public int Size; // size of stack array
  public int[] Array;
  private int Top; // top of stack
  public Stack(int s) // constructor
  {
    Size = s; // set array size
    Array = new int[Size]; // create array
    Top = -1; // no items yet
  }
  public void push(int j) // put item on top of stack
  {

    if(Top==(Size-1))       //cheack for stack overflow
    {
        System.out.println("STACK OVERFLOW..!!");
    }
    else
    {
      Top=Top+1;          //increment the pointer value by one
      Array[Top]=j; //perform incertion

    }

  }

  public void  pop() // take item from top of stack
  {
    if(Top==-1)             //cheaking wheather stack is empty
    {
        System.out.printf("STACK UNDERFLOW\n");
    }
    else
    {
        System.out.printf("POPED ELEMENT IS:%d\n",Array[Top]);
        Top=Top-1;          //removing the top impormation
    }
  }
  public void Display()
  {
      if(Top==-1)
      {
        System.out.println("STACK IS EMPTY");
      }
      else
      {
        System.out.println("STACK IS:");
        for(int i=Top;i>=0;i--)
        {
          System.out.printf("%d\n",Array[i]);
        }

      }
  }
}
class StackMain
{
  public static void main(String[] args)
    {
      Stack theStack = new Stack(10); // make new stack
      Scanner sc =new Scanner(System.in);
      for (;;)
      {
        System.out.println("****IET-AU****");
        System.out.println("1. push");
        System.out.println("2. Pop");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        int choice =sc.nextInt();
        switch(choice)
        {
          case 1:
            System.out.println("ENTER ITEM:");
            int item=sc.nextInt();
            theStack.push(item);
          break;
          case 2:
              theStack.pop();
          break;
          case 4:
            System.exit(0);
          break;
          case 3:
            theStack.Display();
            break;
          default:
            System.out.println("ENTER CORRRECT CHOICE");
          break;
        }
      }

    }
}
