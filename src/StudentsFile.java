import java.lang.*;
import java.util.*;
import java.util.List;


public class StudentsFile {
    private List<Students> listStudents = new ArrayList<Students>();

    public List<Students> getListStudents() {return listStudents;}
    public void setListStudents(List<Students> listStudents) {this.listStudents = listStudents; }


    public Boolean addStudent (int id, String name, String level, String grade){
        //Instance student to add its own information.
                Students student= new Students();
                student.setId(id);
                student.setStudentName(name);
                student.setLevel(level);
                student.setGrade(grade);

        if(student.getId() == 0) {
            System.out.println("Student can not added. Please, check the ID.");


            return false;
        }  else {

            Boolean bandera;
                if(listStudents.size() == 0) {
                    listStudents.add(student);
                    System.out.println("Student succesfully added.");
                    return true;
                }
                else{
                    bandera = true;
                    for (int i = 0; i < listStudents.size(); i++){
                        if (listStudents.get(i).getId().equals(student.getId())){
                            bandera = false;
                            System.out.println("Student can not added. Please, check the ID.");
                            break;
                        }
                    }

                    if(bandera){
                        listStudents.add(student);
                        System.out.println("Student succesfully added.");

                    }
                    return bandera;
                }


        }


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
            System.out.println("Id doesn´t exist.");
            return bandera;
        }

    }


    public static void main(String[] args) {


        //Add student with idValid and id no repeat.
        StudentsFile dataStudent = new StudentsFile();

        Boolean alumno1=dataStudent.addStudent(56543, "Claudia","kindergarten","3ro");
        Boolean alumno2=dataStudent.addStudent(5543, "Claudia1","kindergarten","3ro");
        Boolean alumno3=dataStudent.addStudent(56543, "Claudia2","kindergarten","3ro");
        Boolean alumno4=dataStudent.addStudent(58543, "Claudia3","kindergarten","3ro");


        /*
        dataStudent.idValidOrNot(studentData);
        dataStudent.idAlreadyExist(studentData);


        List<Subject> listSubjects1 = new ArrayList<>();
        List<Subject> listSubjects2 = new ArrayList<>();
        List<Subject> listSubjects3 = new ArrayList<>();

        Subject subject1 = new Subject("Spanish");
        Subject subject2 = new Subject("Mathematics");
        Subject subject3 = new Subject("Geography");
        Subject subject4 = new Subject("History");
        Subject subject5 = new Subject("Art");


        dataStudent.subjectGrade(studentData, subject5, 7); */

        dataStudent.allListStudent();


    }
}

