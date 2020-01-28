package com.xzwb123.weibo.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "RegisterSuccessPage",
        urlPatterns = {"/registerSuccess"}
)
public class RegisterSuccessPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("utf-8");
        // resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String uid = (String)req.getAttribute("uid");
        out.println("<h1>注册成功!您的账号为<b>" + uid +"</b></h1><hr>");
        out.println("<a href='http://localhost:8080/weibo/loginPage'>返回登录界面</a>");
    }
}
