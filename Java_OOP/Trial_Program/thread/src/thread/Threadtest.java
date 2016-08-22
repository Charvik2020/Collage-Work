/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;
import java.lang.Thread;


class A extends Thread{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("From thread A:"+i);
        }
        System.out.println("exit from A");
    }
}


class B extends Thread{
    public void run(){
        for(int j=0;j<5;j++){
            System.out.println("from thread B:"+j);
        }
        System.out.println("exit from b");
    }
}



class C extends Thread{
    public void run(){
        for(int k=0;k<5;k++){
            System.out.println("thread from C:"+k);
        }
        System.out.println("exit from c");
    }
}
/**
 *
 * @author charvik.pc
 */
public class Threadtest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 A a=new A();
B b=new B();
 C c=new C();
 
a.start();
b.start();
c.start();
 
        // TODO code application logic here
    }
}
