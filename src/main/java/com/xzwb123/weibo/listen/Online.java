package com.xzwb123.weibo.listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Online implements HttpSessionListener, ServletContextListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sc =  se.getSession().getServletContext();
        int i = (int)sc.getAttribute("onlineCount") + 1;
        sc.setAttribute("onlineCount", i);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        int i = (int)sc.getAttribute("onlineCount") - 1;
        sc.setAttribute("onlineCount", i);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("onlineCount", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
