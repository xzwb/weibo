package com.xzwb123.weibo.page;

import com.xzwb123.weibo.dao.DraftDao;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.info.UserFile;
import com.xzwb123.weibo.service.DraftService;
import com.xzwb123.weibo.service.impl.DraftServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "SendFilePage",
        urlPatterns = {"/sendFile.do"}
)
public class SendFilePage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        User user = (User) hs.getAttribute("user");
        String uid = user.getUid() + "";
        PrintWriter out = resp.getWriter();
        DraftService ds = new DraftServiceImpl();
        UserFile userFile = ds.getDraftService(uid);
        out.println("<h1>抒发好心情,在还没想好名字微博发表动态......</h1><br><hr>");
        out.println("<form action = 'sendFile' method = 'post' enctype='multipart/form-data'>");
        if (userFile == null) {
            out.println("<textarea rows='20' cols='100' name = 'txt'  placeholder='抒发好心情.....' required></textarea><br>");
        } else {
            out.println("<textarea rows='20' cols='100' name = 'txt' required>" + userFile.getTxt() + "</textarea><br>");
        }
        out.println("<input type='file' accept=\"image/png, image/jpeg, image/gif, image/jpg\" name='img'>");
        out.println("</form>");
    }
}
