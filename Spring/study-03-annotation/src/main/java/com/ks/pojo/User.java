package com.ks.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    // 属性注入
    @Value("ks1")
    // 相当于配置文件中 <property name="name" value="秦疆"/>
    private String name;
    public void say(){
        System.out.println("use annotation" + name);
    }
}
