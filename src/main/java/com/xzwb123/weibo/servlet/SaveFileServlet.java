package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.info.UserFile;
import com.xzwb123.weibo.service.SaveFileService;
import com.xzwb123.weibo.service.impl.SaveFileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(
        name = "SaveFileServlet",
        urlPatterns = {"/saveFile"}
)
public class SaveFileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String uid = req.getParameter("uid");
        String txt = req.getParameter("txt");
        SaveFileService sf = new SaveFileServiceImpl();
        sf.saveFile(name, uid, txt);
        resp.sendRedirect("/weibo/homePage.do");
    }
}
