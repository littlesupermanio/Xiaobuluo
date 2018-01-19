package com.xiaobuluo.action;

import com.xiaobuluo.dao.CommentDao;
import com.xiaobuluo.dao.PostDao;
import com.xiaobuluo.dao.SectionDao;
import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.CommentDaoImpl;
import com.xiaobuluo.dao.jdbc.PostDaoImpl;
import com.xiaobuluo.dao.jdbc.SectionDaoImpl;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.Post;
import com.xiaobuluo.entity.Section;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.globe.Constants;
import com.xiaobuluo.service.SectionService;
import com.xiaobuluo.service.impl.SectionServiceImpl;

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
        String type = request.getParameter("type");
        User loginUser = (User) request.getSession().getAttribute("user");
        if(Constants.ADMIN_SECTION_SHOWLIST.equals(type))
        {
            checkUserStatus(loginUser);
            List<Section> sections = sDao.getAllSections();
            request.setAttribute("sections",sections);
            request.getRequestDispatcher("/admin/section_admin.jsp").forward(request,response);
        }
        if(Constants.ADMIN_SECTION_ADD.equals(type))
        {
            checkUserStatus(loginUser);
            String name = request.getParameter("name");
            String parent_id = request.getParameter("parent_id");
            Section section = new Section();
            section.setName(name);
            if(!parent_id.equals("null"))
            {
                section.setParent_id(Integer.parseInt(parent_id));
            }
            section.setManager_id(loginUser.getId());
            SectionService sectionService = new SectionServiceImpl();
            sectionService.addSection(section);
            Message msg = Message.successMessage("创建版块成功","/section.jhtml?type="+Constants.ADMIN_SECTION_SHOWLIST);
            request.setAttribute("message",msg);
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }


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
