package az.kontakt.shop.dao;

import az.kontakt.shop.model.Customer;
import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer c) throws Exception;

    List<Customer> getCustomerList() throws Exception;

    List<Customer> searchCustomerData(String keyword) throws Exception;

    void deleteCustomer(Long customerId) throws Exception;

    Customer getCustomerByID(Long selectedId) throws Exception;

    void updateCustomer(Customer c) throws Exception;
}