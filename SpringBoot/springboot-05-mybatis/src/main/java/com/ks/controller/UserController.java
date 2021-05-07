package com.ks.controller;

import com.ks.mapper.UserMapper;
import com.ks.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/userList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user: userList){
            System.out.println(user);
        }
        return userList;

    }
}
