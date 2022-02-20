import extra.Plot;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//is a Jcomponent to add to the frame.
public class MarsDisplay extends Plot{

    //vars
    private MarsData md=new MarsData();
    //public double[][] slatLong; //scaled version of coordinates
    private List<Double>scalelongs=new ArrayList<>();
    private List<Double>scalelats=new ArrayList<>();
    private int datalen=(int)((md.getLongmax()-md.getLongmin())*(md.getLatmax()-md.getLatmin()));


    //constructors

    //methods
    //paintComponent paints each coordinate as a dot on the window (scaled)
    //each dot has rgb value. the r value is generated based on the difference between the current point altitude value and the min altitude - so that lower altitude will be darker
    public void paintComponent(Graphics graphic) {
        for(int i=0;i<md.getLongs().size();i++){ //loops through every (scaled) long, then every (scaled) lat, paints an oval at that(i,j) position, with the rgb value depending on altitude as mentioned above.
            for(int j=0;j<md.getLats().size();j++){
                int r=(int)((md.getAltitude(md.getLongs().get(i),md.getLats().get(j))-md.getAltmin())*(255)/(md.getAltmax()-md.getAltmin()));
                int g=56;
                int b=77;
                graphic.setColor(new Color(r,g,b));
                graphic.fillOval((int)((double)(scalelongs.get(i))),(int)((double)(scalelats.get(j))),10,10);

            }
        }


    }

    //scale the values using plot and dump them back into an array, then can paint them.
    public void scale(String fileLoc) throws IOException {
        md.readData2D(fileLoc);
        this.setScaleX(md.getLongmin(),md.getLongmax());
        this.setScaleY(md.getLatmin(),md.getLatmax());
        for(Double d:md.getLongs()){ //add scaled values into scaled version of array
            double sd=this.scaleX(d);
            scalelongs.add(sd);
        }
        for(Double d:md.getLats()){
            double sd=this.scaleY(d);
            scalelats.add(sd);
        }





    }


}
