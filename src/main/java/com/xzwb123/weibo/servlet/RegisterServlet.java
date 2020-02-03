package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.RegisterService;
import com.xzwb123.weibo.service.impl.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "RegisterServlet",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        RegisterService rs = new RegisterServiceImpl();
        User user = rs.judgeRegisterService(name, email, pwd, phoneNumber);
        if (user == null) {
            req.setAttribute("register", "no");
            req.getRequestDispatcher("registerPage").forward(req, resp);
        } else {
            req.setAttribute("uid", user.getUid()+"");
            req.getRequestDispatcher("registerSuccess").forward(req, resp);
        }
    }
}
