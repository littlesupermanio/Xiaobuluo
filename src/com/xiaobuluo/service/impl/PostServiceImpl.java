package com.xiaobuluo.service.impl;

import com.xiaobuluo.entity.Post;
import com.xiaobuluo.service.PostService;
import com.xiaobuluo.util.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostServiceImpl implements PostService{
    @Override
    public void addPost(Post post) {
        Connection con = DataSourceUtil.getConnection();
        String title = post.getTitle();
        String body = post.getBody();
        Integer user_id = post.getUser_id();
        Integer section_id = post.getSection_id();

        String sql = "insert into posts(user_id,section_id,title,body,created_at) VALUES (?,?,?,?,NOW()"
                +")";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,section_id);
            ps.setString(3,title);
            ps.setString(4,body);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
    }

    @Override
    public void editPost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }
}
