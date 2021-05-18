package com.ks.servlet;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.DocumentationTool;
import java.io.IOException;
import java.util.Locale;

public class RedirectServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/ps");
//        resp.setHeader("Location","/ps");
        resp.setStatus(302);
    }
}
