/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.and.array;

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author charvik.pc
 */
public class helloapplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    public void paint(Graphics g)
    {
        g.drawString("hello",50, 100);
        
    }
    // TODO overwrite start(), stop() and destroy() methods
}
