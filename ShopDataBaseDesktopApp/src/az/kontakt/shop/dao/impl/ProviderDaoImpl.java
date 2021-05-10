package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.*;
import az.kontakt.shop.model.Provider;
import java.sql.*;
import java.util.*;

public class ProviderDaoImpl implements ProviderDao {

    @Override
    public List<Provider> getProviderList() throws Exception {

        List<Provider> providerList = new ArrayList<>();

        String sql = "SELECT ID, NAME, CITY, COUNTRY, PHONE FROM PROVIDER "
                + "WHERE ACTIVE = 1 ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {

                Provider provider = new Provider();
                provider.setId(rs.getLong("ID"));
                provider.setName(rs.getString("NAME"));
                provider.setCity(rs.getString("CITY"));
                provider.setCountry(rs.getString("COUNTRY"));
                provider.setPhone(rs.getString("PHONE"));

                providerList.add(provider);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return providerList;
    }

    @Override
    public List<Provider> searchProviderData(String keyword) throws Exception {
        List<Provider> providerList = new ArrayList<>();

        String sql = "SELECT ID, NAME, CITY, COUNTRY, PHONE FROM PROVIDER "
                + "WHERE ACTIVE = 1 "
                + "         AND (   LOWER (NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (CITY) LIKE LOWER (?)\n"
                + "              OR LOWER (COUNTRY) LIKE LOWER (?)\n"
                + "              OR LOWER (PHONE) LIKE LOWER (?) )\n"
                + "ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Provider provider = new Provider();
                provider.setId(rs.getLong("ID"));
                provider.setName(rs.getString("NAME"));
                provider.setCity(rs.getString("CITY"));
                provider.setCountry(rs.getString("COUNTRY"));
                provider.setPhone(rs.getString("PHONE"));

                providerList.add(provider);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return providerList;
    }

    @Override
    public void deleteProvider(Long providerId) throws Exception {

        String sql = "UPDATE PROVIDER SET ACTIVE = 0 WHERE ID = ?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, providerId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void addProvider(Provider provider) throws Exception {

        String sql = "insert into provider(ID, NAME, CITY, COUNTRY, PHONE) "
                + "values(PROVIDER_SEQ.NEXTVAL, ?, ?, ?, ?)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, provider.getName());
            ps.setString(2, provider.getCity());
            ps.setString(3, provider.getCountry());
            ps.setString(4, provider.getPhone());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Provider getProviderByID(Long selectedId) throws Exception {

        String sql = "SELECT ID, NAME, CITY, COUNTRY, PHONE "
                + "FROM PROVIDER "
                + "WHERE ID = ?";

        Provider provider = new Provider();

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, selectedId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                provider.setId(rs.getLong("ID"));
                provider.setName(rs.getString("NAME"));
                provider.setCity(rs.getString("CITY"));
                provider.setCountry(rs.getString("COUNTRY"));
                provider.setPhone(rs.getString("PHONE"));
                provider.setId(rs.getLong("ID"));
            }
        }
        return provider;
    }

    @Override
    public void updateProvider(Provider provider) throws Exception {

        String sql = "UPDATE PROVIDER SET NAME = ?, CITY = ?, COUNTRY = ?, PHONE = ? "
                + " WHERE ID =?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, provider.getName());
            ps.setString(2, provider.getCity());
            ps.setString(3, provider.getCountry());
            ps.setString(4, provider.getPhone());
            ps.setLong(5, provider.getId());
            ps.execute();
            c.commit();
        }
    }
}
