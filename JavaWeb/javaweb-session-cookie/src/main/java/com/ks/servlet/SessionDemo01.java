package com.ks.servlet;

import com.ks.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到session
        HttpSession session = req.getSession();

        //  获取id, 是浏览器访问时候,cookie中的JSESSIONID
        String id = session.getId();
        // 给Session中存东西
        session.setAttribute("name","qinjiang");


        //session 存实体类
        Person user = new Person("qingjiang", 3);
        session.setAttribute("user",user);

        // 判断是不是新建的
        if(session.isNew()){
            resp.getWriter().write("session创建" + id);
        }else{
            resp.getWriter().write("已经在存在" + id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
