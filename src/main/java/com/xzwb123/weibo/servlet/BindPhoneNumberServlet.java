package com.xzwb123.weibo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "BindPhoneNumberServlet",
        urlPatterns = {"/bindPhoneNumber"}
)
public class BindPhoneNumberServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String judge = (String) req.getAttribute("judge");
        out.println("<a href='http://localhost:8080/weibo/homePage'>返回主页</a><hr>");
        if ("have".equals(judge)) {
            out.println("该手机号已经被绑定了");
        }
        out.println("<form action = 'bind' method = 'post'>");
        out.println("请输入您要绑定的手机号: <input type='text' name = 'phoneNumber'>");
        out.println("<input type='submit' value='提交'>");
        out.println("</form>");
    }
}
