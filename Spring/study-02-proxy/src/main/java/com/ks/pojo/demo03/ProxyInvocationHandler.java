package com.ks.pojo.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    /*
    * 核心：一个动态代理 , 一般代理某一类业务； 一个动态代理可以代理多个类；代理的是接口！
    * */

    // 被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    } // 参数是Host实例，Host实例Rent接口

    /*
    * 参数：
    * loader: 定义代理类的类加载器
    * interfaces: 代理类实现的接口列表rent
    * */

    public Object getProxy(){
        // 生成代理类，重点是第二个参数，获取要代理的抽象角色！之前都是一个角色，现在可以代理一类角色
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }


    // proxy : 代理类 method : 代理类的调用处理程序的方法对象.
    // 处理代理实例上的方法调用并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        //核心：本质利用反射实现！
        Object result = method.invoke(rent, args); // 相当于代理实例调用rent()
        return result;
    }

    // 其他方法
    public void seeHouse(){
        System.out.println("see house...");
    }
}
