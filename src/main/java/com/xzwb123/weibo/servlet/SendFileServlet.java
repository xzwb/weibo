package com.xzwb123.weibo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(
        name = "SendFileServlet",
        urlPatterns = {"/sendFile"}
)
public class SendFileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("post");
        if (type == null) {
            req.getRequestDispatcher("saveFile").forward(req, resp);
        } else {
            req.getRequestDispatcher("postFile").forward(req, resp);
        }
    }
}
