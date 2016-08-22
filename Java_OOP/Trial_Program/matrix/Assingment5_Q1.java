
import java.util.*;

/**
 *
 * @author charvik.pc
 */
public class Matrix
	{
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.print("ROW M.1=");
			int i=sc.nextInt();
			System.out.print("\nCOLUMN M.1=");
			int j=sc.nextInt();
			System.out.println();
			System.out.print("ROW M.2=");
			int ij=sc.nextInt();
			System.out.print("\nCOLUMN M.2=");
			int ji=sc.nextInt();
			int p,q;
			int [][]A=new int[i][j];
			int [][]B=new int[ij][ji];
			int [][]C=new int[i][j];
			
			
			do
			{
				System.out.println("-------------------------------------------------------------");
				System.out.println("1.ASSIGN VALUE");
				System.out.println("2.EXTRACT VALUE");
				System.out.println("3.TRANSPOSE");
				System.out.println("4.ADDITION");
				System.out.println("5.MULTIPLY");
				System.out.println("6.MULTIPLY WITH SCALER VALUE");
                                System.out.println("7.EXIT");
				System.out.println("-------------------------------------------------------------");
				System.out.print("ENTER THE CHOICE :");
				int n=sc.nextInt();
				switch(n)
				{
					case 1:
					{
						int k, l;
						for(k=0;k<i;k++)
						{
							for(l=0;l<j;l++)
							{
								System.out.print("INPUT VALUE IS:"+k+" "+l+"=");
								A[k][l]=sc.nextInt();
								System.out.println();
								
							}	
								
						}
							
					}
					break;
					
					case 2:
					{
						System.out.println("ENTER ROW YOU WANT TO SEE:");
						int y=sc.nextInt();
                                                System.out.println("ENTER COLUMN YOU WANT TO SEE:");
						int z=sc.nextInt();
						for(int k=0;k<=(i-1);k++)
						{
							for(int l=0;l<=(j-1);l++)
							{
								if(k==y && l==z)
								{	
									System.out.print("\t"+A[k][l]);
								}
								System.out.println("\n");
							}	
							System.out.println();
						}
					}
					break;
					
					case 3:
					{
						for(int l=0;l<j;l++)
						{
							for(int k=0;k<i;k++)
							{
								System.out.print("\t"+A[k][l]);
							}
							System.out.println("\n");							
						}
					}	
						
					break;
					
					case 4:
					{
						for(int k=0;k<=(ij-1);k++)
						{
							for(int l=0;l<=(ji-1);l++)
							{
								System.out.print("INPUT VALUE IS :"+k+" "+l+"=");
								B[k][l]=sc.nextInt();
								System.out.println();
								
							}	
								
						}
						if(i==ij && j==ji)
						{
							for(int k=0;k<=(i-1);k++)
							{
								for(int l=0;l<=(j-1);l++)
								{
									C[k][l]=A[k][l]+B[k][l];								
								}	
									
							}
						}
						else 
						{
							System.out.println("PLEASE ENTER CHEACK ROW AND COLUMN");
						}

						for(int k=0;k<=(i-1);k++)
						{
							for(int l=0;l<=(j-1);l++)
							{
								System.out.print("\t"+C[k][l]);
							}	
							System.out.println();
						}
					}
					break;
					
					case 5:
					{
						for(int k=0;k<=(ij-1);k++)
						{
							for(int l=0;l<=(ji-1);l++)
							{
								System.out.print("INPUT VALUE IS:"+k+" "+l+"=");
								B[k][l]=sc.nextInt();
								System.out.println();
								
							}	
						}	
						if(j==ij && i==ji)
						{
								
							int temp = 0;
							for ( int k = 0; k < i; k++) 
							{
								for (int l = 0; l < ji; l++) 
								{
									for (int o = 0; o < ij; o++) 
									{
										temp= temp + A[k][o] * B[o][l];
									}
									C[k][l] = temp;
									temp = 0;
								}
							}
								
							for (int k = 0; k < i; k++) 
							{
								for (int l = 0; l < ji; l++) 
								{
									System.out.print(C[k][l] + "\t");
								}
								System.out.println();
							}
						}
						else
						{
							System.out.println("MULTIPLICATION IS NOT POSSIBLE");
						}	
					}
					break;
					
					case 6:
					{
						System.out.println("ENTER VALUE YOU WANT TO MULTIPLAY WITH MATRIX :");
						int f=sc.nextInt();
						for(int k=0;k<=(i-1);k++)
						{
							for(int l=0;l<=(j-1);l++)
							{
								C[k][l]=f*A[k][l];
							}
						}
						
						for(int k=0;k<=(i-1);k++)
						{
							for(int l=0;l<=(j-1);l++)
							{
								System.out.print("\t"+C[k][l]);
							}	
							System.out.println();
						}
					}
                                            break;
                                        case 7:
                                        {
                                            break;
                                        }
				}
				
			}while(true);
		}
	}
	
