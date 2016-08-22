/*
   This program will write and read records from EMP.DAT file.
   Create corresponing objects out of it.
   Display the content of each object.
   Author : Sanjay Chaudhary

*/


import java.io.*;
import java.util.*;


class Person implements Serializable
{ 
	public Person(int id, String nm)
        {
                pid = id;
                pnm = nm;
        }
	public void print()
	{
	        System.out.println("------------------------------------");
	      	System.out.println("ID : "+pid);
	 	System.out.println("NAME : "+pnm);
	}

        private int pid;
        String pnm;

}

class Employee extends Person 
{
		
	public Employee(int eid,String enm,int sal)
	{
		super(eid,enm);
		salary=sal;
	}
	public void display()
	{
		print();
		System.out.println("Salary :"+salary);

        }
 
	private int salary;
}

public class EmployeeTestObjectStream implements Serializable
{ 
    public static void main(String[] args)throws IOException
    {
        	
        String choice="y";
	boolean append=true;
        Employee emp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	File file = new File("emp.dat"); 

//Creates an output file stream to write to the file with the specified name

        FileOutputStream fos = new FileOutputStream(file.getName(),append );
	

ObjectOutputStream oos = (file.length() > 0) ? new NoHeaderOutputStream(fos):new ObjectOutputStream(fos); 


//An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream. The objects can be read (reconstituted) using an ObjectInputStream. Persistent storage of objects can be accomplished by using a file for the stream. If the stream is a network socket stream, the objects can be reconsituted on another host or in another process. 

//Only objects that support the java.io.Serializable interface can be written to streams. 
		
    
   	try
   	{
   	while(choice.equals("y"))
	{
		
                System.out.print("Enter Emp Id   :");
		int id = Integer.parseInt(br.readLine());
		
		System.out.print("Enter Emp name :");
		String nm = br.readLine();
		
		System.out.print("Enter salary   :");
		int sal = Integer.parseInt(br.readLine());
				
		emp= new Employee(id,nm,sal);
		oos.writeObject(emp);
				
              System.out.print("Do you want to add more records ? y/n ");
            choice=br.readLine();
                
        }
        }catch(Exception e)
	{
	     System.out.println(e);
	}
        	
oos.flush();
oos.close();
fos.close();        
	
	
		
        FileInputStream fis = new FileInputStream("emp.dat");
	
	ObjectInputStream ois = new ObjectInputStream(fis);
		
      	boolean EOF = false;
	try
	{         
                   while(fis.available() > 0)
                   {
                      	emp = (Employee)ois.readObject();
                	emp.display();
                   }
        
	}catch(Exception e)

	{
		
		EOF=true;
		System.out.println(e);
	}
   	ois.close();
	//bis.close();
	fis.close ();

        
        System.out.println("------------------------------------");
   	System.out.println("End of Program");
}
}
class NoHeaderOutputStream 
         extends ObjectOutputStream 
{ 
  public NoHeaderOutputStream(OutputStream out) 
            throws IOException { 
                super(out); 
    } 
// The writeStreamHeader method is provided so subclasses can append or prepend their own // header to the stream.

  protected void writeStreamHeader() 
               throws IOException { 
     } 
}
        	 
     
