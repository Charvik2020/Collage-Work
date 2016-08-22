import java.io.*;


public class DataIOFile {

  public static void main(String[] args) {

    DataInputStream din = null;
    DataOutputStream dout = null;

    File  myFile = new File("file.dat");

    if(myFile.exists()) {
     System.out.println("File file.dat exists, delete & rerun");
     System.exit(0);
    }

    try {
     dout = new DataOutputStream(new FileOutputStream(myFile));
     for(int i=0;i<10;i++)
      dout.writeFloat((float)(Math.random()*1000));
    }
    catch(IOException e) {
     System.out.println(e.getMessage());
    }
    finally {
     try {
      if(dout != null) dout.close();
     }
     catch(IOException e)
     {}
    }

    try {
     din = new DataInputStream(new FileInputStream(myFile));
     for(int i=0;i<10;i++)
      System.out.println(din.readFloat());
    }
    catch(FileNotFoundException e) {
     System.out.println(e);
    }
    catch(IOException e) {
     System.out.println(e.getMessage());
    }
    finally {
     try {
      if(din != null) din.close();
     }
     catch(IOException e)
     {}
    }
  }
}


