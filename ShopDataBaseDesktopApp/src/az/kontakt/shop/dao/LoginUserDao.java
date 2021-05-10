package az.kontakt.shop.dao;

import az.kontakt.shop.model.LoginUser;

public interface LoginUserDao {

    LoginUser login(String username, String password) throws Exception;
}