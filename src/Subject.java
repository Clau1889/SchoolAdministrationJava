import java.util.*;

public class Subject {
    private Integer grade = -1;
    private String nameSubject;

    public String getNameSubject() { return nameSubject; }
    public void setNameSubject(String nameSubject) { this.nameSubject = nameSubject; }


    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }

    /*
    public Subject(String subject, int grade){
        setNameSubject(subject);
        setGrade(grade);
    }*/


    public Subject(String subject){
        setNameSubject(subject);

    }



}




