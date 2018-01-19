package com.xiaobuluo.dao.jdbc;

import com.xiaobuluo.dao.UserDao;
import com.xiaobuluo.entity.User;
import com.xiaobuluo.util.DataSourceUtil;
import com.xiaobuluo.util.Packager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        User user = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            user = Packager.packUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO users(name,email,password,created_at) VALUES(?,?,?,NOW())";
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


    @Override
    public User getUserByCondition(String condition) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        String sql = "SELECT * FROM users u WHERE u.name = ? or u.email = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,condition);
            ps.setString(2,condition);
            rs = ps.executeQuery();
            if(rs.next()){
                user = Packager.packUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                User user = Packager.packUser(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return users;
    }

    @Override
    public void deleteUser(User user) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer id = user.getId();

        String sql = "delete FROM users where id = ?";
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

    @Override
    public void update(User user) {
        StringBuilder sql =new StringBuilder( "update user set name=?,email=?");
        ArrayList<Object> pList=new ArrayList<Object>();
        pList.add(user.getName());
        pList.add(user.getEmail());
        if(user.getPassword()!=null){
            sql.append(",password=?");
            pList.add(user.getPassword());
        }
        if(user.getAvatar()!=null){
            sql.append(",avatar=?");
            pList.add(user.getAvatar());
        }
        sql.append(" where id=?");
        pList.add(user.getId());
        Object[] param=pList.toArray();
        saveOrUpdateOrDelete(sql.toString(), param);
    }

    private void saveOrUpdateOrDelete(String sql, Object values[]) {
        PreparedStatement stmt = null;
        Connection conn = DataSourceUtil.getConnection();
        try {
            stmt = conn.prepareStatement(sql);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    stmt.setObject(i + 1, values[i]);
                }
            }
            stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DataSourceUtil.close(null, stmt, conn);
        }
    }


}
