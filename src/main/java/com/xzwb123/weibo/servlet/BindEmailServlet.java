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
        name = "BindEmailServlet",
        urlPatterns = {"/bindEmail"}
)
public class BindEmailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession hs = req.getSession();
        User user = (User) hs.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/weibo/loginPage");
            return;
        }
        PrintWriter out = resp.getWriter();
        String judge = (String) req.getAttribute("judge");
        out.println("<a href='http://localhost:8080/weibo/homePage'>返回主页</a><hr>");
        if ("have".equals(judge)) {
            out.println("该邮箱已经被绑定了");
        }
        out.println("<form action = 'bind' method = 'post'>");
        out.println("请输入您要绑定的邮箱: <input type='email' name = 'email'>");
        out.println("<input type='submit' value='提交'>");
        out.println("</form>");
    }
}
