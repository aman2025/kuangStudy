package com.ks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        System.out.println("dd");
        // 封装数据
        model.addAttribute("msg", "hello,annotations2");
        return "hello";  // 视图名称hello
    }
}
