import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Crew {

    //vars
    private static final String[] RANKS ={"Commander","Pilot","Payload Commander","Mission Specialist",
                                            "Spaceflight Participant"};
    private String[] nationalities = new String[0]; //have to initialise this as array of len 0 in order to copy
    private List<Astronaut> crew= new ArrayList<Astronaut>();


    //constructor
    Crew(String filePath) throws FileNotFoundException {
        getNationalities(filePath); //too much code in constructor so made method to extract nationalities from file and call it here
        //loop the RANKS list, for each rank make an astronaut object of each nationality with random age (within boundary)
        for(int i=0;i< RANKS.length;i++){
            for(int n=0;n< nationalities.length;n++){
                Astronaut a = new Astronaut(nationalities[n],RANKS[i],i,(int)(Math.random()*(25)+26));
                crew.add(a);
            }
        }
    }


    //methods

    //returns the nationalities array updated with list pulled from file.  Could force it to not accept .csv?
    private void getNationalities(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        int i=1; //make a counter for the array index and len, start at 1 to put first element in
        while(input.hasNext()){ //while there are lines in file:
            nationalities = Arrays.copyOf(nationalities,i); //make a new copy of the nationalities array with increased size. Since we start at length 1, index 0 must be used
            nationalities[i-1]=input.nextLine(); //add the text on this line to the correct index in array
            i=i+1;
        }
        input.close();
    }

    public void printCrew(){
        System.out.println(crew);
    }

    public void sortCrew(){
        Collections.sort(crew);
    }

    public void shuffleCrew(){
        Collections.shuffle(crew);
    }

    public TreeMap assembleMissionCrew() {
        TreeMap<String, Object> missionCrew = new TreeMap<>();
        for (int i = 0; i < RANKS.length;i++){
            List<Astronaut> useList = new ArrayList<Astronaut>(); //fill with the appropriate astros to use
            for(Astronaut a: crew){
                if(a.getRank()==RANKS[i]){
                    useList.add(a);
                }
            }
            int r=(int)(Math.random()*(useList.size()-1)); //generate random index
            missionCrew.put(useList.get(r).getRank(),useList.get(r));
        }
        System.out.println(missionCrew);
        return missionCrew;  //check
    }





}

