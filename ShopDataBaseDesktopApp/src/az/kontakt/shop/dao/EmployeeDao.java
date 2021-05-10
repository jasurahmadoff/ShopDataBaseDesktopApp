package az.kontakt.shop.dao;

import az.kontakt.shop.model.Employee;
import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeeList() throws Exception;

    List<Employee> searchEmployeeData(String keyword) throws Exception;

    void deleteEmployee(Long employeeId) throws Exception;

    void addEmployee(Employee employee) throws Exception;

    Employee getEmployeeByID(Long selectedId) throws Exception;

    void updateEmployee(Employee employee) throws Exception;
}
