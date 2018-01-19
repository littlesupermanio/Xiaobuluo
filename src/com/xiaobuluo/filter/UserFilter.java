package com.xiaobuluo.filter;

import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {
    String[] page_urls;
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println("UserFilter获得请求："+request.getRequestURI());

        for (int i = 0; i < page_urls.length; i++) {
            if(request.getRequestURI().endsWith(page_urls[i]))
            {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("user");
                if(user==null)
                {
                    Message msg = Message.failedMessage("请先登录后在操作","/pages/login.jsp");
                    request.setAttribute("message",msg);
                    request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
                }else{
                    chain.doFilter(req, resp);
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("UserFilter被创建");
        String checked = config.getInitParameter("checked");
        page_urls = checked.split(";");

    }

}