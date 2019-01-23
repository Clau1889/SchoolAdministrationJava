import java.lang.*;
import java.util.*;

public class Students {
    private Integer id;
    private String studentName, level, grade;
    private List<Subject> listSubjects= new ArrayList<>();




    /*     Validate: ID length : 5 digits, starts with 5.
       Incorrect enter ID ---> Default 0  */
    public Integer getId() { return id; }

    public void setId(Integer idd) {
        this.id = idd;
        String str_id= Integer.toString(id);

        //Validate that length = 5 digits AND start with 5
        if (str_id.length() == 5 && str_id.charAt(0) == '5' ) {
            this.id= idd;
            //System.out.println("ID: " + id);

        }else {
            this.id= 0;
            //System.out.println("id: " + id);

        }
    }


    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
        //System.out.println("Student: " + studentName);
    }



    /* Verify if Student´s level is: Kindergarten, MiddleSchool or HighSchool
   Default --> word LEVEL*/
    public String getLevel() { return level; }

    public void setLevel(String level) {
        this.level = level;
        String accLevel= level.toUpperCase();


        switch(accLevel){
            case "KINDERGARTEN":
                this.level= "KINDERGARTEN";
                //System.out.println("Level: " + this.level);
                break;

            case "MIDDLESCHOOL":
                this.level= "MIDDLESCHOOL";
                //System.out.println("Level: " + this.level);
                break;

            case "HIGHSCHOOL":
                this.level= "HIGHSCHOOL";
                //System.out.println("Level: " + this.level);
                break;

            default:
                //System.out.println("Level");
        }

    }


    public String getGrade() { return grade; }
    public void setGrade(String grade) {
        this.grade = grade;

        if (grade.equals("1ro") || grade.equals("2do") || grade.equals("3ro")
                || grade.equals("4to") || grade.equals("5to") ||grade.equals("6to")){
            this.grade= grade;
            //System.out.println("Grade: " + grade + ".");

        } else {
            this.grade="Grade invalid.";
            //System.out.println(this.grade);

        }
    }
    

    public List<Subject> getListSubjects() { return listSubjects; }
    public void setListSubjects(List<Subject> listSubjects) { this.listSubjects = listSubjects; }



    //Constructor
    public Students(int id, String name, String level, String grade, List<Subject> listSubjects){
        setId(id);
        setStudentName(name);
        setLevel(level);
        setGrade(grade);
        setListSubjects(listSubjects);
    }


}
