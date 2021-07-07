package com.alibaba.nacos.console.controller;

import com.alibaba.nacos.api.common.Constants;
import com.alibaba.nacos.common.utils.JacksonUtils;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping({"/v1/auth", "/v1/auth/users"})
public class UserController {
    // 点击登录post请求
    @GetMapping("/login")
    public Object login(@RequestParam String username, @RequestParam String password, HttpServletResponse response,
                        HttpServletRequest request)  {
        ObjectNode result = JacksonUtils.createEmptyJsonNode();
        result.put(Constants.ACCESS_TOKEN, "token");
        result.put(Constants.TOKEN_TTL, "tokenttl");
        result.put(Constants.GLOBAL_ADMIN, "1");
        return result; // 结果返回给前端
    }
}
