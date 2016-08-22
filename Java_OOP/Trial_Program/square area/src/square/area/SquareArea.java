/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package square.area;

import java.io.DataInputStream;

class Square1{
    int x;
    void getData(int a){
        x=a;
    }double area(){
        double ans=x*x;
        return (ans);
    }
            
}


/**
 *
 * @author charvik.pc
 */
public class SquareArea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   try{ 
        System.out.println("enter x");
       Square1 s=new Square1();
        DataInputStream obj=new DataInputStream(System.in);
       
       int x=Integer.parseInt(obj.readLine());
      
       System.out.println("enter x is "+x);
       s.getData(x);
       double ans2=s.area();
       System.out.println("area="+ans2);
       
       
       
       
   }catch(Exception e){
       
   }
        // TODO code application logic here
    }
}
