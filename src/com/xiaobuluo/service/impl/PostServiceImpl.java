package com.xiaobuluo.service.impl;

import com.xiaobuluo.entity.Post;
import com.xiaobuluo.service.PostService;
import com.xiaobuluo.util.DataSourceUtil;

import java.sql.*;

public class PostServiceImpl implements PostService{
    @Override
    public Integer addPost(Post post) {
        Connection con = DataSourceUtil.getConnection();
        String title = post.getTitle();
        String body = post.getBody();
        Integer user_id = post.getUser_id();
        Integer section_id = post.getSection_id();

        String sql = "insert into posts(user_id,section_id,title,body,created_at) VALUES (?,?,?,?,NOW()"
                +")";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,user_id);
            ps.setInt(2,section_id);
            ps.setString(3,title);
            ps.setString(4,body);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return id;
    }

    @Override
    public void editPost(Post post) {
        Connection con = DataSourceUtil.getConnection();
        String title = post.getTitle();
        String body = post.getBody();
        Integer id = post.getId();

        String sql = "update posts set title = ?  and body = ? where id =?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,body);
            ps.setInt(3,id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
    }

//    @Override
//    public void deletePostById(int id) {
//        Connection con = DataSourceUtil.getConnection();
//
//        String sql = "delete from posts where id = ?";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1,id);
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally{
//            DataSourceUtil.close(rs, ps, con);
//        }
//    }
}
