package com.xiaobuluo.action;

import com.xiaobuluo.dao.CommentDao;
import com.xiaobuluo.dao.PostDao;
import com.xiaobuluo.dao.SectionDao;
import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.CommentDaoImpl;
import com.xiaobuluo.dao.jdbc.PostDaoImpl;
import com.xiaobuluo.dao.jdbc.SectionDaoImpl;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.*;
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
    PostDao pDao = new PostDaoImpl();
    CommentDao cDao = new CommentDaoImpl();
    UserDao uDao = new UserDaoImpl();

    RequestDispatcher dispatcher;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if(Constants.POST_SHOW_POST.equals(type)||Constants.POST_SHOW_EDIT_POST.equals(type))
        {
            Integer postId = Integer.parseInt(request.getParameter("id"));
            showPost(postId,type);
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

        if(Constants.POST_NEW_POST.equals(type))
        {
            SectionDao sectionDao = new SectionDaoImpl();
            List<Section> allSections = sectionDao.getAllSections();
            request.setAttribute("allSections",allSections);
            request.getRequestDispatcher("/pages/newpost.jsp").forward(request,response);
            return;
        }

        String title = request.getParameter("title");
        String body = request.getParameter("body");
        String section = request.getParameter("section");
        body = body.replace("\n","<br />");
        User user = (User) request.getSession().getAttribute("user");
        if(user==null)
        {
            Message msg = Message.failedMessage("请登录后操作","/pages/login.jsp");
            request.setAttribute("message",msg);
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
            return;
        }
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUser_id(user.getId());
        post.setSection_id(Integer.parseInt(section));
        int postId = submitPost(post);
        Message msg = Message.successMessage("发布主题成功","/post.jhtml?type=showPost&id="+postId);
        request.setAttribute("message",msg);
        request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public int submitPost(Post post)
    {
        PostService pDao = new PostServiceImpl();
        Integer id = pDao.addPost(post);
        return id;
    }


    public void showPost(int id,String type)
    {

        Post post = pDao.getPostById(id);
        User user = uDao.getUserById(post.getUser_id());
        post.setUser(user);
        if(Constants.POST_SHOW_POST.equals(type))
        {
            request.setAttribute("post",post);
            try {
                request.getRequestDispatcher("/pages/post.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Constants.POST_SHOW_EDIT_POST.equals(type))
        {
            request.setAttribute("post",post);
            try {
                request.getRequestDispatcher("/pages/editpost.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void showAllPosts()
    {
        pDao = new PostDaoImpl();

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
    }
}
