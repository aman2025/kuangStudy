package com.ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigApplication.class, args);
        System.out.println(":1");
    }

}
