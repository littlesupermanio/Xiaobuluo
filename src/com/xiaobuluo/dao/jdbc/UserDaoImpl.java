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
            user.setUsername(rs.getString("name"));
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
}
