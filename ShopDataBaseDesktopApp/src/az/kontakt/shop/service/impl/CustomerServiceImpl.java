package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.CustomerDao;
import az.kontakt.shop.model.Customer;
import az.kontakt.shop.service.CustomerService;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = null;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getCustomerList() throws Exception {
        return customerDao.getCustomerList();
    }

    @Override
    public List<Customer> searchCustomerData(String keyword) throws Exception {
        return customerDao.searchCustomerData(keyword);
    }

    @Override
    public void deleteCustomer(Long customerId) throws Exception {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public void addCustomer(Customer c) throws Exception {
        customerDao.addCustomer(c);
    }

    @Override
    public Customer getCustomerByID(Long selectedId) throws Exception {
        return customerDao.getCustomerByID(selectedId);
    }

    @Override
    public void updateCustomer(Customer c) throws Exception {
        customerDao.updateCustomer(c);
    }
}