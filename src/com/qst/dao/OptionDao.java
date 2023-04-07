package com.qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qst.entity.Option;
import com.qst.entity.Subject;
import com.qst.entity.User;
import com.qst.util.DBUtil;

public class OptionDao implements OptionInterface{
	public void addOption(Option option) {
		Connection con=DBUtil.getConnection();
		String sql="insert into vote_option(VO_OPTION,VS_ID,VO_ORDER)values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, option.getVO_OPTION());
			ps.setInt(2, option.getVS_ID());
			ps.setInt(3, option.getVO_ORDER());
			int num=ps.executeUpdate();
			if(num>0){
				System.out.println("添加选项成功....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
	}
	public List<Option> findOptions(Subject subs) {
		List<Option> options=new ArrayList<Option>();
		//获取连接对象
		Connection con=DBUtil.getConnection();
		 String sql="select * from vote_option where  VS_ID ='" + subs.getVS_ID() + "'";
		try {
			//创建语句对象
			PreparedStatement ps=con.prepareStatement(sql);
			PreparedStatement ps1=null;
			//返回结果集
			     ResultSet rs=ps.executeQuery();
			     while(rs.next()){
			    	 Option option=new Option();
			    	 option.setVO_ID(rs.getInt("VO_ID"));
			    	 option.setVO_OPTION(rs.getString("VO_OPTION"));
			    	 option.setVS_ID(rs.getInt("VS_ID"));
			    	 option.setVO_ORDER(rs.getInt("VO_ORDER"));
			    	 String sql1="SELECT count(DISTINCT VU_USER_ID) from vote_item where VO_ID="+option.getVO_ID();
			    	 ps1 =con.prepareStatement(sql1);
			    	 ResultSet rs1=ps1.executeQuery();
			    	 if(rs1.next()){
			    		 option.setSum(rs1.getInt(1));
			    	     options.add(option);
			     }
			    	 ps1.close();
			     }
			     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
			
		return options;
	}
	public void deleteOption(int VS_ID) {
		Connection con=DBUtil.getConnection();
		String sql="delete  from vote_option where VS_ID=?";
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
	public void updateOption(Option option) {
		Connection con=DBUtil.getConnection();
		System.out.println("dao内容是："+option.getVO_OPTION());
		String sql="update vote_option set VO_OPTION=? where VO_ID=?";
		 int i =0;
        PreparedStatement ps;
		try {
			    ps = con.prepareStatement(sql);
			    ps.setString(1, option.getVO_OPTION());
		        ps.setInt(2, option.getVO_ID());
		        i =ps.executeUpdate();
		        System.out.println(i);
		        if(i>0)
		        {
		        	 System.out.println("选项成功！");
		        }
		        else
		        {
		        	System.out.println("选项失败");
		        }
		       
		} catch (SQLException e) {
			
			e.printStackTrace();
		}    
        
	}

}
