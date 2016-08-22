/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package media;
import java.*;
import java.util.Scanner;
class Media
{
    private String title;
    private int YearOfPublication;
    private int price;
    public Media()
    {
        title=null;
        YearOfPublication=0;
        price=0;
    }
    public Media(String t,int yop,int p)
    {
        title=t;
        YearOfPublication=yop;
        price=p;
    }
   
    void Display()
    {
                System.out.println("title="+title+"\t YearOfPublication="+YearOfPublication+"\t price="+price);
    }
}
class Cd extends Media
{
    float SizeMB;
    float PlayTym;
}
class Book extends Media
{
    char Author;
    int total_Page;
}
public class M {
    public static void main(String[] args) {
       // Media Med =new Media();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter title :");
        String x=sc.nextLine();
        System.out.println("enter Year Of PUBLICATION :");
       int y;
       y = 0;
       y=sc.nextInt();
       System.out.println("enter price:  ");
       int z;
       z = 0;
       z=sc.nextInt();
      Media Med=new Media(x, y, z);
       Med.Display();
    }
}
