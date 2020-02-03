package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.UserFile;
import com.xzwb123.weibo.service.PostFileService;
import com.xzwb123.weibo.service.impl.PostFileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Calendar;

// @MultipartConfig(location = "/usr/share/tomcat/webapps/weibo")
@WebServlet(
        name = "PostFileServlet",
        urlPatterns = {"/postFile"}
)
public class PostFileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("img");
        String filename = part.getSubmittedFileName();
        UserFile userFile = new UserFile();
        userFile.setTxt(req.getParameter("txt"));
        userFile.setUname(req.getParameter("uname"));
        userFile.setUid(Integer.valueOf(req.getParameter("uid")));
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if ("".equals(filename)) {
            userFile.setFilename("");
        } else {
            userFile.setFilename(timeInMillis+"");
            try {
                part.write(String.format("%s%s", req.getSession().getServletContext().getRealPath("/"), userFile.getFilename()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PostFileService ps = new PostFileServiceImpl();
        ps.postFileService(userFile);
        resp.sendRedirect("/weibo/homePage.do");
    }
}
