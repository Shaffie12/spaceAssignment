import java.util.stream.IntStream;

public class Rocket {
    //vars
    private int[] payload;


    //constructors
    Rocket(int[] intArray){
        this.payload=intArray;
    }


    //methods
    //return the sum of items in payload
    public int getLaunchWeight(){
        int arraySum = IntStream.of(payload).sum();
        System.out.println("Sum " + arraySum );
        return arraySum;
    }

    //return mean weight of items in the payload
    public double getAverageWeight(){
        int arraySum=IntStream.of(payload).sum();
        double mean = arraySum/payload.length;
        System.out.println("Mean: "+ mean);
        return mean;
    }
    //return max weight of item in payload
    public int getMaxWeight(){
        int largest=payload[0];
        for(int i=1; i<payload.length; i++){
            if (payload[i]>largest){
                largest=payload[i];
            }

        }
        System.out.println("Max: "+largest);
        return largest;
    }

    //return min weight of item in payload
    public int getMinWeight(){
        int smallest=payload[0];
        for(int i=1; i<payload.length; i++){
            if (payload[i]<smallest){
                smallest=payload[i];
            }

        }
        System.out.println("Min: "+smallest);
        return smallest;
    }

    //prints a countdown from parameter
    public void printCountdown(int seconds){
        if (seconds<1){
            System.out.println("Invalid time");
        }
        else {
            while (seconds > 0) {
                System.out.println(seconds);
                seconds = seconds - 1;
            }
            System.out.println("Lift off!");
        }
    }

}
