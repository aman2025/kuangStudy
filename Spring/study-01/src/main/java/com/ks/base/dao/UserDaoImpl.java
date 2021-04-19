package com.ks.base.dao;

public class UserDaoImpl implements UserDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getUser() {
        System.out.println("get user info2..." + name);
    }
}
