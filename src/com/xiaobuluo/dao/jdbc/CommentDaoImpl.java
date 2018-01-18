package com.xiaobuluo.dao.jdbc;

import com.xiaobuluo.dao.CommentDao;
import com.xiaobuluo.entity.Comment;
import com.xiaobuluo.util.DataSourceUtil;
import com.xiaobuluo.util.Packager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DylanHo on 18/01/2018.
 * Email: imhhb1997@gmail.com
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> getCommentsByPostId(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Comment> comments = new ArrayList<>();
        String sql = "select * from comments where post_id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Comment comment = Packager.packComment(rs);
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return comments;
    }

    @Override
    public int getCommentsCountByPostId(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select count(*) as rowCount from comments where post_id=?";
        int commentsCount = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            commentsCount = rs.getInt("rowCount");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return commentsCount;
    }


}
