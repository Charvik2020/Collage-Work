/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;
import java.io.*;
/**
 *
 * @author charvik.pc
 */
public class Wrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Float principalAmount=new Float(0);
        Float intrestRate =new Float(0);
        int numYears=0;
        
        try{
            DataInputStream in =new  DataInputStream(System.in);
            System.out.println("Enter Principal Amount :");
            System.out.flush();
            String principalString =in.readLine();
            principalAmount =Float.valueOf(principalString); //string object to number object 
            System.out.println("Enter Intrest Rate :");
            System.out.flush();
            String intrestString =in.readLine();
            intrestRate =Float.valueOf(intrestString);
            System.out.println("Enter years :");
            String yearsString =in.readLine();
            numYears =Integer.parseInt(yearsString);
        }
        catch(Exception e)
        {
            System.out.println("I/O Error");
            System.exit(1);
        }
       
        float value=loan(principalAmount.floatValue(),intrestRate.floatValue(),numYears);
        //System.out.println("charvik");
        printline();
        System.out.println("final Value ="+value);
        printline();
               
   
    
            // TODO code application logic here
    }
     // Method to Compute Final value
    
    static float loan(float p,float r,int n)
    {
        int year =1;
        float sum =p;
        while(year<=n)
        {
            sum=sum*(1+r);
            year =year+1;  
        }
    
    return sum;
    }
    
    //Method to draw a line
    static void printline()
    {
        for(int i=1;i<=3;i++)
        {
            System.out.println("=");
            
        }
        System.out.println(" ");
    }
}
    

