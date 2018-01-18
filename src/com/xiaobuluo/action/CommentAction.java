package com.xiaobuluo.action;

import com.xiaobuluo.entity.Comment;
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
        if(Constants.COMMENT_SUBMIT_COMMENT.equals(type))
        {
            Integer postId = Integer.parseInt(request.getParameter("postId"));
            String comment_body = request.getParameter("comment_body");
            comment_body = comment_body.replace("\n","<br />");
            Comment comment = new Comment();
            comment.setPost_id(postId);
            comment.setUser_id(1);
            comment.setBody(comment_body);
            CommentService commentService = new CommentServiceImpl();
            commentService.addCommentToPost(comment);
            System.out.println("添加评论成功");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
