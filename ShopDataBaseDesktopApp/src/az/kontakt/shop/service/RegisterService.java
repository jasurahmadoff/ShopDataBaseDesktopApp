package az.kontakt.shop.service;

import az.kontakt.shop.model.Register;
import az.kontakt.shop.model.Role;
import java.util.List;

public interface RegisterService {

    void addRegister(Register register) throws Exception;

    List<Role> getRoleList() throws Exception;
}