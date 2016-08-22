/*NAME:CHARVIK PATEL
 * ROLLNO:14010794
 * PROGRAM DETAIL:
 * Create a class called “List” in Java having data members capable of storing numbers in a dynamic
   array as well as the size of the array. Create appropriate constructor(s) for the class. Create
   appropriate member functions for performing the following operations on the list:
   (a) Add an item in the list
   (b) Delete an item from the list
   (c) Check whether the list contains duplicate elements (show with frequency)
   (d) Remove duplicate values of elements from the list
   (e) Sort the list in ascending order
   (f) Sort the list in descending order
   (g) Reverse the list
   (h) Calculate maximum, minimum, sum, mean, median, mode, and standard deviation
 */
import java.util.Scanner;
class Customer_detail
{
	Scanner S=new Scanner(System.in);
	public String c_name,c_address,p_company;
	public double c_phoneno,p_quantity,p_price;
        static double sum;
	public int bill_no;
        static int j;
	//Member Function for add Bill Details.
	public void addItem()									
	{
		System.out.print("Enter customer Name : ");
		c_name=S.next();
		System.out.print("\n");
		System.out.print("Enter Customer Address : ");
		c_address=S.next();
		System.out.print("\n");
		System.out.print("Enter Customer Mobile No. : ");
		c_phoneno=S.nextDouble();
		System.out.print("\n");
		System.out.print("Enter Bill No. : ");
		bill_no=S.nextInt();
		System.out.print("\n");
		System.out.print("\n");
               System.out.println("\n\nEnter your product coumpny: ");
                p_company=S.next();
                System.out.println("\nEnter your quantity: ");
                p_quantity=S.nextDouble();
                System.out.println("\nEnter price of product: ");
                p_price=S.nextInt();
	}
	//Member Function for delete Bill.
	public void deleteItem()										
	{
		c_name=null;
		c_address=null;
		c_phoneno=0;
		bill_no=0;
	}
	//Member Function for Show Bill Details.
	public void showItem()											
	{
		System.out.println("Customer Name : " + c_name);

		System.out.println("Customer Address : " + c_address);

		System.out.println("Customer phone No. : " + c_phoneno);

		System.out.println("Customer Account No. is : " + bill_no);
		
		System.out.println("\n\n");
	}
	//Member Function for copy Bill Details.
	public void copyObject(Customer_detail C)							
	{
		this.c_name=C.c_name;
		this.c_address=C.c_address;
		this.c_phoneno=C.c_phoneno;
		this.bill_no=C.bill_no;
	}
        //Member Function for product detail show.
        public void product_detail_show()
        {
            System.out.println("  " +p_company);
            System.out.print("               " +p_quantity);
            System.out.print("                      " +p_price);
            System.out.print("                                " + (p_quantity*p_price));
            sum+=((p_quantity)*(p_price));
       
        }
        
}
public class List_lab_a_2 {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
			
			int o,s,Account_to_be_deleted,n,l,op,k=-1;
			int i=0,p_price;
                        double sum,p_quantity,c_phoneno;
			String p_company,c_name,c_address;
                        
                        int bill_no;
			System.out.print("How many account do you want to create?");
			n=S.nextInt();
			System.out.print("\n");
			//create array of objects..
			Customer_detail[] A=new Customer_detail[n];							
			l=n;
			//do-while loop for repeat program.
			do													
			{
                                System.out.println("___________________IET-AU____________________");
				System.out.println("1. Add account ");
				System.out.println("2. Delete account ");
				System.out.println("3. Show particular account ");
                                System.out.println("4. Show Particular Product Detail  ");
				System.out.println("5. Check duplicate account	");
				System.out.println("6. Print all accounts ");
				System.out.println("7. Put Accounts in ascending / descending order ");
				System.out.println("8. Max. / Min. ");
				System.out.println("9. Print all Account reverse  ");
                                System.out.println("10. Bill  ");
 				System.out.println("0. Exit ");
                                System.out.println("ENTER OUR CHOICE : ");
				
				o=S.nextInt();
				System.out.println("\n");
				
				switch(o)
				{
                                    //Add account details
					case 1:																	
					if(i==n && k==-1)						
					{
						System.out.println("No other Bill Accepted!");
						System.out.print("\n");
						break;
					}
					
					else if(k!=-1)
					{
						A[k]=new Customer_detail();
						A[k].addItem();
						k=-1;
						break;
					}
				
					else
					{
						A[i]=new Customer_detail();
						A[i].addItem();
						i++;
						break;
					}
					
					//For  delete account
					case 2:																	
					System.out.print("Enter Bill no. which you want to delete : ");
					Account_to_be_deleted=S.nextInt();
					System.out.print("\n");
					
					for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
					{
						if(Account_to_be_deleted==A[Customer_detail.j].bill_no)												
						{
							System.out.println("Bill number matched! now your bill is going to delete");
							A[Customer_detail.j].deleteItem();
							System.out.print("\n");
							System.out.println("Bill is deleted Succesfully!");
							k=Customer_detail.j;
							System.out.print("\n");
							System.out.print("\n");
							break;
						}
						
						else if(Customer_detail.j==n-1 && Account_to_be_deleted!=A[n-1].bill_no)
						{
							System.out.println("Bill number doesn't match!");
							System.out.println("\n");
							break;
						}
					}
					break;
					//Show particular account details
					case 3:																	
					System.out.print("Enter Bill no. which you want to watch : ");
					Account_to_be_deleted=S.nextInt();
					System.out.print("\n");
					
					for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
					{
						if(Account_to_be_deleted==A[Customer_detail.j].bill_no)												
						{
							System.out.println("Bill number matched!");
							System.out.print("\n");
							
							A[Customer_detail.j].showItem();
							
							System.out.print("\n");
					
							break;
						}
						
						else if(Customer_detail.j==n-1 && Account_to_be_deleted!=A[n-1].bill_no)
						{
							System.out.println("Bill number doesn't match!");
							System.out.print("\n");
							break;
						}
					}
					break;
					//delete account.
					case 5:																		
					for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
					{
						for(s=Customer_detail.j+1;s<n;s++)
						{
							if(A[Customer_detail.j].bill_no==A[s].bill_no)								
							{
								System.out.println("Bill number matched!");
								A[s].deleteItem();
								System.out.print("\n");
								
								System.out.println("Bill is deleted..!");
								k=s;
								System.out.print("\n");
								System.out.print("\n");
								break;
							}
							
							else if(s==n-1 && (A[s].bill_no!=A[n-1].bill_no))
							{
								System.out.println("There is no duplicate Bill.");
								break;
							}
						}
					}
					break;
					//print all accounts.
					case 6:														
					for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
					{
						if(A[Customer_detail.j].c_name!=null)
						{
							A[Customer_detail.j].showItem();
							System.out.println("\n");
						}
					}
					break;
					//sort all accounts by bill_no wise.
					case 7:													
					
						System.out.println("1. Sort Bill as ascending order(by Bill number) : ");
						System.out.println("2. Sort Bill as descending order (by Bill number) : ");
						op=S.nextInt();
					
						if(op==1)
						{	
							for(Customer_detail.j=0;Customer_detail.j<n-1;Customer_detail.j++)
							{
								for(s=Customer_detail.j+1;s<n;s++)
								{
									if(A[Customer_detail.j].bill_no>A[s].bill_no)
									{
										String tempName=A[Customer_detail.j].c_name;
										String tempAdd=A[Customer_detail.j].c_address;
										
										double tempMob=A[Customer_detail.j].c_phoneno;
										
										int tempAc=A[Customer_detail.j].bill_no;
										
										A[Customer_detail.j].c_name=A[s].c_name;
										A[Customer_detail.j].c_address=A[s].c_address;
										
										A[Customer_detail.j].c_phoneno=A[s].c_phoneno;
										
										A[Customer_detail.j].bill_no=A[s].bill_no;
										
										A[s].c_name=tempName;
										A[s].c_address=tempAdd;
										
										A[s].c_phoneno=tempMob;
										
										A[s].bill_no=tempAc;
									}
								}
							}
							System.out.println("Bill are sorted in ascending order...");
							System.out.println("\n");
					
							break;
						}
					
						else if(op==2)
						{
							for(Customer_detail.j=0;Customer_detail.j<n-1;Customer_detail.j++)
							{	
								for(s=Customer_detail.j+1;s<n;s++)
								{
									if(A[Customer_detail.j].bill_no<A[s].bill_no)
									{
										String temp_c_Name=A[Customer_detail.j].c_name;
										String temp_c_Add=A[Customer_detail.j].c_address;
										
										double temp_c_Mob=A[Customer_detail.j].c_phoneno;
										
										int temp_c_Ac=A[Customer_detail.j].bill_no;
										
										A[Customer_detail.j].c_name=A[s].c_name;
										A[Customer_detail.j].c_address=A[s].c_address;
										
										A[Customer_detail.j].c_phoneno=A[s].c_phoneno;
										
										A[Customer_detail.j].bill_no=A[s].bill_no;
										
										A[s].c_name=temp_c_Name;
										A[s].c_address=temp_c_Add;
										
										A[s].c_phoneno=temp_c_Mob;
										
										A[s].bill_no=temp_c_Ac;
									}
								}
							}
						}
							System.out.println("Bill are sorted in descending order...");
							System.out.println("\n");
					break;
					//show maximum/ minimum account details by bill_no wise.
					case 8:												
					Customer_detail max_min=new Customer_detail();
					
					max_min.copyObject(A[0]);
					
					System.out.println("1. Print Max. Bill (by Bill number) : ");
					System.out.println("2. Print Min. Account (by Bill number) : ");
					op=S.nextInt();
					
					if(op==1)
					{						
						for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
						{
							if(max_min.bill_no<A[Customer_detail.j].bill_no)
							{
								max_min.copyObject(A[Customer_detail.j]);
							}
						}
						max_min.showItem();					
					}
					
					else if(op==2)
					{
						for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
						{
							if(max_min.bill_no>A[Customer_detail.j].bill_no)
							{
								max_min.copyObject(A[Customer_detail.j]);
							}
						}
						max_min.showItem();	
					}
					break;
					//reverse Account
					case 9:										
					for(Customer_detail.j=n-1;Customer_detail.j>=0;Customer_detail.j--)
					{
						A[Customer_detail.j].showItem();
					}
					break;
                                        case 10:
                                            System.out.print("Enter Bill No. : ");
					Account_to_be_deleted=S.nextInt();
					System.out.println("\n");
					for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
					{
                                            if(Account_to_be_deleted==A[Customer_detail.j].bill_no )
                                                {
                                                    System.out.println("\n                         **BILL**                              ");
                                                    System.out.println("\n***************************************************************");
                                                    A[Customer_detail.j].showItem();
                                                    System.out.println("\n_______________________________________________________________");
                                                    System.out.println("\nP_Company       P_quantity          P_price             Cost\n\n");
                                                    A[Customer_detail.j].product_detail_show();
                                                    System.out.println("\n_____________________________________________________Total="+Customer_detail.sum);
                                                }
                                        }
                                            break;
                                        case 4:
                                            System.out.print("Enter Bill No. : ");
					    Account_to_be_deleted=S.nextInt();
                                            System.out.print("\n");
					for(Customer_detail.j=0;Customer_detail.j<n;Customer_detail.j++)
					{
						if(Account_to_be_deleted==A[Customer_detail.j].bill_no)												
						{
							System.out.println("Bill number matched!");
							System.out.print("\n");
							A[Customer_detail.j].product_detail_show();
							System.out.print("\n");
							break;
						}
						
						else if(Customer_detail.j==n-1 && Account_to_be_deleted!=A[n-1].bill_no)
						{
							System.out.println("Bill number doesn't match!");
							System.out.print("\n");
							break;
						}
					}
                                                                                        }
    }while(o!=0);
                        }
}

                        

