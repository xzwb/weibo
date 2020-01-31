package com.xzwb123.weibo.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "RegisterPage",
        urlPatterns = {"/registerPage"}
)
public class RegisterPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<h1>欢迎来还没想好名字微博注册</h1><br><h3>请完善以下信息</h3><br><hr>");
        if (req.getAttribute("register") != null) {
            out.println("<h1>请输入正确的手机号</h1><br>");
        }
        out.println("<img src='1.jpg' width=200px>");
        out.println("<form action='register' method='post'>");
        out.println("用户名: <input type='text' name='uname' required><br>");
        out.println("密  码: <input type='password' name='pwd' required><br>");
        out.println("邮  箱: <input type='email' name='email' required><br>");
        out.println("电  话: <input type='text' name='phoneNumber' required><br>");
        out.println("<input type='submit' value='提交'>");
        out.println("</form>");
    }
}
