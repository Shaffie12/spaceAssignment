import javax.swing.*;
import java.io.IOException;

public class MainMars {

    public static void main(String[] args)  {
        //mars map
        //check that mars display can read file and create array of coordinates
        MarsDisplay mars=new MarsDisplay();
        try {
            mars.scale("src/JavaData/marsPolarMedium.csv");

        }
        catch (IOException ioe){
            ioe.getMessage();
        }
        //create jframe and add the marsdisplay to it
        JFrame frame = new JFrame("mars surface");
        frame.setSize(mars.width,mars.height+40);
        frame.add(mars);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);




    }
}




