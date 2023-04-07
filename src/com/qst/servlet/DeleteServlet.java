package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.dao.ItemDao;
import com.qst.dao.OptionDao;
import com.qst.dao.SubjectDao;

public class DeleteServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  System.out.println("删除前......");
		  request.setCharacterEncoding("utf-8");
		  response.setContentType("text/html;charset=utf-8");
		  int  VS_ID=(Integer.parseInt(request.getParameter("VS_ID")));
		  OptionDao dao2=new OptionDao();
		  SubjectDao dao3=new SubjectDao();
		  ItemDao dao1=new ItemDao();
		  dao1.deleteItem(VS_ID);
		  dao2.deleteOption(VS_ID);
		  dao3.deleteSubject(VS_ID);
		  System.out.println("删除后......");
		  request.setAttribute("msg", "删除成功");
		  request.getRequestDispatcher("/list").forward(request, response);
	  
		  
		
	}

}
