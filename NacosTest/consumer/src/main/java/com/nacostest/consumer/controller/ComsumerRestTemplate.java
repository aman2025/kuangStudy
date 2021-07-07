package com.nacostest.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComsumerRestTemplate {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("rest")
    public String getRest(){
        // 用ip访问provider服务，不管provider有没有注册到nacos，都可以访问
       final String forObject = restTemplate.getForObject("http://127.0.0.1:8001/send", String.class);
       return forObject;
    }
}
