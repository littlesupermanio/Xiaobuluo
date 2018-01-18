package com.xiaobuluo.dao.jdbc;

import com.xiaobuluo.dao.SectionDao;
import com.xiaobuluo.entity.Section;
import com.xiaobuluo.util.DataSourceUtil;
import com.xiaobuluo.util.Packager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionDaoImpl implements SectionDao {
    @Override
    public List<Section> getAllSections() {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from sections";

        List<Section> sections = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Section section = Packager.packSection(rs);
                sections.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return sections;
    }



    @Override
    public List<Section> getSubSectionsBySectionId(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from sections where parent_id = ? ";

        List<Section> sections = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                Section section = Packager.packSection(rs);
                sections.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return sections;
    }

    @Override
    public List<Section> getMainSections() {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from sections where parent_id is NULL ";

        List<Section> sections = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Section section = Packager.packSection(rs);
                sections.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return sections;
    }

    @Override
    public Section getSectionById(int id) {
        Connection con = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from sections where id = ? ";

        Section section = new Section();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                section = Packager.packSection(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DataSourceUtil.close(rs, ps, con);
        }
        return section;
    }


}
