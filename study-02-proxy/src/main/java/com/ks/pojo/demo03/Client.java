package com.ks.pojo.demo03;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler(); // 动态代理类
        pih.setRent(host); // 将真实角色放置进去！Rent接口的实现类，也可以是Rent接口的其他实现类；
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }
}
