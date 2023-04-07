package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.dao.UserDao;
import com.qst.entity.Subject;
import com.qst.entity.User;

public class SafeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        System.out.println("得到用户信息前............");
	        UserDao dao=new UserDao();
	        List<User> users=dao.findUsers();
	        //向jsp页面传值
	        request.setAttribute("users",users);
	        System.out.println("得到用户信息后............");
	        request.getRequestDispatcher("/safe.jsp").forward(request, response);
	        
	        
	}

}
