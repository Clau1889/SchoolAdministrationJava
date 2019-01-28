

import java.lang.*;
import java.util.*;
import java.util.List;


public class StudentsFile {
   // Students student= new Students();
    private List<Students> listStudents = new ArrayList<Students>();

    public List<Students> getListStudents() {return listStudents;}
    public void setListStudents(List<Students> listStudents) {this.listStudents = listStudents; }



    /*    *******************************************************************************************************
     *       CREATE A LIST OF STUDENTS, IS NECESSARY CHECK IF THE STUDENTS´ ID IS VALID AND DOES NOT EXIST TO ADD
     *       A NEW STUDENT.
     *  ************************************************************************************************************/

    /*Method to add information to Student. And verify if ID entered is valid or not.
    * If ID is valid and doesn´t exist is going to be added within the list of Students */
    public Boolean addStudent (int id, String name, String level, String grade) {
        //Instance student to store its own information.
        Students student = new Students();
        student.setId(id);
        student.setStudentName(name);
        student.setLevel(level);
        student.setGrade(grade);

        if (student.getId() == 0) {
            System.out.println("Student can not added. ID invalid" + "\n");
            return false;

        } else {

            if (getIndexStudentFromList(student) == -1) {
                listStudents.add(student);
                System.out.println("Student succesfully added.");
                return true;


            } else {
                System.out.println("Student can not added. Please, check the ID." );
                return false;

            }

        }
    }



    /*Verify if a ID exist in a specific index.
    if not return -1 */
    public int getIndexStudentFromList(Students student) {
        Integer flag = -1;


        for(int i= 0; i<listStudents.size(); i++){

            if(listStudents.get(i).getId().equals(student.getId())){
                flag = i;
                System.out.println("ID " + listStudents.get(i).getId() + " exists in index " + flag);
                break;
            }
        }

        return flag;
    }



    /*    *******************************************************************************************************
    *       IF A STUDENTS WAS ADDED TO THE LIST, NOW IS NECESSARY TO ADD HER/HIM A CORRECT GROUP OF SUBJECTS.
    *
    *  ************************************************************************************************************/
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



    //Set the list of Subject to each student
    public Boolean fillSubjects(List<Subject> sublist) {

        getListStudents().get(getListStudents().size()-1).setListSubjects(sublist);
        System.out.println("Subject list added correctly.");

        return true;
    }



    // To store a grade to specific subject within a specific student.
    public Boolean gradeSubject(Students student){
        Boolean flag= true;

        for(int k= 0; k< listStudents.size(); k++){
            if(!listStudents.get(k).getId().equals(student.getId())){
                System.out.println("This ID cannot be find.");

                flag= false;
                return flag;
            }else{
                return flag;
            }
        }
        


        if(flag){
            for (int i = 0; i < student.getListSubjects().size(); i++){
                if (student.getListSubjects().get(i).getNameSubject().equals(fillSubjects())){
                    flag = true;
                    break;
                }
        }

        return flag;
    }




    /*    *******************************************************************************************************
     *      CONSULT WHOLE LIST OF STUDENTS:  OWN DATA WITH SUBJECTS
     *
     *  **********************************************************************************************************/
        /*PAINTING ALL STUDENTS EXIST WITHIN LIST*/
        public void allListStudent () {

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
        }


    /* If a student is at 3rd.Kindergarten or 6th.MiddleSchool or 3rd.HighSchool
    he/she could be ascend to the next level
    public void ascendLevel (Students student){

        for(int j=0; j<listStudents.size(); j++) {
            if (((getIndexStudentFromList(student) != -1 ) && ((student.getGrade().equals("3rd") && student.getLevel().equals("KINDERGARTEN"))))){
                System.out.print("This student could be promoted to the next level");
            } else if (((getIndexStudentFromList(student) != -1 ) && (student.getGrade().equals("6th") && student.getLevel().equals("MIDDLESCHOOL")))) {
                System.out.print("This student could be promoted to the next level");
            } else if (((getIndexStudentFromList(student) != -1 ) && (student.getGrade().equals("3rd") && student.getLevel().equals("HIGHSCHOOL")))) {
                System.out.print("This student is: " + student.getLevel());
            } else {
                System.out.print("This student could not be promoted yet");
            }
        }
    }*/






    /*
    public Boolean subjectGrade(Students student, Subject subject, int grade){
        Boolean bandera;
        Boolean bandera1;
        bandera = false;

        for (int i = 0; i < listStudents.size(); i++){
            if (listStudents.get(i).getId().equals(student.getId())){
                bandera = true;
                break;
            }
        }

        if(bandera){
            bandera1=false;
            for (int i = 0; i < student.getListSubjects().size(); i++){
                if (student.getListSubjects().get(i).getNameSubject().equals(subject.getNameSubject())){
                    student.getListSubjects().get(i).setGrade(grade);
                    bandera1 = true;
                    break;
                }
            }
            if(bandera1){
                return bandera1;
            } else{
                System.out.println("Subject doesn´t exists.");
                return bandera1;
            }

        }
        else{
            System.out.println("Subject doesn´t exist.");
            return bandera;
        }

    }*/


    public static void main(String[] args) {
        StudentsFile dataStudent = new StudentsFile();


        //Create new instances from Subject
        Subject subject1= new Subject("Spanish");
        Subject subject2= new Subject("Mathematics");
        Subject subject3= new Subject("English");
        Subject subject4= new Subject("Art");
        Subject subject5= new Subject("Literature");
        Subject subject6= new Subject("Philosophy");
        Subject subject7= new Subject("Chemistry");
        Subject subject8= new Subject("Geography");
        Subject subject9= new Subject("History");



        List<Subject> listSubjects1 = new ArrayList<>();
        listSubjects1.add(subject1);
        listSubjects1.add(subject8);
        listSubjects1.add(subject5);

        List<Subject> listSubjects2 = new ArrayList<>();
        listSubjects2.add(subject2);
        listSubjects2.add(subject4);
        listSubjects2.add(subject6);

        List<Subject> listSubjects3 = new ArrayList<>();
        listSubjects3.add(subject3);
        listSubjects3.add(subject7);
        listSubjects3.add(subject9);

        List<Subject> listSubjects4 = new ArrayList<>();
        listSubjects4.add(subject9);

        //Add students with idValid and id no repeat.
        Boolean alumno1=dataStudent.addStudent(56543, "Claudia","kindergarten","3rd", listSubjects1);
        Boolean alumno2=dataStudent.addStudent(5543, "Rosa","kindergarten","3rd",listSubjects3);
        Boolean alumno3=dataStudent.addStudent(56543, "Israel","kindergarten","2nd",listSubjects2);
        Boolean alumno4=dataStudent.addStudent(51111, "Fernando","kindergarten","1st",listSubjects2);
        Boolean alumno5=dataStudent.addStudent(51111, "Fabiola","kindergarten","2nd",listSubjects4);
        Boolean alumno6=dataStudent.addStudent(50000, "Fatima","kindergarten","3rd",listSubjects1);
        Boolean alumno7=dataStudent.addStudent(53333, "Matias","hiGHSCHOOL","3rd",listSubjects4);
        Boolean alumno8=dataStudent.addStudent(58888, "Mateo","kindergarten","3rd",listSubjects3);
        Boolean alumno9=dataStudent.addStudent(56544, "Sergio","kindergarten","1st",listSubjects2);
        Boolean alumno10=dataStudent.addStudent(553, "Rafael","hiGHSCHOOL","3ro", listSubjects3);
        Boolean alumno11=dataStudent.addStudent(59999, "Angelina","kindergarten","2nd",listSubjects2);
        Boolean alumno12=dataStudent.addStudent(50000, "Janeth","kindergarten","1st",listSubjects4);


        /*
        Boolean alumno1a=dataStudent.addStudent(50000, "Rafael","kindergarten","3rd", listSubjects3 );
        Boolean alumno1b=dataStudent.addStudent(59999, "Angelina","kindergarten","1st", listSubjects1);
        Boolean alumno1c=dataStudent.addStudent(50000, "Janeth","kindergarten","2nd", listSubjects3);*/

        //dataStudent.subjectGrade(studentData, subject5, 7); */

        dataStudent.allListStudent();


    }
}

