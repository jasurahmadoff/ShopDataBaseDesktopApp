package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.*;
import java.sql.*;
import java.util.*;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> getProductList() throws Exception {

        List<Product> productList = new ArrayList<>();

        String sql = "SELECT \n"
                + "    P.ID AS PRODUCT_ID,\n"
                + "    S.ID AS SHOP_ID,\n"
                + "    S.NAME AS SHOP_NAME,\n"
                + "    ST.ID AS STOCK_ID,\n"
                + "    ST.NAME AS STOCK_NAME,\n"
                + "    ST.QUANTITY AS STOCK_QUANTITY,\n"
                + "    P.QUANTITY AS PRODUCT_QUANTITY\n"
                + "    FROM PRODUCT P \n"
                + "    INNER JOIN SHOP S ON P.SHOP_ID = S.ID\n"
                + "    INNER JOIN STOCK ST ON P.STOCK_ID = ST.ID\n"
                + "   WHERE P.ACTIVE = 1\n"
                + "ORDER BY P.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Stock stock = new Stock();
                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));
                stock.setQuantity(rs.getInt("STOCK_QUANTITY"));

                Product product = new Product();
                product.setId(rs.getLong("PRODUCT_ID"));
                product.setShop(shop);
                product.setStock(stock);
                product.setQuantity(rs.getInt("PRODUCT_QUANTITY"));

                productList.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchProductData(String keyword) throws Exception {
        List<Product> productList = new ArrayList<>();

        String sql = "SELECT \n"
                + "    P.ID AS PRODUCT_ID,\n"
                + "    S.ID AS SHOP_ID,\n"
                + "    S.NAME AS SHOP_NAME,\n"
                + "    ST.ID AS STOCK_ID,\n"
                + "    ST.NAME AS STOCK_NAME,\n"
                + "    P.QUANTITY AS PRODUCT_QUANTITY\n"
                + "    FROM PRODUCT P \n"
                + "    INNER JOIN SHOP S ON P.SHOP_ID = S.ID\n"
                + "    INNER JOIN STOCK ST ON P.STOCK_ID = ST.ID\n"
                + "   WHERE P.ACTIVE = 1\n"
                + "         AND (   LOWER (S.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (ST.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (P.QUANTITY) LIKE LOWER (?))\n"
                + "ORDER BY P.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("SHOP_ID"));
                shop.setName(rs.getString("SHOP_NAME"));

                Stock stock = new Stock();
                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));

                Product product = new Product();
                product.setId(rs.getLong("PRODUCT_ID"));
                product.setShop(shop);
                product.setStock(stock);
                product.setQuantity(rs.getInt("PRODUCT_QUANTITY"));

                productList.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void deleteProduct(Long productId) throws Exception {
        String sql = "UPDATE PRODUCT SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, productId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addProduct(Product product) throws Exception {

        String sql = "INSERT INTO PRODUCT "
                + "VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 1)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, product.getShop().getId());
            ps.setLong(2, product.getStock().getId());
            ps.setDouble(3, product.getQuantity());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Integer findTotalCountOfSelectedProductInProductTable(Stock stock) throws Exception {

        String sql = "SELECT "
                + "SUM(QUANTITY) AS TOTAL_COUNT\n"
                + "FROM PRODUCT \n"
                + "WHERE STOCK_ID = ? AND\n"
                + "ACTIVE = 1";

        Integer totalCount = null;

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, stock.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                totalCount = rs.getInt("TOTAL_COUNT");
            }

        }
        return totalCount;
    }

    @Override
    public Product getProductByID(Long selectedId) throws Exception {

        String sql = " SELECT P.ID           AS PRODUCT_ID,\n"
                + "         S.ID           AS SHOP_ID,\n"
                + "         S.NAME         AS SHOP_NAME,\n"
                + "         ST.ID          AS STOCK_ID,\n"
                + "         ST.NAME        AS STOCK_NAME,\n"
                + "         ST.QUANTITY    AS STOCK_QUANTITY,\n"
                + "         P.QUANTITY     AS PRODUCT_QUANTITY\n"
                + "    FROM PRODUCT P\n"
                + "         INNER JOIN SHOP S ON P.SHOP_ID = S.ID\n"
                + "         INNER JOIN STOCK ST ON P.STOCK_ID = ST.ID\n"
                + "   WHERE P.ACTIVE = 1 AND P.ID = ?";

        Product product = new Product();

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
                stock.setQuantity(rs.getInt("STOCK_QUANTITY"));

                product.setId(rs.getLong("PRODUCT_ID"));
                product.setShop(shop);
                product.setStock(stock);
                product.setQuantity(rs.getInt("PRODUCT_QUANTITY"));
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) throws Exception {

        String sql = "UPDATE PRODUCT SET SHOP_ID = ?, STOCK_ID = ?, QUANTITY = ? "
                + "WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, product.getShop().getId());
            ps.setLong(2, product.getStock().getId());
            ps.setInt(3, product.getQuantity());
            ps.setLong(4, product.getId());
            ps.execute();
            c.commit();
        }
    }
}
