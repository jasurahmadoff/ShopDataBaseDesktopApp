package az.kontakt.shop.service.impl;

import az.kontakt.shop.dao.LoginUserDao;
import az.kontakt.shop.model.LoginUser;
import az.kontakt.shop.service.LoginUserService;

public class LoginUserServiceImpl implements LoginUserService {

    public LoginUserDao loginUserDao;

    public LoginUserServiceImpl(LoginUserDao loginUserDao) {
        this.loginUserDao = loginUserDao;
    }

    @Override
    public LoginUser login(String username, String password) throws Exception {
        return loginUserDao.login(username, password);
    }
}