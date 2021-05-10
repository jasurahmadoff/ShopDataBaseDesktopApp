package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.*;
import java.sql.*;
import java.util.*;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getEmployeeList() throws Exception {

        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT\n "
                + "    E.ID AS EMPLOYEE_ID,\n"
                + "    E.NAME AS EMPLOYEE_NAME,\n"
                + "    E.SURNAME AS EMPLOYEE_SURNAME, \n"
                + "    S.ID AS SHOP_ID, \n"
                + "    S.NAME AS SHOP_NAME,\n"
                + "    J.ID AS JOB_ID,\n"
                + "    J.NAME AS JOB_NAME,\n"
                + "    E.SALARY AS EMPLOYEE_SALARY,\n"
                + "    E.LAST_UPDATE AS HIRE_DATE \n"
                + "FROM EMPLOYEE E\n"
                + "    INNER JOIN SHOP S ON E.SHOP_ID = S.ID\n"
                + "    INNER JOIN JOB J ON E.JOB_ID = J.ID\n"
                + "     WHERE E.ACTIVE = 1\n"
                + "ORDER BY E.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Job job = new Job();
                job.setId(rs.getLong("JOB_ID"));
                job.setName(rs.getString("JOB_NAME"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("EMPLOYEE_ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                employee.setSalary(rs.getDouble("EMPLOYEE_SALARY"));
                employee.setShop(shop);
                employee.setJob(job);
                employee.setHireDate(rs.getDate("HIRE_DATE"));

                employeeList.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public List<Employee> searchEmployeeData(String keyword) throws Exception {

        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT\n "
                + "    E.ID AS EMPLOYEE_ID,\n"
                + "    E.NAME AS EMPLOYEE_NAME,\n"
                + "    E.SURNAME AS EMPLOYEE_SURNAME, \n"
                + "    S.ID AS SHOP_ID, \n"
                + "    S.NAME AS SHOP_NAME,\n"
                + "    J.ID AS JOB_ID,\n"
                + "    J.NAME AS JOB_NAME,\n"
                + "    E.SALARY AS EMPLOYEE_SALARY,\n"
                + "    E.LAST_UPDATE AS HIRE_DATE \n"
                + "FROM EMPLOYEE E\n"
                + "    INNER JOIN SHOP S ON E.SHOP_ID = S.ID\n"
                + "    INNER JOIN JOB J ON E.JOB_ID = J.ID\n"
                + "     WHERE E.ACTIVE = 1\n"
                + "         AND (   LOWER (E.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (E.SURNAME) LIKE LOWER (?)\n"
                + "              OR LOWER (S.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (J.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (E.SALARY) LIKE LOWER (?)) \n"
                + "ORDER BY E.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Job job = new Job();
                job.setId(rs.getLong("JOB_ID"));
                job.setName(rs.getString("JOB_NAME"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("EMPLOYEE_ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                employee.setSalary(rs.getDouble("EMPLOYEE_SALARY"));
                employee.setShop(shop);
                employee.setJob(job);
                employee.setHireDate(rs.getDate("HIRE_DATE"));
                employeeList.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void deleteEmployee(Long employeeId) throws Exception {

        String sql = "UPDATE EMPLOYEE SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, employeeId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addEmployee(Employee e) throws Exception {

        String sql = "INSERT INTO EMPLOYEE "
                + "VALUES(EMPLOYEE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, 1, ?)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getSurname());
            ps.setLong(3, e.getShop().getId());
            ps.setLong(4, e.getJob().getId());
            if (e.getHireDate() != null) {
                ps.setDate(5, new java.sql.Date(e.getHireDate().getTime()));
            }
            ps.setDouble(6, e.getSalary());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Employee getEmployeeByID(Long employeeId) throws Exception {

        Employee employee = new Employee();

        String sql = "SELECT E.ID AS EMPLOYEE_ID,\n"
                + "       E.NAME AS EMPLOYEE_NAME,\n"
                + "       E.SURNAME AS EMPLOYEE_SURNAME,\n"
                + "       S.ID AS SHOP_ID,\n"
                + "       S.NAME AS SHOP_NAME,\n"
                + "       J.ID AS JOB_ID, \n"
                + "       J.NAME AS JOB_NAME,\n"
                + "       E.SALARY AS EMPLOYEE_SALARY,\n"
                + "       E.LAST_UPDATE AS HIRE_DATE\n"
                + "  FROM EMPLOYEE E\n"
                + "  INNER JOIN SHOP S ON (E.SHOP_ID = S.ID)\n"
                + "  INNER JOIN JOB J ON (E.JOB_ID = J.ID)\n"
                + " WHERE E.ACTIVE = 1 AND E.ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setLong(1, employeeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Job job = new Job();
                job.setId(rs.getLong("JOB_ID"));
                job.setName(rs.getString("JOB_NAME"));

                employee.setId(rs.getLong("EMPLOYEE_ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                employee.setSalary(rs.getDouble("EMPLOYEE_SALARY"));
                employee.setShop(shop);
                employee.setJob(job);
                employee.setHireDate(rs.getDate("HIRE_DATE"));
            }
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {

        String sql = "UPDATE EMPLOYEE SET NAME = ?, SURNAME = ?, SHOP_ID = ?, JOB_ID = ?, SALARY = ?, LAST_UPDATE = ? "
                + "WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setLong(3, employee.getShop().getId());
            ps.setLong(4, employee.getJob().getId());
            ps.setDouble(5, employee.getSalary());
            if (employee.getHireDate() != null) {
                ps.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
            }
            ps.setLong(7, employee.getId());
            ps.execute();
            c.commit();
        }
    }
}
