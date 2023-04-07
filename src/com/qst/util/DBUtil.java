package com.qst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con=null;
	//启动数据库
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//连接数据库
	public static Connection getConnection(){
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vote", "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//关闭数据库
	public static void closeConnection(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//验证数据库是否启动成功
	public static void main(String[] args) {
		System.out.println(DBUtil.getConnection()+"%%%%%%%%%%%%%%%%");

	}

}
