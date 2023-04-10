package Application;

import DAO.CityDAO;
import DAO.CityDAOImplementation;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImplementation;
import com.sun.source.tree.AssertTree;
import java.util.List;

public class Application {
    public static void main(String[] args)  {
        CityDAO cityDao = new CityDAOImplementation();
        EmployeeDAO employeeDAO = new EmployeeDAOImplementation();




        City newCity = City.builder().employeeList(List.of())
                .city_name("Санкт Петербург")
                .build();
        cityDao.addCity(newCity);


        Employee employee1 = Employee.builder()
                .first_name("Иво")
                .last_name("Кусев")
                .gender("male")
                .age(23)
                .city(newCity)
                .build();
        Employee employee2 = Employee.builder()
                .first_name("Симона")
                .last_name("Кацарска")
                .gender("female")
                .age(21)
                .city(newCity)
                .build();

        newCity.setEmployeeList(List.of(employee1, employee2));
        City updatedCity = cityDao.updateCity(newCity);






        /*employeeDAO.addEmployee(testEmployee);

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
        employeeDAO.deleteEmployee(newEmployee);*/




    }
}
