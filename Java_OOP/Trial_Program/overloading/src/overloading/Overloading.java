/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package overloading;
class Room
{
    int l,w;
   void Room(int a,int b)
    {
        l=a;
        w=b;
        
    }
    void Room(int a)
    {
        l=w=a;
    }
   double area()
    {
        double ans=l*w;
        return(ans);
    }
}

/**
 *
 * @author charvik.pc
 */
public class Overloading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Room r=new Room();
        r.Room(12, 13);
           
        System.out.println("area="+r.area());
        r.Room(14);
     
        System.out.println("area of square:"+r.area());
        
        // TODO code application logic here
    }
}
