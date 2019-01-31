import java.util.*;
import java.lang.*;

public class EmployeesFile {
    List<Employees> listEmployees= new ArrayList<Employees>();

    /*    *******************************************************************************************************
     *    - RECEIVE DATA FROM EMPLOYEE.                                                                         *
     *    - VERIFY IF DATA ENTERED WAS CORRECT, IF ID DOES NOT EXIST.                                           *
     *    - IF THE EMPLOYEE IS DIRECTOR O ADMINISTRATOR CHANGE GROUP AS "NA"                                    *
     *  *********************************************************************************************************/

    //Add a new employee.
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
                System.out.println("Employee was added succesfully." + "\n");

                return false;
            }
        }

        return true;
    }


    //Find if ID already exists.
    public int getIndexEmployeeFromList(int id){

        for(int k=0; k<listEmployees.size(); k++) {
            if(listEmployees.get(k).getId().equals(id)){
                System.out.println("This ID was found.");
                return k;

            }
        }
        return -1;
    }


    /*    *******************************************************************************************************
     *    TO CHANGE AN EMPLOYEE THE CAREER                                                                      *
     *        - ID EXISTS WITHIN THE LIST.                                                                      *
     *        - FROM ADMINISTRATOR TO DIRECTOR/TEACHER -> ADD GROUP AND DIRECTOR NOT EXISTS.                    *
     *        -FROM TEACHER TO DIRECTOR/ADMINISTRATOR  -> QUIT GROUP TO N/A  AND NOT EXIST OTHER DIRECTOR.      *
     *  *********************************************************************************************************/
    //Recibe el id del empleado y el nuevo puesto a asignar, validar si cambia de maestro a otro tipo q desasignemos
    // el grupo y si es a director q no tengamos uno ya existente en la lista de empleados, también validar
    // q el puesto q estamos recibiendo sea un string valido, así como el q id del empleado exista en la lista.
   /* public void addNewCareer (int id, String newCareer) {
        int index= getIndexEmployeeFromList(id);



    }*/


    public static void main(String[] args){
        EmployeesFile dataEmployee = new EmployeesFile();

        //Create 8 employees
        dataEmployee.addEmployee(10001, "Roberto", "Teacher", "3rd", "KindergARTEN");
        dataEmployee.addEmployee(10002, "Matías", "Director", "1st", "MIDDLESCHOOL");
        dataEmployee.addEmployee(10003, "Cassandra", "Teacher", "4th", "mIDDLESCHOOL");
        dataEmployee.addEmployee(10004, "Ramiro", "ADmiNistrator", "1st", "HighSchool");
        dataEmployee.addEmployee(10005, "Marcela", "Teacher", "2nd", "Highschool");
        dataEmployee.addEmployee(101, "Luis", "Director", "6th", "MiddlesCHOOL");
        dataEmployee.addEmployee(10006, "Jesús", "ADminiSTRATOR", "3d", "kiNDERGARten");
        dataEmployee.addEmployee(10007, "Francisco", "TEACHER", "2nd", "Kindergarten");
        dataEmployee.addEmployee(10008, "Jóse Luis", "teacher", "2nd", "HighSchool");
        dataEmployee.addEmployee(10001, "Luis", "Director", "5th", "MiddleSchool");

    }
}
