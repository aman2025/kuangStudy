package com.nacostest.consumer.controller;

import com.nacostest.consumer.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private ProviderFeign providerFeign;

    // 本地浏览器请求 /consumer, 然后调用
    @GetMapping("consumer")
    public String send(){
        String send = providerFeign.send();
        return "consumer get=> " + send; // 输出 providerName, 从 provider微服务那边获取
    }
}
