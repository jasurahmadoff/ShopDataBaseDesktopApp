package az.kontakt.shop.dao;

import az.kontakt.shop.model.Register;
import az.kontakt.shop.model.Role;
import java.util.List;

public interface RegisterDao {

    void addRegister(Register register) throws Exception;

    List<Role> getRoleList() throws Exception;
}