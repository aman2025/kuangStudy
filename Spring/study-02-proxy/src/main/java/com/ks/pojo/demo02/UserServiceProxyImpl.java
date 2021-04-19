package com.ks.pojo.demo02;

//代理角色，在这里面增加日志的实现， 相当于二次封装： 不改变原来的业务情况下
public class UserServiceProxyImpl implements UserService {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        userService.add();
        log("add..");
    }

    public void delete() {
        userService.delete();
        log("delete..");
    }

    public void update() {
        userService.update();
        log("update..");
    }

    public void query() {
        userService.query();
        log("query..");
    }
    public void log(String msg){
        System.out.println("message is: " + msg);
    }
}
