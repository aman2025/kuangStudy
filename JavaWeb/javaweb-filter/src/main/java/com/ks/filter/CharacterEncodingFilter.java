package com.ks.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    // 初始化: web服务器启动就执行,随时等待过滤对象出现
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("过滤前");
        chain.doFilter(req, resp); // 放行,继续下一个filter,传req,resp
        System.out.println("过滤后");
    }
    // 销毁
    public void destroy() {
        System.out.println("销毁");
    }
}
