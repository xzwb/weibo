package com.xzwb123.weibo.page;

import com.xzwb123.weibo.info.UserFile;
import com.xzwb123.weibo.service.HotUserFileService;
import com.xzwb123.weibo.service.impl.HotUserFileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * 登录界面
 */
@WebServlet(
        name = "LoginPage",
        urlPatterns = {"/loginPage"}
)
public class LoginPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String judge = (String)req.getAttribute("judge");
        if (judge != null) {
            out.println("<h1>用户名或密码错误</h1>");
        }
        out.println("<img src='1.jpg' width=200px>");
        out.println("<form action='login' method='post'>");
        out.println("账号: <input type='text' name='name' placeholder='账号/邮箱/手机号' required><br><br>");
        out.println("密码: <input type='password' name='pwd' required>");
        out.println("<input type='submit' value='登录'>  <input type='checkbox' name='autoLogin' value='yes'> 三天内自动登录登陆");
        out.println("</form><br>");
        out.println("<a href='http://localhost:8080/weibo/registerPage'>还没有账号?注册</a>");
        out.print("<hr>");
        out.println("<h3>最新动态</h3>");
        HotUserFileService hotUserFileService = new HotUserFileServiceImpl();
        HashSet<UserFile> hotUserFile = hotUserFileService.getHotUserFile();
        if (hotUserFile != null) {
            for (UserFile userFile : hotUserFile) {
                out.println("<b>发布时间: </b>" + userFile.getTimestamp() + "<br>");
                out.println("<b>用户昵称: </b>" + userFile.getUname() + "<br>");
                out.println("<p>" + userFile.getTxt() + "</p><br>");
                if (!("".equals(userFile.getFilename()))) {
                    out.println("<img src='" + userFile.getFilename() + "' width='200px'>");
                }
                out.println("<br><hr><br>");
            }
            HttpSession hs = req.getSession();
            hs.setAttribute("HotUserFile", hotUserFile);
        }
    }
}
