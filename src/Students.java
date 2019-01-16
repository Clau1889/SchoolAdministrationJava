import java.lang.*;

public class Students {
    private Integer id= 0;
    private String studentName, level= "level", grade;


    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
        String str_id= Integer.toString(id);

        //Validate that length = 5 digits AND start with 5
        if (str_id.length() == 5 && str_id.charAt(0) == '5' ) {

            System.out.println("ID correct.");

        }else {
            System.out.println("ID incorrect. Please, enter ID with 5 digits.");

        }
    }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }


    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }


    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }



    public static void main(String[] args){
        Students dataStudents= new Students();
        dataStudents.setId(54882);

        //List<Subject> subjects= new ArrayList<Subject>();

    }

}
