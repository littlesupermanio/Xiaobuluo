package com.xiaobuluo.dao.jdbc;

import com.xiaobuluo.dao.PostDao;
import com.xiaobuluo.entity.Post;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.util.DataSourceUtil;
import com.xiaobuluo.util.Packager;
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
                Post post = Packager.packPost(rs);
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
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Post post = Packager.packPost(rs);
                return post;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return null;
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
                Post post = Packager.packPost(rs);
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
    public List<Post> getPostsBySectionId(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from posts where section_id = ? ORDER BY created_at desc";

        List<Post> posts = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while(rs.next()){
                Post post = Packager.packPost(rs);
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
