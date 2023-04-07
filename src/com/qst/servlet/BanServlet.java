package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.dao.UserDao;
import com.qst.entity.User;

public class BanServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		System.out.println("禁用前.............");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int  VU_USER_ID=(Integer.parseInt(request.getParameter("VU_USER_ID")));
		  User user=new User();
		  user.setVU_USER_ID(VU_USER_ID);
		  UserDao dao=new UserDao();
		  dao.updateUserVERSION(user);
		  System.out.println("禁用后.............");
		  request.setAttribute("msg", "禁用成功!");
		  request.getRequestDispatcher("safe").forward(request,response);

	}

}
