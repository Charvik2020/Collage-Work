/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgstatic;


/**
 *
 * @author charvik.pc
 */
public class StaticDemo 
{
    static int a=3;
    static int b;
    static void meth(int x) 
    {
    System.out.println("X="+x);
    System.out.println("a="+a);
    System.out.println("b="+b);
    
    }
    static
    {
        System.out.println("Static block initialization ");
        b=a*4;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        meth(42);
        // TODO code application logic here
    }
}
