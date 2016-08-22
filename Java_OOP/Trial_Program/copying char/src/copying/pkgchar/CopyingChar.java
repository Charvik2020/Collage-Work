/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copying.pkgchar;
import java.io.*;

/**
 *
 * @author charvik.pc
 */
public class CopyingChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileReader ins=null;
        FileWriter out=null;
        File infile=new File("test.txt");
        File outfile=new File("output.txt");
        
        
        try
            
        {
          //  FileInputStream fis =new FileInputStream("test.txt");
            ins=new FileReader(infile);
            out=new FileWriter(outfile);
            int ch;
            while((ch=ins.read())!=-1){
                out.write(ch);
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try{
            ins.close();
            out.close();
            }
            catch(Exception e){
                
            }
        }
        // TODO code application logic here
    }
}
