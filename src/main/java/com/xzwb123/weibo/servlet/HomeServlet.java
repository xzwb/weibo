package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.info.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "HomeServlet",
        urlPatterns = {"/homePage"}
)
public class HomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        HttpSession hs = req.getSession();
        User user = (User)hs.getAttribute("user");
        out.println("<h1>欢迎来到" + user.getName() + "的主页</h1><br>");
        out.println("<a href='http://localhost:8080/weibo/logout'>注销</a><hr>");
        if ("".equals(user.getEmail())) {
            out.println("<a href = 'http://local:8080/weibo/bindEmail'>绑定邮箱</a><hr>");
        } else if ("".equals(user.getPhotoNumber())) {
            out.println("<a href = 'http://local:8080/weibo/bindPhoneNumber'>绑定手机</a><hr>");
        }
    }
}
