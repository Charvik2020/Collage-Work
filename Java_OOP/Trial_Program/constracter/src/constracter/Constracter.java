/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package constracter;
class Box{
    double w;
    double l;
    double d;

Box(double a,double b,double c){
w=a;
l=b;
d=c;


}
double Volume()
{
    return(w*l*d);
}}

/**
 *
 * @author charvik.pc
 */
public class Constracter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Box obj = new Box(11,12,13);
        Double ans=obj.Volume();
        System.out.println("volume="+ans);
        // TODO code application logic here
    }
}
