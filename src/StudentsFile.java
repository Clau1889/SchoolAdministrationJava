import java.lang.*;
import java.util.*;
import java.util.List;


public class StudentsFile {
   // Students student= new Students();
    private List<Students> listStudents = new ArrayList<Students>();

    public List<Students> getListStudents() {return listStudents;}
    public void setListStudents(List<Students> listStudents) {this.listStudents = listStudents; }


    public Boolean addStudent (int id, String name, String level, String grade) {
        //Instance student to store its own information.
        Students student = new Students();
        student.setId(id);
        student.setStudentName(name);
        student.setLevel(level);
        student.setGrade(grade);
        //System.out.println(student.getListSubjects().size() + "    test");

        if (student.getId() == 0) {
            System.out.println("Student can not added. ID invalid" + "\n");
            return false;

        } else {

            //int Pa = getIndexStudentFromList(student);
            //System.out.println(Pa);
            if (getIndexStudentFromList(student) == -1) {
                listStudents.add(student);
                System.out.println("Student succesfully added." + "\n");
                return true;


            } else {
                System.out.println("Student can not added. Please, check the ID."  + "\n");
                return false;

            }
        }
    }


        public Boolean addStudent ( int id, String name, String level, String grade, List < Subject > subjectList ){
        /*Instance student to add its own information.
        Students student= new Students();
        student.setListSubjects(subjectList);*/

            if (addStudent(id, name, level, grade)) {
                //student.setListSubjects(subjectList);
                return true;

            } else {
                System.out.println("Subject can not added.");
                return false;

            }
        }




    /*Verify if a ID exist in a specific index.
    if not return -1 */
    public int getIndexStudentFromList(Students student) {
        Integer flag = -1;

        //System.out.println("estudiante a buscar " + student.getId() );

        for(int i= 0; i<listStudents.size(); i++){
           // System.out.println("estudiante a comparar "+listStudents.get(i).getId());

            if(listStudents.get(i).getId().equals(student.getId())){
                flag = i;
                System.out.println("ID " + listStudents.get(i).getId() + " existe en el index " + flag);
                break;
            }
        }
        //System.out.println("flag "+ flag);
        return flag;
    }





    /*PAINTING ALL STUDENTS EXIST WITHIN LIST*/
    public void allListStudent(){

        for( Students st: listStudents){
            System.out.println(" *** STUDENT ***" );
            System.out.println("ID: " + st.getId() + "\n"
                    + "Name: " + st.getStudentName() + "\n"
                    + "Level: " + st.getLevel() + "\n"
                    + "Grade: " + st.getGrade());

            System.out.println(" -----  SUBJECTS ------" );
            for(int i= 0; i<st.getListSubjects().size(); i++){
                System.out.println(st.getListSubjects().get(i).getNameSubject() + " grade: " +
                        st.getListSubjects().get(i).getGrade());
            }

            System.out.println("\n");
        }
    }







    /*FINDING THE SUBJECT WITHIN STUDENT*/
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

    }


    public static void main(String[] args) {
        StudentsFile dataStudent = new StudentsFile();


        //Create instances of each Subject.
        Subject subject1 = new Subject("Spanish");
        Subject subject2 = new Subject("Mathematics");
        Subject subject3 = new Subject("Geography");
        Subject subject4 = new Subject("History");
        Subject subject5 = new Subject("Art");
        Subject subject6 = new Subject("English");
        Subject subject7 = new Subject("Literature");
        Subject subject8 = new Subject("Philosophy");
        Subject subject9 = new Subject("Chemistry");



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


        //Add students with idValid and id no repeat.
        Boolean alumno1=dataStudent.addStudent(56543, "Claudia","kindergarten","3ro");
        Boolean alumno2=dataStudent.addStudent(5543, "Rosa","kindergarten","3ro");
        Boolean alumno3=dataStudent.addStudent(56543, "Israel","kindergarten","3ro");
        Boolean alumno4=dataStudent.addStudent(51111, "Fernando","kindergarten","3ro");
        Boolean alumno5=dataStudent.addStudent(56222, "Fabiola","kindergarten","3ro");
        Boolean alumno6=dataStudent.addStudent(50000, "Fatima","kindergarten","3ro");
        Boolean alumno7=dataStudent.addStudent(53333, "Matias","kindergarten","3ro");
        Boolean alumno8=dataStudent.addStudent(58888, "Mateo","kindergarten","3ro");
        Boolean alumno9=dataStudent.addStudent(56544, "Sergio","kindergarten","3ro");
        Boolean alumno10=dataStudent.addStudent(553, "Rafael","kindergarten","3ro");
        Boolean alumno11=dataStudent.addStudent(59999, "Angelina","kindergarten","3ro");
        Boolean alumno12=dataStudent.addStudent(50000, "Janeth","kindergarten","3ro");



       /* Boolean alumno1a=dataStudent.addStudent(50000, "Rafael","kindergarten","3rd", listSubjects2 );
        Boolean alumno1b=dataStudent.addStudent(59999, "Angelina","kindergarten","1st", listSubjects1);
        Boolean alumno1c=dataStudent.addStudent(50000, "Janeth","kindergarten","2nd", listSubjects3);*/

        //dataStudent.subjectGrade(studentData, subject5, 7); */


        dataStudent.allListStudent();


    }
}

