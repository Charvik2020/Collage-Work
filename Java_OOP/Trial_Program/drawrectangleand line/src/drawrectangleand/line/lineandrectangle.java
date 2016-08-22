/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawrectangleand.line;
import java.awt.*;

import java.applet.Applet;

/**
 *
 * @author charvik.pc
 */
public class lineandrectangle extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.drawLine(100, 100,100, 200);
        g.setColor(Color.red);
        g.drawRect(10,60,400,600);
       // g.fillRect(15, 65, 300, 500);
        //g.drawRoundRect(10,100,80,50,10,100);
        g.drawArc(100, 200, 80, 50, -100, -100);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
