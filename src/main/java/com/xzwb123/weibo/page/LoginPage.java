package com.xzwb123.weibo.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "LoginPage",
        urlPatterns = {"/loginPage"}
)
public class LoginPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("utf-8");
        // resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String judge = (String)req.getAttribute("judge");
        if ("no".equals(judge)) {
            out.println("<h1>用户名或密码错误</h1>");
        }
        out.println("<img src=\"1.jpg\" width=\"128px\" alt=\"微博图标\">");
        out.println("<form action=\"login\" method=\"post\">\n" +
                "    用户名：<input type=\"text\" name=\"uname\" placeholder=\"账号/电话/邮箱\"><br>\n" +
                "    密码：<input type=\"password\" name=\"pwd\" value=\"\"><br>\n" +
                "    <input type=\"submit\" value=\"登录\">\n" +"<input type=\"checkbox\" name=\"autoLogin\" value=\"yes\"> 三天免登陆" +
                "</form>");
        out.println("<a href=\"http://localhost:8080/weibo/registerPage\">还没有账号?注册</a>");
    }
}
