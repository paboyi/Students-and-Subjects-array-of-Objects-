import java.util.Arrays;

public class Student {
    /* Beginning of attributes */

    // attributes for student ID & tracking the number of students
     int id;
     static int nextId = 0;

     // simple attributes for students
    private String name;
    private String surname;
    private String group;

    // attributes I will create later in Utils & Main // need a place to save them
    private float totalScore;
    private float averagescore;

    /* End of attributes */





    /* Beginning of setters */
    public void setName (String name)
    {
        this.name = name;
    }

    public void setSurname (String surname)
    {
        this.surname = surname;
    }

    public void setGroup (String group)
    {
        this.group = group;
    }


    public void setTotalScore (Float totalScore)
    {
        this.totalScore = totalScore;
    }

    public void setAveragescore (Float averagescore)
    {
        this.averagescore = averagescore;
    }

    /* End of setters */





    /* Beginning of getters */
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getGroup() {
        return group;
    }

    public Float getTotalScore() {
        return totalScore;
    }
    public Float getAveragescore()
    {
       return averagescore;
    }


    /* End of getters */






    // Calling the Subject Object for use within the Student class
    private Subject subject;

    public Subject getsubject() {
        return subject;
    }



    // Class Constructor
    // I can have more than 1 constructor if I change the parameters

    Student (String name, String surname, String group, Subject subject)
    {
        nextId++;
        this.id = nextId;
        this.setName(name);
        this.setSurname(surname);
        this.setGroup(group);

        this.subject = subject;

        float[] p = setScores();
    }





    /* Working with the SUBJECT Class */

    float[] n = new float[5]; // scores variable (an array)

    public float[] setScores() {
        int o = 0; //creating o because I cant use i (float) for an array's [] index ([i] = ! , [o] = good)
      for(float i : n)
       {
       n[o] = Subject.score();
       o++;
       }
        return n; // n is an array of scores // we are basically filling up our float above
    }




    boolean passed = Subject.passed;

    /* I will create 2 passed methods to check if a Student passed a subject*/

    // (i) To check a single subject, for a single student, by its index (i.e. index in its array)
    boolean passed_in_student(int Subject_index)
    {
                if (n[Subject_index] >= 3)
                {
                    passed = true;
                    P.rintln("Your score '" + n[Subject_index] + "' is > 2");
                }
                else {
                    passed = false;
                    P.rintln("Your score '" + n[Subject_index] + "' is < 3");
                }
        P.rint("Did this Student Pass " + subject.nameofSubjects[Subject_index] + "? - ");
        return passed;
    }


    // (i) To check for every single subject, for a single student
    public String ispassed_or_not_main(float[] n)
    {
       for (int i = 0; i < n.length; i++)
       {
           if (n[i] >= 3) {
               passed = true;
           } else {
               passed = false;
           }
           System.out.println(subject.nameofSubjects[i] + " (" + n[i] + ") : passed(?)  = " + passed);
       }
        return "---";
    }

    /* End of Working with the Subject Class */





    // Beginning of print toString() override
    @Override
    public String toString() {
     return "\nStudent ID: " + id +" | NAME: " + name + " " + surname + " | GROUP: "
             + group +"\n"
             + "SUBJECTS: " + subject +
             "\nSCORES: " + Arrays.toString(n) + "\n";
    }


//  Beware !!!
//End of Class
}