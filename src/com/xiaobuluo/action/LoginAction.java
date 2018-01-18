package com.xiaobuluo.action;

import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.globe.Constants;
import com.xiaobuluo.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by DylanHo on 05/01/2018.
 * Email: imhhb1997@gmail.com
 */

public class LoginAction extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 用户提交的手机或邮箱
        String condition = request.getParameter("name");
        // 用户的个人密码
        String password = request.getParameter("password");


        // 如果用户名、密码或者验证码为空则跳转回登录页面
        if (condition == null || password == null) {
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            return;
        }

        // 通过用户名查询用户
        User user = userDao.getUserByCondition(condition);
        // 验证用户名和密码是否正确
        if (user == null || !user.getPassword().equals(Utils.toMD5(password))) {
            Message msg = Message.failedMessage("用户名或密码错误","/pages/login.jsp");
            request.setAttribute("message",msg);
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
            return;
        }

        request.setAttribute("user",user);
        Message msg = Message.successMessage("登陆成功","/index.jhtml");
        request.setAttribute("message",msg);
        saveUserInfo(request,user);
        System.out.println(request.getSession().getAttribute("user"));
        request.getRequestDispatcher("/pages/message.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    private void saveUserInfo(HttpServletRequest request, User user) {
        // 重新开启session，方便计算用户登录时间
        request.getSession().invalidate();
        HttpSession session = request.getSession();
        // 把用户状态存入session中
        session.setAttribute(Constants.USER_KEY, user);
    }
}
