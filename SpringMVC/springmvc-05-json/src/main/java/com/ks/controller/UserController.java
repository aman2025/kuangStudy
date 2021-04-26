package com.ks.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    // 返回一个json对象字符串
    @RequestMapping("/j1")
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("1号", 3, "男");
        String str = mapper.writeValueAsString(user);
        return str;
    }

    // 返回一个list集合,字符串
    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();

        User user1 = new User("1号", 3, "男");
        User user2 = new User("2号", 3, "男");
        userList.add(user1);
        userList.add(user2);

        String str = mapper.writeValueAsString(userList);
        return str;
    }

    // 返回一个时间戳字符串
    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();

        String str = mapper.writeValueAsString(date);
        return str;
    }
}
