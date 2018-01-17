package com.xiaobuluo.dao.jdbc;

import com.xiaobuluo.util.JDBCUtil;

import java.sql.*;

public class JDBCBase {
	
	 protected JDBCBase(){}
	
	/**
	 * 查询结果集
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps){
		return query(ps, null);
	}
	
	/**
	 * 封装未知参数并查询结果集
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @param param 存放未知参数的数组
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps, Object[] param){
		return query(ps, param , null, null);
	}
	
	/**
	 * 查询分页结果集
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @param start 起始索引
	 * @param maxCount 当页最大值
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps , Integer start, Integer maxCount){
		return query(ps, null , start, maxCount);
	}
	
	/**
	 * 封装未知参数并查询分页结果集
	 * @param ps 由sql语句实例化的PreparedStatement对象
	 * @param param 存放未知参数的数组
	 * @param start 起始索引
	 * @param maxCount 当页最大值
	 * @return 结果集
	 */
	protected ResultSet query(PreparedStatement ps, Object[] param , Integer start, Integer maxCount){
		ResultSet rs = null;
		try {
			if(param != null){
				for(int i=0; i<param.length; i++){
					ps.setObject(i+1, param[i]);
				}
			}
			
			// 设置查询到的记录的最大索引
			if(start != null && maxCount != null)
				ps.setMaxRows(start+maxCount);
			
			rs = ps.executeQuery();
			
			// 设置查询到的记录的起始索引
			if(start != null && maxCount != null){
				rs.first();
				rs.relative(start-1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 非事务添加/更新操作
	 * @param sql sql语句
	 * @param param 存放未知参数的数组
	 * @return 添加操作的记录的id值
	 */
	protected int save(String sql, Object[] param){
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		try {
			/**
			 * RETURN_GENERATED_KEYS：设置PreparedStatement为可返回键值的模式
			 * 一般用于获取自动生成的键值
			 */
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if(param != null){
				for(int i=0; i<param.length; i++){
					ps.setObject(i+1, param[i]);
				}
			}
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				// 获取插入数据的主键id
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, con);
		}
		return id;
	}
	
	/**
	 * 事务添加/更新操作
	 * @param sql sql语句
	 * @param param 存放未知参数的数组
	 * @param con 数据库连接对象
	 * @return 添加操作的记录的id值
	 */
	protected int save(String sql, Object[] param, Connection con){
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		try {
			/**
			 * RETURN_GENERATED_KEYS：设置PreparedStatement为可返回键值的模式
			 * 一般用于获取自动生成的键值
			 */
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if(param != null){
				for(int i=0; i<param.length; i++){
					ps.setObject(i+1, param[i]);
				}
			}
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				// 获取插入数据的主键id
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// 事物发生异常回滚
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
		}
		return id;
	}
	
	protected int getCount(String sql){
		Connection con = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		int count = 0;
		try {
			/**
			 * 	1.TYPE_FORWORD_ONLY,只可向前滚动；
			 * 	2.TYPE_SCROLL_INSENSITIVE,双向滚动，但不及时更新，就是如果数据库里的数据修改过，并不在ResultSet中反应出来。
			 *	3.TYPE_SCROLL_SENSITIVE，双向滚动，并及时跟踪数据库的更新,以便更改ResultSet中的数据。 
			 */
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = query(ps);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return count;
	}
	
	/**
	 * 可以用来处理增、删、改的方法
	 * */
	protected void saveOrUpdateOrDelete(String sql, Object values[]) {
		PreparedStatement stmt = null;
		Connection conn = JDBCUtil.getConnection();
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
			JDBCUtil.close(null, stmt, conn);
		}
	}
}
