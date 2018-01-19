package com.xiaobuluo.service.impl;

import com.xiaobuluo.entity.Section;
import com.xiaobuluo.service.SectionService;
import com.xiaobuluo.util.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionServiceImpl implements SectionService{
    @Override
    public void addSection(Section section) {
        Connection con = DataSourceUtil.getConnection();
        String name = section.getName();
        Integer parent_id = section.getParent_id();
        Integer manager_id = section.getManager_id();

        String sql = "insert into sections (name,parent_id,manager_id) VALUES (?,?,?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setObject(2,parent_id);
            ps.setInt(3,manager_id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
    }

    @Override
    public void editSection(Section section) {

    }
}
