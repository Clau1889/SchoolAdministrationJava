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
    //Recibe el id del empleado y el nuevo puesto a asignar, validar si cambia de maestro a otro tipo q desasignemos
    // el grupo y si es a director q no tengamos uno ya existente en la lista de empleados, también validar
    // q el puesto q estamos recibiendo sea un string valido, así como el q id del empleado exista en la lista.
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
                       if(addNewCareer=="ADMINISTRATOR"){
                           getListEmployees().get(index).setCareer(addNewCareer);
                           System.out.println("Career changed to Administrator");

                       }else if(addNewCareer=="DIRECTOR"){
                           for(Employees emp: getListEmployees()){

                               if(emp.getCareer()=="DIRECTOR"){
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

               }else if((getListEmployees().get(index).getId().equals(employee.getId()) && (employee.getCareer().equals("DIRECTOR"))) ){
                   System.out.println("This is A DIRECTOR.");

               }


           } else {
               System.out.println("ID not exists.");

           }
       }



    }


    //asignarGrupo -> Recibe el id del empleado y el grupo a asignar, validar q sea maestro para poder asignar,
    // así como el q id del empleado exista en la lista.


    //desasignarGrupo -> Recibe el id del empleado, validar q sea maestro para poder desasignar,
    // así como el q id del empleado exista en la lista.


    //bajaEmpleado -> Recibe el id del empleado, validar q si es maestro no tenga grupo asignado,
    // así como el q id del empleado exista en la lista.

    //reporteEmpleados -> imprimir todos los empleados y sus datos correspondientes
    public void printAllEmployees (){
       for (Employees emp: listEmployees){
           System.out.println("----------     EMPLOYEE     ----------------");
           System.out.println("ID: " + emp.getId() + "\n"
                              + "          Name: " +  emp.getName() + "\n"
                              + "          Career: " +  emp.getCareer() + "\n"
                              + "          Group: " +  emp.getGroup() + "\n");
       }
    }

    //reporteEmpleadosPuesto -> imprimir todos los empleados de un puesto dado y sus datos correspondientes

    //reporteMaestrosNivel -> imprimir todos los maestros de cierto nivel dado datos correspondientes

    public static void main(String[] args){
        EmployeesFile dataEmployee = new EmployeesFile();

        //Create 8 employees
        dataEmployee.addEmployee(10001, "Roberto", "Teacher", "3rd", "KindergARTEN");
        dataEmployee.addEmployee(10002, "Matías", "teacher", "1st", "MIDDLESCHOOL");
        dataEmployee.addEmployee(10003, "Cassandra", "Teacher", "4th", "mIDDLESCHOOL");
        dataEmployee.addEmployee(10004, "Ramiro", "ADmiNistrator", "1st", "HighSchool");
        dataEmployee.addEmployee(10005, "Marcela", "Teacher", "2nd", "Highschool");
        dataEmployee.addEmployee(10006, "Jesús", "TEACHER", "3d", "kiNDERGARten");
        dataEmployee.addEmployee(10007, "Francisco", "TEACHER", "2nd", "Kindergarten");
        dataEmployee.addEmployee(10008, "Jóse Luis", "Teacher", "2nd", "HighSchool");
        //dataEmployee.addEmployee(10001, "Luis", "Director", "5th", "MiddleSchool");
        //dataEmployee.addEmployee(101, "Luis", "Director", "6th", "MiddlesCHOOL");

       dataEmployee.changeCareer(10001, "DIRECTOR");

       dataEmployee.printAllEmployees();

    }
}
