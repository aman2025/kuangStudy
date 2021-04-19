package com.ks.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class User {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    @Value("ks5")
    private String name;

    public Cat getCat() {
        return cat;
    }
    public Dog getDog() {
        return dog;
    }
    public String getName() {
        return name;
    }
}
