package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.RegisterDao;
import az.kontakt.shop.model.Register;
import az.kontakt.shop.model.Role;
import az.kontakt.shop.service.RegisterService;
import java.util.List;

public class RegisterServiceImpl implements RegisterService {

    private RegisterDao registerDao = null;

    public RegisterServiceImpl(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    @Override
    public void addRegister(Register register) throws Exception {
        registerDao.addRegister(register);
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        return registerDao.getRoleList();
    }
}