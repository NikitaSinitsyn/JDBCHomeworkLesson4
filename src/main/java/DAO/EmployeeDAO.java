package DAO;

import Application.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    public void addEmployee(Employee employee);

    public Optional<Employee> getEmployeeById(int id);

    public List<Employee> getAllEmployees();

    public void updateEmployee(Employee employee, int id);

    public void deleteEmployee(Employee employee);
}
