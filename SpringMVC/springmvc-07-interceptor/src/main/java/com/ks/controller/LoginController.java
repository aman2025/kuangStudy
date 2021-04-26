package com.ks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    // main
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    // goLogin
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    // login
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户的信息存在session中
        session.setAttribute("userLoginInfo", username);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "main";
    }

    // goOut
    @RequestMapping("/goOut")
    public String goOut(HttpSession session1){
        // remove session
        session1.removeAttribute("userLoginInfo");
        return "login";
    }
}
