/*
 * NAME:CHARVIK PATEL
 * ROLLNO:1401079
 * PROGRAM TOPIC:MATRIX RELATED
 */
/*Design a class called â€œMatrixâ€? in Java to store various attributes required for a dynamic matrix.
 *Create appropriate constructors (including a copy constructor) for the class. Create appropriate
 *member functions for performing the following operations:
 * (a) Assign values to a matrix
 * (b) Extract values from a matrix
 * (c) Find transpose of a matrix
 * (d) Add two matrices after checking validity of the operation
 * (e) Multiply two matrices after checking validity of the operation
 * (f) Multiply a matrix with a scalar value
 */
import java.util.*;
public class LAB_ASS_5_1
{
    public static void main(String[] args)
    {
        int p,q;
			
        		Scanner sc=new Scanner(System.in);
			System.out.print("ROW M.1=");
			int i=sc.nextInt();
			System.out.print("\nCOLUMN M.1=");
			int j=sc.nextInt();
                        int [][]A=new int[i][j];
			System.out.println();
			System.out.print("ROW M.2=");
			int ij=sc.nextInt();
			System.out.print("\nCOLUMN M.2=");
			int ji=sc.nextInt();
			int [][]B=new int[ij][ji];
			int [][]C=new int[i][j];

			do
			{
				System.out.println("-------------------------IET-AU------------------------------");
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
                                    //ASSIGN VALUE TO MATRIX
					case 1:
					{
						int k, l;
						for(k=0;k<i;k++)
						{
							for(l=0;l<j;l++)
							{
								System.out.print("INPUT VALUE IS:"+k+" "+l+"=");
								A[k][l]=sc.nextInt();
							}	
						}
					}
					break;
                                            //EXTRACT VALUE TO MATRIX
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
                                            //TRANPOSE OF MATRIX
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
                                            //ADDITION OF MATRIX
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
							System.out.println("PLEASE CHEACK ROW AND COLUMN");
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
					//MULTIPLICATION OF MATRIX
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
					//MULTIPLICATION WITH SCALER VALUE WITH MATRIX
					case 6:
					{
						System.out.println("ENTER VALUE YOU WANT TO MULTIPLAY WITH MATRIX :");
						int NO=sc.nextInt();
						for(int k=0;k<=(i-1);k++)
						{
							for(int l=0;l<=(j-1);l++)
							{
								C[k][l]=NO*A[k][l];
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
                                            return;
                                        }
				}
				
			}while(true);
		}
    }
/*
 * REFFER TO 1. www.iitk.ac.in/esc101/08Jan/Solutions/lab8/thursday/mat_op.java
             2.www.roseindia.net/answers/viewqa/Java-Beginners/18542-code-for-multiplication-of-matrix-in-java-using-methods.html
 */