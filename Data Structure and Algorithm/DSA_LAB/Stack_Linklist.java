import java.util.*;
class List
{
    public int info;
    public List link;
}
class Stack_Linklist
{
  private List Top=null;
  public void push()
  {
    Scanner sc =new Scanner(System.in);
      List tmp=new List();
      int pushed_item;
      System.out.printf("enter new element:");
      pushed_item=sc.nextInt();
      tmp.info=pushed_item;
      tmp.link=Top;
      Top=tmp;
  }
  public void pop()
  {
         List tmp;
        if(Top==null)
        {
            System.out.printf("Stack is empty\n");
        }
        else
        {
            tmp=Top;
            System.out.printf("Poped item is %d\n",tmp.info);
            Top=Top.link;
        }
  }
public void display()
  {
      List ptr;
      ptr=Top;
      if(Top==null)
      {
          System.out.printf("Stack is empty\n");
      }
      else
      {
          System.out.printf("Stack element is:\n");
          while(ptr!=null)
          {
              System.out.printf("%d\n",ptr.info);
              ptr=ptr.link;

          }

      }

  }
  public void Peak(int pos1)
  {
    List current = Top;//intalization of current pointer as Top
    int i;
    for(i=0;i<pos1-1;i++)//loop for geting upto position
    {
      current=current.link;//incrementing pointer
      if(current==null)//if  statement for if some one enter position out of index then it will return
      {
        System.out.println("There are less then "+pos1+" elements");
        return;
      }
    }
System.out.println("Peak value is :"+current.info);
  }
  public void Change_position(int pos1,int pos2)
  {
    List current = Top;//intalization of current pointer as Top
    int i;
    List current_1 = Top;//intalization of current pointer as Top

    int j;

    for(i=0;i<pos1;i++)//loop for geting upto position
    {
      current=current.link;//incrementing pointer
      if(current==null)//if  statement for if some one enter position out of index then it will return
      {
        System.out.println("There are less then "+pos1+" elements");
        return;
      }
    }
    for(j=0;j<pos2;j++)//loop for geting upto position
    {
      current_1=current_1.link;//incrementing pointer
      if(current_1==null)//if  statement for if some one enter position out of index then it will return
      {
        System.out.println("There are less then "+pos2+" elements");
        return;
      }
    }

      int tmp=current.info;
      current.info=current_1.info;
      current_1.info=tmp;
      display();


  }
  public void peek()
  {

   if(Top==null)
   {
       System.out.printf("Stack is empty\n");
   }
   else
   {

       System.out.printf("Peek item is %d\n",Top.info);

   }

  }
  public void peep()
  {
    List current=Top;
    while(current!=null)
    {
      if(current.link==null)
      {
        System.out.println("Peep Data is:" +current.info);
        current=null;
      }
      else
      {
        current=current.link;
      }
    }

  }
  public void change_Key(int key,int key2)
  {
    Scanner sc=new Scanner(System.in);
    	List current =Top; // start at ‘Top’
      List ptr1=Top;
      while(current.info!= key) // while no match,
  		{
        if(current.link == null) // if end of list,
  				return; // didn’t find it
  			else // not end of list,
  				current = current.link; // go to next link
      }
      while(ptr1.info!= key2) // while no match,
  		{
        if(ptr1.link == null) // if end of list,
  				return; // didn’t find it
  			else // not end of list,
  				ptr1 =ptr1.link; // go to next link
      }

      	int tmp=current.info;
    		current.info=ptr1.info;
    		ptr1.info=tmp;
        display();
  }
  public List Search(int key)
  {
    int size=0;
    List current =Top; // start at ‘Top’
    while(current.info!= key) // while no match,
    {
      if(current.link == null) // if end of list,
        return null; // didn’t find it
      else // not end of list,
        current = current.link; // go to next link
        size++;
    }
    System.out.println("Data Found At Position "+size);
  return current;
  }

}
class Stack_LinklistMain{
  public static void main(String[] args) {
    int choice;
    Stack_Linklist Sll=new Stack_Linklist();
    Scanner sc=new Scanner(System.in);
    for(;;)
    {
        System.out.printf("**STACK USING LINKLIST**\n");
        System.out.printf("1.push\n");
        System.out.printf("2.pop\n");
        System.out.printf("3.display\n");
        System.out.println("4.Search");
        System.out.println("5.change Key");
        System.out.println("6.change Position");
        System.out.println("7.Peek");
        System.out.println("8.Peep");
        System.out.printf("9.Peak\n");
        System.out.println("10.Exit");
        System.out.printf("ENTER YOUR CHOICE:");
        choice =sc.nextInt();
        switch(choice)
        {
            case 1:
            {
                Sll.push();
                break;
            }
            case 2:
            {
                Sll.pop();
                break;
            }
            case 3:
            {
                Sll.display();
                break;
            }
            case 4:
            {
              System.out.println("Enter value to be Search:");
              int Key=sc.nextInt();
              List f=Sll.Search(Key);
              if(f!=null)
              {
                System.out.println("Data Link Found "+f.info);
              }
              else
              {
                System.out.println("Data not found");
              }
              break;
            }
            case 5:
            {
              System.out.println("enter number1:");
              int num1=sc.nextInt();
              System.out.println("enter number2:");
              int num2=sc.nextInt();
              Sll.change_Key(num1,num2);
              break;
            }
            case 6:
            {
              System.out.println("enter position1:");
              int POS1=sc.nextInt();
              System.out.println("enter position2:");
              int POS2=sc.nextInt();
              Sll.Change_position(POS1,POS2);
              break;
            }
            case 7:
            {
              Sll.peek();
              break;
            }
            case 8:
            {
                Sll.peep();
                break;
            }
            case 9:
            {
              System.out.println("enter position to be Peak :");
              int POS1=sc.nextInt();
              Sll.Peak(POS1);
              break;
            }
            case 10:
            {
              System.exit(0);
            }

        }

    }

  }
}
