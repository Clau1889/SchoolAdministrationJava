public class Employees {
    private Integer id;
    private String name, career = "career", group;


    /* Validate: ID length : 5 digits, starts with 1.
       Incorrect enter ID ---> Default 0  */
    public Integer getId() { return id; }
    public void setId(Integer id) {
        String str_id= Integer.toString(id);

        //Validate that length = 5 digits AND start with 1
        if (str_id.length() == 5 && str_id.charAt(0) == '1' ) {
            this.id= id;

        }else {
            this.id= 0;

        }
    }




    // Receive Employee´s name
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;

    }




    /* Verify if Employee´s career is: Teacher, Director or Administrator
   Default --> word Career*/
    public String getCareer() {return career; }
    public void setCareer(String career) {
        String currentCareer= career.toUpperCase();


        switch(currentCareer){
            case "TEACHER":
                this.career= "TEACHER";
                break;

            case "DIRECTOR":
                this.career= "DIRECTOR";
                break;

            case "ADMINISTRATOR":
                this.career= "ADMINISTRATOR";
                break;

            default:
                this.career="Not Career";

        }}





    //Validate that group return a String with the parameters grade + level
    public String getGroup() { return group; }
    public void setGroup (String grade, String level){
        level= level.toUpperCase();

        if(getCareer().equals("TEACHER")){

            if ((grade.equals("1st") || grade.equals("2nd") || grade.equals("3rd")) && (level.equals("KINDERGARTEN"))){
                this.group= grade + level;

            } else if((grade.equals("1st") || grade.equals("2nd") || grade.equals("3rd")
                || grade.equals("4th") || grade.equals("5th") ||grade.equals("6th")) && (level.equals("MIDDLESCHOOL"))){
                this.group= grade + level;


            } else if ((grade.equals("1st") || grade.equals("2nd") || grade.equals("3rd")) && (level.equals("HIGHSCHOOL"))){
                this.group= grade + level;

            } else {
                this.group= "Not group";

            }

        }else if (getCareer().equals("ADMINISTRATOR") || getCareer().equals("DIRECTOR")){
            this.group= "NA";

        }

    }


}
