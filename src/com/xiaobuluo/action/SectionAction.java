package com.xiaobuluo.action;

import com.xiaobuluo.dao.CommentDao;
import com.xiaobuluo.dao.PostDao;
import com.xiaobuluo.dao.SectionDao;
import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.CommentDaoImpl;
import com.xiaobuluo.dao.jdbc.PostDaoImpl;
import com.xiaobuluo.dao.jdbc.SectionDaoImpl;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.Post;
import com.xiaobuluo.entity.Section;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SectionAction extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;

    PostDao pDao = new PostDaoImpl();
    CommentDao cDao = new CommentDaoImpl();
    UserDao uDao = new UserDaoImpl();
    SectionDao sDao = new SectionDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;
        request.setCharacterEncoding("UTF-8");
        showPostsBySectionId();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void showPostsBySectionId()
    {
        String sectionId = request.getParameter("sectionId");
        if(sectionId!=null)
        {
            List<Post> posts = pDao.getPostsBySectionId(Integer.parseInt(sectionId));
            List<Section> mainSections = sDao.getMainSections();
            request.setAttribute("posts",posts);
            request.setAttribute("main_sections",mainSections);
            try {
                request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
