package keyapplet;



import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.text.ParseException;
public class keyapp extends Applet implements KeyListener
{
    String msg = "Hello!";
 
    public void init()
    {
        addKeyListener(this);
    }
 
    public void keyReleased(KeyEvent k)
    {
        showStatus("Key Released");
        msg="Key Released";
        repaint();
    }
 
    public void keyTyped(KeyEvent k)
    {
        showStatus("Key Typed");
        //repaint();
    }
 
    public void keyPressed(KeyEvent k)
    {
    	msg="Key Pressed";
    	showStatus("Key Pressed");
        repaint();
    }
 
    public void paint(Graphics g)
    {
    	//resize(300,400);
        g.drawString(msg, 100, 10);
    }
}
