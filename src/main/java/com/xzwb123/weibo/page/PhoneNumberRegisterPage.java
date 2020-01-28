package com.xzwb123.weibo.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "PhoneNumberRegisterPage",
        urlPatterns = "/phoneNumberRegister"
)
public class PhoneNumberRegisterPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("utf-8");
        // resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String judge = (String) req.getAttribute("judge");
        if ("no".equals(judge)) {
            out.println("<h1>个人信息不完整请重新填写</h1><hr>");
        } else if ("have".equals(judge)) {
            out.println("<h1>该手机号已经注册过微博了</h1>");
        }
        out.println("<h2>请完整填写以下信息<h2><hr>");
        out.println("<form action='register' method='post'><br>");
        out.println("手机号: <input type = 'tel' name = 'phoneNumber'><br>");
        out.println("用户名: <input type = 'text' name = 'uname'><br>");
        out.println("密码: <input type = 'password' name = 'pwd'><br>");
        out.println("<input type='submit' value = '注册'>");
        out.println("</form>");
        out.println("<a href=\"http://localhost:8080/weibo/registerPage\">换一种注册方式!</a>");
    }

}
