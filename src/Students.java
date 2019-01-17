import java.lang.*;

public class Students {
    private Integer id;
    private String studentName, level, grade;
    private Object levels;


    public Integer getId() { return id; }

    /*     Validate: ID lenght : 5 digits, starts with 5.
           Incorrect enter ID ---> Default 0                */
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


    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }




    //Set of static levels
    public enum levels {
        KINDERGARTEN, MIDDLESCHOOL, HIGHSCHOOL;

    }

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



    public static void main(String[] args){
        Students dataStudents= new Students();
        dataStudents.setId(56780);
        dataStudents.setLevel("KINDERGARTEN");

        //List<Subject> subjects= new ArrayList<Subject>();

    }

}
