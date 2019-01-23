public class Employees {
    private Integer id;
    private String name, career = "career", group;


    /* Validate: ID length : 5 digits, starts with 1.
       Incorrect enter ID ---> Default 0  */
    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
        String str_id= Integer.toString(id);

        //Validate that length = 5 digits AND start with 5
        if (str_id.length() == 5 && str_id.charAt(0) == '1' ) {
            this.id= id;
            System.out.println("ID: " + id );

        }else {
            this.id= 0;
            System.out.println("id: " + this.id);

        }
    }




    // Receive Employee´s name
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
        System.out.println("Name: " + this.name);
    }




    /* Verify if Employee´s career is: Teacher, Director or Administrator
   Default --> word Career*/
    public String getCareer() {return career; }
    public void setCareer(String career) {
        this.career = career;
        String currentCareer= career.toUpperCase();


        switch(currentCareer){
            case "TEACHER":
                this.career= "TEACHER";
                System.out.println("Career: " + currentCareer);
                break;

            case "DIRECTOR":
                this.career= "DIRECTOR";
                System.out.println("Career: " + currentCareer);
                break;

            case "ADMINISTRATOR":
                this.career= "ADMINISTRATOR";
                System.out.println("Career: " + currentCareer);
                break;

            default:
                this.career="Not Career";
                System.out.println(this.career);
        }}



    //Validate that group return a String with the parameters grade + level
    public String getGroup() { return group; }
    public void setGroup (String grade, String level){
        level= level.toUpperCase();

        if ((grade.equals("1ro") || grade.equals("2do") || grade.equals("3ro")) && (level.equals("KINDERGARTEN"))){
            this.group= grade + level;
            System.out.println("Group: " + this.group);

        } else if((grade.equals("1ro") || grade.equals("2do") || grade.equals("3ro")
                || grade.equals("4to") || grade.equals("5to") ||grade.equals("6to")) && (level.equals("MIDDLESCHOOL"))){

            this.group= grade + level;
            System.out.println("Group: " + this.group);

        } else if ((grade.equals("1ro") || grade.equals("2do") || grade.equals("3ro")) && (level.equals("HIGHSCHOOL"))){
            this.group= grade + level;
            System.out.println("Group: " + this.group);

        } else {
            this.group= "Not group";
            System.out.println(this.group);

        }
    }


    //Constructor
    public Employees(int id, String name, String career, String grade, String level){
        setId(id);
        setName(name);
        setCareer(career);
        setGroup(grade, level);
    }


    public static void main (String[] args) {
    Employees dataEmployee= new Employees(12456, "Sebastian", "Teacher" , "5to", "MiddleSchool" + "\n");

    }
}
