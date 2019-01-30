

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
    * If ID is valid and does not exist is going to be added within the list of Students */
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

            if (getIndexStudentFromList(id) == -1) {
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
    public int getIndexStudentFromList(int id) {

        for(int i= 0; i<listStudents.size(); i++){

            if(listStudents.get(i).getId()== id){
                System.out.println("ID " + listStudents.get(i).getId() + " exists in index " + i);
                return i;
            }
        }

        return -1;
    }






    /*    *******************************************************************************************************
    *       IF A STUDENTS WAS ADDED TO THE LIST, NOW IS NECESSARY TO ADD HER/HIM A CORRECT GROUP OF SUBJECTS.
    *
    *  ************************************************************************************************************/
    //Add the list of subjects to Students.
    public Boolean addStudent ( int id, String name, String level, String grade, List<Subject> sublist){


            if ((addStudent(id, name, level, grade))){

                System.out.println("Subjects were succesfully added." + "\n");
                return true;

            } else {
                System.out.println("Subjects can not added." + "\n");
                return false;
            }


    }



    //Set the list of Subject to each student
    /*· fillMaterias-> toma toda la lista de alumnos y les agrega 3 materias que yo defina,
     para no tener q dar de alta manualmente las materias a cada alumno, pueden hacerlo q lo haga a todos
     o a un id q uds le manden, depende de cómo se les haga más fácil.*/

    public void fillSubjects(int id, String eachSubject) {
        Subject subject= new Subject(eachSubject);
        subject.setNameSubject(eachSubject);

        int indexStudent= getIndexStudentFromList(id);


        if((getIndexStudentFromList(id) != -1)){

            getListStudents().get(indexStudent).getListSubjects().add(subject);
            System.out.println("Subject list added correctly.");

        }

    }



    // To store a grade to specific subject within a specific student.
    public void gradeSubject(int id, String subject, int grade) {
        //System.out.println(grade);
        int index = getIndexStudentFromList(id);
        if(index == -1){
            System.out.println("This ID cannot be find.");

        } else {
            System.out.println("ID find it.");
            for(int k= 0; k <listStudents.get(index).getListSubjects().size(); k++){

                if(listStudents.get(index).getListSubjects().get(k).getNameSubject().equals(subject)){
                    listStudents.get(index).getListSubjects().get(k).setGrade(grade);
                    System.out.println("Grade stored.");
                    break;
                }
            }

        }

    }



    /*    *******************************************************************************************************
     *      CONSULT WHOLE LIST OF STUDENTS:  OWN DATA WITH SUBJECTS
     *
     *  **********************************************************************************************************/
        /*PAINTING ALL STUDENTS EXIST WITHIN LIST*/
        public void allListStudent() {

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




    public static void main(String[] args) {
        StudentsFile dataStudent = new StudentsFile();

        List<Subject> listSubjects = new ArrayList<>();

        /*Create new instances from Subject
        Subject subject1= new Subject("Spanish");
        Subject subject2= new Subject("Mathematics");
        Subject subject3= new Subject("English");
        Subject subject4= new Subject("Art");
        Subject subject5= new Subject("Literature");
        Subject subject6= new Subject("Philosophy");
        Subject subject7= new Subject("Chemistry");
        Subject subject8= new Subject("Geography");
        Subject subject9= new Subject("History");*/

/*
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
        listSubjects4.add(subject9);*/



        //Add students with idValid and id no repeat.
        dataStudent.addStudent(56666, "Claudia","kindergarten","3rd");
        dataStudent.addStudent(5543, "Rosa","kindergarten","3rd");
        dataStudent.addStudent(56543, "Israel","kindergarten","2nd");
        dataStudent.addStudent(51111, "Fernando","kindergarten","1st");
        dataStudent.addStudent(51111, "Fabiola","kindergarten","2nd");
        dataStudent.addStudent(50000, "Fatima","kindergarten","3rd");
        dataStudent.addStudent(53333, "Matias","hiGHSCHOOL","3rd");
        dataStudent.addStudent(58888, "Mateo","kindergarten","3rd");
        dataStudent.addStudent(56544, "Sergio","kindergarten","1st");
        dataStudent.addStudent(553, "Rafael","hiGHSCHOOL","3ro");
        dataStudent.addStudent(59999, "Angelina","kindergarten","2nd");
        dataStudent.addStudent(50000, "Janeth","kindergarten","1st");


        dataStudent.fillSubjects(59999, "Mathematics");
        dataStudent.fillSubjects(50000, "Spanish");
        dataStudent.fillSubjects(56666, "Geography");
        dataStudent.fillSubjects(50000, "Geography");

        dataStudent.gradeSubject(50000, "Geography", 8);

        dataStudent.allListStudent();




    }
}

