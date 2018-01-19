package com.xiaobuluo.action;

import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.globe.Constants;
import com.xiaobuluo.service.UserService;
import com.xiaobuluo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserAction extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    UserDao userDao = new UserDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        User loginUser = (User) request.getSession().getAttribute("user");
        String id = request.getParameter("id");
        if(Constants.USER_SHOW_USER.equals(type))
        {
            checkUserStatus(loginUser);
            userDao = new UserDaoImpl();
            User user = userDao.getUserById(Integer.parseInt(id));
            request.setAttribute("user",user);
            request.getRequestDispatcher("/pages/userinfo.jsp").forward(request,response);
        }

        if(Constants.ADMIN_USER_SHOWLIST.equals(type))
        {
            UserService userService = new UserServiceImpl();
            System.out.println("进入方法");
            checkUserStatus(loginUser);
            if(userService.isAdmin(loginUser))
            {
                System.out.println("hai");
                List<User> users = userDao.getAllUsers();
                System.out.println(users.size());
                request.setAttribute("users",users);
                request.getRequestDispatcher("/admin/user_admin.jsp").forward(request,response);
            }else{
                Message msg = Message.failedMessage("对不起，您没有权限","/index.jhtml");
                request.setAttribute("message",msg);
                request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
            }
        }

        if(Constants.ADMIN_USER_DELETE.equals(type))
        {
            String deleteUserId = request.getParameter("id");
            User deleteUser = userDao.getUserById(Integer.parseInt(deleteUserId));
            userDao.deleteUser(deleteUser);
            Message msg = Message.successMessage("删除用户成功","/user.jhtml?type="+Constants.ADMIN_USER_SHOWLIST);
            request.setAttribute("message",msg);
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void checkUserStatus(User user)
    {
        if(user==null)
        {
            Message msg = Message.failedMessage("请登录后操作","/pages/login.jsp");
            request.setAttribute("message",msg);
            try {
                request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }
}
