/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userin;
import java.awt.*;


import java.applet.Applet;

/**
 *
 * @author charvik.pc
 */
public class userInput extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    TextField t1,t2;
    Label l1;
    public void init() {
      // setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        l1=new Label();
        t1=new TextField(8);
        t2=new TextField(8);
       
        add(l1);
        l1.setText("name");
        l1.setLocation(200, 100);
        //setLocation(null);
        add(t1);
      //setLayout(new FlowLayout(FlowLayout.LEFT,20,50));
        //System.out.println("\n");
        add(t2);
        t1.setText("0");
       // System.out.println("\n");
        t2.setText("0");
        // TODO start asynchronous download of heavy resources
    }
    public void paint(Graphics g){
        int x=0,y=0,z=0;
        String s1,s2,s;
        g.drawString("input number in box ", 10, 50);
        try{
             g.drawString("num1",50,20);
             
            // g.drawString("+", 100, 20);
             
            s1=t1.getText();
            x=Integer.parseInt(s1);
          //  System.out.println("\n");
            s2=t2.getText();
            y=Integer.parseInt(s2);
            
        }
        catch(Exception e){
        }
        z=x+y;
        s=String.valueOf(z);
        g.drawString("sum :", 10, 75);
        g.drawString(s,100, 75);
        }
    public boolean action (Event event,Object object){
        repaint();
        return true;
    }
    // TODO overwrite start(), stop() and destroy() methods
}
