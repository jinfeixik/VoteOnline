package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qst.dao.UserDao;
import com.qst.entity.User;

public class AddServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          System.out.println("注册前......");  
		 request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 String VU_USER_NAME=request.getParameter("VU_USER_NAME");
		 String VU_PASSWORD=request.getParameter("VU_PASSWORD");
		 String VU_PASSWORDX=request.getParameter("VU_PASSWORDX");
		 String  VU_STATUS=request.getParameter("VU_STATUS");
		 int  VU_VERSION=1;
		 /* String[] VU_USER_ID=request.getParameterValues("VU_USER_ID");
		  String ss="";
		   for(String str:VU_USER_ID){
			   ss=ss+str;
		   }*/
		  if(VU_PASSWORD.equals(VU_PASSWORDX)&&VU_USER_NAME.length()<10){
		  User user=new User();
		  user.setVU_USER_NAME(VU_USER_NAME);
		  user.setVU_PASSWORD(VU_PASSWORD);
		  user.setVU_STATUS(VU_STATUS);
		  user.setVU_VERSION(VU_VERSION);
		  UserDao dao=new UserDao();
		  dao.addUser(user);
		  System.out.println("注册后......"); 
		  //重定向
		  response.sendRedirect("login") ;  
		  }else if(VU_USER_NAME.length()>=10){
			  System.out.println("注册失败,账号过长......");
			  request.setAttribute("error", "注册失败,账号过长");
			  request.getRequestDispatcher("/loginregister.jsp").forward(request, response);
		  }else if(VU_PASSWORD.equals(VU_PASSWORDX)==false){
				  System.out.println("注册失败,两次密码不一致......");
				  request.setAttribute("error", "注册失败,两次密码不一致");
				  request.getRequestDispatcher("/loginregister.jsp").forward(request, response);
				  //response.sendRedirect("loginregister.jsp") ;
		   
		  
	}

	}
}
