import java.sql.*;

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

    }
    public static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "Cjdtncrfz159753";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        return DriverManager.getConnection(url, user, password);
    }
}
