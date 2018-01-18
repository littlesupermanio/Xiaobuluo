package com.xiaobuluo.util;

import com.xiaobuluo.entity.Comment;
import com.xiaobuluo.entity.Post;
import com.xiaobuluo.entity.Section;
import com.xiaobuluo.entity.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        Date created_at = rs.getDate("created_at");
        post.setId(rs.getInt("id"));
        post.setUser_id(rs.getInt("user_id"));
        post.setSection_id(rs.getInt("section_id"));
        post.setTitle(rs.getString("title"));
        post.setBody(rs.getString("body"));
        post.setCreated_at(created_at);
        post.setUpdate_at(rs.getDate("updated_at"));
        System.out.println(Utils.diffTimeFromNow(created_at));
        post.setTime_interval(Utils.diffTimeFromNow(created_at));
        return post;
    }

    /**
     * 封装Comment的普通属性
     */

    public static Comment packComment(ResultSet rs) throws SQLException {
        Comment comment = new Comment();
        Date created_at = rs.getDate("created_at");
        comment.setId(rs.getInt("id"));
        comment.setUser_id(rs.getInt("user_id"));
        comment.setPost_id(rs.getInt("post_id"));
        comment.setBody(rs.getString("body"));
        comment.setCreated_at(created_at);
        comment.setUpdated_at(rs.getDate("updated_at"));
        return comment;
    }

    /**
     * 封装Section的普通属性
     */

    public static Section packSection(ResultSet rs) throws SQLException {
        Section section = new Section();
        section.setId(rs.getInt("id"));
        section.setManager_id(rs.getInt("manager_id"));
        section.setName(rs.getString("body"));
        section.setParent_id(rs.getInt("parent_id"));
        return section;
    }
}
