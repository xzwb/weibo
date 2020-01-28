package com.xzwb123.weibo.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录界面
 */
@WebServlet(
        name = "LoginPage",
        urlPatterns = {"/loginPage"}
)
public class LoginPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<img src='1.jpg' width=200px>");
        out.println("<form action='login' method='post'>");
        out.println("账号: <input type='text' name='name' placeholder='账号/邮箱/手机号' required><br><br>");
        out.println("密码: <input type='password' name='pwd' required>");
        out.println("<input type='submit' value='登录'>  <input type='checkbox' name='autoLogin' value='yes'> 三天内自动登录登陆");
        out.println("</form><br>");
        out.println("<a href='http://localhost:8080/weibo/registerPage'>还没有账号?注册</a>");
        out.print("<hr>");
    }
}
