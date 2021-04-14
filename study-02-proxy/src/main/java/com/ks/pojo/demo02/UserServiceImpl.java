package com.ks.pojo.demo02;

// 真实对象，完成增删改查操作的人
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("tick add...");
    }
    public void delete() {
        System.out.println("tick delete...");
    }
    public void update() {
        System.out.println("tick update...");
    }
    public void query() {
        System.out.println("tick query...");
    }
}
