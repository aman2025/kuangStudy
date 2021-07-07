package com.nacostest.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 相当于服务的url，这里直接取服务名字,
@FeignClient("provider")
public interface ProviderFeign {
    @GetMapping("send")
    String send();
}
