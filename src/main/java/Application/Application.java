package Application;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImplementation;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImplementation();

        Employee newEmployee = new Employee(13,"Bianka", "Trifonova", "female", 32, 1);
        Employee testEmployee = new Employee("Anna", "Zahorodnuk", "female", 30, 1);
        System.out.println(testEmployee);

        //employeeDAO.addEmployee(testEmployee);

        Employee employee = employeeDAO.getEmployeeById(13).get();
        System.out.println(employee);
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        for (Employee employee1 : employeeList) {
            //System.out.println("Employee ID: " + employee1.getId());
            //System.out.println("First name: " + employee1.getFirst_name());
            //System.out.println("Last name: " + employee1.getLast_name());
            //System.out.println("Gender: " + employee1.getGender());
            //System.out.println("Age: " + employee1.getAge());
            //System.out.println("City id: " + employee1.getCity_id());

        }
        System.out.println(testEmployee);
        employeeDAO.updateEmployee(testEmployee, 14);
        System.out.println(testEmployee);
        employeeDAO.deleteEmployee(newEmployee);


    }
}
