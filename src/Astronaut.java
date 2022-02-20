public class Astronaut implements Comparable<Astronaut> {
    //vars
    private String nationality;
    private String rank;
    private int rankNum;
    private int age;


    //constructor
    Astronaut(String astNationality, String astRank, int astRankNum, int astAge) {
        this.nationality = astNationality;
        this.rank = astRank;
        this.rankNum = astRankNum;
        this.age = astAge;
    }

    //method
    //override the toString method to print out an astronaut object in the following way:
    @Override
    public String toString() {
        String printAst = rank + " " + "(" + nationality + "," + " " + age +")";
        return printAst;
    }

    //overriding the compareTo method to ensure the list sorts as we want it to: ascending: (rank number,nationality alphabetical,age)
    @Override
    public int compareTo(Astronaut otherAst) { //check this sorts correctly- is type of list ok to default sort by compareto?
        int result = otherAst.rankNum - this.rankNum;
        if (result == 0) { //if the ranks are the same
            String nat1 = this.nationality;
            String nat2 = otherAst.nationality;
            result = nat2.compareTo(nat1);
            if(result==0){
                result=otherAst.age-this.age;
            }
        }
        return result;

    }

    //override the equality check between objects
    @Override
    public boolean equals(Object o){
        Astronaut a = (Astronaut) o;
        return rankNum == a.rankNum && nationality == a.nationality && age == a.age;
    }

    public String getRank(){
        return this.rank;
    }


}
