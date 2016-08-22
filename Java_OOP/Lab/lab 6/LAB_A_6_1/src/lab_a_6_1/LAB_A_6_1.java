/*
 * NAME:CHARVIK PATEL
 * ROLLNO:1401079
 * COLLAGE:IET-AU
 */
package lab_a_6_1;
import java.util.*;
class point_dim
{
	Scanner sc=new Scanner(System.in);
	public int  D;
	public int []point;
	public int e;
        point_dim(int r)//PARAMETER CONSTRUCTOR
        {
            e=r;
	}
        point_dim(point_dim s)//COPY CONSTRUCTOR
        {
            e=s.e;
        }
        public void create()//CREATE FUNCTION								
	{
            
            System.out.println("ENTER DIMENSION :");
            D=sc.nextInt();
            point=new int[D];
            for(int i=0;i<D;i++)
            {
		System.out.println("ENTER CO-ORDINATE"+i+":");
		point[i]=sc.nextInt();
            }
            System.out.println("______________IET-AU_______________");		
	}
        public void check(point_dim P_D)							
        {
            int g,count=0;
            for(g=0;g<D;g++)
            {
                if(point[g]==P_D.point[g])						
		{
                    count++;
		}
		else
		{
                    System.out.println("** COMPARE RESULT **");
                    System.out.println("POINT ARE DIFFRENT");
                    break;
		}
		}
		if(count==D)
                {
                    System.out.println("** COMPARE RESULT **");
                    System.out.println("POINT ARE EQUAL");
                }
                }
}
public class LAB_A_6_1 {
    public static void main(String[] args) {
        int n;
        	Scanner sc=new Scanner(System.in);
		System.out.println("ENTER POINT YOUR WANT TO ENTER:");
		int a=sc.nextInt();
		point_dim pd=new point_dim(a);
		point_dim x2=new point_dim(pd);
		point_dim[] PD=new point_dim[a];							
                do{
                    System.out.println("*****IET-AU*****");
                    System.out.println("1.CREATE");
                    System.out.println("2.COMPARE");
                    System.out.println("0.EXIT");
                    System.out.println("ENTER YOUR CHOICE:");
                    n=sc.nextInt();
                switch(n){
                        case 1://CREATE POINT
                            for(int k=0;k<a;k++)
                            {
                                PD[k]=new point_dim(a);	
                                PD[k].create();		
                            }break; 
                        case 2://CHEAK POINT
                            for(int l=0;l<a-1;l++)		
                            {
                                if(PD[l].D==PD[l+1].D)			
                                {
                                    for(int m=0;m<PD[l].D-1;m++)
                                    {
					PD[m].check(PD[m+1]);
                                    }
                                }
                                else
                                {
                                    System.out.println("DIMENTION ARE NOT SAME THUS POINT ARE NEVER SAME");
                                    continue;
                                }
                            }break;
                          }
                    }while(n!=0);
}
}