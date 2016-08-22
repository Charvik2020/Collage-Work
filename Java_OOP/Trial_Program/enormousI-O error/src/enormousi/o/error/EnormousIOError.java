/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//question:the purpus of this program is to verify whether the method you are using to read input data is sufficiatly
//         fast to handle problembs handed with theenormous Input/output warning. you are accepte to be able to process atleast
//         2.5MB of input data per second at run time
//INPUT   :the input begaines with the two positive integer n k(n,k<=10^7). the next n line integer contain one positive
//         integer tn,not greater than 10^9,each.
//OUTPUT  :write single integer to output, denote how many integers ti are divisible by k
package enormousi.o.error;

/**
 *
 * @author charvik.pc
 */
public class EnormousIOError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException {
        java.io.InputStreamReader s=new java.io.InputStreamReader(System.in);
        java.io.BufferedReader b =new java.io.BufferedReader(s, 16*1024);
       // System.out.println("enter n:");
        int n,k,m=0;
        String[] line0=b.readLine().split(" ");
       n=Integer.parseInt(line0[0]);
       k=Integer.parseInt(line0[1]);
       for(int c=0;c<n;c++)
       {
           if(Integer.parseInt(b.readLine())%k==0)
           {
               m++;
           }
           System.out.println(m);
       }
        // TODO code application logic here
    }
}
