/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgswitch;

/**
 *
 * @author charvik.pc
 */
import java.io.DataInputStream;
public class Switch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x;
        DataInputStream obj =new DataInputStream(System.in);
        try
        {
            System.out.println("enter number:");
        x=Integer.parseInt(obj.readLine());
        switch(x)
        {
            case 0:
                System.out.println("number is 0");
                break;
            case 1:
                System.out.println("number is 1");
                break;
            case 2:
                break;
            case 3:
                System.out.println("number is 2,3 or4");
                break;
            default:
                System.out.println("number is less than  0 or greater than 4");
                break;
                
                
        }
        
        
        }
        
        catch(Exception e){
            
        }
        
        // TODO code application logic here
    }
}
