package com.qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.qst.entity.Subject;
import com.qst.entity.User;
import com.qst.util.DBUtil;

public class UserDao implements UserInterface{
	public void addUser(User user) {
		Connection con=DBUtil.getConnection();
		String sql="insert into vote_user(VU_USER_NAME,VU_PASSWORD,VU_STATUS,VU_VERSION)values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1, user.getVU_USER_ID());
			ps.setString(1, user.getVU_USER_NAME());
			ps.setString(2, user.getVU_PASSWORD());
			ps.setString(3, user.getVU_STATUS());
			ps.setInt(4, user.getVU_VERSION());
			int num=ps.executeUpdate();
			if(num>0){
				System.out.println("注册成功....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
	}
	 public User loginUser(String VU_USER_NAME, String VU_PASSWORD) {
		 //获取连接对象
		    Connection con=DBUtil.getConnection();
			String sql="select * from vote_user where VU_USER_NAME=? and VU_PASSWORD=?";
			try {
				//预编译语句
				    PreparedStatement ps=con.prepareStatement(sql);
				    //注入参数值
				    ps.setString(1, VU_USER_NAME);
				    ps.setString(2, VU_PASSWORD);
				    //返回结果集
				    ResultSet rs=ps.executeQuery();
				    //遍历，寻找合适值
					while(rs.next()){
						User user=new User();
						user.setVU_STATUS(rs.getString("VU_STATUS"));
						user.setVU_USER_NAME(rs.getString("VU_USER_NAME"));
						user.setVU_PASSWORD(rs.getString("VU_PASSWORD"));
						return user;
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(con);
			}
			return null;
		}
	 public int findUserId(String VU_USER_NAME) {
			Connection con=DBUtil.getConnection();
			String sql="select VU_USER_ID from vote_user where VU_USER_NAME=?";
			int userid = 0;
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				//向预编译语句？中填值
				ps.setString(1, VU_USER_NAME);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					User user=new User();
				    user.setVU_USER_ID(rs.getInt("VU_USER_ID"));
				    userid = user.getVU_USER_ID();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userid;
		}
	 public String findUserName(int VU_USER_ID) {
			Connection con=DBUtil.getConnection();
			String sql="select VU_USER_NAME from vote_user where VU_USER_ID=?";
			String username=null;
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				//向预编译语句？中填值
				ps.setInt(1, VU_USER_ID);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					User user=new User();
				    user.setVU_USER_NAME(rs.getString("VU_USER_NAME"));
				    username = user.getVU_USER_NAME();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return username;
		}
	 public int findUserVERSION(String VU_USER_NAME) {
			Connection con=DBUtil.getConnection();
			String sql="select VU_VERSION from vote_user where VU_USER_NAME=?";
			int userversion = 0;
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				//向预编译语句？中填值
				ps.setString(1, VU_USER_NAME);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					User user=new User();
				    user.setVU_VERSION(rs.getInt("VU_VERSION"));
				    userversion = user.getVU_VERSION();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userversion;
		}
	 public List<User> findUsers() {
			List<User> users=new ArrayList<User>();
			//获取连接对象
			Connection con=DBUtil.getConnection();
			 String sql="select * from vote_user where VU_STATUS='1'";
			try {
				//创建语句对象
				PreparedStatement ps=con.prepareStatement(sql);
				     ResultSet rs=ps.executeQuery();
				     while(rs.next()){
				    	User user=new User();
				    	user.setVU_USER_ID(rs.getInt("VU_USER_ID"));
				    	user.setVU_USER_NAME(rs.getString("VU_USER_NAME"));
				    	user.setVU_PASSWORD(rs.getString("VU_PASSWORD"));
				    	user.setVU_STATUS(rs.getString("VU_STATUS"));
				    	user.setVU_VERSION(rs.getInt("VU_VERSION"));
				    	users.add(user);
				     }
				     
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(con);
			}
				
			return users;
		}
	 public void updateUserVERSION(User user) {
			Connection con=DBUtil.getConnection();
			String sql="update vote_user set VU_VERSION=2 where VU_USER_ID=?";
	        PreparedStatement ps;
			try {
				    ps = con.prepareStatement(sql);
			        ps.setInt(1, user.getVU_USER_ID());
			        ps.executeUpdate();
			        System.out.println("封禁成功！");
			} catch (SQLException e) {
				System.out.println("封禁失败");
				e.printStackTrace();
			}    
	        
		}
	 public void updateUserVERSIONX(User user) {
			Connection con=DBUtil.getConnection();
			String sql="update vote_user set VU_VERSION=1 where VU_USER_ID=?";
	        PreparedStatement ps;
			try {
				    ps = con.prepareStatement(sql);
			        ps.setInt(1, user.getVU_USER_ID());
			        ps.executeUpdate();
			        System.out.println("恢复成功！");
			} catch (SQLException e) {
				System.out.println("恢复失败");
				e.printStackTrace();
			}    
	        
		}

}
