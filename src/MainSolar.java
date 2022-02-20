import javax.swing.*;

public class MainSolar {

    public static void main(String[] args) throws InterruptedException {
        SolarDisplay sdisplay = new SolarDisplay();
        //add the jframe and add the display component to it. initiate while loop to keep checking if paused is true/false and play /pause repainting.
        JFrame frame = new JFrame();
        frame.setSize(SolarDisplay.width, SolarDisplay.height);
        frame.add(sdisplay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addMouseListener(sdisplay);
        frame.addKeyListener(sdisplay);
        while(true) {
            while (sdisplay.paused == false) { //the paused variable here was not being checked properly and did not work until paused was made volatile.  Assume this is because volatile variable is not cached and forces JVM to check its status again ?
                Thread.sleep(sdisplay.SLEEP_TIME);
                for (Planet p : sdisplay.planets) {
                    p.move();


                }
                frame.repaint();
            }
        }



    }
}




