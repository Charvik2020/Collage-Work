/*
 * name : charvik patel
 * rollno:1401079
 * collage:IET-AU
 * Program detail:Enter an two number And find maximum occuring number and its frequancy?
 *                output:enter frist page:5
 *                      :enter secound page:13
 *                       
 *                      :the number is:5678910111213
 *                      :The Maximum Occuring is 1 
 *                      :The Frequency is: 5
 * 
 */
package textbook.pages;
import java.util.Scanner;
public class TextbookPages
{
      public static void main(String[] args) 
    {
        int frist_page,last_page,i,n;
        int []a = new int [10];
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter First Page:");
        frist_page = scn.nextInt();
        System.out.println("Enter Last Page:");
        last_page = scn.nextInt();
        
        for(i=0;i<10;i++)
        {
            a[i]=0;
        }
        System.out.println("The Number is:");
        for(i=frist_page;i<=last_page;i++)
        {
            System.out.print(i);
            for(n=i;n!=0;n=n/10) //for adding the number to there respective number group for finding maximum frequency
            {
                a[n%10]++;
            }
        }
        n=0;
        for(i=0;i<9;i++)    //for maximum 
        {
            if(a[n]<a[i+1])
            {
                n =i+1;
            }
        }
        System.out.println();
        System.out.println("The Maximum Occuring is: "+n);
        System.out.println("The frequency is:"+a[n]);
        System.out.println("THANK YOU");
           }
}
