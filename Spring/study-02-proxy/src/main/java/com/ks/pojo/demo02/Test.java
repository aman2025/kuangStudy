package com.ks.pojo.demo02;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);
        UserService proxy = (UserService) pih.getProxy();
        proxy.delete();
    }
}
