package com.qst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


import com.mysql.jdbc.Statement;
import com.qst.entity.Option;
import com.qst.entity.SuOption;
import com.qst.entity.Subject;
import com.qst.util.DBUtil;

public class SubjectDao implements SubjectInterface{
	
	//@SuppressWarnings("deprecation")
	public void addSubject(Subject subject) {
		Connection con=DBUtil.getConnection();
		String sql="insert into vote_subject(VS_TITLE,VS_TYPE,VU_USER_NAME)values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, subject.getVS_TITLE());
			ps.setInt(2, subject.getVS_TYPE());
			ps.setString(3, subject.getVU_USER_NAME());
			int num=ps.executeUpdate();
			
			if(num>0){
				System.out.println("发起投票成功....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
	}
	public int findItemVSID(int VS_ID) {
		Connection con=DBUtil.getConnection();
		String sql="select count(*) num from vote_item where VS_ID=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			//向预编译语句？中填值
			ps.setInt(1, VS_ID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){		
				int num=rs.getInt("num");
				return num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	public List<Subject> findSubjects(int id) {
		List<Subject> subjects=new ArrayList<Subject>();
		//获取连接对象
		Connection con=DBUtil.getConnection();
		 String sql="SELECT vote_subject.VS_ID, vote_subject.VS_TITLE, vote_subject.VS_TYPE,vote_subject.VU_USER_NAME from vote_subject";
		try {
			//创建语句对象
			PreparedStatement ps=con.prepareStatement(sql);
			 PreparedStatement ps1 = null;
			 PreparedStatement ps2 = null;
			
			     ResultSet rs=ps.executeQuery();
			     while(rs.next()){
			    	 Subject subject=new Subject();
			    	 subject.setVS_ID(rs.getInt("VS_ID"));
			    	 subject.setVS_TITLE(rs.getString("VS_TITLE"));
			    	 subject.setVU_USER_NAME(rs.getString("VU_USER_NAME"));
			    	 subject.setVS_TYPE(rs.getInt("VS_TYPE"));
			    	 String sql1="SELECT count(DISTINCT VU_USER_ID) from vote_item where VS_ID="+subject.getVS_ID();
			    	 String sql2="SELECT VU_USER_ID from vote_item where VS_ID="+subject.getVS_ID();
			    	 ps1 =con.prepareStatement(sql1);
			    	 ps2 =con.prepareStatement(sql2);
			    	 ResultSet rs1=ps1.executeQuery();
			    	 ResultSet rs2=ps2.executeQuery();
			    	// ps2.setString(1, name);
			    	 while(rs2.next()){
			    		 if(rs2.getInt("VU_USER_ID")==id){
			    			 subject.setFlag(1);
			    		 }else{
			    			 //subject.setFlag(2);
			    		 }
			         }
			    	 if(rs1.next()){
			    		 subject.setNum(rs1.getInt(1));
			    	
			    	 subjects.add(subject);
			     }
			     ps1.close();
			     }
			     ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
			
		return subjects;
	}
	public int findId(String VS_TITLE) {
		Connection con=DBUtil.getConnection();
		String sql="select VS_ID from vote_subject where VS_TITLE=?";
		int id = 0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			//向预编译语句？中填值
			ps.setString(1, VS_TITLE);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Subject subject=new Subject();
			    subject.setVS_ID(rs.getInt("VS_ID"));
			    id = subject.getVS_ID();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	public void deleteSubject(int VS_ID) {
		Connection con=DBUtil.getConnection();
		String sql="delete  from vote_subject where VS_ID=?";
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
	public List<Subject> findSub(String VS_TITLE,int id) {
		List<Subject> subjects=new ArrayList<Subject>();
		//获取连接对象
		Connection con=DBUtil.getConnection();
		 String sql="select * from vote_subject where  VS_TITLE like '%"+VS_TITLE+"%'";
		try {
			//创建语句对象
			PreparedStatement ps=con.prepareStatement(sql);
			PreparedStatement ps1=null;
			PreparedStatement ps2=null;
			     ResultSet rs=ps.executeQuery();
			     while(rs.next()){
			    	 Subject subject=new Subject();
			    	 subject.setVS_ID(rs.getInt("VS_ID"));
			    	 subject.setVS_TITLE(rs.getString("VS_TITLE"));
			    	 subject.setVU_USER_NAME(rs.getString("VU_USER_NAME"));
			    	 subject.setVS_TYPE(rs.getInt("VS_TYPE"));
			    	 String sql1="SELECT count(DISTINCT VU_USER_ID) from vote_item where VS_ID="+subject.getVS_ID();
			    	 String sql2="SELECT VU_USER_ID from vote_item where VS_ID="+subject.getVS_ID();
			    	 ps1 =con.prepareStatement(sql1);
			    	 ps2 =con.prepareStatement(sql2);
			    	 ResultSet rs1=ps1.executeQuery();
			    	 ResultSet rs2=ps2.executeQuery();
			    	 while(rs2.next()){
			    		 if(rs2.getInt("VU_USER_ID")==id){
			    			 subject.setFlag(1);
			    		 }else{
			    			// subject.setFlag(2);
			    		 }
			         }
			    	 if(rs1.next()){
			    		 subject.setNum(rs1.getInt(1));
			    	     subjects.add(subject);
			     }
			     ps1.close();
			     }
			     ps2.close();     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
			
		return subjects;
	}
	public List<Subject> findSingleSubject(int VS_ID) {
		List<Subject> subjects=new ArrayList<Subject>();
		//获取连接对象
		Connection con=DBUtil.getConnection();
		 String sql="select * from vote_subject where  VS_ID=?";
		try {
			//创建语句对象
			PreparedStatement ps=con.prepareStatement(sql);
			PreparedStatement ps1=null;
			ps.setInt(1, VS_ID);
			ResultSet rs=ps.executeQuery();
			     while(rs.next()){
			    	 Subject subject=new Subject();
			    	 subject.setVS_ID(rs.getInt("VS_ID"));
			    	 subject.setVS_TITLE(rs.getString("VS_TITLE"));	 
			    	 subject.setVS_TYPE(rs.getInt("VS_TYPE"));
			    	 String sql1="SELECT count(DISTINCT VU_USER_ID) from vote_item where VS_ID="+subject.getVS_ID();
			    	 ps1 =con.prepareStatement(sql1);
			    	 ResultSet rs1=ps1.executeQuery();
			    	 if(rs1.next()){
			    		 subject.setNum(rs1.getInt(1));
			    	     subjects.add(subject);
			     }
			     ps1.close();
			     }
			     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
			
		return subjects;
	}
	/*public List<SuOption> findPages(int page, int pageSize) {
		List<SuOption> sps=new LinkedList<SuOption>();
		Connection con=DBUtil.getConnection();
		String sql="select * from vote_subject limit ?,?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			 ps.setInt(1, (page-1)*pageSize);
			 ps.setInt(2, pageSize);
			 ResultSet rs=ps.executeQuery();
		     while(rs.next()){
		    	 Subject sub=new Subject();
		    	 OptionDao opnd=new OptionDao();
		    	 //opnd.findOptions(sub);
		    	 for(int i=0;i<findSubjects().size();i++){
		    	 SuOption spn=new SuOption();
		    	 spn.setSu(findSubjects().get(i));
		    	 spn.setOps(opnd.findOptions(findSubjects().get(i)));
		    	 sps.add(spn);
		    	 System.out.println("所有内容为："+sps.toString());
		     }
		    	 //spn.setOps(findSubjects());
		    	 
		    	
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sps;
	}*/
	public void updateSubject(Subject subject) {
		Connection con=DBUtil.getConnection();
		String sql="update vote_subject set VS_TITLE=?,VS_TYPE=? where VS_ID=?";
        PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			    ps.setString(1, subject.getVS_TITLE());
		        ps.setInt(2, subject.getVS_TYPE());
		        ps.setInt(3, subject.getVS_ID());
		        ps.executeUpdate();
		        System.out.println("修改成功！");
		} catch (SQLException e) {
			System.out.println("修改失败");
			e.printStackTrace();
		}    
        
	}
	
}
