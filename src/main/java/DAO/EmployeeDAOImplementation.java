package DAO;

import Application.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImplementation implements EmployeeDAO {
    @Override
    public void createEmployee() {
        String query = "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ('Anastasia', 'Corneva', 'female', 30, 2)";
        try(Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        String query = "SELECT * FROM employee  WHERE id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            String first_name = resultSet.getString(2);
            String last_name = resultSet.getString(3);
            String gender = resultSet.getString(4);
            Integer age = resultSet.getInt(5);
            int city_id = resultSet.getInt(6);

            Employee Employee = new Employee(id, first_name, last_name, gender, age, city_id);
            return Optional.ofNullable(Employee);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");
                int city_id = resultSet.getInt("city_id");
                employeeList.add(new Employee(id, first_name, last_name, gender, age, city_id));


            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void updateEmployee(int id) {
        String query = "UPDATE employee SET first_name = 'Polina' WHERE id = ? ";
        try(Connection connection = getConnection()){

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public void deleteEmployeeById(int id) {
        String query = "DELETE FROM employee WHERE id = ?";
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "Cjdtncrfz159753";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        return DriverManager.getConnection(url, user, password);
    }
}
