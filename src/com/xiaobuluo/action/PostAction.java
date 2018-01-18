package com.xiaobuluo.action;

import com.xiaobuluo.dao.CommentDao;
import com.xiaobuluo.dao.PostDao;
import com.xiaobuluo.dao.jdbc.CommentDaoImpl;
import com.xiaobuluo.dao.jdbc.PostDaoImpl;
import com.xiaobuluo.entity.Comment;
import com.xiaobuluo.entity.Post;
import com.xiaobuluo.globe.Constants;
import com.xiaobuluo.service.PostService;
import com.xiaobuluo.service.impl.PostServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PostAction extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    RequestDispatcher dispatcher;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if(Constants.POST_SHOW_POST.equals(type))
        {
            Integer postId = Integer.parseInt(request.getParameter("id"));
            showPost(postId);
            return;
        }

        if(Constants.POST_SHOW_ALL_POSTS.equals(type))
        {
            showAllPosts();
            return;
        }

        if(Constants.POST_DELETE_POST.equals(type))
        {
            Integer postId = Integer.parseInt(request.getParameter("id"));
            deletePost(postId);
            return;
        }

        String title = request.getParameter("title");
        String body = request.getParameter("body");
        body = body.replace("\n","<br />");
        System.out.println(title);
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser_id(1);
        post.setSection_id(1);
        submitPost(post);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void submitPost(Post post)
    {
        PostService pDao = new PostServiceImpl();
        pDao.addPost(post);
        System.out.println("生成文章成功！");
    }

    public void showPost(int id)
    {
        PostDao pDao = new PostDaoImpl();
        CommentDao cDao = new CommentDaoImpl();
        Post post = pDao.getPostById(id);
        List<Comment> comments = cDao.getCommentsByPostId(id);

        request.setAttribute("post",post);
        request.setAttribute("comments",comments);
        try {
            request.getRequestDispatcher("/pages/post.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAllPosts()
    {
        PostDao pDao = new PostDaoImpl();
        List<Post> posts = pDao.getAllPosts();
        request.setAttribute("posts",posts);
        try {
            request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(int id)
    {
        PostDao pDao = new PostDaoImpl();
        pDao.deletePostById(id);
        System.out.println("删除id为"+id+"的文章成功");
    }
}
