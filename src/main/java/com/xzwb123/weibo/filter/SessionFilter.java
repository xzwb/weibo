package com.xzwb123.weibo.filter;

import com.xzwb123.weibo.info.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 设置用户session失效后的处理
 */
@WebFilter("*.do")
public class SessionFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession hs = request.getSession();
        User user = (User) hs.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/weibo/cookie");
        } else {
            chain.doFilter(request, response);
        }
    }
}
