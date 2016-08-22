/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copying.bytes.from.one.file;
import java.io.*;
/**
 *
 * @author charvik.pc
 */
public class CopyingBytesFromOneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
FileInputStream infile =null;
FileOutputStream outfile =null;
byte byteRead;
try{
    infile=new FileInputStream("in.txt");
    outfile =new FileInputSream("out.txt");
    
    
    do{
        byteRead =(byte)infile.read();
        
    }
}

        // TODO code application logic here
    }
}
