package com.xzwb123.weibo.listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器用来看有多少人在线
 */
@WebListener
public class OnlineNumber implements HttpSessionListener, ServletContextListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        int i = (int)sc.getAttribute("online");
        i++;
        sc.setAttribute("online", i);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        int i = (int)sc.getAttribute("online");
        i--;
        sc.setAttribute("online", i);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("online", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
