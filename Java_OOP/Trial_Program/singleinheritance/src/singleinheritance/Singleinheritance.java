/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package singleinheritance;
class A
{
    int x,y;
    void getData(int a,int b)
    {
        x=a;
        y=b;
    }
    void Show()
    {
        System.out.println(x);
        System.out.println(y);
    }
}
class B extends A
{
    void display()
    {
        
        System.out.println("Singleinheritance");
    
    }
    static void dis()
    {
     System.out.println("Static ");   
    }
}
/**
 *
 * @author charvik.pc
 */
public class Singleinheritance 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ {
        B b=new B();
        b.getData(5, 6);
        b.Show();
        b.display();
        B.dis();

        A a =new A();
        a.getData(8, 7);
        a.Show();
        b.display();
        // TODO code application logic here
    }
    
}
}

