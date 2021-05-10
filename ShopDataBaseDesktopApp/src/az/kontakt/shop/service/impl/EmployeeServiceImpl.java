package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.EmployeeDao;
import az.kontakt.shop.model.Employee;
import az.kontakt.shop.service.EmployeeService;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = null;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeDao.getEmployeeList();
    }

    @Override
    public List<Employee> searchEmployeeData(String keyword) throws Exception {
        return employeeDao.searchEmployeeData(keyword);
    }

    @Override
    public void deleteEmployee(Long employeeId) throws Exception {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeByID(Long selectedId) throws Exception {
        return employeeDao.getEmployeeByID(selectedId);
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        employeeDao.updateEmployee(employee);
    }
}