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

            System.out.println("ID: " + id );

        }else {
            int defaultId= 0;
            System.out.println("id: " + defaultId);

        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCareer() {return career; }
    public void setCareer(String career) { this.career = career; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }








    public static void main (String[] args) {
    Employees dataEmployee= new Employees();
    dataEmployee.setId(23);
    }
}
