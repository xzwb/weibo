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
        PrintWriter out = resp.getWriter();
        String uid = (String) req.getAttribute("uid");
        out.println("<h1>您在还没想好名字微博的账号是: " + uid +  "</h1><br><hr>");
        out.println("<a href='http://localhost:8080/weibo/loginPage'>返回登录界面</a>");
    }
}
