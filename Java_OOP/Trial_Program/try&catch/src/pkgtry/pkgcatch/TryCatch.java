/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtry.pkgcatch;

/**
 *
 * @author charvik.pc
 */
import java.*;
//import java.util.*;
public class TryCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int invalid =0;
        int number,count =0;
        for(int i=0;i<=args.length;i++)
        {
            try
            {
                number =Integer.parseInt(args[i]);
            }
            catch(NumberFormatException e)
            {
                invalid=invalid+1;
                System.out.println("invalid number: "+args[i]);
                continue;
            }
            catch (Exception e){
                System.out.println("invalid");
            }
            count=count+1;
        }
        System.out.println("valid number ="+count);
        System.out.println("invalid number ="+invalid);
        // TODO code application logic here
    }
}
