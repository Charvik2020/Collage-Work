/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfor.loop;

/**
 *
 * @author charvik.pc
 */
public class ForLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x=10,sum=0;
        System.out.print("sum=1+2+3+4+5+6+7+8+9+10=");
        for(int i=1;i<=x;i++)
        {
            sum=i+sum;
            
        }
        System.out.println(""+sum);
        // TODO code application logic here
    }
}
