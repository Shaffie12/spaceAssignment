import java.awt.*;

public class Planet {
    //vars
    private Color color;
    private double speed;
    private double orbit;
    private int positionx;
    private int positiony;
    private double angle;
    private int size;

    //constructor
    Planet(Color c,double speed,double orbit, int size){
        this.color=c;
        this.speed=speed;
        this.orbit=orbit*150;
        this.positionx=(int)((SolarDisplay.width/2)+this.orbit);
        this.positiony=(SolarDisplay.height/2);
        this.angle=0;
        this.size=size;
    }

    //method
    //adjusts the x/y coordinates of the planet based on an angle and its speed.
    public void move(){
        this.positionx=(int)((SolarDisplay.width/2)+(Math.cos(this.angle)*this.orbit));
        this.positiony=(int)((SolarDisplay.height/2)+(Math.sin(this.angle)*this.orbit));
        this.angle+=0.01*this.speed;
    }


    //getters
    public Color getcol(){
        return this.color;
    }

    public double getspeed(){
        return this.speed;
    }

    public double getorbit(){
        return this.orbit;
    }

    public int getposx(){
        return this.positionx;
    }

    public int getposy(){
        return this.positiony;
    }

    public double getangle(){
        return this.angle;
    }

    public void setAngle(double a){
        this.angle=a;
    }

    public int getSize(){
        return this.size;
    }

}
