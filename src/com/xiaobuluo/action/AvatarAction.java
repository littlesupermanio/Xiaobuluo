package com.xiaobuluo.action;

import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.Message;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.globe.Constants;
import com.xiaobuluo.util.Utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AvatarAction extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            this.request = request;
            this.response = response;
            User user = (User) request.getSession().getAttribute(Constants.USER_KEY);
            getUserHeadPic(user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void getUserHeadPic(User user) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        //为解析类提供配置信息
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建解析类的实例
        ServletFileUpload sfu = new ServletFileUpload(factory);
        try {
            List<FileItem> items = sfu.parseRequest(request);
            //区分表单域
            for (int i = 0; i < items.size(); i++) {
                FileItem item = items.get(i);
                //isFormField为true，表示这不是文件上传表单域
                if(!item.isFormField()){
                    ServletContext sctx = getServletContext();
                    //获得存放文件的物理路径
                    //upload下的某个文件夹   得到当前在线的用户  找到对应的文件夹

                    String path = sctx.getRealPath("/storage/avatar");
                    System.out.println(path);
                    //获得文件名
                    String fileName = item.getName();
                    System.out.println(fileName);
                    //该方法在某些平台(操作系统),会返回路径+文件名
                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);
                    File file = new File(path+"\\"+fileName);
                    if(!file.exists()){
                        item.write(file);
                        //将上传图片的名字记录到数据库中
                        Message msg = Message.successMessage("头像上传成功","/pages/modifyuserinfo.jsp");
                        request.setAttribute("message",msg);
                        request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
