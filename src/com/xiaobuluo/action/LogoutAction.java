package com.xiaobuluo.action;

import com.xiaobuluo.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //强制销毁Session
        request.getSession().removeAttribute("user");
        Message msg = Message.successMessage("注销成功","/pages/login.jsp");
        request.setAttribute("message",msg);
        request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
