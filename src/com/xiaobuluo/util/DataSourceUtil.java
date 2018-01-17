package com.xiaobuluo.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	private static DataSource dataSource;
	private static Connection conn;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static Connection getConnection(){
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printResultSet(ResultSet rs) {
		StringBuffer sb = new StringBuffer();
		try {
			ResultSetMetaData meta = rs.getMetaData();
			int cols = meta.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					sb.append(meta.getColumnName(i) + "=");
					sb.append(rs.getString(i) + "  ");
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
