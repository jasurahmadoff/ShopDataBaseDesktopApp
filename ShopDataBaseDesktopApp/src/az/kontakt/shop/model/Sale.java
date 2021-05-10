package az.kontakt.shop.model;

import az.kontakt.shop.dao.impl.SaleDaoImpl;
import java.util.Date;

public class Sale extends CourseModel {

    private Shop shop;
    private Product product;
    private Customer customer;
    private Employee employee;
    private Integer quantity;
    private Double discount;
    private Double amount;
    private Long chequeNumber;
    private Date saleDate;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getChequeNumber() {

        return chequeNumber;
    }

    public Long getProperChequeNumber() {

        Long maxChequeNum = null;

        SaleDaoImpl sdi = new SaleDaoImpl();

        try {
            maxChequeNum = sdi.findMaxChequeNumSale();
            if (maxChequeNum == 0) {
                System.err.println("There was 0 element in sale");
                maxChequeNum = 100000L;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ++maxChequeNum;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public void setChequeNumber(Long chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    @Override
    public String toString() {
        return "Sale{" + "shop=" + shop + ", product=" + product + ", customer=" + customer + ", employee=" + employee + ", quantity=" + quantity + ", discount=" + discount + ", amount=" + amount + ", chequeNumber=" + chequeNumber + ", saleDate=" + saleDate + '}';
    }

    public double getProperAmount() {

        Long productID = this.getProduct().getId();

        Double properUnitPrice = null;

        SaleDaoImpl sdi = new SaleDaoImpl();

        try {
            properUnitPrice = sdi.findUnitPriceById(productID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Integer properQuantity = this.getQuantity();
        Double properDiscount = this.getDiscount();

        Double totalAmount = (properUnitPrice * properQuantity) - (((properUnitPrice * properQuantity) * properDiscount) / 100);

        return totalAmount;
    }
}
