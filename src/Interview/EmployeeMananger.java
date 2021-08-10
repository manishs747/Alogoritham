package Interview;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMananger {
    private static Map<String,Employee> employeeMap = new HashMap<>();


    public  static void addEmployee(Employee employee){
        employeeMap.put(employee.getName(),employee);
    }

    public  static Employee getEmployeeByName(String name){
        return employeeMap.get(name);
    }


    public  static void enrichEmployee(){
        employeeMap.put("Sam" ,new Employee("Sam",EmpType.GENERAL));
        employeeMap.put("Tom" ,new Employee("Tom",EmpType.GENERAL));
        employeeMap.put("Harry" ,new Employee("Harry",EmpType.SUPERVISOR));
    }
}
