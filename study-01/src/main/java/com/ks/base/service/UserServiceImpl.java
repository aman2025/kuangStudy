package com.ks.base.service;

import com.ks.base.dao.UserDao;

public class UserServiceImpl implements UserService {


    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
