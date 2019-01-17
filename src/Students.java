import java.lang.*;

public class Students {
    private Integer id;
    private String studentName, level, grade;


    /*     Validate: ID length : 5 digits, starts with 5.
       Incorrect enter ID ---> Default 0  */
    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
        String str_id= Integer.toString(id);

        //Validate that length = 5 digits AND start with 5
        if (str_id.length() == 5 && str_id.charAt(0) == '5' ) {

            System.out.println("ID: " + id );

        }else {
            int defaultId= 0;
            System.out.println("id: " + defaultId);

        }
    }


    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }



    /* Verify if Student´s level is: Kindergarten, MiddleSchool or HighSchool
   Default --> word LEVEL*/
    public String getLevel() { return level; }

    public void setLevel(String level) {
        this.level = level;
        String accLevel= level.toUpperCase();


        switch(accLevel){
            case "KINDERGARTEN":
                System.out.println("Level: " + accLevel);
                break;

            case "MIDDLESCHOOL":
                System.out.println("Level: " + accLevel);
                break;

            case "HIGHSCHOOL":
                System.out.println("Level: " + accLevel);
                break;

            default:
                System.out.println("Level");
        }

    }


    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }


    /* Verify if grade is equal to 1ro, 2do, 3ro, 4to, 5to, 6to.*/
    public String validateGrade(String gradeLevel){
        this.grade= gradeLevel;

        if (gradeLevel.equals("1ro") || gradeLevel.equals("2do") | gradeLevel.equals("3ro")
                || gradeLevel.equals("4to") || gradeLevel.equals("5to") || gradeLevel.equals("6to")){

            System.out.println("Grade: " + gradeLevel + ".");

            return gradeLevel;
        } else {

            System.out.println("Grade invalid");
            return null;
        }

    }


    public static void main(String[] args){
        Students dataStudents= new Students();
        dataStudents.setId(56483);
        dataStudents.setLevel("");
        dataStudents.validateGrade("");

        //List<Subject> subjects= new ArrayList<Subject>();

    }

}
