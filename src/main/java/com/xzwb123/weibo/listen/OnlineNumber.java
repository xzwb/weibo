package com.xzwb123.weibo.listen;

import com.xzwb123.weibo.info.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.HashSet;

/**
 * 监听器用来看有多少人在线
 */
@WebListener
public class OnlineNumber implements HttpSessionListener, ServletContextListener, HttpSessionAttributeListener {
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
        User user = (User) se.getSession().getAttribute("user");
        HashSet<User> userHashSet = (HashSet<User>) sc.getAttribute("users");
        userHashSet.remove(user);
        sc.setAttribute("users", userHashSet);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("online", 0);
        HashSet<User> userHashSet = new HashSet<>();
        sc.setAttribute("users", userHashSet);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        HashSet<User> userHashSet = (HashSet<User>) sc.getAttribute("users");
        User user = (User) se.getSession().getAttribute("user");
        userHashSet.add(user);
        sc.setAttribute("users", userHashSet);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
