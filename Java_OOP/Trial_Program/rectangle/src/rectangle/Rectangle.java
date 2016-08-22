/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangle;
import java.io.DataInputStream;
class Rectangle1{
    int w,l;
    void getData(int a,int b)
    {
        w=a;
        l=b;
    }
    double area(){
        double ans=w*l;
        return (ans);
    }
            
    
}

/**
 *
 * @author charvik.pc
 */
public class Rectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Rectangle1 r = new Rectangle1();
        r.getData(12,13);
        double ans =r.area();
        System.out.println("area of rectengle:"+ans);
        Rectangle1 r1 = new Rectangle1();
        r1.getData(14,13);
        double ans1 =r1.area();
        System.out.println("area of rectengle:"+ans1);
        DataInputStream obj =new DataInputStream(System.in);
        System.out.println("enter lenght :");
        int x=Integer.parseInt(obj.readLine());
          //DataInputStream obj1 =new DataInputStream(System.in);
        System.out.println("enter wreath :");
        int y=Integer.parseInt(obj.readLine());
    r.getData(x, y);
    double ans2=r.area();
    System.out.println("area of rectengle:"+ans2);
    // TODO code application logic here
        }
        catch(Exception e){
            
        }
    
    }
}
