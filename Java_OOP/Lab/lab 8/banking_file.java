/*
 * NAME:CHARVIK PATEL
 * ROLLNO:1401079
 * ASSIGNMENT:8 Q-1
 * Modify the banking program of LabAssignmentSession7 to store the account details in binary files and allow the user
 * to create as well as delete an account. The user should also be allowed to perform operations on
 * existing accounts through a menu.
*/
import java.util.*;
import java.io.*;
abstract class Account
{
	private double credit;
	public double balance;
	Scanner S=new Scanner(System.in);
	protected int count=0;
	protected double account_no;
	static int x1,y1;
     public Account()//DEFULT CONSTRUCTER
    {
        balance=0;
        
    }
    public Account(double bal,double acc_no)//PARAMETER CONSTRUCTER
    {
        balance=bal;
        account_no=acc_no;
        
    }
    public double get_balance()//MEMBER FUNCTION OF GET BALANCE
    {
        return balance;
    }
    public double account_no()
	{
    	count++;
		return (account_no);
	}
   
    public double get_credit() throws FileNotFoundException//MEMBER FUNCTION OF GET CREDIT
    {
        System.out.println("HOW MUCH CREDIT DO YOU WANT TO CREDIT?");
        double credit=S.nextDouble();
        if(credit>=0)
        {
            balance=balance+credit;
            System.out.println("BALANCE UPDATED SUCCESSFULLY"+"\nNEW BALANCE:"+balance);
         
        }
        
        else
        {
            System.out.println("BALANCE UPDATED UNSUCCESSFULLY");
        }
        
        return credit;
    }
    /*************************************************************************
     * DELETING ACCOUNT FUNCTION:
     * THIS WILL DELETE AN FILE AND ACCOUNT DETAIL WITH THE FUNCTION .DELETE
     * ***********************************************************************/
    public void deleteAccount()
	{
    	String fileName = String.valueOf(account_no());
    	
		File file = new File("IET_ACCOUNT_NO_"+fileName);
		try
		{
			if(file.delete())
			{
				System.out.println("Account deleted successful");	
			}
			else
			{
				System.out.println("delete operation unsuccessful");
			}
		
		}
		
		catch(Exception e) 
		{
		    	System.out.println("delete operation unsuccessful");
		}
	}
}
class saving extends Account
{
	//MEMBER FUNCTION OF SAVING CLASS
    public double rateofintrest;
    public int month;
    public int year,s_ac_no;
   public saving(double bal,double acc_no, int rate_of_intrest,int mnth,int yr) {
       super(bal,acc_no);
       rateofintrest=rate_of_intrest;
       month=mnth;
       year=yr;
       
    }
   
   /****************************************************************************************
    * WITHDROW FUNCION WILL DO THE WITHROW MONEY FROM SAVING ACCOUNT.
    * BUT THERE IS AN CONDITON THAT AFTER WITHDROW THERE MUST BE MINIMUM âš 500 IN ACCOUNT,
    * THUS I HAVE KEPT IF CONDITION IN FUNCTION
    * @throws FileNotFoundException 
    *****************************************************************************************/
   public void withdrow() throws FileNotFoundException
   {
       System.out.println("ENTER AMOUNT TO BE WITHDROW?");
      double withdrow=S.nextDouble();
      if(balance-withdrow>=500)
      {
          balance=balance-withdrow;
          System.out.println("***SAVING WITHDROW***"+"\nNEW BALANCE"+balance+"\nBALANCE IS UPDATED");
            }else
      {
           System.out.println("BALANCE UPDATED UNSUCCESSFULLY");
      }
}
   /*****************************************************************************
    * INTREST FUNCTION WILL CALCULATE INTREST EVERY 3 MONTH,
    * FOR THIS I HAVE TAKE AN DIFFRENCE OF THE TWO DATES WHICH I HAVE ASK WHILE 
    * CHOICE OF ACCOUNT 
    *  
    *****************************************************************************/
   
      public void Intrest() throws FileNotFoundException
   {
       double si=0;int e=1;
       System.out.println("ENTER CURRENT MONTH:");
       int month1=S.nextInt();
       System.out.println("ENTER CURRENT YEAR:");
       int year1=S.nextInt();
     if(year<=year1)
      {
        int a = month1 - month;
        int b = year1 - year;
        int Month = a + b*12;
        int T= Month/3;
        for(int i=0;i<T;i++)
         { 
            si=(balance*rateofintrest*(0.25))/100;
            System.out.println("INTREST:"+balance);
            balance = si + balance;continue;
         }
         System.out.println("TOTAL INTREST IS "+ si+ "RS.");
         System.out.println("NOW YOUR CURRENT ACCOUNT BALANCE IS: " +balance);

         
}
}
      /****************************
       * CREATE FILE FUNCTION:
       * THIS WILL CREATE AN FILE
       * ***************************/
      public void createFile()
   	{					
   		String fileName = String.valueOf(account_no());					
   		
   		try{					
   			FileOutputStream outs = new FileOutputStream("IET_ACCOUNT_NO_"+fileName);
   			ObjectOutputStream oos =new ObjectOutputStream(outs);
   			String type ="This is Saving Account.\n";
   			byte[] t = type.getBytes();
   			oos.writeObject(t);
   			String ac = "\n Account No. : "+ account_no()+"\n";
   			byte[] a = ac.getBytes();
   			oos.writeObject(a);
   			String ra = "\n Interest Rate :" +rateofintrest+"\n";
   			byte[] r = ra.getBytes();
   			oos.writeObject(r);
   			String ba = "\n Balance :"+ get_balance()+"\n";
   			byte[] b = ba.getBytes();
   			oos.writeObject(b);
   			oos.close();
   		}
   		catch(IOException ex) 
   		{
   		    System.out.println("Error writing to file '"+ fileName + "'");
   		}
   	}
      /***************************************************
       * READ FILE FUNCTION:
       * THIS WILL READ AN DATA IN FILE OF ENTER ACCOUNT
       * **************************************************/
      public void readFile()
      {
    	  	String fileName = String.valueOf(account_no());
    	  try{
    		  	FileInputStream fis =new FileInputStream("IET_ACCOUNT_NO_"+fileName);
          		DataInputStream dis= new DataInputStream(fis);
          		String type ="This is Saving Account.\n";
          		byte[] t = type.getBytes();
          		dis.read(t);
          		String ac = "\n Account No. : "+ account_no()+"\n";
          		byte[] a = ac.getBytes();
          		dis.read(a);
          		String ra = "\n Interest Rate :" +rateofintrest+"\n";
          		byte[] r = ra.getBytes();
          		dis.read(r);
          		String ba = "\n Balance :"+ get_balance()+"\n";
          		byte[] b = ba.getBytes();
          		dis.read(b);
          		fis.close();
 			

      }catch(Exception e)
      {
    	  System.out.println(e);
      }
      }

  }
class current extends Account
{
	double overdraft_limit,withdrow;
	int c_ac_no;
    current(double bal,double acc_no,double o_draft)
    {
        super(bal,acc_no);
        overdraft_limit=o_draft;
        
    }
    /***********************************************************************************************
     * WITHDROW FUNCION WILL DO THE WITHROW MONEY FROM CURRENT ACCOUNT.
     * BUT THERE IS AN CONDITON THAT ADDITION OF BALANCE AND OVERDRAFT LIMIT MUST BE MORE THAN âš0,
     * THUS I HAVE KEPT IF CONDITION IN FUNCTION
     ***********************************************************************************************/
    public void withdrow() throws FileNotFoundException
    {
        System.out.println("ENTER AMOUNT TO WITHDROW?");
       double withdrow=S.nextDouble();
       balance=balance-withdrow;
       if(balance+overdraft_limit>0)
       {
           System.out.println("***SAVING WITHDROW***"+"\nNEW BALANCE: "+balance+"\nBALANCE IS UPDATED");
           
       }
       else
       {
           System.out.println("BALANCE UPDATED UNSUCCESSFULLY");
       }
}

    /****************************
     * CREATE FILE FUNCTION:
     * THIS WILL CREATE AN FILE
     * ***************************/
    public void createFile()
   	{					
   		String fileName = String.valueOf(account_no());					
   		
   		try{					
   			FileOutputStream outs = new FileOutputStream("IET_ACCOUNT_NO_"+fileName);
   			ObjectOutputStream oos =new ObjectOutputStream(outs);
   			String type = "This is current Account.\n";
   			byte[] t = type.getBytes();
   			
   			oos.writeObject(t);
   			String ac = "Account No. : "+ account_no()+"\n";
   			byte[] a = ac.getBytes();
   			
   			oos.writeObject(a);
   			String ra = "overdraft limit :" +overdraft_limit  + "\n";
   			byte[] r = ra.getBytes();
   			
   			oos.writeObject(r);
   			String ba = "Balance :"+ get_balance();
   			byte[] b = ba.getBytes();
   			
   			oos.writeObject(b);												
   			oos.close();
   		}
   		catch(IOException ex) 
   		{
   		    System.out.println("Error writing to file '"+ fileName + "'");
   		}
   	}
    /***************************************************
     * READ FILE FUNCTION:
     * THIS WILL READ AN DATA IN FILE OF ENTER ACCOUNT
     * **************************************************/
    
    public void readFile()
    {
  	  	String fileName = String.valueOf(account_no());
  	  try{
  		  	FileInputStream fis =new FileInputStream("IET_ACCOUNT_NO_"+fileName);
  		  	DataInputStream dis= new DataInputStream(fis);
  		  	String type ="This is Saving Account.\n";
  		  	byte[] t = type.getBytes();
  		  	dis.read(t);
  		  	String ac = "\n Account No. : "+ account_no()+"\n";
			byte[] a = ac.getBytes();
			dis.read(a);
			String ra = "\n overdraft limit :" +overdraft_limit+"\n";
			byte[] r = ra.getBytes();
			dis.read(r);
			String ba = "\n Balance :"+ get_balance()+"\n";
			byte[] b = ba.getBytes();
			dis.read(b);
			//dis.read(Object);
			fis.close();
    }catch(Exception e)
    {
  	  System.out.println(e);
    }
    }
}
public class banking_file {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner S=new Scanner(System.in);
		int j=0;
		int k=-1,i=0,Account_to_be_deleted;
		for(;;)
			{
            System.out.println("___________________IET-AU____________________");
			System.out.println("1.SAVING ACCOUNT");
			System.out.println("2.CURRENT ACCOUNT");
			System.out.println("0. EXIT ");
            System.out.println("ENTER OUR CHOICE : ");
			int o;
			o=S.nextInt();
			System.out.println("\n");
			switch(o)
			{
			case 1:
            {
            	//ENTER OF DETAIL SUCH AS BALANCE,ACCOUNT NO,OVERDRAFT LIMIIT.
    			System.out.println("HOW MANY SAVING ACCOUNT DO YOU WANT TO CREATE?");
    			int n=S.nextInt();
    			saving[] s=new saving[n];
    			Account[] a=new Account[n];
    			do{
    			
    			switch(1){
    			case 1:
    			for(j=0;j<n;j++){
    				if(n==0)
        			{
        				System.out.println("NO ACCOUNT CAN BE CREATED");
        			}
        			else if( k==n)
        			{
        				System.out.println("no more account can be created");
        			}
        			else
        			{
        				for(j=0; j<n; j++)
        				{
        					 System.out.println("ENTER BALANCE: ");
        		                double x=S.nextDouble();
        		                if(x>999)
        		                {
        		                	System.out.print("ENTER ACCOUNT NO: ");
        		                	double y=S.nextInt();
        		        			System.out.println("ENTER RATE OF INTREST: ");
        		                	int z=S.nextInt();if(z>0){
        		                	System.out.println("ENTER MONTH OF CREATING OF ACCOUNT: ");
        		                	Account.x1=S.nextInt();if(Account.x1>0){
        		                	System.out.println("ENTER YEAR OF CREATING OF ACCOUNT: ");
        		                	Account.y1=S.nextInt();if(Account.y1>0){
        		                	//CREATE AN OBJECT OF SAVING CLASS
        		                     s[j]=new saving(x,y, z, Account.x1, Account.y1);
        		                     a[j]=s[j];
        		                     s[j].createFile();
        		                     s[j].readFile();
        		                		}else{System.out.println("YEAR MUST BE GREATER THAN ZERO");};
		                                }else{System.out.println("MONTH MUST BE GREATER THAN ZERO");};
		                                }else{System.out.println("RATE OF INTREST MUST BE GREATER THAN ZERO");};
		                             	}else{System.out.println("BALANCE MUST BE GREATER THAN OR EQUALS TO RS.1000");};
        				
        				}
        			}
    			}
    			                 do{//DO WHILE LOOP FOR DOING THE FUNCTION MENTION IN CASE BY SWITCH CASE INSIDE DO WHILE LOOP
    		                         System.out.println("\n**IET-AU**"+"\n1.WITHDROW \n2.DIPOSIT\n3.INTREST\n4.EXIT\n5.delete account\nENTER YOUR CHOICE:");
    		                        int p=S.nextInt();
    		                        switch(p)
    		                        {
    		                            case 1://WITHDROW
    		                            	System.out.println("WHICH ACCOUNT NO YOU WANT TO WITHDROW?");
    		                            	Account_to_be_deleted=S.nextInt();
    		                            	for(j=0;j<n;j++){
    		                            	if(Account_to_be_deleted==s[j].account_no())
    		                            	{
    		                            	
    		                                if(s[j].balance>500){
    		                                try {
    		                					s[j].withdrow();
    		                					s[j].createFile();
    		                					s[j].readFile();
    		                					break;
    		                				} catch (FileNotFoundException e) {
    		                					// TODO Auto-generated catch block
    		                					e.printStackTrace();
    		                				}//CALLING OF WITHDROW FUNCTION OF SAVING ACCOUNT
    		                                
    		                            	}
    		                            	else if(j==n-1 && Account_to_be_deleted!=s[n-1].account_no)
    		                            	{
    		                            		System.out.println("ACCOUNT NO NOT MATCHED!");
    		                            		break;
    		                            	}
    		                            	}else 
		                                    {
		                                    System.out.println("PLEASE CREDIT YOUR ACCOUNT TO WIDHROW");
		                                    }
    		                            	}
    		                                break;
    		                            case 2://DIPOSIT
                                         	System.out.println("WHICH ACCOUNT NO YOU WANT TO DIPOSITE?");
    		                            	Account_to_be_deleted=S.nextInt();
    		                            	for(j=0;j<n;j++){
    		                            	if(Account_to_be_deleted==a[j].account_no())
    		                            	{
    		                            	
    		                			try {
    		                				a[j].get_credit();
    		                				s[j].createFile();
    		                				s[j].readFile();
    		                				break;
    		                			} catch (FileNotFoundException e1) {
    		                				// TODO Auto-generated catch block
    		                				e1.printStackTrace();
    		                			}//CALLING OF CREDIT FUNCTION OF PARENT CLASS REFERING TO SAVING ACCOUNT
    		                            	}
    		                            	else if(j==n-1 && Account_to_be_deleted!=s[n-1].account_no){
    		                            	System.out.println("ACCOUNT NO NOT MATCHED!");	
    		                            	}
    		                            	}
    		                                break;
    		                            case 3://INTREST
    		                            	System.out.println("WHICH ACCOUNT NO YOU WANT TO SEE INTREST?");
    		                            	Account_to_be_deleted=S.nextInt();
    		                            	for(j=0;j<n;j++){
    		                            	if(Account_to_be_deleted==a[j].account_no())
    		                            	{
    		                            	
    		                			try {
    		                				s[j].Intrest();
    		                				s[j].createFile();
    		                				s[j].readFile();
    		                				break;
    		                			} catch (FileNotFoundException e) {
    		                				e.printStackTrace();
    		                			}//CALLING OF INTREST FUNCTION OF SAVING ACCOUNT
    		                            	}
    		                            	else if(j==n-1 && Account_to_be_deleted!=s[n-1].account_no){
    		                            		System.out.println("ACCOUNT NO NOT MATCHED!");
    		                            	}
    		                            	}
    		                            	
    		                                break;
    		                            case 4://EXIT
    		                            	
    		                               return;
    		                            case 5:
    		                            {
    		                            	
    		                            	System.out.println("WHICH ACCOUNT NO YOU WANT TO DELETE?");
    		                            	Account_to_be_deleted=S.nextInt();
    		                            	for(j=0;j<n;j++){
    		                            	if(Account_to_be_deleted==a[j].account_no())
    		                            	{
    		                            		s[j].deleteAccount();
    		                            		break;
    
    		                            	}
    		                            	else if(j==n-1 && Account_to_be_deleted!=s[n-1].account_no)
    		                            	{
    		                            		System.out.println("ACCOUNT NO NOT MATCHED!");
    		                            	}
    		                            	}
    		                            }
    		                        }
    		                        }while(n!=0);
    		                                         
    		                       break;     				
    				}
    			        }while(n!=0);
    			}
				break;
			case 2://selection of account
			{	
				System.out.println("HOW MANY CURRENT ACCOUNT DO YOU WANT TO CREATE?");
		        int n=S.nextInt();
		        current c[]=new current[n];
		       Account a[]=new Account[n];
		        do{
		        switch(1)
		        {
		        
		        case 1:
		        	for(j=0;j<n;j++){
			        	if(n==0)
		    			{
		    				System.out.println("NO ACCOUNT CAN BE CREATED");
		    			}
		    			else if( k==n)
		    			{
		    				System.out.println("NO MORE ACCOUNT TO BE CREATED!");
		    			}
		    			else
		    			{
		    				for(j=0;j<n;j++){
		    				//ENTER OF DETAIL SUCH AS BALANCE,ACCOUNT NO,OVERDRAFT LIMIIT.
						            	System.out.println("ENTER BALANCE: ");
						                double x=S.nextDouble();
						                System.out.println("ENTER ACCOUNT NO:");
						                double y=S.nextDouble();
						                System.out.println("ENTER OVERDRAFT LIMIT:");
						                double e=S.nextDouble();
						     //CREATE AN OBJECT OF CURRENT CLASS        
						         c[j]=new current(x,y,e);
						         a[j]=c[j];
						         c[j].createFile();
						         c[j].readFile();
		    				
		    				}
		    			}
			        	
			        }
		        	
				         do{//DO WHILE LOOP FOR DOING THE FUNCTION MENTION IN CASE BY SWITCH CASE INSIDE DO WHILE LOOP
				         System.out.println("\n**IET-AU**"+"\n1.WITHDROW \n2.DIPOSIT\n3.DELETE ACCOUNT\n4.EXIT \nENTER YOUR CHOICE:");
				        int w=S.nextInt();
				        switch(w)
				        {
				            case 1:
				            	System.out.println("WHICH ACCOUNT NO YOU WANT TO WITHDROW?");
                            	Account_to_be_deleted=S.nextInt();
                            	for(j=0;j<n;j++){
                            	if(Account_to_be_deleted==c[j].account_no())
                            	{
                            	
                                
                                try {
                					c[j].withdrow();
                					c[j].createFile();
                					c[j].readFile();
                					break;
                				} catch (FileNotFoundException e) {
                					e.printStackTrace();
                				}//CALLING OF WITHDROW FUNCTION OF SAVING ACCOUNT
                                
                            	}
                            	else if(j==n-1 && Account_to_be_deleted!=c[n-1].account_no)
                            	{
                            		System.out.println("ACCOUNT NO NOT MATCHED!");
                            		//break;
                            	}
                            	
                            	}
				            	
				            	
				            	    break;
				                
				            case 2:
				            	System.out.println("WHICH ACCOUNT NO YOU WANT TO CREDIT?");
                            	Account_to_be_deleted=S.nextInt();
                            	for(j=0;j<n;j++){
                            	if(Account_to_be_deleted==a[j].account_no())
                            	{
                            		a[j]=c[j];
				                a[j].get_credit();//CALLING OF CREDIT FUNCTION OF CURRENT ACCOUNT BY REFERING TO PARENT CLASS
				                c[j].createFile();
				                c[j].readFile();
				                break;
                            	}else if(j==n-1 && Account_to_be_deleted!=c[n-1].account_no)
                            	{
                            		System.out.println("ACCOUNT NO NOT MATCHED!");
                            	}
                            	}
				                break;
				            case 3:
				            {
				            	System.out.println("WHICH ACCOUNT NO YOU WANT TO DELETE?");
                            	Account_to_be_deleted=S.nextInt();
                            	for(j=0;j<n;j++){
                            	if(Account_to_be_deleted==a[j].account_no())
                            	{
                            		a[j]=c[j];
                            		c[j].deleteAccount();
                            		break;
                            	}
                            	else if(j==n-1 && Account_to_be_deleted!=c[n-1].account_no)
                            	{
                            		System.out.println("ACCOUNT NO NOT MATCHED!");
                            	}
                            	}

				            }
				            break;
				            case 4:
				                return;//EXIT
				        }
				         
				         }while(n!=0);
				            
				            break;
					}
		        }while(o!=0);
		        } 
			case 0:
			return;
			
    			}
				
			}
	}
}
/************
*end project
**************/