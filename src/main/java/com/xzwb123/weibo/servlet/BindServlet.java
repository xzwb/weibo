package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.dao.BindDao;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.BindService;
import com.xzwb123.weibo.service.impl.BindServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "BindServlet",
        urlPatterns = {"/bind"}
)
public class BindServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("utf-8");
        // resp.setContentType("text/html;charset=utf-8");
        String information = req.getParameter("email");
        String type = "email";
        if (information == null) {
            information = req.getParameter("phoneNumber");
            type = "phoneNumber";
        }
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/weibo/loginPage");
            return;
        }
        BindService bs = new BindServiceImpl();
        user = bs.bind(type, information, user.getUid()+"");
        if (user == null) {
            req.setAttribute("judge", "have");
            if ("email".equals(type)) {
                req.getRequestDispatcher("bindEmail").forward(req, resp);
            } else {
                req.getRequestDispatcher("bindPhoneNumber").forward(req, resp);
            }
        } else {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/weibo/homePage");
        }
    }
}
