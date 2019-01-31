

import java.lang.*;
import java.util.*;
import java.util.List;


public class StudentsFile {
   // Students student= new Students();
    private List<Students> listStudents = new ArrayList<Students>();

    public List<Students> getListStudents() {return listStudents;}
    public void setListStudents(List<Students> listStudents) {this.listStudents = listStudents; }



    /*    **********************************************************************************************************
     *       CREATE A LIST OF STUDENTS, IS NECESSARY CHECK IF THE STUDENTS´ ID IS VALID AND DOES NOT EXIST TO ADD  *
     *       A NEW STUDENT.                                                                                        *
     *  ************************************************************************************************************/

    /*Method to add information to Student. And verify if ID entered is valid or not.
    * If ID is valid and does not exist is going to be added within the list of Students */
    public Boolean addStudent (int id, String name, String level, String grade) {
        Students student = new Students();
        student.setId(id);
        student.setStudentName(name);
        student.setLevel(level);
        student.setGrade(grade);


        if (student.getId() == 0) {
            System.out.println("Student can not added. Please, check the ID.");
            return false;

        } else {

            if (getIndexStudentFromList(id) == -1) {
                listStudents.add(student);
                System.out.println("Student succesfully added.");
                return true;


            } else {
                //System.out.println("Student can not added. Please, check the ID.");
                return false;

            }

        }
    }


    /*Verify if a ID exist in a specific index.
    if not return -1 */
    public int getIndexStudentFromList(int id) {

        for(int i= 0; i<listStudents.size(); i++){

            if(listStudents.get(i).getId()== id){
                //System.out.println("ID " + listStudents.get(i).getId() + " exists in index " + i);
                return i;
            }
        }

        return -1;
    }






    /*    *******************************************************************************************************
    *       IF A STUDENTS WAS ADDED TO THE LIST, NOW IS NECESSARY TO ADD HER/HIM A CORRECT GROUP OF SUBJECTS.   *
    *                                                                                                           *
    *  **********************************************************************************************************/
    //Add the list of subjects to Students.
    public Boolean addStudent ( int id, String name, String level, String grade, List<Subject> sublist){

        if ((addStudent(id, name, level, grade)) && (fillSubjects(sublist))){
            System.out.println("Subjects were succesfully added." + "\n");
            return true;

        } else {
            System.out.println("Subjects can not added." + "\n");
            return false;
        }
    }



    /*    *******************************************************************************************************
     *    STORE SUBJECTS WITHIN EACH STUDENT.                                                                   *
     *          -Find the ID, if ID exists the subjects can be stored.                                          *
     *                                                                                                          *
     *    SET A GRADE WITHIN A SPECIFIC SUBJECT IN SPECIFIC STUDENT.                                            *
     *          -Find the ID, if ID exists and the SUBJECT exists, the grade can be stored.                     *
     *                                                                                                          *
     *          NOTE: the grade just accept integers between 0 to 10.                                           *
     *                                                                                                          *
     *  **********************************************************************************************************/

    public Boolean fillSubjects(List<Subject> sublist) {

        getListStudents().get(getListStudents().size()-1).setListSubjects(sublist);
        System.out.println("Subject list added correctly.");

        return true;
    }



    //To store a grade to specific subject within a specific students´ ID.
    public void gradeSubject(int id, Subject sub, int grade) {
        int index = getIndexStudentFromList(id);

        if(index == -1){
            System.out.println("This ID cannot be find.");

        } else {

            for(int k= 0; k <listStudents.get(index).getListSubjects().size(); k++){

                if(listStudents.get(index).getListSubjects().get(k).getNameSubject().equals(sub.getNameSubject())){
                    if( (grade > 0) && (grade < 10) ){
                        listStudents.get(index).getListSubjects().get(k).setGrade(grade);

                    } else {
                        System.out.println("Please, choose a grade between 0 to 10");
                    }

                }

            }
            //System.out.println("Subject cannot be find.");
        }

    }






    /*    *******************************************************************************************************
     *     IF A STUDENT IS IN:    -  3rd. kindergarten a msg will be  promoted to MiddleSchool.                 *
     *                            -  6th. MiddleSchool a msg will be promoted to HighSchool.                    *
     *                            -  3rd. Highschool this Student is Graduate.                                  *
     *                                                                                                          *
     *  **********************************************************************************************************/

        public void ascendLevel (int id){
            int index= getIndexStudentFromList(id);

            if(index != -1 ) {

                if ((getListStudents().get(index).getGrade().equals("3rd.") && (getListStudents().get(index).getLevel().equals("HIGHSCHOOL")))) {
                    getListStudents().get(index).setLevel("GRADUATE");
                    System.out.println("Student graduated.");
                    return;
                }


                if ((getListStudents().get(index).getGrade().equals("3rd.")) && (getListStudents().get(index).getLevel().equals("KINDERGARTEN"))) {
                    System.out.println("Promote to MiddleSchool.");
                    return;

                } else if ((getListStudents().get(index).getGrade().equals("6th.")) && (getListStudents().get(index).getLevel().equals("MIDDLESCHOOL"))) {
                    System.out.println("Promote to HighSchool.");
                    return;

                }

                System.out.println("Student cannot be promoted.");

            }



        }



    /*    *******************************************************************************************************
     *    REPORT LIST OF STUDENTS PER GROUP :                                                                                  *
     *              - GET ALL DATA.                                                    *
     *  **********************************************************************************************************/

    // imprimir en pantalla los alumnos de cierto grado y nivel, manejar mensajes de validación correspondientes, todos los datos incluyendo las materias
    public void reportListGroup (String grade, String level){
        

        for(int i= 0; i< getListStudents().size(); i++){

            if((getListStudents().get(i).getGrade().equals(grade) && (getListStudents().get(i).getLevel().equals(level)))){
                System.out.println(" ************** STUDENT **************");
                System.out.println("ID: " + getListStudents().get(i).getId() + "\n" + "\n"
                        + "            Name: " + getListStudents().get(i).getStudentName() + "\n"
                        + "            Level: " + getListStudents().get(i).getLevel() + "\n"
                        + "            Grade: " + getListStudents().get(i).getGrade() + "\n");


                System.out.println("           --- SUBJECTS ---          ");
                for (int j = 0; j < getListStudents().get(i).getListSubjects().size(); j++) {
                    System.out.println("            Subject: " + getListStudents().get(i).getListSubjects().get(j).getNameSubject() + "\n"
                            + "            grade: " + getListStudents().get(i).getListSubjects().get(j).getGrade() + "\n");
                }


                System.out.println("*************************************");
                System.out.println("\n");


            }

        }

        System.out.println("The list cannot be founded.");
        System.out.println("Please verify the grade and the level you entered.");
    }









    /*    *******************************************************************************************************
     *    REPORT EACH STUDENT:                                                                                  *
     *              - GET WHOLE STUDENT´S DATA SEARCHED FOR ID.                                                 *
     *  *********************************************************************************************************/
        public void eachDataStudent (int id){
            int indexStudent= getIndexStudentFromList(id);
            int gotIdStudent= getListStudents().get(indexStudent).getId();

            if(indexStudent != -1){
                    System.out.println("\n" +  "Student´s Information: " + gotIdStudent);
                    System.out.println(" ************** STUDENT **************");
                    System.out.println("ID: " + getListStudents().get(indexStudent).getId() + "\n" + "\n"
                            + "            Name: " + getListStudents().get(indexStudent).getStudentName()+ "\n"
                            + "            Grade: " + getListStudents().get(indexStudent).getGrade() + "\n"
                            + "            Level: " + getListStudents().get(indexStudent).getLevel() + "\n");

                    System.out.println("           --- SUBJECTS ---          ");
                for (int i = 0; i < getListStudents().get(indexStudent).getListSubjects().size(); i++) {
                    System.out.println("            Subject: " + getListStudents().get(indexStudent).getListSubjects().get(i).getNameSubject() + "\n"
                            + "            grade: " + getListStudents().get(indexStudent).getListSubjects().get(i).getGrade() + "\n");
                }


            } else {
                System.out.println("Student cannot be found.");
            }


        }




    /*    *******************************************************************************************************
     *      CONSULT WHOLE LIST OF STUDENTS:  OWN DATA WITH SUBJECTS
     *
     *  **********************************************************************************************************/
    /*PAINTING ALL STUDENTS EXIST WITHIN LIST*/
    public Boolean printListStudent() {

        for (Students st : listStudents) {
            System.out.println(" ************** STUDENT **************");
            System.out.println("ID: " + st.getId() + "\n" + "\n"
                    + "            Name: " + st.getStudentName() + "\n"
                    + "            Level: " + st.getLevel() + "\n"
                    + "            Grade: " + st.getGrade() + "\n");


            System.out.println("           --- SUBJECTS ---          ");
            for (int i = 0; i < st.getListSubjects().size(); i++) {
                System.out.println("            Subject: " + st.getListSubjects().get(i).getNameSubject() + "\n"
                        + "            grade: " + st.getListSubjects().get(i).getGrade() + "\n");
            }


            System.out.println("*************************************");
            System.out.println("\n");
        }

        return true;
    }





    public static void main(String[] args) {
        StudentsFile dataStudent = new StudentsFile();


        //Create new instances from Subject
        Subject spanish1= new Subject("Spanish");
        Subject spanish2= new Subject("Spanish");
        Subject spanish3= new Subject("Spanish");

        Subject mathe1= new Subject("Mathematics");
        Subject mathe2= new Subject("Mathematics");
        Subject mathe3= new Subject("Mathematics");

        Subject english1= new Subject("English");
        Subject english2= new Subject("English");
        Subject english3= new Subject("English");

        Subject chem1= new Subject("Chemistry");
        Subject chem2= new Subject("Chemistry");
        Subject chem3= new Subject("Chemistry");

        Subject geo1= new Subject("Geography");
        Subject geo2= new Subject("Geography");
        Subject geo3= new Subject("Geography");

        Subject hist1= new Subject("History");
        Subject hist2= new Subject("History");
        Subject hist3= new Subject("History");

        Subject phil1= new Subject("Philosophy");
        Subject phil2= new Subject("Philosophy");
        Subject phil3= new Subject("Philosophy");

        Subject art1= new Subject("Art");
        Subject art2= new Subject("Art");
        Subject art3= new Subject("Art");


        //Create new instances from List<Subject>
        List<Subject> listSubjects1 = new ArrayList<>();
        listSubjects1.add(spanish1);
        listSubjects1.add(geo1);
        listSubjects1.add(english1);

        List<Subject> listSubjects2 = new ArrayList<>();
        listSubjects2.add(mathe1);
        listSubjects2.add(chem1);
        listSubjects2.add(hist1);

        List<Subject> listSubjects3 = new ArrayList<>();
        listSubjects3.add(spanish2);
        listSubjects3.add(phil1);
        listSubjects3.add(geo2);

        List<Subject> listSubjects4 = new ArrayList<>();
        listSubjects4.add(english2);
        listSubjects4.add(art1);
        listSubjects4.add(hist2);

        List<Subject> listSubjects5 = new ArrayList<>();
        listSubjects5.add(chem2);
        listSubjects5.add(mathe2);
        listSubjects5.add(art2);

        List<Subject> listSubjects6 = new ArrayList<>();
        listSubjects6.add(english3);
        listSubjects6.add(phil2);
        listSubjects6.add(spanish3);

        List<Subject> listSubjects7 = new ArrayList<>();
        listSubjects7.add(hist3);
        listSubjects7.add(art3);
        listSubjects7.add(chem3);

        List<Subject> listSubjects8 = new ArrayList<>();
        listSubjects8.add(mathe3);
        listSubjects8.add(phil3);
        listSubjects8.add(geo3);




        //Add students with idValid and id no repeat.
        dataStudent.addStudent(50000, "Claudia","hiGHSCHOOL","2nd", listSubjects1 );
        dataStudent.addStudent(51111, "Fernando","kindergarten", "2nd", listSubjects2);
        dataStudent.addStudent(52222, "Fatima","MiddleSchool","5th", listSubjects3);
        dataStudent.addStudent(53333, "Matias","hiGHSCHOOL","3rd", listSubjects4);
        dataStudent.addStudent(54444, "Mateo","kindergarten","2nd", listSubjects5);
        dataStudent.addStudent(55555, "Sergio","MiddleSchool","1st", listSubjects6);
        dataStudent.addStudent(56666, "Angelina","kindergarten","2nd", listSubjects7);
        dataStudent.addStudent(57777, "Janeth","MiddLESchooL","6th", listSubjects8);
        //dataStudent.addStudent(51111, "Fabiola","kindergarten","2nd");
        //dataStudent.addStudent(53333, "Israel","kindergarten", "2nd");



        //Store a grade within each subject for Students´ ID
        //dataStudent.gradeSubject(50000, geo1 , 7);



        /*To know if a Students can be promoted.
        dataStudent.ascendLevel(50000);
        dataStudent.ascendLevel(51111);
        dataStudent.ascendLevel(52222);
        dataStudent.ascendLevel(53333);
        dataStudent.ascendLevel(54444);
        dataStudent.ascendLevel(55555);
        dataStudent.ascendLevel(56666);
        dataStudent.ascendLevel(57777);*/


        dataStudent.reportListGroup("4th.", "HIGHSCHOOL");


        //dataStudent.eachDataStudent(50000);

        //dataStudent.printListStudent();


    }
}

