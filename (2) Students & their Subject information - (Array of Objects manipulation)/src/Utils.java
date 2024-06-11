import java.util.ArrayList;

public class Utils {


    //Start of Methods

    /* Start of Get the BEST STUDENT */

    // This method finds the Best Subject for each student (because our students offer different subjects (not the same)
    public static String getTheBestSubject(Student[] array_of_student) //it receives an array of Student Objects (we made it in Main)
    {


            for (int p = 0; p < array_of_student.length; p++) {

                float[] There = array_of_student[p].n; // to store Current student's scores (n is an array)
                Subject Here = array_of_student[p].getsubject(); //Here is a Subject Object // to store Current student's subjects (we made getsubject() in Student class, Student Objects save their Subjects as a Subject object)

                float highest_score = 0;

                String Name = array_of_student[p].getName(); // saves Current student's name

//                System.out.println("\nSubjects of " + Name + "'s HERE - " + Arrays.toString(Here.nameofSubjects));
//              I can open these comments later if I want. But it adds a lot of information in my Run Terminal, so i'll close it.


                // For loop to go through the scores and select the highest one
                    for (int j = 0; j < There.length; j++)
                    {
//                        System.out.println(Here.nameofSubjects[j] + ":" + There[j]);

                        if (There[j] > highest_score)
                        {
                            highest_score = There[j];
                        }
                    }


                    // After getting the highest score, we want to find its location and output it.
                    // And Yes it cannot be done it in the top loop bcoz the current highest_score will be printed at every turn (5x).
                        for (int b = 0; b < There.length; b++)
                        {
                            if (There[b] == highest_score)
                            {
                                System.out.println(Name + "'s Highest Subject is " + Here.nameofSubjects[b] + " with the Score: " + highest_score);
                            }
                        }


            }
             return "---\n";
    }




    /* Start of Get the BEST STUDENT */

    public static String getTheBestStudent (Student[] array_of_student){
        // We need the top student
        // I can do 2 things (since they don't all offer the same course)
        // (1) I can pick the best student for each subjects
        // Or, (2) I can pick the student with the highest score, no matter the subject. (because they all offer 5 subjects :. the total will be the same for everybody)
        // What to do? I pick 2. Easier. (Hopefully.)


        for (int p = 0; p < array_of_student.length; p++) // it receives an array of student objects // for loop to calculate the total scores of each student
        {
            String Name = ""; // calling it here as a local variable so I can access it outside the for loop after making changes to it.

            float[] There = array_of_student[p].n; // stores the scores of current student (an array)

            float this_students_totalscore = 0.0F;

            for (int b = 0; b < There.length; b++) // calculating total score of Current student
            {
                Name = array_of_student[p].getName();
                this_students_totalscore = this_students_totalscore + There[b];
            }
            System.out.println("This is " + Name + "'s Total score = " + this_students_totalscore);
            array_of_student[p].setTotalScore(this_students_totalscore);
        }


        /*The Best Student is then ...*/

        float highest_scorer_holder = 0.0F;
        float temp = 0.0F; // I actually don't need this. I used it during troubleshooting
        ArrayList<Integer> indexes = new ArrayList<Integer>(); // I needed a dynamic array (ArrayList) in other to add only the amount of elements I get

        for (int m = 0; m < array_of_student.length; m++) // goes through every student to see if their score is higher than the last
        {
            if (array_of_student[m].getTotalScore() >= highest_scorer_holder) // Updates the highest score
            {
                temp = highest_scorer_holder;
                highest_scorer_holder = array_of_student[m].getTotalScore();

            }
//            System.out.println("highest score = " + highest_scorer_holder);
//            System.out.println("temp = " + temp);
        }


        // for loop to check if more than one student has the same total score as the highest score we found above
        // then we add their index to our dynamic array (ArrayLists)(as many students as we get, randomly)
        for (int b = 0; b < array_of_student.length; b++)
        {
            if (array_of_student[b].getTotalScore() == highest_scorer_holder) {
                indexes.add(b); // this add method that array lists have is what I needed.
            }
        }
//        System.out.println("highest score = " + highest_scorer_holder);
//        System.out.println("temp = " + temp);



        // Then we print the Name and Highest score of our students with their index in our ArrayList
        System.out.println("\nIndexes of the top student(s): " + indexes);
        for (int m = 0; m < indexes.size(); m++)
        {
            System.out.println("No " + m + " Best Student is ! " + array_of_student[indexes.get(m)].getName() + " with the score : " + array_of_student[indexes.get(m)].getTotalScore());
        }


        return "---\n";
    }

}