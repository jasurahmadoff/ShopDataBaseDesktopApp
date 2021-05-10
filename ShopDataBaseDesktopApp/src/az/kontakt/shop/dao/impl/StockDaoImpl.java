package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.*;
import java.sql.*;
import java.util.*;

public class StockDaoImpl implements StockDao {

    @Override
    public List<Stock> getStockList() throws Exception {

        List<Stock> stockList = new ArrayList<>();

        String sql = "SELECT S.ID              AS STOCK_ID, "
                + "         S.NAME            AS STOCK_NAME,\n"
                + "         S.QUANTITY        AS STOCK_QUANTITY,\n"
                + "         P.ID              AS PROVIDER_ID,\n"
                + "         P.NAME            AS PROVIDER_NAME,\n"
                + "         C.ID              AS CATAGORY_ID,\n"
                + "         C.NAME            AS CATAGORY_NAME,\n"
                + "         S.UNIT_PRICE      AS STOCK_UNIT_PRICE,\n"
                + "         S.DESCRIPTION     AS STOCK_DESCRIPTION,\n"
                + "         S.LAST_UPDATE     AS STOCK_UPDATE\n"
                + "    FROM STOCK S\n"
                + "         INNER JOIN PROVIDER P ON (S.PROVIDER_ID = P.ID)\n"
                + "         INNER JOIN CATAGORY C ON (S.CATAGORY_ID = C.ID)\n"
                + "   WHERE S.ACTIVE = 1\n"
                + "ORDER BY S.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Provider provider = new Provider();
                provider.setId(rs.getLong("PROVIDER_ID"));
                provider.setName(rs.getString("PROVIDER_NAME"));

                Catagory catagory = new Catagory();
                catagory.setId(rs.getLong("CATAGORY_ID"));
                catagory.setName(rs.getString("CATAGORY_NAME"));

                Stock stock = new Stock();
                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));
                stock.setQuantity(rs.getInt("STOCK_QUANTITY"));
                stock.setProvider(provider);
                stock.setCatagory(catagory);
                stock.setUnitPrice(rs.getDouble("STOCK_UNIT_PRICE"));
                stock.setDescription(rs.getString("STOCK_DESCRIPTION"));
                stock.setLastUpdate(rs.getDate("STOCK_UPDATE"));
                stockList.add(stock);
            }
        }
        return stockList;
    }

    @Override
    public List<Stock> searchStockData(String keyword) throws Exception {

        List<Stock> stockList = new ArrayList<>();

        String sql = "SELECT S.ID             AS STOCK_ID,\n "
                + "         S.NAME            AS STOCK_NAME,\n"
                + "         S.QUANTITY        AS STOCK_QUANTITY,\n"
                + "         P.ID              AS PROVIDER_ID,\n"
                + "         P.NAME            AS PROVIDER_NAME,\n"
                + "         C.ID              AS CATAGORY_ID,\n"
                + "         C.NAME            AS CATAGORY_NAME,\n"
                + "         S.UNIT_PRICE      AS STOCK_UNIT_PRICE,\n"
                + "         S.DESCRIPTION     AS STOCK_DESCRIPTION,\n"
                + "         S.LAST_UPDATE     AS STOCK_UPDATE\n"
                + "    FROM STOCK S\n"
                + "         INNER JOIN PROVIDER P ON (S.PROVIDER_ID = P.ID)\n"
                + "         INNER JOIN CATAGORY C ON (S.CATAGORY_ID = C.ID)\n"
                + "   WHERE S.ACTIVE = 1\n"
                + "         AND (   LOWER (S.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (P.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (S.QUANTITY) LIKE LOWER (?)\n"
                + "              OR LOWER (C.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (S.UNIT_PRICE) LIKE LOWER (?))\n"
                + " ORDER BY S.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Provider provider = new Provider();
                provider.setId(rs.getLong("PROVIDER_ID"));
                provider.setName(rs.getString("PROVIDER_NAME"));

                Catagory catagory = new Catagory();
                catagory.setId(rs.getLong("CATAGORY_ID"));
                catagory.setName(rs.getString("CATAGORY_NAME"));

                Stock stock = new Stock();
                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));
                stock.setQuantity(rs.getInt("STOCK_QUANTITY"));
                stock.setProvider(provider);
                stock.setCatagory(catagory);
                stock.setUnitPrice(rs.getDouble("STOCK_UNIT_PRICE"));
                stock.setDescription(rs.getString("STOCK_DESCRIPTION"));
                stock.setLastUpdate(rs.getDate("STOCK_UPDATE"));
                stockList.add(stock);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockList;
    }

    @Override
    public void deleteStock(Long stockId) throws Exception {
        String sql = "UPDATE STOCK SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, stockId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addStock(Stock stock) throws Exception {

        String sql = "INSERT INTO STOCK "
                + "VALUES(STOCK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE, 1)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, stock.getName());
            ps.setInt(2, stock.getQuantity());
            ps.setLong(3, stock.getProvider().getId());
            ps.setLong(4, stock.getCatagory().getId());
            ps.setDouble(5, stock.getUnitPrice());
            ps.setString(6, stock.getDescription());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Stock getStockById(Long selectedId) throws Exception {

        Stock stock = new Stock();

        String sql = "SELECT S.ID             AS STOCK_ID, "
                + "         S.NAME            AS STOCK_NAME,\n"
                + "         S.QUANTITY        AS STOCK_QUANTITY,\n"
                + "         P.ID              AS PROVIDER_ID,\n"
                + "         P.NAME            AS PROVIDER_NAME,\n"
                + "         C.ID              AS CATAGORY_ID,\n"
                + "         C.NAME            AS CATAGORY_NAME,\n"
                + "         S.UNIT_PRICE      AS STOCK_UNIT_PRICE,\n"
                + "         S.DESCRIPTION     AS STOCK_DESCRIPTION,\n"
                + "         S.LAST_UPDATE     AS STOCK_UPDATE\n"
                + "    FROM STOCK S\n"
                + "         INNER JOIN PROVIDER P ON (S.PROVIDER_ID = P.ID)\n"
                + "         INNER JOIN CATAGORY C ON (S.CATAGORY_ID = C.ID)\n"
                + "   WHERE S.ACTIVE = 1 AND S.ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setLong(1, selectedId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Provider provider = new Provider();
                provider.setId(rs.getLong("PROVIDER_ID"));
                provider.setName(rs.getString("PROVIDER_NAME"));

                Catagory catagory = new Catagory();
                catagory.setId(rs.getLong("CATAGORY_ID"));
                catagory.setName(rs.getString("CATAGORY_NAME"));

                stock.setId(rs.getLong("STOCK_ID"));
                stock.setName(rs.getString("STOCK_NAME"));
                stock.setProvider(provider);
                stock.setCatagory(catagory);
                stock.setQuantity(rs.getInt("STOCK_QUANTITY"));
                stock.setUnitPrice(rs.getDouble("STOCK_UNIT_PRICE"));
                stock.setDescription(rs.getString("STOCK_DESCRIPTION"));
                stock.setLastUpdate(rs.getDate("STOCK_UPDATE"));
            }
        }
        return stock;
    }

    @Override
    public void updateStock(Stock stock) throws Exception {

        String sql = "UPDATE STOCK SET NAME = ?, QUANTITY = ?, PROVIDER_ID = ?, CATAGORY_ID = ?, UNIT_PRICE = ?, DESCRIPTION = ? "
                + "WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, stock.getName());
            ps.setInt(2, stock.getQuantity());
            ps.setLong(3, stock.getProvider().getId());
            ps.setLong(4, stock.getCatagory().getId());
            ps.setDouble(5, stock.getUnitPrice());
            ps.setString(6, stock.getDescription());
            ps.setLong(7, stock.getId());
            ps.execute();
            c.commit();
        }
    }
}
