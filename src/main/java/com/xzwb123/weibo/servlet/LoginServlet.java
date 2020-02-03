package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.JudgeLoginService;
import com.xzwb123.weibo.service.impl.JudgeLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 处理登录流程
 */
@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String auto = req.getParameter("autoLogin");
        JudgeLoginService js = new JudgeLoginServiceImpl();
        User user = js.judgeLoginService(uname, pwd);
        if (user == null) {
            req.setAttribute("judge", "no");
            req.getRequestDispatcher("loginPage").forward(req, resp);
        } else {
            HttpSession hs = req.getSession();
            hs.setAttribute("user", user);
            if ("yes".equals(auto)) {
                Cookie c = new Cookie("uid", user.getUid() + "");
                c.setMaxAge(3*24*3600);
                resp.addCookie(c);
            } else {
                Cookie c = new Cookie("uid", user.getUid() + "");
                resp.addCookie(c);
            }
            resp.sendRedirect("/weibo/homePage.do");
        }
    }
}
