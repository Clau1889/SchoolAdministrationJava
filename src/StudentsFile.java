import java.lang.*;
import java.util.*;
import java.util.List;


public class StudentsFile {
    private List<Students> listStudents = new ArrayList<Students>();
    private List<Subject> listSubjects1 = new ArrayList<>();
    private List<Subject> listSubjects2 = new ArrayList<>();
    private List<Subject> listSubjects3 = new ArrayList<>();
    
    public List<Students> getListStudents() {return listStudents;}
    public void setListStudents(List<Students> listStudents) {this.listStudents = listStudents; }



    //Validate if id is valid or not.
    public Boolean idValidOrNot(Students student){
           if(student.getId() == 0) {

               //System.out.println("Id invalid.");

               return false;
           }  else {
               //System.out.println("Id valid.");
               //listStudents.add(student);
                //System.out.println(listStudents.size());
                return true;

           }

    }


    /*Verify if ID get already exist
    * IF DOESN´T EXIST NOT ADD WITHIN LIST*/
    public Boolean idAlreadyExist(Students student){
        Boolean bandera;
       if(idValidOrNot(student).equals(true)){
             if(listStudents.size() == 0) {
                listStudents.add(student);
                //System.out.println("ID "+ student.getId());
                //System.out.println(listStudents.size());
                return true;
             }
             else{
                 bandera = true;
                 for (int i = 0; i < listStudents.size(); i++){
                     if (listStudents.get(i).getId().equals(student.getId())){
                         bandera = false;
                         break;
                     }
                 }

                 if(bandera){
                     listStudents.add(student);
                     //System.out.println("ID "+ student.getId());
                     //System.out.println(listStudents.size());

                 }
                 return bandera;
             }
       } else{
         return false;

       }
    }

    /*PAINTING ALL STUDENTS EXIST WITHIN LIST*/
    public void allListStudent(){

        for( Students st: listStudents){
            System.out.println(" *** STUDENT ***" );
            System.out.println("ID: " + st.getId() + "\n"
                    +  st.getStudentName() + "\n"
                    + st.getLevel() + "\n"
                    + st.getGrade());

            System.out.println(" -----  SUBJECTS ------" );
            for(int i= 0; i<st.getListSubjects().size(); i++){
                System.out.println(st.getListSubjects().get(i).getNameSubject() + " grade: " +
                        st.getListSubjects().get(i).getGrade());
            }

            System.out.println("\n");
        }
    }


    public void listSubject1(Subject sub){
        listSubjects1.add(sub);
    }
    public void listSubject2(Subject sub){
        listSubjects2.add(sub);
    }
    public void listSubject3(Subject sub){
        listSubjects3.add(sub);
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

        Subject subject1 = new Subject("Spanish");
        Subject subject2 = new Subject("Mathematics");
        Subject subject3 = new Subject("Geography");
        Subject subject4 = new Subject("History");
        Subject subject5 = new Subject("Art");

        dataStudent.listSubject1(subject1);
        dataStudent.listSubject1(subject2);
        dataStudent.listSubject1(subject3);

        dataStudent.listSubject2(subject1);
        dataStudent.listSubject2(subject4);
        dataStudent.listSubject2(subject5);

        dataStudent.listSubject3(subject3);
        dataStudent.listSubject3(subject4);
        dataStudent.listSubject3(subject5);

         //Create 8 Students within list.
         Students studentData1= new Students(51111, "Claudia", "kindergarten", "4to", dataStudent.listSubjects1);
         Students studentData2= new Students(52222, "Rosa", "kindergarten", "2do", dataStudent.listSubjects2);
         Students studentData3= new Students(53333, "Claudia", "middleSchool", "4to", dataStudent.listSubjects3);
         Students studentData4= new Students(54444, "Fernando", "middleSchool", "5to", dataStudent.listSubjects3);
         Students studentData5= new Students(55555, "Israel", "kindergarten", "4to", dataStudent.listSubjects2);
         Students studentData6= new Students(56666, "Fatima", "Highschool", "3ro", dataStudent.listSubjects1);
         Students studentData7= new Students(57777, "Mateo", "kindergarten", "1ro", dataStudent.listSubjects1);
         Students studentData8= new Students(58888, "Mateo", "kindergarten", "1ro", dataStudent.listSubjects3);


         dataStudent.idValidOrNot(studentData1);
         dataStudent.idAlreadyExist(studentData1);

         dataStudent.idValidOrNot(studentData2);
         dataStudent.idAlreadyExist(studentData2);

         dataStudent.idValidOrNot(studentData3);
         dataStudent.idAlreadyExist(studentData3);

         dataStudent.idValidOrNot(studentData4);
         dataStudent.idAlreadyExist(studentData4);

         dataStudent.idValidOrNot(studentData5);
         dataStudent.idAlreadyExist(studentData5);

         dataStudent.idValidOrNot(studentData6);
         dataStudent.idAlreadyExist(studentData6);

         dataStudent.idValidOrNot(studentData7);
         dataStudent.idAlreadyExist(studentData7);


        dataStudent.idValidOrNot(studentData8);
        dataStudent.idAlreadyExist(studentData8);


        dataStudent.subjectGrade(studentData6, subject5, 7);
        dataStudent.subjectGrade(studentData3, subject3, 7);
        dataStudent.subjectGrade(studentData1, subject1, 9);
        dataStudent.allListStudent();


    }
}

