import java.util.Arrays;

public class Subject {


    // this array is for the names of the objects we'll create.
    // the teacher wants me to pick the Subjects the students will offer from this array
    // I believe he actually wanted me to create a 5 subject array. Same for all students. But I realized that later. It would have been easier though. I don't regret it.

     String [] nameOfSubjectObjects = {"Photography","Politics","Law","Fashion","Math","English", "Chemistry","Physics","Biology","History"};
    // I have 10 subjects. Indexes 0 - 9


    // The students can only offer 5 subjects. So I will create 5 attributes
    String [] nameofSubjects = new String[5];


    /* Subject Constructor. needs 5 ints (indexes to me)*/
    Subject (int a, int b, int c, int d, int e)
    {
        nameofSubjects[0] = this.nameOfSubjectObjects[a];
        nameofSubjects[1] = this.nameOfSubjectObjects[b];
        nameofSubjects[2] = this.nameOfSubjectObjects[c];
        nameofSubjects[3] = this.nameOfSubjectObjects[d];
        nameofSubjects[4] = this.nameOfSubjectObjects[e];
    }



    /*Task was to create a score() method in Subject class, that gives random scores from 2 to 5*/
    public static float score()
    {
        float mark;
        mark = (float) (((Math.random() + 0.01) * 3) + 2); // will return a number between 2 and 5
        // I put the 0.01 there to even out a 4.9 to 5
        // Because Math.Random generates numbers from 0.0... to 0.9...

        float rounded = (float) (Math.round(mark * 100.0)/100.0); // gives 2 decimal places (e.g. 4.9876..* 100 = 498.76 | round 498.76 = 499 | 499/100 = 4.99).
        return rounded;
    }


    public static boolean passed; // I was asked to do it. Plus I needed it in Subject class. //It had to be (i) public & (ii) static, to be able to be called from another class. Just like float score() above.



    // Beginning of print toString() override
    @Override
    public String toString() {
        return Arrays.toString(nameofSubjects);
    }



// End of Class Subject
}
