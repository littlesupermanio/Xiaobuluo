package com.xiaobuluo.service.impl;

import com.xiaobuluo.entity.User;
import com.xiaobuluo.service.UserService;
import com.xiaobuluo.util.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public boolean isAdmin(User user) {
        Connection con = DataSourceUtil.getConnection();
        Integer id = user.getId();
        boolean flag = false;
        String sql = "select * from sections where manager_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs != null)
            {
                flag = true;
                return flag;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return flag;
    }
}
