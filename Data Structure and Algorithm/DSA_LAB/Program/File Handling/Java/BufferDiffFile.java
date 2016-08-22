import java.io.*;
import java.util.*;

public class BufferDiffFile {

  public static void main(String[] args) throws IOException {

    FileOutputStream unbufStream;
    BufferedOutputStream bufStream;

    unbufStream = new FileOutputStream("test.one");
    bufStream = new BufferedOutputStream(new FileOutputStream("test.two"));

    System.out.println("Write file unbuffered : " + time(unbufStream) + "ms");
    System.out.println("Write file buffered : " + time(bufStream) + "ms");

  }

  static int time(OutputStream outStream) throws IOException {

   Date then = new Date();

   for(int i=0;i<50000;i++)
    outStream.write(1);
   

   outStream.close();
   return (int)((new Date()).getTime() - then.getTime());
  
  }
}



