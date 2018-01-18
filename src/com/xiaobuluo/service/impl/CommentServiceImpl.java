package com.xiaobuluo.service.impl;

import com.xiaobuluo.entity.Comment;
import com.xiaobuluo.service.CommentService;
import com.xiaobuluo.util.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentServiceImpl implements CommentService {
    @Override
    public void addCommentToPost(Comment comment) {
        Connection con = DataSourceUtil.getConnection();
        String body = comment.getBody();
        Integer user_id = comment.getUser_id();
        Integer post_id = comment.getPost_id();
        String sql = "insert into comments(user_id,post_id,body,created_at) VALUES (?,?,?,NOW()"
                +")";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,post_id);
            ps.setString(3,body);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
    }
}
