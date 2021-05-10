package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.*;
import java.sql.*;
import java.util.*;

public class SaleDaoImpl implements SaleDao {

    @Override
    public List<Sale> getSaleList() throws Exception {

        List<Sale> saleList = new ArrayList<>();

        String sql = " SELECT SA.ID             AS SALE_ID,\n"
                + "         SH.ID             AS SHOP_ID,\n"
                + "         SH.NAME           AS SHOP_NAME,\n"
                + "         P.ID              AS PRODUCT_ID,\n"
                + "         ST.ID             AS STOCK_ID,\n"
                + "         ST.NAME           AS STOCK_NAME,\n"
                + "         ST.UNIT_PRICE     AS STOCK_UNIT_PRICE,\n"
                + "         C.ID              AS CUSTOMER_ID,\n"
                + "         C.NAME            AS CUSTOMER_NAME,\n"
                + "         C.SURNAME            AS CUSTOMER_SURNAME,\n"
                + "         E.ID              AS EMPLOYEE_ID,\n"
                + "         E.NAME            AS EMPLOYEE_NAME,\n"
                + "         E.SURNAME            AS EMPLOYEE_SURNAME,\n"
                + "         SA.QUANTITY       AS SALE_QUANTITY,\n"
                + "         SA.DISCOUNT       AS SALE_DISCOUNT,\n"
                + "         SA.AMOUNT         AS SALE_AMOUNT,\n"
                + "         SA.CHEQUE_NO      AS SALE_CHEQUE,\n"
                + "         SA.SALE_DATE      AS SALE_DATE "
                + "    FROM SALE SA "
                + "         INNER JOIN SHOP SH ON (SA.SHOP_ID = SH.ID)\n"
                + "         INNER JOIN PRODUCT P ON (SA.PRODUCT_ID = P.ID)\n"
                + "         INNER JOIN CUSTOMER C ON (SA.CUSTOMER_ID = C.ID)\n"
                + "         INNER JOIN EMPLOYEE E ON (SA.EMPLOYEE_ID = E.ID)\n"
                + "         INNER JOIN STOCK ST ON (P.STOCK_ID = ST.ID)\n"
                + "   WHERE SA.ACTIVE = 1\n"
                + " ORDER BY SA.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Stock stock = new Stock();
                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));
                stock.setUnitPrice(rs.getDouble("STOCK_UNIT_PRICE"));

                Product product = new Product();
                product.setId(rs.getLong("PRODUCT_ID"));
                product.setStock(stock);

                Customer customer = new Customer();
                customer.setId(rs.getLong("CUSTOMER_ID"));
                customer.setName(rs.getString("CUSTOMER_NAME"));
                customer.setSurname(rs.getString("CUSTOMER_SURNAME"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("EMPLOYEE_ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));

                Sale sale = new Sale();
                sale.setId(rs.getLong("SALE_ID"));
                sale.setShop(shop);
                sale.setProduct(product);
                sale.setCustomer(customer);
                sale.setEmployee(employee);
                sale.setQuantity(rs.getInt("SALE_QUANTITY"));
                sale.setDiscount(rs.getDouble("SALE_DISCOUNT"));
                sale.setAmount(rs.getDouble("SALE_AMOUNT"));
                sale.setChequeNumber(rs.getLong("SALE_CHEQUE"));
                sale.setSaleDate(rs.getDate("SALE_DATE"));

                saleList.add(sale);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return saleList;
    }

    @Override
    public List<Sale> searchSaleData(String keyword) throws Exception {

        List<Sale> saleList = new ArrayList<>();

        String sql = " SELECT SA.ID             AS SALE_ID,\n"
                + "         SH.ID             AS SHOP_ID,\n"
                + "         SH.NAME           AS SHOP_NAME,\n"
                + "         P.ID              AS PRODUCT_ID,\n"
                + "         ST.ID             AS STOCK_ID,\n"
                + "         ST.NAME           AS STOCK_NAME,\n"
                + "         ST.UNIT_PRICE     AS STOCK_UNIT_PRICE,\n"
                + "         C.ID              AS CUSTOMER_ID,\n"
                + "         C.NAME            AS CUSTOMER_NAME,\n"
                + "         C.SURNAME            AS CUSTOMER_SURNAME,\n"
                + "         E.ID              AS EMPLOYEE_ID,\n"
                + "         E.NAME            AS EMPLOYEE_NAME,\n"
                + "         E.SURNAME            AS EMPLOYEE_SURNAME,\n"
                + "         SA.QUANTITY       AS SALE_QUANTITY,\n"
                + "         SA.DISCOUNT       AS SALE_DISCOUNT,\n"
                + "         SA.AMOUNT         AS SALE_AMOUNT,\n"
                + "         SA.CHEQUE_NO      AS SALE_CHEQUE,\n"
                + "         SA.SALE_DATE      AS SALE_DATE "
                + "    FROM SALE SA "
                + "         INNER JOIN SHOP SH ON (SA.SHOP_ID = SH.ID)\n"
                + "         INNER JOIN PRODUCT P ON (SA.PRODUCT_ID = P.ID)\n"
                + "         INNER JOIN CUSTOMER C ON (SA.CUSTOMER_ID = C.ID)\n"
                + "         INNER JOIN EMPLOYEE E ON (SA.EMPLOYEE_ID = E.ID)\n"
                + "         INNER JOIN STOCK ST ON (P.STOCK_ID = ST.ID)\n"
                + "   WHERE SA.ACTIVE = 1 "
                + "         AND (   LOWER (SH.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (ST.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (C.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (C.SURNAME) LIKE LOWER (?)\n"
                + "              OR LOWER (E.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (E.SURNAME) LIKE LOWER (?)\n"
                + "              OR LOWER (ST.UNIT_PRICE) LIKE LOWER (?)\n"
                + "              OR LOWER (SA.QUANTITY) LIKE LOWER (?)\n"
                + "              OR LOWER (SA.DISCOUNT) LIKE LOWER (?)\n"
                + "              OR LOWER (SA.AMOUNT) LIKE LOWER (?) \n"
                + "              OR LOWER (SA.CHEQUE_NO) LIKE LOWER (?) ) "
                + " ORDER BY SA.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");
            ps.setString(6, "%" + keyword + "%");
            ps.setString(7, "%" + keyword + "%");
            ps.setString(8, "%" + keyword + "%");
            ps.setString(9, "%" + keyword + "%");
            ps.setString(10, "%" + keyword + "%");
            ps.setString(11, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Stock stock = new Stock();
                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));
                stock.setUnitPrice(rs.getDouble("STOCK_UNIT_PRICE"));

                Product product = new Product();
                product.setId(rs.getLong("PRODUCT_ID"));
                product.setStock(stock);

                Customer customer = new Customer();
                customer.setId(rs.getLong("CUSTOMER_ID"));
                customer.setName(rs.getString("CUSTOMER_NAME"));
                customer.setSurname(rs.getString("CUSTOMER_SURNAME"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("EMPLOYEE_ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));

                Sale sale = new Sale();
                sale.setId(rs.getLong("SALE_ID"));
                sale.setShop(shop);
                sale.setProduct(product);
                sale.setCustomer(customer);
                sale.setEmployee(employee);
                sale.setQuantity(rs.getInt("SALE_QUANTITY"));
                sale.setDiscount(rs.getDouble("SALE_DISCOUNT"));
                sale.setAmount(rs.getDouble("SALE_AMOUNT"));
                sale.setChequeNumber(rs.getLong("SALE_CHEQUE"));
                sale.setSaleDate(rs.getDate("SALE_DATE"));

                saleList.add(sale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saleList;
    }

    @Override
    public void deleteSale(Long saleId) throws Exception {
        String sql = "UPDATE SALE SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, saleId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addSale(Sale sale) throws Exception {

        String sql = "INSERT INTO SALE "
                + "VALUES(SALE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, 1)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, sale.getShop().getId());
            ps.setLong(2, sale.getProduct().getId());
            ps.setLong(3, sale.getCustomer().getId());
            ps.setLong(4, sale.getEmployee().getId());
            ps.setInt(5, sale.getQuantity());
            ps.setDouble(6, sale.getDiscount());
            ps.setDouble(7, sale.getProperAmount());
            ps.setLong(8, sale.getProperChequeNumber());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Long findMaxChequeNumSale() throws Exception {

        Long maxChequeNo = null;

        String sql = "SELECT MAX(CHEQUE_NO) AS MAX_CHEQUE_NO FROM SALE";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                maxChequeNo = rs.getLong("MAX_CHEQUE_NO");
            }
        }

        return maxChequeNo;
    }

    @Override
    public Double findUnitPriceById(Long productID) throws Exception {

        String sql = "SELECT S.UNIT_PRICE AS UNIT_PRICE\n"
                + "  FROM PRODUCT P \n"
                + "  INNER JOIN STOCK S ON (P.STOCK_ID = S.ID)\n"
                + " WHERE P.ID = ? AND P.ACTIVE = 1";

        Double properUnitPrice = null;

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, productID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                properUnitPrice = rs.getDouble("UNIT_PRICE");
            }
        }
        return properUnitPrice;
    }

    @Override
    public Sale getSaleById(Long selectedId) throws Exception {

        Sale sale = new Sale();

        String sql = " SELECT SA.ID           AS SALE_ID,\n"
                + "         SH.ID             AS SHOP_ID,\n"
                + "         SH.NAME           AS SHOP_NAME,\n"
                + "         P.ID              AS PRODUCT_ID,\n"
                + "         ST.ID             AS STOCK_ID,\n"
                + "         ST.NAME           AS STOCK_NAME,\n"
                + "         ST.UNIT_PRICE     AS STOCK_UNIT_PRICE,\n"
                + "         C.ID              AS CUSTOMER_ID,\n"
                + "         C.NAME            AS CUSTOMER_NAME,\n"
                + "         C.SURNAME            AS CUSTOMER_SURNAME,\n"
                + "         E.ID              AS EMPLOYEE_ID,\n"
                + "         E.NAME            AS EMPLOYEE_NAME,\n"
                + "         E.SURNAME            AS EMPLOYEE_SURNAME,\n"
                + "         SA.QUANTITY       AS SALE_QUANTITY,\n"
                + "         SA.DISCOUNT       AS SALE_DISCOUNT,\n"
                + "         SA.AMOUNT         AS SALE_AMOUNT,\n"
                + "         SA.CHEQUE_NO      AS SALE_CHEQUE,\n"
                + "         SA.SALE_DATE      AS SALE_DATE "
                + "    FROM SALE SA "
                + "         INNER JOIN SHOP SH ON (SA.SHOP_ID = SH.ID)\n"
                + "         INNER JOIN PRODUCT P ON (SA.PRODUCT_ID = P.ID)\n"
                + "         INNER JOIN CUSTOMER C ON (SA.CUSTOMER_ID = C.ID)\n"
                + "         INNER JOIN EMPLOYEE E ON (SA.EMPLOYEE_ID = E.ID)\n"
                + "         INNER JOIN STOCK ST ON (P.STOCK_ID = ST.ID) "
                + "   WHERE SA.ACTIVE = 1 AND SA.ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setLong(1, selectedId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Stock stock = new Stock();
                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));
                stock.setUnitPrice(rs.getDouble("STOCK_UNIT_PRICE"));

                Product product = new Product();
                product.setId(rs.getLong("PRODUCT_ID"));
                product.setStock(stock);

                Customer customer = new Customer();
                customer.setId(rs.getLong("CUSTOMER_ID"));
                customer.setName(rs.getString("CUSTOMER_NAME"));
                customer.setSurname(rs.getString("CUSTOMER_SURNAME"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("EMPLOYEE_ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));

                sale.setId(rs.getLong("SALE_ID"));
                sale.setShop(shop);
                sale.setProduct(product);
                sale.setCustomer(customer);
                sale.setEmployee(employee);
                sale.setQuantity(rs.getInt("SALE_QUANTITY"));
                sale.setDiscount(rs.getDouble("SALE_DISCOUNT"));
                sale.setAmount(rs.getDouble("SALE_AMOUNT"));
                sale.setChequeNumber(rs.getLong("SALE_CHEQUE"));
                sale.setSaleDate(rs.getDate("SALE_DATE"));
            }
        }
        return sale;
    }

    @Override
    public void updateSale(Sale sale) throws Exception {

        String sql = "UPDATE SALE SET SHOP_ID = ?, PRODUCT_ID = ?, CUSTOMER_ID = ?, "
                + "EMPLOYEE_ID = ?, QUANTITY = ?, DISCOUNT = ?, AMOUNT = ? "
                + "WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, sale.getShop().getId());
            ps.setLong(2, sale.getProduct().getId());
            ps.setLong(3, sale.getCustomer().getId());
            ps.setLong(4, sale.getEmployee().getId());
            ps.setInt(5, sale.getQuantity());
            ps.setDouble(6, sale.getDiscount());
            ps.setDouble(7, sale.getProperAmount());
            ps.setLong(8, sale.getId());
            ps.execute();
            c.commit();
        }
    }
}