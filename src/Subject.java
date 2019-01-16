public class Subject {

    private String[] subjects= {"spanish", "chemistry", "english", "mathematics"};
    private Integer grade;


    public String[] getSubjects() { return subjects; }
    public void setSubjects(String[] signatures) { this.subjects = subjects;}

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }



    public Boolean validateSubject(String subject){
        String validateSubject= subject.toLowerCase();

        if(validateSubject.equals("spanish") || validateSubject.equals("chemistry") || validateSubject.equals("english" ) || validateSubject.equals("mathematics")){
            System.out.println("Subject was funded.");
            return true;

        } else {
            System.out.println("Subject was not found.");
            return false;
        }
    }
    

    public static void main (String[] args){
        Subject subjectsStudent= new Subject();
        subjectsStudent.validateSubject("CHEMISTRY");
    }
}
