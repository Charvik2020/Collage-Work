/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;
import java.io.DataInputStream;

/**
 *
 * @author charvik.pc
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int fact=1,x;
         DataInputStream obj =new DataInputStream(System.in);
         try
        {
            System.out.println("enter number of x:");
        x=Integer.parseInt(obj.readLine());
        {
            for(int i=1;i<=x;i++)
            {
                fact=fact*i;
                System.out.println("Fact="+fact);
            }
        }
        // TODO code application logic here
    } catch(Exception e){
            
        }
}
}