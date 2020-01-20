package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.info.User;
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
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String information = req.getParameter("email");
        String type = "email";
        if (information == null) {
            information = req.getParameter("phoneNumber");
            type = "phoneNumber";
        }
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        RegisterService rs = new RegisterServiceImpl();
        User user = rs.judgeRegisterInformation(type, information, name, pwd);
        if (user == null) {
            if ("".equals(information) || "".equals(name) || "".equals(pwd)) {
                req.setAttribute("judge", "no");
            } else {
                req.setAttribute("judge", "have");
            }
            if ("email".equals(type)) {
                req.getRequestDispatcher("registerPage").forward(req, resp);
            } else {
                req.getRequestDispatcher("phoneNumberRegister").forward(req, resp);
            }
        } else {
            req.setAttribute("uid", user.getUid()+"");
            req.getRequestDispatcher("registerSuccess").forward(req, resp);
        }
    }
}
