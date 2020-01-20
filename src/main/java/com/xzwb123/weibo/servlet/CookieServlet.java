package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.LoginService;
import com.xzwb123.weibo.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 微博项目的第一个界面查看有没有三天免登陆,如果有直接跳转主页面并且添加session
 */
@WebServlet(
        name = "CookieServlet",
        urlPatterns = {"/cookie"}
)
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        Cookie[] cookies = req.getCookies();
        LoginService ls = new LoginServiceImpl();
        User user = null;
        String name = "";
        String value = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                name = c.getName();
                value = c.getValue();
                if ("uid".equals(name)) {
                    user = ls.checkCookie(value);
                    if (user != null) {
                        req.getSession().setAttribute("user", user);
                        resp.sendRedirect("/weibo/homePage");
                        return;
                    }
                }
            }
        }
        resp.sendRedirect("/weibo/loginPage");
    }
}
