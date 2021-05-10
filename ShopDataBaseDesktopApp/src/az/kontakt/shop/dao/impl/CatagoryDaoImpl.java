package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.Catagory;
import java.sql.*;
import java.util.*;

public class CatagoryDaoImpl implements CatagoryDao {

    @Override
    public List<Catagory> getCatagoryList() throws Exception {

        List<Catagory> catagoryList = new ArrayList<>();

        String sql = "SELECT ID, NAME\n"
                + "    FROM catagory\n"
                + "   WHERE active = 1\n"
                + "ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Catagory catagory = new Catagory();
                catagory.setId(rs.getLong("ID"));
                catagory.setName(rs.getString("NAME"));

                catagoryList.add(catagory);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return catagoryList;
    }
}
