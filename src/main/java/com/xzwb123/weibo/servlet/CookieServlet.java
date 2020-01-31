package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.CookieService;
import com.xzwb123.weibo.service.impl.CookieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(
        name = "CookieServlet",
        urlPatterns = {"/cookie"}
)
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String name;
        String value;
        if (cookies != null) {
            for (Cookie c : cookies) {
                name = c.getName();
                value = c.getValue();
                if ("uid".equals(name)) {
                    CookieService cs = new CookieServiceImpl();
                    User user = cs.getCookieService(value);
                    if (user != null) {
                        HttpSession hs = req.getSession();
                        hs.setAttribute("user", user);
                        resp.sendRedirect("/weibo/homePage.do");
                        return;
                    }
                }
            }
        }
        resp.sendRedirect("/weibo/loginPage");
    }
}
