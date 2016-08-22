/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package overhidding;
class A
{
   // int x,y;
   // void get(int a,int b)
    //{
    //    x=a;
     //   y=b;
   // }
   A()
  {
      System.out.println("super class show");
  }
}
class B extends A
{
     B()
    {
        super();
        System.out.println("sub class show");
    }
}

/**
 *
 * @author charvik.pc
 */
public class Overhidding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        B b=new B();
                
        // TODO code application logic here
    }
}
