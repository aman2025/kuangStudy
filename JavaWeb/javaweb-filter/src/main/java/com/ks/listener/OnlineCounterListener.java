package com.ks.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCounterListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext cxt = se.getSession().getServletContext();
        Integer onlineCounter = (Integer) cxt.getAttribute("onlineCounter");
        if(onlineCounter==null){
            onlineCounter = new Integer(1);
        }else {
            int count = onlineCounter.intValue();
            onlineCounter = new Integer(count + 1);
        }
        cxt.setAttribute("onlineCounter", onlineCounter);
        System.out.println(se.getSession().getId());

    }
    // 销毁
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().invalidate();
        ServletContext cxt = se.getSession().getServletContext();
        Integer onlineCounter = (Integer) cxt.getAttribute("onlineCounter");
        if(onlineCounter==null){
            onlineCounter = new Integer(0);
        }else {
            int count = onlineCounter.intValue();
            onlineCounter = new Integer(count - 1);
        }
        cxt.setAttribute("onlineCounter", onlineCounter);
        System.out.println("销毁");
    }
}
