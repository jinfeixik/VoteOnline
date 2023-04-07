package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.dao.ItemDao;
import com.qst.dao.UserDao;
import com.qst.entity.Item;
import com.qst.entity.User;

public class VoteServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    String []VO_ID = request.getParameterValues("VO_ID");		
		    System.out.println("投票开始前.......");
		    int  VS_ID=(Integer.parseInt(request.getParameter("VS_ID")));
		    System.out.println("标题标识为=========="+VS_ID);
		    //从session中得到用户名
		    HttpSession session=request.getSession();
		    String VU_USER_NAME=session.getAttribute("name").toString();
		    //用查找方法通过用户名查找id标识
		     UserDao udao=new UserDao();
		     udao.findUserId(VU_USER_NAME);
		     System.out.println("用户账号为=========="+VU_USER_NAME);
		     System.out.println("用户标识为=========="+udao.findUserId(VU_USER_NAME));
		    //遍历[]VO_ID插入数据
		     for(String c:VO_ID){
						 Item item=new Item();
					     item.setVO_ID(Integer.parseInt(c));
					     item.setVS_ID(VS_ID);
						 item.setVU_USER_ID(udao.findUserId(VU_USER_NAME));
						 ItemDao dao=new ItemDao();
						 dao.addItem(item);
				}
		     
			 System.out.println("投票成功.......");
			 request.setAttribute("msg", "投票成功!");
			 request.getRequestDispatcher("/list").forward(request, response);
			 //response.sendRedirect("list") ;
		    

	}

}
