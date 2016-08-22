/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.lang.Thread;


/**
 *
 * @author charvik.pc
 */
public class clock extends Applet implements Runnable  {
    Thread t=null;
    int hours=0,min=0,sec=0;
    String timeString="";

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        setBackground(Color.green);
        // TODO start asynchronous download of heavy resources
    }
    public void Start()
    {
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        try{
            while(true){
                Calendar cd=Calendar.getInstance();
                hours=cd.get(Calendar.HOUR_OF_DAY);
                if(hours>12)
                {
                    hours -=12;
                }
                min=cd.get(Calendar.MINUTE);
                sec=cd.get(Calendar.SECOND);
                SimpleDateFormat fr=new SimpleDateFormat("hh:mm:ss");
                
                Date date=cd.getTime();
                timeString=fr.format(date);
 
 repaint();
                t.sleep(1000);
                continue;
            }
            
        }
        catch(Exception e){
            
        }
        
    }
public void paint(Graphics g)
{
    g.setColor(Color.blue);
       g.drawString(timeString, 500, 500);
       //g.drawSrring(action(continue, timeString));
       Calendar cd=Calendar.getInstance();
                hours=cd.get(Calendar.HOUR_OF_DAY);
                if(hours>12)
                {
                    hours -=12;
                }
                min=cd.get(Calendar.MINUTE);
                sec=cd.get(Calendar.SECOND);
                SimpleDateFormat fr=new SimpleDateFormat("hh:mm:ss");
                
                Date date=cd.getTime();
                timeString=fr.format(date);
 
}
    // TODO overwrite start(), stop() and destroy() methods
}

