package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.Customer;
import java.sql.*;
import java.util.*;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> getCustomerList() throws Exception {

        List<Customer> customerList = new ArrayList<>();
        Connection c = null; // baza ile elaqe yaradir
        PreparedStatement ps = null; // sql'i run etmek ucun hazirlayir
        ResultSet rs = null; // sql'den qayidan neticeni ozunde saxlayir
        String sql = "SELECT ID, \n"
                + "         NAME, \n"
                + "         SURNAME, \n"
                + "         ADDRESS, \n"
                + "         PHONE, \n"
                + "         POSTAL_CODE \n"
                + "    FROM CUSTOMER\n"
                + "   WHERE ACTIVE = 1\n"
                + "ORDER BY ID";

        try {

            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery(sql);

                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getLong("ID"));
                    customer.setName(rs.getString("NAME"));
                    customer.setSurname(rs.getString("SURNAME"));
                    customer.setAddress(rs.getString("ADDRESS"));
                    customer.setPhone(rs.getString("PHONE"));
                    customer.setPostalCode(rs.getString("POSTAL_CODE"));
                    customerList.add(customer);
                }

            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (c != null) {
                c.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> searchCustomerData(String keyword) throws Exception {

        List<Customer> customerList = new ArrayList<>();

        String sql = "SELECT ID, \n"
                + "         NAME, \n"
                + "         SURNAME, \n"
                + "         ADDRESS, \n"
                + "         PHONE, \n"
                + "         POSTAL_CODE \n"
                + "    FROM CUSTOMER\n"
                + "   WHERE ACTIVE = 1\n"
                + "         AND (   LOWER (NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (SURNAME) LIKE LOWER (?)\n"
                + "              OR LOWER (ADDRESS) LIKE LOWER (?)\n"
                + "              OR LOWER (PHONE) LIKE LOWER (?)\n"
                + "              OR LOWER (POSTAL_CODE) LIKE LOWER (?))\n"
                + "ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();
                customer.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setPostalCode(rs.getString("POSTAL_CODE"));
                customerList.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void deleteCustomer(Long customerId) throws Exception {

        String sql = "UPDATE CUSTOMER SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, customerId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {

        String sql = "insert into customer(ID, NAME, SURNAME, ADDRESS, PHONE, POSTAL_CODE) "
                + "VALUES(CUSTOMER_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getPostalCode());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Customer getCustomerByID(Long selectedId) throws Exception {

        String sql = "SELECT ID, NAME, SURNAME, ADDRESS, PHONE, POSTAL_CODE "
                + "FROM CUSTOMER "
                + "WHERE ID = ?";

        Customer customer = new Customer();

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, selectedId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customer.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setPostalCode(rs.getString("POSTAL_CODE"));
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {

        String sql = "UPDATE CUSTOMER SET NAME = ?, SURNAME = ?, ADDRESS = ?, PHONE = ?, POSTAL_CODE = ? "
                + " WHERE ID =?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getPostalCode());
            ps.setLong(6, customer.getId());
            ps.execute();
            c.commit();
        }
    }
}