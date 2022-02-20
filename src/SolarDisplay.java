import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SolarDisplay extends JComponent implements KeyListener, MouseListener { //class to call when making planet to display
    //vars
    public static final Planet[] planets = new Planet[5];
    public static int width=1000,height=600;
    public static volatile boolean paused=false;
    public static int SLEEP_TIME=10;

    //constructor
    SolarDisplay(){
        planets[0]=new Planet(Color.yellow,0,0,50);
        planets[1]=new Planet(Color.orange,1.607,0.387,10);
        planets[2]=new Planet(Color.yellow,1.174,0.723,10);
        planets[3]=new Planet(Color.blue,1.000,1.0,10);
        planets[4]=new Planet(Color.red,0.802,1.524,10);
    }


    //method
    @Override
    //paints the planets to the jframe
    public void paintComponent(Graphics g) {
        for(Planet p:planets){
            g.setColor(p.getcol());
            g.fillOval(p.getposx()-(p.getSize()/2), p.getposy()-(p.getSize()/2),p.getSize(), p.getSize());
        }


    }

    //key press events/mouse event listeners
    //increased/decreased speed time and uses boolean (volatile) variable to check for paused status.  volatile was used as this is worked with nested while.
    @Override
    public void keyPressed(KeyEvent ke) {
        int key= ke.getKeyCode();
        if(key==107||key==61){ //if plus is pressed
            paused=false;
            if(SLEEP_TIME-2<=1){ //stop user speeding up program too much
                System.out.println("Speed limit reached");
            }
            else{
                SLEEP_TIME-=2;
            }

        }
        if (key==109||key==45){ //is minus is pressed
            if(SLEEP_TIME+2>=20){
                paused=true;
            }
            else{
                SLEEP_TIME+=5;
            }
        }

    }


    @Override
    public void mouseClicked(MouseEvent me) {
        int mbutton=me.getButton();
        paused= !paused;
        if(paused==true){
            System.out.println("paused");
        }
        else{
            System.out.println("running");
        }

    }








   //not used but required due to interface.

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
