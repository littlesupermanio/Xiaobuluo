package com.xiaobuluo.dao.jdbc;

import com.xiaobuluo.dao.PostDao;
import com.xiaobuluo.entity.Post;
import com.xiaobuluo.util.DataSourceUtil;
import javafx.geometry.Pos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDao {

    @Override
    public List<Post> getAllPosts() {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from posts ORDER BY created_at desc";

        List<Post> posts = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Post post = new Post();
                int post_id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int section_id = rs.getInt("section_id");
                String title = rs.getString("title");
                String body = rs.getString("body");
                Date created_at = rs.getDate("created_at");
                post.setId(post_id);
                post.setUser_id(user_id);
                post.setSection_id(section_id);
                post.setTitle(title);
                post.setBody(body);
                post.setCreated_at(created_at);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from posts where id=?";
        Post post = new Post();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                int post_id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int section_id = rs.getInt("section_id");
                String title = rs.getString("title");
                String body = rs.getString("body");
                Date created_at = rs.getDate("created_at");
                post.setId(post_id);
                post.setUser_id(user_id);
                post.setSection_id(section_id);
                post.setTitle(title);
                post.setBody(body);
                post.setCreated_at(created_at);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return post;
    }

    @Override
    public List<Post> getPostsByUserId(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from posts where user_id = ? ORDER BY created_at desc";

        List<Post> posts = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while(rs.next()){
                Post post = new Post();
                int post_id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int section_id = rs.getInt("section_id");
                String title = rs.getString("title");
                String body = rs.getString("body");
                Date created_at = rs.getDate("created_at");
                post.setId(post_id);
                post.setUser_id(user_id);
                post.setSection_id(section_id);
                post.setTitle(title);
                post.setBody(body);
                post.setCreated_at(created_at);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return posts;
    }


    @Override
    public void deletePostById(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "delete from posts where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
    }
}
