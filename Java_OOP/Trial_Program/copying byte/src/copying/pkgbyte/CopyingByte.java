/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copying.pkgbyte;
import java.io.*;

/**
 *
 * @author charvik.pc
 */
public class CopyingByte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
FileInputStream infile =null;
FileOutputStream outfile =null;
byte byteRead;
try{
    infile =new FileInputStream("a.txt");
    outfile=new FileOutputStream("b.txt");
    
    do{
        byteRead=(byte)infile.read();
        outfile.write(byteRead);
    }
    while(byteRead!=-1);
    

}
catch(Exception e){
    System.out.println(e);
}
finally{
    try{
        infile.close();
        outfile.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
}
        // TODO code application logic here
    }
}
