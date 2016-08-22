/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package throwing.own.exception;
import java.lang.Exception;
class MyException extends Exception{
    MyException(String message){
        super(message);
    }
}

/**
 *
 * @author charvik.pc
 */
public class ThrowingOwnException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x=5,y=1000;
        try
        {
            float z=(float)x/(float)y;
            if(z<0.01)
            {
                throw new MyException("Number is too small");
            }
        }
        catch(MyException e){
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("I am always here");
        }
        // TODO code application logic here
    }
}
