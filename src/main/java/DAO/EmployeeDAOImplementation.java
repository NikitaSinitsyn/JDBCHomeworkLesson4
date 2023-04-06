package DAO;

import Application.Employee;
import Application.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class EmployeeDAOImplementation implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {

        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();

        }
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {


        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession())  {
            return Optional.ofNullable(session.get(Employee.class, id));


        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("from Employee ").list();

        }
    }

    @Override
    public void updateEmployee(Employee employee, int id) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employee.setId(id);
            session.update(employee);
            transaction.commit();

        }

    }

    @Override
    public void deleteEmployee(Employee employee){

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){

            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();

        }
    }

}
