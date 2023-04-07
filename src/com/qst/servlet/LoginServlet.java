package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.dao.UserDao;
import com.qst.entity.User;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login验证执行前");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//得到从jsp页面传来的参数
		String name=request.getParameter("VU_USER_NAME");
		String password=request.getParameter("VU_PASSWORD");
		//新建user
		User user=new User();
		//调用loginUser方法
		UserDao dao=new UserDao();
		PrintWriter out = response.getWriter();
		user = dao.loginUser(name, password);
		//得到session对象
		HttpSession session=request.getSession();
		//比较值，默认为true
		
		
		if(user!=null){
			System.out.println("login验证执行后");
			out.write("登录成功");
			session.setAttribute("name",name);
			char[] as=user.getVU_STATUS().toCharArray();
			String ss="";
			for(char c:as){
				if(c=='1'){
					ss=ss+"普通用户";
				}else if(c=='2'){
					ss=ss+"管理员";
			}
			}
			session.setAttribute("sta",ss);
			//request.setAttribute("sta",ss);
			//response.sendRedirect("list") ;
			
			request.getRequestDispatcher("/list").forward(request, response);
		}else{
			request.setAttribute("error", "账号或者密码错误");
			System.out.println(1);
			request.getRequestDispatcher("/loginregister.jsp").forward(request, response);
			//response.sendRedirect("loginregister.jsp");
		}
		
	}

}
