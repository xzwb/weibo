package com.xzwb123.weibo.page;

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
        name = "HomePage",
        urlPatterns = {"/homePage.do"}
)
public class HomePage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs =  req.getSession();
        User user = (User) hs.getAttribute("user");
        PrintWriter out = resp.getWriter();
        out.println("<h1>欢迎访问" + user.getUname() + "的主页</h1><hr>");
        out.println("<a href='http://localhost:8080/weibo/logout'>注销</a><br>");
    }
}
