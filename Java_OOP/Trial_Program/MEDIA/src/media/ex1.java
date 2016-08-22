package media;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package media;

/**
 *
 * @author charvik.pc
 */
class m{
private 
        int year;
String t;
public m(){
    year=0;
    t="NULL";
}
m(int x, String t1){year=x;
t=t1;}
void display(){
System.out.println("Year="+year+"\n title="+t);
}
}
public class ex1 {
    public static void main(String a[]){
    m m1= new m();
    m m2= new m(12,"ROY");
    m1.display();
    m2.display();
}
}
