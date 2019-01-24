import java.lang.*;
import java.util.*;

public class Students {
    private Integer id;
    private String studentName, level, grade;
    private List<Subject> listSubjects= new ArrayList<>();


    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public List<Subject> getListSubjects() { return listSubjects; }
    public void setListSubjects(List<Subject> listSubjects) { this.listSubjects = listSubjects; }




    /*     Validate: ID length : 5 digits, starts with 5.
       Incorrect enter ID ---> Default 0  */
    public Integer getId() { return id; }

    public void setId(Integer id) {
        String str_id= Integer.toString(id);

        //Validate that length = 5 digits AND start with 5
        if (str_id.length() == 5 && str_id.charAt(0) == '5' ) {
            this.id= id;

        }else {
            this.id= 0;

        }
    }




    /* Verify if Student´s level is: Kindergarten, MiddleSchool or HighSchool
   Default --> word LEVEL*/
    public String getLevel() { return level; }
    public void setLevel(String level) {
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
                this.level= "LEVEL";
        }

    }


    //Validate just receive those grades in that format and in a specific level.
    public String getGrade() { return grade; }
    public void setGrade(String grade) {

        if (grade.equals("1st") || grade.equals("2nd") || grade.equals("3rd") && (getLevel().equals("KINDERGARTEN"))){
            this.grade= grade;

        }else if ((grade.equals("1st") || grade.equals("2nd") || grade.equals("3st") || grade.equals("4th")
                || grade.equals("5th")|| grade.equals("6th")) && (getLevel().equals("MIDDLESCHOOL"))){
            this.grade= grade;

        }else if ((grade.equals("1st") || grade.equals("2nd") || grade.equals("3rd")) && (getLevel().equals("HIGSCHOOL"))){
            this.grade= grade;

        }else {
            this.grade = "Grade invalid.";
        }

    }



}
