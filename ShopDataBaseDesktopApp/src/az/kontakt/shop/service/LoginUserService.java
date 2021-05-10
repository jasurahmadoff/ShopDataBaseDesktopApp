package az.kontakt.shop.service;

import az.kontakt.shop.model.LoginUser;

public interface LoginUserService {

    LoginUser login(String username, String password) throws Exception;
}