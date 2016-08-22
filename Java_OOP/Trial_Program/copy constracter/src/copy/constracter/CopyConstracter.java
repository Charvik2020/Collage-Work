/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copy.constracter;
class Sum{
    int i=45,j=15;
    
    Sum(){
        System.out.println("sum="+(i+j));
    }
        Sum(Sum x)
        {
        int a=x.i;
        int b=x.j;
        
        System.out.println("sum ="+(a+b));
        }
        
    
    }


/**
 *
 * @author charvik.pc
 */
public class CopyConstracter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Sum obj =new Sum();
       Sum obj1 =new Sum(obj);
       
        // TODO code application logic here
    }
}
