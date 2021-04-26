package com.ks.controller;

import com.ks.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    // 前端请求 localhost:8080/user/t1?name=xxx
    @RequestMapping("/t1")
    public String test1(String name, Model model){
        // 参数和前端的参数一致情况
        model.addAttribute("msg", name);
        return "hello";
    }

    // 前端请求 localhost:8080/user/t1?username=xxx
    @RequestMapping("/t2")
    public String test2(@RequestParam("username") String name, Model model){
        // 参数和前端的参数不一致情况,用@RequestParam("username")
        model.addAttribute("msg", name);
        return "hello";
    }

    // 前端请求参数是一个i对象  localhost:8080/user/t3?id=1&name=xxx&age=3
    @RequestMapping("/t3")
    public String test3(User user, Model model){
        System.out.println(user);  // 相当用前端参数构造一个实例 User user = new User(1, "xxx", 3);
        model.addAttribute("msg", user);
        return "hello";
    }
}
