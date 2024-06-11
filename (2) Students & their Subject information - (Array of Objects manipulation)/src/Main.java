import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        P.rintln("\nLET'S BEGIN");
        P.rintln("We have 10 subjects to pick from. Initialize your Students with these indexes.");
        P.rintln("0-Photography, 1-Politics, 2-Law, 3-Fashion, 4-Math, 5-English, 6-Chemistry, 7-Physics, 8-Biology, 9-History");



        P.rintln("\n_____________________________________________________________________");
        P.rintln("Task 1 - Create an array of 5 students");
        P.rintln("                        ------------------------                        ");


        /*I am initializing a Student and a Subject array for that Student*/
        Subject Subjects_1st_person = new Subject(0, 2, 4, 3, 1);
        Student _1_Student = new Student("Bridget","Von","Red", Subjects_1st_person);

        Subject Subjects_2nd_person = new Subject(1, 3, 5, 7, 9);
        Student _2_Student = new Student("Daniel","Hu","Blue", Subjects_2nd_person);

        Subject Subjects_3rd_person = new Subject(9, 1, 4, 8, 7);
        Student _3_Student = new Student("Newie","Nerd","Yellow", Subjects_3rd_person);

        Subject Subjects_4th_person = new Subject(0, 3, 4, 7, 8);
        Student _4_Student = new Student("Christella","Butterfly","Green", Subjects_4th_person);

        Subject Subjects_5th_person = new Subject(1, 2, 5, 6, 8);
        Student _5_Student = new Student("Moranna","Caine","Purple", Subjects_5th_person);


        /*I made nextId increase ++ everytime a new student is added (a static member) so it keeps record of the number of students we have*/
        Student [] array_of_student_objects = new Student[Student.nextId];
        array_of_student_objects[0] = _1_Student;
        array_of_student_objects[1] = _2_Student;
        array_of_student_objects[2] = _3_Student;
        array_of_student_objects[3] = _4_Student;
        array_of_student_objects[4] = _5_Student;



        /* Display the new Array of Student OBJECTS*/
        System.out.println("Array of Students = \n" + Arrays.toString(array_of_student_objects));





        /*Calculate the average score of each student based on the (total) results of the session.*/
        P.rintln("\n_____________________________________________________________________");
        P.rintln("Task 2 - Calculate the average score of each Student");
        P.rintln("                        ------------------------                        ");

        for (int i = 0; i < array_of_student_objects.length; i++)
        {
            float average = 0;
            for (float v : array_of_student_objects[i].n) // float n is the array of scores (see Student class & score() in Subject class)
            {
                average = average + v;
            }
            float true_average = average / array_of_student_objects[i].n.length; //calculate average
            array_of_student_objects[i].setAveragescore(true_average); // set average value into every student object for safekeeping
            System.out.println("The average for " + array_of_student_objects[i].getName() + " is " + true_average); //print
        }





        /*
        For each student
         * print out grades,
         * the average score for the semester,
         * passed or not passed the subject,
        */
        P.rintln("\n_____________________________________________________________________");
        P.rintln("Task 3 - Print the (i) grades, (ii) average score & (iii) passed or not passed - for each student");
        P.rintln("                        ------------------------                        ");

        for (int i = 0; i < array_of_student_objects.length; i++) // length of array of student OBJECTS
        {
            String Name = array_of_student_objects[i].getName();
            P.rintln(Name); // print Current student name
            System.out.println(Arrays.toString(array_of_student_objects[i].n)); // print Current Student's scores (an array)

            Subject getsubject = array_of_student_objects[i].getsubject(); // get the Current students subjects (an array)
            // !! but it is an Object of the Subject class that the Student class took. so we'll call it again with its variable from Subject class
            String[] inhalt = getsubject.nameofSubjects; // save the subjects per student in a simple holder  // never used

            float[] thefloat = array_of_student_objects[i].n; // save the scores per student in a simple holder
            System.out.println(array_of_student_objects[i].ispassed_or_not_main(thefloat)); // Student method. checks all subjects for passed / fail
            P.rintln("Average score: " + array_of_student_objects[i].getAveragescore()); // using our previously saved average score
            P.rintln("");

        }





        /*
         determine who will receive a regular scholarship (average score of 4.0-4.9)
       who will receive increased scholarship (average score 5.0)
         */
        P.rintln("\n_____________________________________________________________________");
        P.rintln("Task 4 - Who gets a Scholarship?");
        P.rintln("                        ------------------------                        ");


        for (int i = 0; i < array_of_student_objects.length; i++)
        {
            if ((array_of_student_objects[i].getAveragescore()) >= 4.0 && (array_of_student_objects[i].getAveragescore() <= 4.9))
            {
                P.rintln(array_of_student_objects[i].getName() + " : REGULAR scholarship");
            } else if (array_of_student_objects[i].getAveragescore() >= 5) {
                P.rintln(array_of_student_objects[i].getName() + " : INCREASED scholarship");
            }
        }





        P.rintln("\n_____________________________________________________________________");
        P.rintln("Other Workings");
        P.rintln("                        ------------------------                        ");


        /* Dealing with Utils class */

        Utils Best_Sub = new Utils();


        System.out.println("\nFrom here is UTILS - BEST SUBJECT per Student: \n");
        System.out.println(Best_Sub.getTheBestSubject(array_of_student_objects)); // A Util class method. // we give it the whole array of Student OBJECTS to work on


        System.out.println("\nFrom here is UTILS - BEST STUDENT: \n");
        System.out.println(Best_Sub.getTheBestStudent(array_of_student_objects)); // A Util class method. // we give it the whole array of Student OBJECTS to work on





        P.rintln("\n_____________________________________________________________________");
        P.rintln("You can also find out if a Student passed 1 subject by giving the Index e.g 5 / 0");
        P.rintln("                        ------------------------                        ");

        /*I created another Student class method that can check if just 1 subject (not the whole subjects) was passed. Give it the subject index.*/
        System.out.println("This is " + _3_Student.getName() + ", index:'4' " + ", score: " + _3_Student.n[4]);
        System.out.println(_3_Student.passed_in_student(4));




// End of Main Class
        }
    }
