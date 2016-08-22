
/*
 * NAME:CHARVIK PATEL
 * ROLLNO:1401079
 * ASSIGNMENT:8 QUESTION 2 
 *   Create a program in Java to perform the following operations on text files:
 *    Count the number of characters
 *    Count the number of words 
 *    Count the number of lines 
 *    Copy the contents of one file to another 
 *    Rename a file

 * */
import java.*;
import java.io.*;
import java.util.*;
class counter
{
	/********************************************************************
	 * line counter function:
	 * i have use an linenumberreader to count no of line in .txt file
	 * ********************************************************************/
	void linecounter()
	{
	try{
	File file =new File("1401079.txt");
	 if(file.exists()){
        FileReader fr = new FileReader(file);
	    LineNumberReader lnr = new LineNumberReader(fr);
        int linenumber = 0;//initial counter
            while (lnr.readLine()!= null){
        	linenumber++;
            }
             System.out.println("Total number of lines : " + linenumber);
            lnr.close();
	}else{
		 System.out.println("File does not exists!");
	}
}catch(IOException e){
	e.printStackTrace();
}
}
	/***************************************************************************************
	 *word counter function:
	 *this function will count no of word in file
	 *for this i have use an concept that when there is an space then the counter is added
	 *and count the word 
	 * *************************************************************************************/
	void wordcounter()
	{
		try{

            FileReader fr=null;
            BufferedReader br=null;
            try { 
                fr=new FileReader("1401079.txt"); 
                br=new BufferedReader(fr);
                String line=br.readLine();
                int totword=0;//initial counter
                while(line!=null) {
                    String a[]=line.split(" "); 
                    for(int i=0;i<a.length;i++) 
                    { 
                        if(a[i].length()>0) totword+=1;
                    }
                    line=br.readLine(); 
                }
                System.out.print("Total number of words : "+totword);
                br.close();
            } catch(Exception e) {
                e.printStackTrace(); 
                System.out.println("error"+e.getMessage()); 
            } finally//finnaly block for closing an files that i have open
            { 
                br.close(); 
                fr.close(); 
            }
        }catch(Exception e)
        {
            System.out.println("error:"+e);
        }
	}
	/*****************************************************************************
	 * char counter function:
	 * in this i have use an concept of Bufferedreader it will go string wise and
	 *  count an no of char in each string and then add the char
	 * ************************************************************************** */
	void charcounter()
	{
		FileReader fReader;
		try{
			fReader = new FileReader("1401079.txt");
			BufferedReader reader = new BufferedReader(fReader);
			String cursor;  
			String content = "";
			int tochar=0;//initial counter
			
		    while((cursor = reader.readLine()) != null){
		    content += cursor;
		    }
		    tochar=content.length();
		    System.out.println("\ntotal no of character : "+tochar+"\n");
		   
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}
}
/***************************************************************************************************************
 * datacopy from file 1 to file 2 function:
 * in this the concept use by me is frist i read an file byte wise and simaltaniously copying the data in file 2
 * with the help of fileinputstream
 * and fileoutputstream respectively
 * ****************************************************************************************************************/
class filedata_1_to_2_file
{
	void datacopy()
	{
		FileInputStream infile =null;
		FileOutputStream outfile =null;
		byte byteRead;
		try{
		    infile =new FileInputStream("1401079.txt");
		    File f =new File("1401079_copy.txt");
		    outfile=new FileOutputStream("1401079_copy.txt");
		    
		    do{
		        byteRead=(byte)infile.read();
		        outfile.write(byteRead);
		    }
		    while(byteRead!=-1);
		    

		}
		catch(Exception e){
		    System.out.println(e);
		}
		finally{
		    try{
		        infile.close();
		        outfile.close();
		        System.out.println("Data copy from 1401079.txt to 1401079_copy.txt");
		    }
		    catch(Exception e){
		        System.out.println(e);
		    }
		}

	}
}
/********************************************************
 * file rename method:
 * i have use an in build functon via import of java.*;
 * ******************************************************/
class File_Rename
{
	Scanner sc=new Scanner(System.in);
	String xyz;
	void Rename()
	{
		System.out.println("Enter old name :");
		xyz=sc.next();
		File oldName=new File(xyz+".txt");
		System.out.print("Enter new Name :");
		String name=sc.next();
		File newName= new File(name+".txt");
		if(oldName.exists())//if old file is exist then it cheak the inner block
		{
			if(oldName.renameTo(newName))
			{
				System.out.println("New name is:"+newName);
			}
			else
			{
				System.out.println("error in renaming");
			}
		
		}
		else
		{
			System.out.println("error");
		}
	}
}
public class COUNT {
	public static void main(String[] args) throws IOException
	{
		int n;
		Scanner sc=new Scanner(System.in);
		counter c=new counter();
		filedata_1_to_2_file fc=new filedata_1_to_2_file();
		File_Rename fr=new File_Rename();
		/**********************
		 * creating file
		 * ********************/
		File file =new File("1401079.txt");
		FileOutputStream outs = new FileOutputStream("1401079.txt");
		String type = "This is current Account.\n";
			byte[] t = type.getBytes();
			try {
				outs.write(t);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String ac = "Account No. :1234565\n ";
			byte[] a = ac.getBytes();
			try {
				outs.write(a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ra = "overdraft limit :55202\n";
			byte[] r = ra.getBytes();
			try {
				outs.write(r);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ba = "Balance :500000\n";
			byte[] b = ba.getBytes();
			try {
				outs.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}												
			outs.close();
			/*****************
			 * close of file 
			 * ***************/
		do{
		System.out.println("\n1.line counter\n2.word counter\n3.char counter\n4.data copy from one file to another\n5.rename file\n0.exit\nENTER YOUR CHOICE:");
		 n=sc.nextInt();
		switch(n)
		{
		case 1:
		c.linecounter();
		break;
		case 2:
		c.wordcounter();
		break;
		case 3:
		c.charcounter();
		break;
		case 4:
		fc.datacopy();
		break;
		case 5:
		fr.Rename();
		break;
		}
		}while(n!=0);
	}
}
/*refrence:stackoverflow.com,totorialspoint.com*/
/***************
 *END PROGRAM
 * *************/
 