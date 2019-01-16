

public class Subject {

    private String[] subjects= {"spanish", "chemistry", "english", "mathematics"};
    private Integer grade;


    public String[] getSubjects() { return subjects; }
    public void setSubjects(String[] signatures) { this.subjects = subjects;}

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }




    //Validate the subject exist into the Subjects´ Array.
    public void validateSubject(String subject){
        String validateSubject= subject.toLowerCase();
        grade= -1;

        if(validateSubject.equals("spanish") || validateSubject.equals("chemistry") || validateSubject.equals("english" ) || validateSubject.equals("mathematics")){
            System.out.println("Subject: " + validateSubject + "\n" + "Grade: " + grade);


        } else {
            System.out.println("Subject was not found.");

        }
    }



    public static void main (String[] args){
        Subject subjectsStudent= new Subject();
        subjectsStudent.validateSubject("algebra");

    }
}
