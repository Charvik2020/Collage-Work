/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_test;
import java.util.*;
class Matrix
{
	Scanner scan;
	int matrix1[][],matrix2[][],sum[][],Multiply[][];
	static int row1, column1, row2, column2;

        
	public void create()
	 {
		
		scan = new Scanner(System.in);
		
		System.out.println("Matrix Creation");
		
		System.out.println("\nEnter number of rows :");
		row1 = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter number of columns :");
		column1 = Integer.parseInt(scan.nextLine());
		
		int matrix[][] = new int[row1][column1];
		System.out.println("Enter the data :");
 
		for(int i=0; i<row1; i++)
		 {
			for(int j=0; j<column1; j++) 
			{
				
				matrix1[i][j] = scan.nextInt();

               			System.out.println("For Second Matrix :");
		
			        System.out.println("\nEnter number of rows :");
				row2 = Integer.parseInt(scan.nextLine());
		
				System.out.println("Enter number of columns :");
				column2 = Integer.parseInt(scan.nextLine());
		
				int Matrix[][] = new int[row2][column2];
				System.out.println("Enter the data :");
 
				for(int k=0; k<row2; k++) 
				{
			
					for(int l=0; l<column2;l++)
					 {
				
						matrix2[k][l] = scan.nextInt();
					 }
				}
			}
		 }
	}
	
	 public void display()

                 {
		         int a;


		        System.out.println("Which Matrix You Want To Be Desplayed?(1/2)");
		        a=scan.nextInt();

			if(a==1)
		         {
				   System.out.println("\nThe Matrix is :");
				 
				   for(int i=0; i<row1; i++) 
                                    {
				 	
				 	for(int j=0; j<column1; j++) 
                                         {
				 		System.out.print("\t" + matrix1[i][j]);
					 }
					System.out.println();
				    }
		         }

		        else if(a==2)
		         {
				   System.out.println("\nThe Matrix is :");
				 
				   for(int i=0; i<row2; i++) 
                                    {	
				 	for(int j=0; j<column2; j++)
                                         {
                                        	System.out.print("\t" + matrix2[i][j]);
					 }
				   System.out.println();
			            } 
		      
		         }
                }


	public void add()

              {
                  

			for(int i=0; i<row1; i++)  
		         {
				for(int j=0; j<column1; j++)  
		                 {		
					sum[i][j] = matrix1[i][j] + matrix2[i][j];
				 }
			 }
		
			System.out.println("\n\nThe Sum is :");
		
			for(int i=0; i<row1; i++) 
		         {	
				for(int j=0; j<column1; j++) 
		                 {
					System.out.print("\t" + sum[i][j]);
				 }
				System.out.println();
			 }
             }
          

         
    public void transpose()
     {
		int a;

		System.out.println("Which Matrix You Want To Transpose ? (1/2)");
		a=scan.nextInt();

		if(a == 1)
		 { 
			  for(int i=0;i<row1;i++)
			   {
			    for(int j=-0;j<column1;j++)
			     {
			        System.out.println("\t"+matrix1[j][i]);
			     }
		          }
	         }

		else if(a == 2)
		 { 
			  for(int i=0;i<row2;i++)
			   {
			    for(int j=-0;j<column2;j++)
			     {
			        System.out.println("\t"+matrix2[j][i]);
			     }
			   }
	         }
     }

    public void multiply()
    {
                 int sum;
		 for (int c = 0 ; c < row1 ; c++ )
		 {
		    for (int d = 0 ; d <column1 ; d++ )
		    {   
		       for (int g = 0 ; g < column2 ; g++ )
		       {
		          sum = sum + matrix1[c][g]*matrix2[g][d];
		       }
	 
		       Multiply[c][d] = sum;
		       sum = 0;
		    }	
                 } 
		 System.out.println("Product of entered matrices:-");

      }


	     void constant_multiply()
	      {
			int a,b;

			System.out.println("With Which Matrix You Want To Multiply (1/2)??");
			a=scan.nextInt();
		 
			System.out.println("Enter The Constant With Which You Want To Multiply Matrx :");
			b=scan.nextInt();

			if(a == 1)
			 {
				   for(int c = 0 ; c < row1;c++ )
				    {
				      for(int d = 0 ; d < row2 ; d++)
				       { 
					matrix1[c][d]=matrix1[c][d]*b;
				       }
			 }

			    for(int c = 0 ; c < row1;c ++ )
			    {
			      for(int d = 0 ; d < column1 ; d++)
			       { 
				System.out.println("\t" +matrix1[c][d]);
			       }
			    }
		
		    

		if(a == 2)
		 {
			   for(int c = 0 ; c < row2;c ++ )
			    {
			      for(int d = 0 ; d < column2 ; d++)
			       { 
				 matrix2[c][d]=matrix2[c][d]*b;
			       }
			    }

			    for(int c = 0 ; c < row2;c++ )
			    {
			      for(int d = 0 ; d < column2 ; d++)
			       { 
				 System.out.println("\t" +matrix2[c][d]);
			       }
			    }
		 }
     }
}
}

/**
 *
 * @author charvik.pc
 */
public class Matrix_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int o;
        Scanner scan = new Scanner(System.in);
        Matrix_test Matrix = new Matrix_test();
                Matrix.();
 
                do{
              

               System.out.println("PLEASE MAKE A CHOICE");
               System.out.println("1. DISPLAY MATRIX :");
               System.out.println("2. ADD TWO MATRIX :");
               System.out.println("3. FIND TRANSPOSE :");
               System.out.println("4. MULTIPLY TWO MATRIX :");
               System.out.println("5. MULTIPLY MATRIX WITH A SCALAR VALUE :");
               System.out.println("6. EXIT :");

               
               System.out.println("Choose Any Number From This :");
               o = scan.nextInt();

               switch(o)
               {
  
               case 1:
                { 
                  Matrix.display();
                  break;
                }

               case 2:
                {
                  if(row1 == row2 && column1 == column2)
                   {
                     Matrix.add();
                     break;
                   }
                 else
                  {
                    System.out.println("Number Of Rows And Columns Are Different. Cannot Do Sum.");
                    break;
                  }
                }           

               case 3:
                {
                  Matrix.transpose();
                  break; 
                }

               case 4:
                {
                  if(row1 == column2)
                   {
                    Matrix.multiply();
                     break;
                   }
         
                 else
                  {
                    System.out.println("Number Of Row1 And Column2 Are Different. Cannot Multiply.");
                  }
                }
 
               case 5:
                {
                  Matrix.constant_multiply();
                  break;
                }
              }

             }while(o < 6);
		
	}	
        
        // TODO code application logic here
    }


