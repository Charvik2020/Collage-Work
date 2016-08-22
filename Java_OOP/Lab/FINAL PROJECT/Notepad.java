import notepad1.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Notepad {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        Notepad_Edit ne;
        
        do
        {
            System.out.println("1>GUEST\n2>ACCOUNT\n3>EXIT\nENTER YOUR CHOICE:");
             choice=sc.nextInt();
             switch(choice)
             {
                 case 1:
                   ne=new Notepad_guest();
                   
                   
        int choice1;
        String Filename_save="filename";
        String Extention_save="txt";
		((Notepad_guest)ne).save_file(Filename_save,Extention_save);
		do{
        System.out.println("1>New File\n2> Open File\n3> copy data\n4> Cut And Paste Data");
        choice=sc.nextInt();
        if(choice==1)
        {
        System.out.println("ENTER FILE NAME:");
        String FileName_Save_get=sc.next();
        System.out.println("ENTER DATA TYPE:");
        String Extention_save_get=sc.next();
		
        ((Notepad_guest)ne).new_file(FileName_Save_get, Extention_save_get);
		
       }
        else if(choice==2)
        {
            System.out.println("ENTER FILE NAME:");
            String FileName_Open_get=sc.next();
            System.out.println("ENTER DATA TYPE:");
            String Extention_Open_get=sc.next();
			((Notepad_guest)ne).open_file(FileName_Open_get, Extention_Open_get);
			
        }
		else if(choice ==3)
		{
			
			ne.datacopy();
		}
		else if(choice == 4)
		{
			ne.datacut();	
		}
    }while(choice!=0);
                     break;
                 case 2:
                    String spassword;
                    char[] password;
         ne=new Notepad_Account();
            Console c=System.console();
            int choice_acc;
            try {
            System.out.println("ENTER USERNAME :");
            String Username=sc.next();
            if(c==null){
            System.out.println("NULL");
            System.exit(1);
            }
            System.out.print("Enter Password :");	
           password=c.readPassword();
             spassword=new String(password);
            System.out.println("PassWord :"+((Notepad_Account)ne).encrypt(spassword));
			System.out.println("PassWord :"+((Notepad_Account)ne).decrypt(((Notepad_Account)ne).encrypt(spassword)));
        }
        catch (Exception ex) 
        {
            System.out.println("ERROR");
        }
			int choice_menubar;
			do{
				System.out.println("1> File \n 2> Edit");
				System.out.print("Enter Your Choice :");
				choice_menubar = sc.nextInt();
				
				if(choice_menubar == 1)
				{
					do{
					System.out.println("1>new file\n2>open file\n0>exit");
					choice_acc=sc.nextInt();
					if(choice_acc==1)
					{
						System.out.println("ENTER FILE NAME:");
						String FileName_Open_get_ACC=sc.next();
						System.out.println("ENTER EXTENTION:");
						String Extention_Open_get_ACC=sc.next();
						((Notepad_Account)ne).new_file(FileName_Open_get_ACC, Extention_Open_get_ACC);
						
					}
					else if(choice_acc==2)
					{
						System.out.println("ENTER FILENAME:");
						String FileName_Open_get_ACC=sc.next();
						System.out.println("ENTER EXTENTION:");
						String Extention_Open_get_ACC=sc.next();
						System.out.print("Enter Password :");	
						password=c.readPassword();
						spassword=new String(password);
						try {
							System.out.println("PassWord :"+((Notepad_Account)ne).encrypt(spassword));
							System.out.println("PassWord :"+((Notepad_Account)ne).decrypt(((Notepad_Account)ne).encrypt(spassword)));
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					try {
						if(spassword.equals(((Notepad_Account)ne).decrypt(((Notepad_Account)ne).encrypt(spassword))))
						{
							((Notepad_guest)ne).open_file(FileName_Open_get_ACC, Extention_Open_get_ACC);
							
						}
						else
						{
							System.err.println("ERROR:PLEASE ENTER CORRECT PASSWORD");
						}
					} catch (Exception e) {
						
						System.out.println("ERROR!CHARVIK");
					}
					}
					
					}while(choice_acc!=0);
				}
				
				else if(choice_menubar == 2)
				{
					
					System.out.println("1> Copy Whole Content \n 2> Cut And Paste Whole Content \n 3> Exit");
					int choice_edit = sc.nextInt();
					
					if(choice_edit == 1)
					{
						
						ne.datacopy();
					}
					
					if(choice_edit == 2)
					{
						
						ne.datacut();
						
						
					}
				}
            }while(choice_menubar < 3);
        
                     

             }
        
            
            
        }while(choice!=3);
    }
}
