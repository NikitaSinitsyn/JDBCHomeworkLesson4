package Application;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImplementation;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        String query = "SELECT employee.first_name, employee.last_name, employee.gender, city.city_name FROM employee JOIN city ON employee.city_id = city.city_id WHERE employee.id = 1;";

        try(Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            String employeeFirstName = resultSet.getString("first_name");
            String employeeLastName = resultSet.getString("last_name");
            String employeeGender = resultSet.getString("gender");
            String cityName = resultSet.getString("city_name");
            System.out.println("Имя " + employeeFirstName + ", Фамилия " + employeeLastName + ", Пол " + employeeGender + ", город " + cityName);

        }

        EmployeeDAO employeeDAO = new EmployeeDAOImplementation();

        employeeDAO.createEmployee();

        Employee employee = employeeDAO.getEmployeeById(5).get();
        System.out.println(employee);

        List<Employee> employeeList = employeeDAO.getAllEmployees();

        for (Employee employee1 : employeeList) {
            System.out.println("Employee ID: " + employee1.getId());
            System.out.println("First name: " + employee1.getFirst_name());
            System.out.println("Last name: " + employee1.getLast_name());
            System.out.println("Gender: " + employee1.getGender());
            System.out.println("Age: " + employee1.getAge());
            System.out.println("City id: " + employee1.getCity_id());
        }

        employeeDAO.updateEmployee(5);
        System.out.println(employee);

        employeeDAO.deleteEmployeeById(7);


    }

    public static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "Cjdtncrfz159753";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        return DriverManager.getConnection(url, user, password);
    }
}
