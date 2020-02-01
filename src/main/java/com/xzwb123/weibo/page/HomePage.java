package com.xzwb123.weibo.page;

import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.info.UserFile;
import com.xzwb123.weibo.listen.OnlineNumber;
import com.xzwb123.weibo.service.HotUserFileService;
import com.xzwb123.weibo.service.impl.HotUserFileServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

@WebServlet(
        name = "HomePage",
        urlPatterns = {"/homePage.do"}
)
public class HomePage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs =  req.getSession();
        User user = (User) hs.getAttribute("user");
        HotUserFileService hotUserFileService = new HotUserFileServiceImpl();
        HashSet<UserFile> userFileHashSet = hotUserFileService.getHotUserFile();
        ServletContext sc = req.getServletContext();
        int online = (int)sc.getAttribute("online");
        PrintWriter out = resp.getWriter();
        out.println("<h1>欢迎访问" + user.getUname() + "的主页</h1> <a href = 'http://localhost:8080/weibo/onlineUser.do'>当前在线人数: " + online + "</a><hr>");
        out.println("<a href='http://localhost:8080/weibo/logout'>注销</a><br><hr>");
        out.println("<h3>最新动态</h3>");
        if (userFileHashSet != null) {
            for (UserFile userFile : userFileHashSet) {
                out.println("<b>发布时间: </b>" + userFile.getTimestamp() + "<br>");
                out.println("<b>用户昵称: </b>" + userFile.getUname() + "<br>");
                out.println("<p>" + userFile.getTxt() + "</p><br>");
                if (!("".equals(userFile.getFilename()))) {
                    out.println("<img src='" + userFile.getFilename() + "' width='200px'>");
                }
                out.println("<br><hr><br>");
            }
        }

    }
}
