import java.io.FileNotFoundException;
import java.util.Scanner;
public class MainCrew {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        Crew c;

        //ex 2D

        //first loop to ensure file enters a readable file name ---CHECK FOR FILE TYPE?---
        while (true) {
            System.out.println("Please enter crew file name");
            String natFile = "src/JavaData/"+s.nextLine();
            try {
                c = new Crew(natFile);
                break;
            }
            catch (FileNotFoundException fne) {
                System.out.println(fne.getMessage());
            }
        }

        //second loop enters after first breaks only.  Ask for user input and respond accordingly
        while(true){
            System.out.println(" ");
            System.out.println("please enter:");
            System.out.println("1 to print crew(sorted)");
            System.out.println("2 to print crew(shuffled)");
            System.out.println("3 to assemble and print mission crew");
            System.out.println("quit to quit");
            String userInput = s.nextLine();
            if(userInput.equals("quit")){
                System.out.println("Bye!");
                s.close();
                break;
            }
            else if(userInput.equals("1")){
                c.sortCrew();
                c.printCrew();
            }
            else if(userInput.equals("2")){
                c.shuffleCrew();
                c.printCrew();
            }
            else if(userInput.equals("3")){
                c.assembleMissionCrew();
            }
            else{
                System.out.println("Invalid entry!");
            }

        }

























    }

}
