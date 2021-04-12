package com.ks.base.service;

import com.ks.base.dao.UserDao;
import com.ks.base.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public void getUser() {
        userDao.getUser();
    }
}
