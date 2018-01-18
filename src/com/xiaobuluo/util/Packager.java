package com.xiaobuluo.util;

import com.xiaobuluo.dao.CommentDao;
import com.xiaobuluo.dao.SectionDao;
import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.dao.jdbc.CommentDaoImpl;
import com.xiaobuluo.dao.jdbc.SectionDaoImpl;
import com.xiaobuluo.dao.jdbc.UserDaoImpl;
import com.xiaobuluo.entity.Comment;
import com.xiaobuluo.entity.Post;
import com.xiaobuluo.entity.Section;
import com.xiaobuluo.entity.User;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Packager {
    /**
     * 封装User的普通属性
     */

    public static User packUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setAvatar(rs.getString("avatar"));
        user.setEmail(rs.getString("email"));
        user.setRegister_date(rs.getDate("created_at"));
        user.setLastlogin_date(rs.getDate("updated_at"));
        return user;
    }

    /**
     * 封装Post的普通属性
     */

    public static Post packPost(ResultSet rs) throws SQLException {
        Post post = new Post();
        CommentDao commentDao = new CommentDaoImpl();
        SectionDao sectionDao = new SectionDaoImpl();
        List<Comment> comments = commentDao.getCommentsByPostId(rs.getInt("id"));
        Section section = sectionDao.getSectionById(rs.getInt("section_id"));
        Date created_at = rs.getTimestamp("created_at");
        post.setId(rs.getInt("id"));
        post.setUser_id(rs.getInt("user_id"));
        post.setSection_id(rs.getInt("section_id"));
        post.setTitle(rs.getString("title"));
        post.setBody(rs.getString("body"));
        post.setCreated_at(created_at);
        post.setUpdate_at(rs.getDate("updated_at"));
        post.setTime_interval(Utils.diffTimeFromNow(created_at));
        post.setComments(comments);
        post.setSection(section);
        return post;
    }

    /**
     * 封装Comment的普通属性
     */

    public static Comment packComment(ResultSet rs) throws SQLException {
        Comment comment = new Comment();
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserById(rs.getInt("user_id"));
        Date created_at = rs.getTimestamp("created_at");
        comment.setId(rs.getInt("id"));
        comment.setUser_id(rs.getInt("user_id"));
        comment.setPost_id(rs.getInt("post_id"));
        comment.setBody(rs.getString("body"));
        comment.setCreated_at(created_at);
        comment.setUpdated_at(rs.getDate("updated_at"));
        comment.setUser(user);
        comment.setTime_interval(Utils.diffTimeFromNow(created_at));
        return comment;
    }

    /**
     * 封装Section的普通属性
     */

    public static Section packSection(ResultSet rs) throws SQLException {
        Section section = new Section();
        SectionDao sectionDao = new SectionDaoImpl();
        List<Section> subSections = sectionDao.getSubSectionsBySectionId(rs.getInt("id"));
        section.setId(rs.getInt("id"));
        section.setManager_id(rs.getInt("manager_id"));
        section.setName(rs.getString("name"));
        section.setParent_id(rs.getInt("parent_id"));
        section.setSubSections(subSections);
        return section;
    }
}
