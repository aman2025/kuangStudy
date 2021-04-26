package com.ks.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //session
        HttpSession session = request.getSession();

        // 需放行的页面
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }
        if(request.getRequestURI().contains("login")){
            return true;
        }
        if(session.getAttribute("userLoginInfo") != null){  // 即访问main页面才拦截, 有session就放行
            return true;
        }

        //拦截后跳转到login
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        return false;
    }

}
