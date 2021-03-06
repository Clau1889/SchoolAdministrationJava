import java.util.*;
import java.lang.*;

public class EmployeesFile {
    List<Employees> listEmployees= new ArrayList<Employees>();

    public List<Employees> getListEmployees() { return listEmployees; }
    public void setListEmployees(List<Employees> listEmployees) { this.listEmployees = listEmployees;}



    /*    *******************************************************************************************************
     *    - RECEIVE DATA FROM EMPLOYEE.                                                                         *
     *    - VERIFY IF DATA ENTERED WAS CORRECT, IF ID DOES NOT EXIST.                                           *
     *    - IF THE EMPLOYEE IS DIRECTOR O ADMINISTRATOR CHANGE GROUP AS "NA"                                    *
     *  *********************************************************************************************************/

    //Add a new employee.
    //Recibe todos los datos y validar q sea correcta la creación son el setters  y q el id no sea repetido
    // como en el caso de los alumnos, si el empleado a agregar no es maestro el campo grupo tiene q ser NA.
    public Boolean addEmployee (int id, String name, String career, String grade, String level){
        Employees employee= new Employees();
        employee.setId(id);
        employee.setName(name);
        employee.setCareer(career);
        employee.setGroup(grade, level);

        if(employee.getId() == 0){
            System.out.println("Employee cannot be added. " + "\n");

        } else {


            if (getIndexEmployeeFromList(id) != -1) {
                System.out.println("Employee cannot be added. " + "\n");

                if(!employee.getCareer().equals("TEACHER")){
                   // employee.setGroup();
                }


                return true;
            } else {
                listEmployees.add(employee);
                //System.out.println("Employee was added succesfully.");

                return false;
            }
        }

        return true;
    }


    //Find if ID already exists.
    public int getIndexEmployeeFromList(int id){

        for(int k=0; k<listEmployees.size(); k++) {
            if(listEmployees.get(k).getId().equals(id)){
                return k;

            }
        }
        return -1;
    }


    /*    *******************************************************************************************************
     *    TO CHANGE AN EMPLOYEE THE CAREER                                                                      *
     *        - ID EXISTS WITHIN THE LIST.                                                                      *
     *        - FROM ADMINISTRATOR TO DIRECTOR/TEACHER -> ADD GROUP AND DIRECTOR NOT EXISTS.                    *
     *        - FROM TEACHER TO DIRECTOR/ADMINISTRATOR  -> QUIT GROUP TO N/A  AND NOT EXIST OTHER DIRECTOR.      *
     *  *********************************************************************************************************/
   public void changeCareer (int id, String changeCareer) {
        int index= getIndexEmployeeFromList(id);
        String addNewCareer= changeCareer.toUpperCase();
        Boolean flag= false;

       for(Employees employee: getListEmployees()) {

           if(index != -1) {
               if((getListEmployees().get(index).getId().equals(employee.getId()) && (employee.getCareer().equals("TEACHER")))){
                   System.out.println("This is a teacher");

                   if(getListEmployees().get(index).getCareer().equals(addNewCareer)){
                       System.out.println("Already is A TEACHER.");

                   } else{
                       if(addNewCareer.equals("ADMINISTRATOR")){
                           getListEmployees().get(index).setCareer(addNewCareer);
                           System.out.println("Career changed to Administrator");

                       }else if(addNewCareer.equals("DIRECTOR")){
                           for(Employees emp: getListEmployees()){

                               if(emp.getCareer().equals("DIRECTOR")){
                                   System.out.println("There is a director already.");
                                   flag= true;

                               }
                           }

                           if (flag == false){
                               getListEmployees().get(index).setCareer(addNewCareer);
                               System.out.println("Career changed to Director");
                           }

                       }else{
                           System.out.println("This career is unavailable.");
                       }
                   }


               }else if ((getListEmployees().get(index).getId().equals(employee.getId()) && (employee.getCareer().equals("ADMINISTRATOR"))) ){
                   System.out.println("This is AN ADMINISTRATOR");

                   if(getListEmployees().get(index).getCareer().equals(addNewCareer)){
                       System.out.println("Already is an Administrator.");

                   } else{
                       if(addNewCareer.equals("TEACHER")){
                           getListEmployees().get(index).setCareer(addNewCareer);
                           System.out.println("Career changed to Teacher");

                       }else if(addNewCareer.equals("DIRECTOR")){
                           for(Employees emp: getListEmployees()){

                               if(emp.getCareer().equals("DIRECTOR")){
                                   System.out.println("There is a director already.");
                                   flag= true;

                               }
                           }

                           if (flag == false){
                               getListEmployees().get(index).setCareer(addNewCareer);
                               System.out.println("Career changed to Director");
                           }

                       }else{
                           System.out.println("This career is unavailable.");
                       }
                   }

               }else if((getListEmployees().get(index).getId().equals(employee.getId()) && (employee.getCareer().equals("DIRECTOR"))) ){
                   System.out.println("This is A DIRECTOR.");

                   if(getListEmployees().get(index).getCareer().equals(addNewCareer)){
                       System.out.println("Already is a Director.");

                   } else{
                       if(addNewCareer.equals("ADMINISTRATOR")){
                           getListEmployees().get(index).setCareer(addNewCareer);
                           System.out.println("Career changed to Administrator");

                       }else if(addNewCareer.equals("TEACHER")){
                           getListEmployees().get(index).setCareer(addNewCareer);
                           System.out.println("Career changed to Teacher");

                       }else{
                           System.out.println("This career is unavailable.");

                       }
                   }
               }


           } else {
               System.out.println("ID not exists.");

           }
       }



    }


    /*    *******************************************************************************************************
     *    CHECK THE EMPLOYEE WITH THE ID, AND IF IS A TEACHER SET A GROUP.                                      *
     *                                                                                                          *
     *  *********************************************************************************************************/
    public void chooseGroupForTeacher(int id, String grade, String level){
        int index= getIndexEmployeeFromList(id);

        if(index != -1){
           if(getListEmployees().get(index).getCareer().equals("TEACHER")){
               getListEmployees().get(index).setGroup(grade, level);
               System.out.println("Group was designed.");

           }else if(getListEmployees().get(index).getCareer().equals("ADMINISTRATOR") || getListEmployees().get(index).getCareer().equals("DIRECTOR")){
               System.out.println("Sorry, you cannot set a group.");
           }

        }else{
            System.out.println("ID doesn´t exist.");


        }
    }



    /*    *******************************************************************************************************
     *    CHECK THE EMPLOYEE WITH THE ID, AND IF IS A TEACHER REMOVE THE GROUP.                                 *
     *                                                                                                          *
     *  *********************************************************************************************************/
    public void removeGroupForTeacher(int id){
        int index= getIndexEmployeeFromList(id);

        if(index != -1){
            if(getListEmployees().get(index).getCareer().equals("TEACHER")){
                getListEmployees().get(index).setGroup("","");
                System.out.println("Group was remove");

            }else if(getListEmployees().get(index).getCareer().equals("ADMINISTRATOR") || getListEmployees().get(index).getCareer().equals("DIRECTOR")){
                System.out.println("Sorry, you cannot remove a group.");
            }


        }else{
            System.out.println("ID cannot be found.");
        }
    }




    /*    ************************************************************************************************************
     *    CHECK THE EMPLOYEE WITH THE ID, AND IF IS A TEACHER AND DOESN´T HAVE A GROUP, THE EMPLOYEE CAN BE REMOVED. *
     *    IF THE EMPLOYEE IS A DIRECTOR OR AN ADMINISTRATOR CAN BE REMOVED.                                          *
     *  **************************************************************************************************************/
    public void removeEmployee(int id){
        int index= getIndexEmployeeFromList(id);

        if(index != -1){
            if(getListEmployees().get(index).getCareer().equals("TEACHER") && getListEmployees().get(index).getGroup().equals("Not group")){
                getListEmployees().get(index).setId(0);
                getListEmployees().get(index).setName("");
                getListEmployees().get(index).setCareer("");
                System.out.println("The employee was removed");

            }else if((getListEmployees().get(index).getCareer().equals("ADMINISTRATOR")) || (getListEmployees().get(index).getCareer().equals("DIRECTOR"))){
                getListEmployees().get(index).setId(0);
                getListEmployees().get(index).setName("");
                getListEmployees().get(index).setCareer("");
                System.out.println("The employee was removed.");

            }else{
                System.out.println("The employee cannot be removed.");
            }

        }else{
            System.out.println("ID was not found.");
        }
    }



    /*    *******************************************************************************************************
     *    PRINT THE WHOLE LIST OF EMPLOYEES                                                                     *
     *  *********************************************************************************************************/
    public void printAllEmployees (){
       for (Employees emp: listEmployees){
           System.out.println("----------     EMPLOYEE     ----------------");
           System.out.println("ID: " + emp.getId() + "\n"
                              + "          Name: " +  emp.getName() + "\n"
                              + "          Career: " +  emp.getCareer() + "\n"
                              + "          Group: " +  emp.getGroup() + "\n");
       }
    }



    /*    *******************************************************************************************************
     *    PRINT THE WHOLE LIST OF EMPLOYEES PER CAREER.                                                         *
     *  *********************************************************************************************************/
    public void printEmployeePerCareer(String career){
        Boolean flag= true;

        for(Employees employee: listEmployees){
            if(flag){
                if(employee.getCareer().equals(career.toUpperCase())){
                    System.out.println("----------     EMPLOYEE     ----------------");
                    System.out.println("ID: " + employee.getId() + "\n"
                        + "          Name: " +  employee.getName() + "\n"
                        + "          Career: " +  employee.getCareer() + "\n"
                        + "          Group: " +  employee.getGroup() + "\n");

                }

            }else {
                flag= false;
                System.out.println("There are not Employees with that career.");
            }
        }
    }


    /*    *******************************************************************************************************
     *    PRINT THE WHOLE LIST OF TEACHERS PER LEVEL                                                            *
     *  *********************************************************************************************************/
    public void printTeachersPerLevel (String level){
        Boolean flag= true;

        for( Employees emp: listEmployees) {
            if (flag) {
                if (emp.getGroup().contains(level.toUpperCase())){
                    System.out.println("----------     EMPLOYEE     ----------------");
                    System.out.println("ID: " + emp.getId() + "\n"
                            + "          Name: " +  emp.getName() + "\n"
                            + "          Career: " +  emp.getCareer() + "\n"
                            + "          Group: " +  emp.getGroup() + "\n");

                }

            } else {
                System.out.println("There are not Teachers in this level.");
            }
        }
    }



    public static void main(String[] args){
        EmployeesFile dataEmployee = new EmployeesFile();

        //Create 8 employees
        dataEmployee.addEmployee(10001, "Roberto", "Teacher", "3rd", "KindergARTEN");
        dataEmployee.addEmployee(10002, "Matías", "teacher", "1st", "MIDDLESCHOOL");
        dataEmployee.addEmployee(10003, "Cassandra", "Teacher", "4th", "mIDDLESCHOOL");
        dataEmployee.addEmployee(10004, "Ramiro", "ADmiNistrator", "1st", "HighSchool");
        dataEmployee.addEmployee(10005, "Marcela", "Director", "2nd", "Highschool");
        dataEmployee.addEmployee(10006, "Jesús", "teacher", "3rd", "kiNDERGARten");
        dataEmployee.addEmployee(10007, "Francisco", "TEACHER", "2nd", "Kindergarten");
        dataEmployee.addEmployee(10008, "Jóse Luis", "Teacher", "2nd", "HighSchool");
        //dataEmployee.addEmployee(10001, "Luis", "Director", "5th", "MiddleSchool");
        //dataEmployee.addEmployee(101, "Luis", "Director", "6th", "MiddlesCHOOL");

       //dataEmployee.changeCareer(10005, "administrator" );

       //dataEmployee.chooseGroupForTeacher(10010, "3rd", "MIddleSchool");

       //dataEmployee.removeGroupForTeacher(10003);

        //dataEmployee.removeEmployee(10005);

       //dataEmployee.printAllEmployees();

        //dataEmployee.printEmployeePerCareer("");

        dataEmployee.printTeachersPerLevel("HighSCHOOL");

    }
}
