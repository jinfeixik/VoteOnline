package com.qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qst.entity.Item;
import com.qst.entity.Option;
import com.qst.entity.Subject;
import com.qst.util.DBUtil;

public class ItemDao implements  ItemInterface{
	public void addItem(Item item) {
		Connection con=DBUtil.getConnection();
		String sql="insert into vote_item(VO_ID,VS_ID,VU_USER_ID)values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, item.getVO_ID());
			ps.setInt(2, item.getVS_ID());
			ps.setInt(3, item.getVU_USER_ID());
			int num=ps.executeUpdate();
			if(num>0){
				System.out.println("投票已加入数据库....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
	}
	public void deleteItem(int VS_ID) {
		Connection con=DBUtil.getConnection();
		String sql="delete  from vote_item where VS_ID=?";
        try {
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, VS_ID);
			 ps.executeUpdate();
			 System.out.println("删除成功!");
		} catch (SQLException e) {
			 System.out.println("删除失败!");
			e.printStackTrace();
		}
        
	}
	public int findItemVSID(int VS_ID) {
		Connection con=DBUtil.getConnection();
		String sql="select count(*) num from vote_item where VS_ID=?";
		//int n = 0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			//向预编译语句？中填值
			ps.setInt(1, VS_ID);
			System.out.println("VSID的值为"+VS_ID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("+++++++++++++");		
				int num=rs.getInt("num");
				return num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
