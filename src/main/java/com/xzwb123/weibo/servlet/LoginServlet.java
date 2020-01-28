package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.LoginService;
import com.xzwb123.weibo.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("utf-8");
        // resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        LoginService ls = new LoginServiceImpl();
        User user = ls.checkLogin(name, pwd);
        if (user == null) {
            req.setAttribute("judge", "no");
            req.getRequestDispatcher("loginPage").forward(req, resp);
            return;
        } else {
            if ("yes".equals(req.getParameter("autoLogin"))) {
                Cookie cookie = new Cookie("uid", user.getUid()+"");
                cookie.setMaxAge(3*24*3600);
                resp.addCookie(cookie);
            }
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/weibo/homePage");
        }
    }
}
