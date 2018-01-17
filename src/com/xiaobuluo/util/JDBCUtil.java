package com.xiaobuluo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	private static  String url= null;  
	private static  String name= null ;  
	private static  String user = null;  
	private static  String password= null;
	
	/**
	 * 加载jdbc参数
	 */
	static {
		loadProperties();
		try {
			Class.forName(name);
		} catch (Exception e) {
		    System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
	}	
	
	/**
	 * 创建数据库连接对象
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			 con = DriverManager.getConnection(url, user, password);//获取连接  
		} catch (Exception e) {
		    System.out.println("数据库连接失败！");    
			e.printStackTrace();
		}
		return con;
	}

	private static void loadProperties() {
		InputStream inputStream  =  JDBCUtil.class.getClassLoader().getResourceAsStream( "jdbc.properties" );    
		 Properties p  =   new  Properties();    
		  try   {    
			  p.load(inputStream);    
		   }   catch  (IOException e1)  {    
			   System.out.println("数据库参数加载错误");   
		  }
		  url =  p.getProperty("url" );
		  name = p.getProperty("driverClassName");
		  user = p.getProperty("username");
		  password = p.getProperty("password");
	}

	/**
	 * 关闭数据库连接对象
	 */
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
	/**
	 * 根据对象，关闭数据库连接
	 */
	public static void close(Object o) {
		try {
			if (o instanceof ResultSet) {
				((ResultSet) o).close();
			} else if (o instanceof Statement) {
				((Statement) o).close();
			} else if (o instanceof Connection) {
				((Connection) o).close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet...resultSets){
		for(ResultSet rs : resultSets){
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * 打印结果集
	 */
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