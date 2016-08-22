/*
 * Author:charvik patel
 * Rollno:1401079
 * program about:Arraylist 
 * function:|1.  insert 			|
 *			|2.  insert at begaining|
 *			|3.  insert at index	|
 *			|4.  remove by index	|
 *			|5.  remove by beganning|
 *			|6.  remove by end		|
 * 			|7.  remove by val		|
 *			|8.  Sort 				|
 *			|9.  Search index 		|
 *			|10. Search value 		|
 *			|11. clear				|
 */
package DynamicArray;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
 class DynamicArray1
{
    private ArrayList al;
     public DynamicArray1()
    {
        al = new ArrayList();        
    }    

    public void clear()
    {
        al.clear();
    }

    public int size()
    {
        return al.size();
    }   

    public void insert(String key)
    {
        al.add(key);
    }    

    public String get(int index)
    {
        if (index >= al.size())
            return "";
        return (String)al.get(index);
    }

    public void remove(int index)
    {
        if (index >= al.size())
            return ;
        al.remove(index);
        al.trimToSize();
    }   

    public void remove(String key)
    {
        al.remove(key);
        al.trimToSize();
    }
    public void remove_begaining()
    {
        al.remove(0);
    }
    public void remove_end()
    {
        al.remove(al.size()-1);
        al.trimToSize();
    }

    public void display()
    {
        System.out.println("\nArray list : "+ al);
        System.out.println();
    }
    public void AddFrist(String Key_1)
    {
    	al.add(0, Key_1);
    	
    }
    public void Insert_Index(int index,String Key_2)
    {
    	al.add(index, Key_2);
    }
    public void Desending_order_sorting()
    {
    	Collections.sort(al, Collections.reverseOrder());
	}
    public void Search_index(int index)
    {
    	System.out.println("Searched value is '"+al.get(index)+"' and index is '"+al.indexOf(al.get(index))+"'");
    	
    }
    public void Search_value(String Key) {
		System.out.println("Serched value index is '"+al.indexOf(Key)+"' and value '"+al.get(al.indexOf(Key))+"'");
	}
}
 
public class DynamicArray
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        DynamicArray1 da = new DynamicArray1();
 
        char ch;
        
        do 
        {
            System.out.println("**IET-AU**");
            System.out.println("\n|Dynamic Array using Arraylist	|");
            System.out.println("|1. insert 			|");
            System.out.println("|2. insert at begaining		|");
            System.out.println("|3. insert at index		|");
            System.out.println("|4. remove by index		|");
            System.out.println("|5. remove by beganning		|");
            System.out.println("|6. remove by end		|");
            System.out.println("|7. remove by val		|");
            System.out.println("|8. Sort 			|");
            System.out.println("|9. Search index 		|");
            System.out.println("|10. Search value 		|");
            System.out.println("|11. Clear			|");
            System.out.println("|Enter your choice:		|");
            int choice = scan.nextInt();            
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter value to insert");
                da.insert(scan.next() );                     
                break;
            case 2:
            	System.out.println("Enter value to insert");
            	da.AddFrist(scan.next());
            	break;
            case 3:
            	System.out.println("Enter index to insert and value");
            	da.Insert_Index(scan.nextInt(), scan.next());
            	break;
            case 4 : 
                System.out.println("Enter index");
                da.remove(scan.nextInt() );
                break;
            case 5:
            	da.remove_begaining();
            	break;
            case 6:
            	da.remove_end();
            	break;
            case 7 : 
                System.out.println("Enter value");
                da.remove(scan.next() );
                break;                                   
            case 8 :
            	System.out.println("\nBefore Sorted Array");
            	da.display();
                System.out.println("\nSorted Array");
                da.Desending_order_sorting();
                break;
            case 9:
            	System.out.println("Enter index :");
            	da.Search_index(scan.nextInt());
                break;
            case 10:
            	System.out.println("Enter value:");
            	da.Search_value(scan.next());
            	break;
            case 11:
            	da.clear();
            	break;
            default : 
                System.out.println("Wrong Entry \n ");
                do{
                	System.out.println("\nDo you want to continue (Type y(1) or n(0)) \n");
                    ch = scan.next().charAt(0); 
                	if(ch=='N'||ch=='n'||ch=='0')
                	{
                		System.exit(0);
                	}
                	else
                	{
                		continue;
                	}
                }while(ch == 'Y'|| ch == 'y'||ch=='1');
                break;   
            }    
            da.display();    
 
            System.out.println("\nDo you want to continue (Type y(1) or n(0)) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y'||ch=='1');               
    }
}