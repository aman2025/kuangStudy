package com.ks.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/t1")
    public String test(){
        System.out.println("TestController.test");
        return "ok";
    }
}
