package com.xzwb123.weibo.page;

import com.xzwb123.weibo.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet(
        name = "OnlineUserPage",
        urlPatterns = {"/onlineUser.do"}
)
public class OnlineUserPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashSet<User> userHashSet = (HashSet<User>) req.getSession().getServletContext().getAttribute("users");
        PrintWriter out = resp.getWriter();
        out.println("<a href='http://localhost:8080/weibo/homePage.do'> <-返回 </a><br><hr><h4>当前在线用户</h4><br>");
        for (User user : userHashSet) {
            out.println("昵称: " + user.getUname());
            out.println("账号: " + user.getUid());
            out.println("<br><hr>");
        }
    }
}
