/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgthrows.pkgthrow;
import java.lang.*;
class Number
{
int num;
void accept(int n)throws Exception{
    if(n==0){
        throw new Exception("cant assign zero value");
    }
    else if(n<0)
    {
        throw new Exception("cant assign negative value");
    }
    else
    {
        System.out.println("valid value :"+(int)n);
        num=n;
    }
}
}
/**
 *
 * @author charvik.pc
 */
public class ThrowsThrow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Number o =new Number();
       try
       {
           // put and value negative ,zero, and positive to get and req. answers
           o.accept(8);
       }
       catch (Exception e){
           System.out.println("Error "+e.getMessage());
       }
        // TODO code application logic here
    }
}
