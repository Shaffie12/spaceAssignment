import java.util.Arrays;

public class MainRocket {
    public static void main(String[] args) {

        int[] numbers = new int[10];
        for(int i=0; i<numbers.length; i++){
            numbers[i]=(int)(Math.random()*101); //generate number between 0 and 100 not inclusive
        }
        System.out.println("payload: "+Arrays.toString(numbers));
        //calling all the methods
        Rocket rocket = new Rocket(numbers);
        rocket.getMaxWeight();
        rocket.getAverageWeight();
        rocket.getMinWeight();
        rocket.getLaunchWeight();










    }
}
