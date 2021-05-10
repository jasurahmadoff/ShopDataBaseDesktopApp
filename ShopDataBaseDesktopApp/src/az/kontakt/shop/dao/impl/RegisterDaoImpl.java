package az.kontakt.shop.dao.impl;

import az.kontakt.shop.dao.DBHelper;
import az.kontakt.shop.dao.RegisterDao;
import az.kontakt.shop.model.Register;
import az.kontakt.shop.model.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegisterDaoImpl implements RegisterDao {

    @Override
    public void addRegister(Register register) throws Exception {

        String sql = "INSERT INTO LOGIN_USER "
                + "VALUES(LOGIN_USER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE, 1)";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, register.getUsername());
            ps.setString(2, register.getPassword());
            ps.setString(3, register.getName());
            ps.setString(4, register.getSurname());
            ps.setLong(5, register.getRole().getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Role> getRoleList() throws Exception {

        String sql = "SELECT \n"
                + "ID, \n"
                + "ROLE_NAME, \n"
                + "DESCRIPTION \n"
                + "FROM ROLE \n"
                + "WHERE ACTIVE = 1 \n"
                + "ORDER BY ID";

        List<Role> roleList = new ArrayList<>();

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Role role = new Role();
                role.setId(rs.getLong("ID"));
                role.setRoleName(rs.getString("ROLE_NAME"));
                role.setDescription(rs.getString("DESCRIPTION"));

                roleList.add(role);
            }
        }

        return roleList;
    }
}
