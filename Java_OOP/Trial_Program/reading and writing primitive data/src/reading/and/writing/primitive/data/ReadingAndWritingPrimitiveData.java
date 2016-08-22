/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reading.and.writing.primitive.data;
import java.io.*;

/**
 *
 * @author charvik.pc
 */
public class ReadingAndWritingPrimitiveData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        File primitive =new File("prim.txt");
        FileOutputStream fos =new FileOutputStream(primitive);
        DataOutputStream dos=new DataOutputStream(fos);                    //write primitive data to "prim.txt" file
        
        dos.writeInt(1999);
        dos.writeDouble(375.56);
        dos.writeBoolean(false);
        dos.writeChar('X');
        dos.close();
        fos.close();                                                        //read data from the"prim.txt" file
        
        
        
        FileInputStream fis =new FileInputStream(primitive);
        DataInputStream dis= new DataInputStream(fis);
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        
        dis.close();
        fis.close();
        // TODO code application logic here
    }
}
