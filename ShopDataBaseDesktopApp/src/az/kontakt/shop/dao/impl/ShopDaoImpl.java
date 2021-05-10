package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.*;
import java.sql.*;
import java.util.*;

public class ShopDaoImpl implements ShopDao {

    @Override
    public List<Shop> getShopList() throws Exception {

        List<Shop> shopList = new ArrayList<>();

        String sql = "SELECT ID, NAME, CITY, ADDRESS, PHONE FROM SHOP "
                + "WHERE ACTIVE = 1 ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("ID"));
                shop.setName(rs.getString("NAME"));
                shop.setCity(rs.getString("CITY"));
                shop.setAddress(rs.getString("ADDRESS"));
                shop.setPhone(rs.getString("PHONE"));
                shopList.add(shop);
            }
        }
        return shopList;
    }

    @Override
    public List<Shop> searchShopData(String keyword) throws Exception {

        List<Shop> shopList = new ArrayList<>();

        String sql = "SELECT ID, NAME, CITY, ADDRESS, PHONE FROM SHOP\n"
                + "WHERE ACTIVE = 1 "
                + "         AND (   LOWER (NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (CITY) LIKE LOWER (?)\n"
                + "              OR LOWER (ADDRESS) LIKE LOWER (?)\n"
                + "              OR LOWER (PHONE) LIKE LOWER (?) )\n"
                + "ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Shop shop = new Shop();
                shop.setId(rs.getLong("ID"));
                shop.setName(rs.getString("NAME"));
                shop.setCity(rs.getString("CITY"));
                shop.setAddress(rs.getString("ADDRESS"));
                shop.setPhone(rs.getString("PHONE"));

                shopList.add(shop);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return shopList;
    }

    @Override
    public void deleteShop(Long shopId) throws Exception {
        String sql = "UPDATE SHOP SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, shopId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addShop(Shop shop) throws Exception {

        String sql = "insert into shop(ID, NAME, CITY, ADDRESS, PHONE) "
                + "values(SHOP_SEQ.NEXTVAL, ?, ?, ?, ?)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, shop.getName());
            ps.setString(2, shop.getCity());
            ps.setString(3, shop.getAddress());
            ps.setString(4, shop.getPhone());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Product> getProductListByShopId(Shop referanceShop) throws Exception {

        String sql = "SELECT P.ID           AS PRODUCT_ID, "
                + "       P.SHOP_ID      AS PRODUCT_SHOP_ID,\n"
                + "       P.STOCK_ID     AS PRODUCT_STOCK_ID,\n"
                + "       P.QUANTITY     AS PRODUCT_QUANTITY,\n"
                + "       SH.ID          AS SHOP_ID,\n"
                + "       SH.NAME        AS SHOP_NAME,\n"
                + "       ST.ID          AS STOCK_ID,\n"
                + "       ST.NAME        AS STOCK_NAME\n"
                + "  FROM PRODUCT P "
                + "       INNER JOIN SHOP SH ON (P.SHOP_ID = SH.ID)\n"
                + "       INNER JOIN STOCK ST ON (P.STOCK_ID = ST.ID)\n"
                + " WHERE P.SHOP_ID = ? AND P.ACTIVE = 1";

        List<Product> productList = new ArrayList<>();

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setLong(1, referanceShop.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Shop localShop = new Shop();
                localShop.setId(rs.getLong("SHOP_ID"));
                localShop.setName(rs.getString("SHOP_NAME"));

                Stock localStock = new Stock();
                localStock.setId(rs.getLong("STOCK_ID"));
                localStock.setName(rs.getString("STOCK_NAME"));

                Product product = new Product();
                product.setId(rs.getLong("PRODUCT_ID"));
                product.setShop(localShop);
                product.setStock(localStock);
                product.setQuantity(rs.getInt("PRODUCT_QUANTITY"));

                productList.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public Shop getShopById(Long selectedId) throws Exception {

        String sql = "SELECT ID, NAME, CITY, ADDRESS, PHONE "
                + "FROM SHOP "
                + "WHERE ID = ?";

        Shop shop = new Shop();

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, selectedId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                shop.setId(rs.getLong("ID"));
                shop.setName(rs.getString("NAME"));
                shop.setCity(rs.getString("CITY"));
                shop.setAddress(rs.getString("ADDRESS"));
                shop.setPhone(rs.getString("PHONE"));
                shop.setId(rs.getLong("ID"));
            }
        }
        return shop;
    }

    @Override
    public void updateShop(Shop shop) throws Exception {

        String sql = "UPDATE SHOP SET NAME = ?, CITY = ?, ADDRESS = ?, PHONE = ? "
                + " WHERE ID =?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, shop.getName());
            ps.setString(2, shop.getCity());
            ps.setString(3, shop.getAddress());
            ps.setString(4, shop.getPhone());
            ps.setLong(5, shop.getId());
            ps.execute();
            c.commit();
        }
    }
}
