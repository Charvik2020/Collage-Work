package notepad1;


import java.io.*;
import java.util.*;

 public class Notepad_Account extends menubar implements Notepad_Edit 
{
    private static final int[] chain = {211, 3347, 2458, 232, 986, 32323, 23234, 654, 436, 34356};
    char[] password;
    String spassword=null;
		
   Scanner sc= new Scanner(System.in);
   public void datacut()
	{
		
		Scanner sc =new Scanner(System.in);
		System.out.println("ENTER FILENAME FROM WHERE YOU WANT TO CUT?");
		String Filename_cut1=sc.next();
		System.out.println("ENTER EXTENTION FROM WHERE YOU WANT TO CUT?");
		String Extention_cut1=sc.next();
		File oldName1=new File(Filename_cut1+"."+Extention_cut1);
		System.out.println("\nEnter FileName WHERE YOU WANT TO PASTE?: ");
        String Filename_cut= sc.next();
        System.out.println("\nEnter EXTENTION WHERE YOU WANT TO PASTE?: ");
        String Extention_cut = sc.next();
        File newName1= new File(Filename_cut+"."+Extention_cut);
    		if(oldName1.exists())//if old file is exist then it check the inner block
    		{
    			if(oldName1.renameTo(newName1))
    			{
    				System.out.println(" DATA IS PASTE IN `"+newName1+"` FILENAME");
					try{
					File fCUT=new File(Filename_cut1+"."+Extention_cut1);
					fCUT.createNewFile();
					}
					catch(Exception e)
					{
						System.out.println("ERROR:PASTE");
					}
    			}
    			else
    			{
    				System.err.println("ERROR IN CUTING!");
    			}
    			}
    		else
    		{
				System.err.println("ERROR");
    		}
		
	}

   public void datacopy()
	{
                String FileName;String FileName1;
                String Extention;String Extention1;
	
		FileInputStream infile =null;
		FileOutputStream outfile =null;
		byte byteRead;
		try{
			Scanner sc =new Scanner(System.in);
			System.out.println("ENTER FILENAME FROM WHERE YOU WANT TO COPY DATA?");
			FileName=sc.next();
			System.out.println("ENTER EXTENTION OF FILE FROM WHERE YOU WANT TO COPY DATA?");
			Extention=sc.next();
			
		    infile =new FileInputStream(""+FileName+"."+Extention);
			
			
			System.out.println("ENTER FILENAME WHERE YOU WANT TO COPY DATA?");
			FileName1=sc.next();
			System.out.println("ENTER EXTENTION OF FILE WHERE YOU WANT TO COPY DATA?");
			Extention1=sc.next();
			
		    File f =new File(""+FileName1+"."+Extention1);
		    outfile=new FileOutputStream(""+FileName1+"."+Extention1);
		    
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
		        
		    }
		    catch(Exception e){
		        System.out.println(e);
		    }
		}

	}
   public void open_file(String Filename_open,String Extention_open)
   {
       int Reader;
		File f=null;
		FileReader fIn =null;
		FileWriter fOut =null;
		Scanner sc=new Scanner(System.in);
		try{
		f=new File(Filename_open+"."+Extention_open);
		if(f.exists())
		{
			fIn=new FileReader(Filename_open+"."+Extention_open);
	        while((Reader=fIn.read()) != -1)
	        {
	        	System.out.print((char)Reader);
	        }
	        	fOut = new FileWriter(Filename_open+"."+Extention_open,true);
	            while((Reader=(char)System.in.read()) != '`')        
			{
                fOut.write(Reader);
			}
                    
	    }
		else 
		{
			System.err.println("FILE NOT FOUND");
		}
		}
		catch(IOException e)
		{
			System.err.println("ERROR");
		}
		finally
		{
            try {
                fOut.close();
                } catch (IOException ex) {
                System.out.println("ERROR");
            }
            try {
					fIn.close();
                } catch (IOException ex) {
					System.out.println("ERROR");
				}
		}
   }
   public void save_file(String Filename_save,String Extention_save)
   {
       String fileName = null;
        Scanner input = new Scanner(System.in);
        String password = null;
	String Filename_save1 = "filename";
	String Extention_save1="txt";
    new_file(Filename_save1, Extention_save1);
	System.out.println("1>Save File");
	System.out.println("2>Exit");
	System.out.print("Enter Your Choice :");
	int choice1 = input.nextInt();
	if(choice1 == 1)
	{
		File oldName=new File(Filename_save1+"."+Extention_save1);
		System.out.println("\nEnter File Name: ");
                Filename_save= input.next();
               System.out.println("\nEnter Extention: ");
               Extention_save = input.next();
                File newName= new File(Filename_save+"."+Extention_save);
    		if(oldName.exists())
    		{
    			if(oldName.renameTo(newName))
    			{
    				System.out.println("FILE IS SAVE AS `"+newName+"` NAME");
    			}
    			else
    			{
    				System.err.println("ERROR IN SAVING!");
    			}
    			}
    		else
    		{
				System.err.println("ERROR");
    		}
						
		}
		else if(choice1 == 2)
		{
			System.exit(1);
		}
   }
   public void new_file(String Filename,String Extention)
   {
       Scanner sc=new Scanner(System.in);
		File f=null;
		FileWriter fOut=null;
		FileReader fIn =null;
		try{
			f=new File(Filename+"."+Extention);
			f.createNewFile();
			
		
		if(f.exists())
		{
			fOut= new FileWriter(Filename+"."+Extention, false);
			char ch;
			System.out.println("\nNOTE:TO END WRITEING FILE PRESS ` BELOW THE ESC KEY ");
			while((ch=(char) System.in.read()) != '`')        
			{
				fOut.write(ch);
			}	   
		}
		else{
			System.out.println("ERROR");
			return;
		}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
                    try {
                        fOut.close();
                    } catch (IOException ex) {
                        System.out.println("ERROR");
                     }
		}
   }
  public static String encrypt(String key)
	{
            String result = "";
        
            try{
		
		int l = key.length();
		char ch;
		int ck =  0;
		for(int i = 0;i<l;i++){
			if(ck >=chain.length - 1)
			{
				ck = 0;
			}
			ch = key.charAt(i);
			ch += chain[ck];
			result = result + ch;
			ck++;
		}
		
            }
            catch(Exception e)
            {
                System.out.println("ERROR");
            }
            return result;
	}
	public  static String decrypt(String key) 
	{
            String result = "";
            try{
		//private static final int[] chain{211, 3347, 2458, 232, 986, 32323,23234,654,436,34356};
		
		int l = key.length();
		char ch;
		int ck = 0;
		for(int i = 0;i<l;i++){
			if(ck >= chain.length -1){ck = 0;}
			ch = key.charAt(i);
			ch -= chain[ck];;
			result += ch;
			ck++;
		}
            }
            catch(Exception e)
            {
                System.out.println("ERROR");
            }
		return result;
	}
    public void config()
    {
        try {
            System.out.println("ENTER USERNAME :");
            String Username=sc.next();
            Console c =System.console();
            if(c==null){
                    System.out.println("NULL");
                    System.exit(1);
            }
            System.out.print("Enter Password :");	
             password=c.readPassword();
             spassword=new String(password);
            System.out.println("PassWord :"+encrypt(spassword));
        }
        catch (Exception ex) 
        {
            System.out.println("ERROR");
        }
    }

}