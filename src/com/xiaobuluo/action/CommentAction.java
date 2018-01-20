package com.xiaobuluo.action;

import com.xiaobuluo.dao.CommentDao;
import com.xiaobuluo.dao.jdbc.CommentDaoImpl;
import com.xiaobuluo.entity.Comment;
import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.globe.Constants;
import com.xiaobuluo.service.CommentService;
import com.xiaobuluo.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DylanHo on 18/01/2018.
 * Email: imhhb1997@gmail.com
 */

public class CommentAction extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        User user = (User) request.getSession().getAttribute("user");
        if(Constants.COMMENT_SUBMIT_COMMENT.equals(type))
        {
            if(request.getSession().getAttribute("user")==null)
            {
                Message msg = Message.failedMessage("请登录后操作","/pages/login.jsp");
                request.setAttribute("message",msg);
                request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
                return;
            }
            Comment comment = new Comment();
            Integer postId = Integer.parseInt(request.getParameter("postId"));
            String comment_body = request.getParameter("comment_body");
            System.out.println(comment_body);
            comment_body = comment_body.replace("\n","<br />");
            comment.setPost_id(postId);
            comment.setUser_id(user.getId());
            comment.setBody(comment_body);
            CommentService commentService = new CommentServiceImpl();
            commentService.addCommentToPost(comment);
            Message message = new Message();
            String jumpUrl = "/post.jhtml?type=showPost&id="+postId;
            message.setType("success");
            message.setIcon("check");
            message.setContent("添加评论成功！");
            message.setJumpUrl(jumpUrl);
            request.setAttribute("message",message);
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }
        if(Constants.COMMENT_DELETE_COMMENT.equals(type))
        {
            if(request.getSession().getAttribute("user")==null)
            {
                Message msg = Message.failedMessage("请登录后操作","/pages/login.jsp");
                request.setAttribute("message",msg);
                request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
                return;
            }
            String id = request.getParameter("id");
            System.out.println(id);
            CommentDao commentDao = new CommentDaoImpl();
            Comment comment = commentDao.getCommentById(Integer.parseInt(id));
            Integer post_id = comment.getPost_id();
            CommentService commentService = new CommentServiceImpl();
            commentService.deleteCommentById(Integer.parseInt(id));
            Message msg = Message.successMessage("删除评论成功","/post.jhtml?type=showPost&id="+post_id);
            request.setAttribute("message",msg);
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
            return;
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
