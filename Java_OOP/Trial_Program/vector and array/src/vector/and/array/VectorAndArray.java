/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.and.array;
import java.util.*;

/**
 *
 * @author charvik.pc
 */
public class VectorAndArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // list[]={"a","b","c","d");
 Vector list=new Vector();
 int length= args.length;
 for(int i=0;i<length;i++){
     list.addElement(args[i]);
 }
 list.insertElementAt("cobol", 2);
 int size=list.size();
 String listArray[]=new String[size];
 list.copyInto(listArray);
 System.out.println("list of lang.");
 for(int i=0;i<size;i++){
     System.out.println(listArray[i]);
 }
        // TODO code application logic here
    }
}
