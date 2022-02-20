import java.io.*;
import java.util.*;

//gets and stores the data from the file
public class MarsData {
    //vars
    private double [][] arrayOfMars;
    private List<Double> longs=new ArrayList<>();
    private List<Double>lats=new ArrayList<>();
    private List<Double>alts=new ArrayList<>();
    private double longmin;
    private double longmax;
    private double latmin;
    private double latmax;
    private double altmin=0;
    private double altmax=0;



    //constructor

    //method

    //gets a list of lats/longs/altitudes and their min/max values by calling readFile.
    //creates searchable arrayOfMars
    public void readData2D(String fileloc) throws IOException {
        readFile(fileloc);
        //this array will be used to find the altitude by searching lat/long.
        // this array is 2d array of [y]x[z] where y is the unique longitude values, and z is the unique latitude values. Each row in this array is a list of altitudes at unique latitudes for that long(row)
        arrayOfMars = new double[longs.size()][lats.size()];
        int shift=0;
        for(int l=0;l<longs.size();l++) {
            double[] row = new double[lats.size()]; //make a row thats the same length as unique lat values for each of the unique long values.
            for (int j = 0; j < lats.size(); j++) {
                row[j] = alts.get(j + shift);
            }
            shift += (row.length); //shift is used to skip values that have already been used.  So that program will not fill row with the same 180 values.
            arrayOfMars[l] = row; //add the row to the 2d array
        }

    }


    //generates the list of lat/long/altitude
    public void readFile(String fileloc) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(fileloc)); //open the reader on a new file at specified location
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] splitLine = line.split(",");

            double double0 = Double.parseDouble(splitLine[0]);
            double double1 = Double.parseDouble(splitLine[1]);
            double double2 = Double.parseDouble(splitLine[2]);

            if (!longs.contains(double0)) {
                longs.add(double0);
            }

            if (!lats.contains(double1)) {
                lats.add(double1);
            }

            alts.add(double2);

        }
        longmin = Collections.min(longs);
        longmax = Collections.max(longs);
        latmin = Collections.min(lats);
        latmax = Collections.max(lats);
        altmin = Collections.min(alts);
        altmax = Collections.max(alts);
    }

    //get altitude by lat/long
    public double getAltitude(double findlong, double findlat){
        int ilong=longs.indexOf(findlong);
        int ilat=lats.indexOf(findlat);
        return arrayOfMars[ilong][ilat];
    }

    //getters
    public double getLongmin(){
        return longmin;
    }
    public double getLongmax(){
        return longmax;
    }
    public double getLatmin(){
        return latmin;
    }
    public double getLatmax(){
        return latmax;
    }
    public double getAltmin(){
        return altmin;
    }
    public double getAltmax(){
        return altmax;
    }
    public List<Double> getLongs(){
        return longs;
    }
    public List<Double> getLats(){
        return lats;
    }


}
