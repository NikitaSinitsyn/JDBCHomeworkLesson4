package DAO;

import Application.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    public void createEmployee();

    public Optional<Employee> getEmployeeById(int id);

    public List<Employee> getAllEmployees();

    public void updateEmployee(int id);

    public void deleteEmployeeById(int id);
}
