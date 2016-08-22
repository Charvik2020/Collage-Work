/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package random.acess.file;
import java.io.*;


/**
 *
 * @author charvik.pc
 */
public class RandomAcessFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        RandomAccessFile rf=new RandomAccessFile("pp.dat","rw");
       // if(rf.exists().)
        rf.writeChar('A');
        rf.writeInt(454);
        rf.writeDouble(1.14325);
        System.out.println(rf.length());
        long position =rf.length();
        position-=40;
        if(position<0){
            position=0;
            
        }
        rf.seek(0);
        
                //byte b=rf.readByte();
                //System.out.println((char)b);
                System.out.println(rf.readChar());
                System.out.println(rf.readInt());
                System.out.println(rf.readDouble());
                
        rf.seek(rf.length());
        rf.writeBytes("\nMUMBAI");
        
        rf.seek(3);
        while(true)
        {        byte b=rf.readByte();
        System.out.println((char)b);}
        
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        // TODO code application logic here
    }
}
