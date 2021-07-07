package com.nacostest.consumer.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
// 初始化 RestTemplate, 再spring ioc中装配bean
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced // 内置ribbon负载均衡
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
