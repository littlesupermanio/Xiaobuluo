package com.xiaobuluo.action;

import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.globe.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAction extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        User user = (User) request.getSession().getAttribute("user");
        if(Constants.USER_SHOW_USER.equals(type))
        {
            if(user==null)
            {
                Message msg = Message.failedMessage("请登录后操作","/pages/login.jsp");
                request.setAttribute("message",msg);
                request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
                return;
            }
            request.getRequestDispatcher("/pages/userinfo.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
