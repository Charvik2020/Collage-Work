import java.io.*;

class FileEOF {

public static void main(String[] args) {

byte ch;

    try {

        FileInputStream fis = new FileInputStream("EOF.java");

        DataInputStream dis = new DataInputStream(fis);

        while (true) {  // no need to check for EOF: exception deals with it

            ch = dis.readByte();
            System.out.print( (char) ch );
            System.out.flush();
        }

    } catch (EOFException eof) {
        System.out.println(" --> Normal program termination.");

    } catch (FileNotFoundException noFile) {
        System.out.println("File not found! " + noFile);

    } catch (IOException io) {
        System.out.println("I/O error occurred: " + io);

    } catch (Throwable anything) {
        System.out.println("Abnormal exception caught !: " + anything);
    }
}} // End of Class EOF


