package com.xiaobuluo.dao.jdbc;

import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.util.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by DylanHo on 18/01/2018.
 * Email: imhhb1997@gmail.com
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from users where id=?";
        User user = new User();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setAvatar(rs.getString("avatar"));
            user.setName(rs.getString("name"));
            user.setPhone(rs.getString("phone"));
            user.setRegister_date(rs.getDate("register_date"));
            user.setLastlogin_date(rs.getDate("lastlogin_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
    }

    @Override
    public void updateUserPassword(User user) {
        String sql = "update user set pass = ? where id = ?";
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setInt(2,user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
    }
}
