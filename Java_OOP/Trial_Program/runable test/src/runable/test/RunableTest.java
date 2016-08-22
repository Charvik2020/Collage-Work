/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runable.test;
import java.lang.Thread;

class X implements Runnable{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("\tThreadX "+i);
        }
        System.out.println("End of threadX");
    }
}
/**
 *
 * @author charvik.pc
 */
public class RunableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        X runnable=new X();
        Thread th=new Thread(runnable);
        th.start();
        
        // TODO code application logic here
    }
}
