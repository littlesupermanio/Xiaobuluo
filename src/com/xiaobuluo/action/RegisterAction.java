package com.xiaobuluo.action;

import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class RegisterAction extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        password = Utils.toMD5(password);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserDao userDao = new UserDaoImpl();
        System.out.println(user.getName());
        userDao.saveUser(user);
        Message msg = Message.successMessage("注册成功","/pages/login.jsp");
        request.setAttribute("message",msg);
        request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
