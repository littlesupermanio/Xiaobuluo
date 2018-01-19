package com.xiaobuluo.action;

import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
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
        User loginUser = (User) request.getSession().getAttribute("user");
        String id = request.getParameter("id");
        if(Constants.USER_SHOW_USER.equals(type))
        {
            if(loginUser==null)
            {
                Message msg = Message.failedMessage("请登录后操作","/pages/login.jsp");
                request.setAttribute("message",msg);
                request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
                return;
            }
            UserDao userDao = new UserDaoImpl();
            User user = userDao.getUserById(Integer.parseInt(id));
            request.setAttribute("user",user);
            request.getRequestDispatcher("/pages/userinfo.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
