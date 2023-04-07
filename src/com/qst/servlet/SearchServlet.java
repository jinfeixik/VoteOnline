package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.dao.OptionDao;
import com.qst.dao.SubjectDao;
import com.qst.dao.UserDao;
import com.qst.entity.Option;
import com.qst.entity.SuOption;
import com.qst.entity.Subject;

public class SearchServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   System.out.println("查找前......");
		   request.setCharacterEncoding("utf-8");
		   response.setContentType("text/html;charset=utf-8");
		   HttpSession session=request.getSession();
		   UserDao dao=new UserDao();
		   String name=((String)session.getAttribute("name"));
		   String VS_TITLE=request.getParameter("VS_TITLE");
		   SubjectDao dao1=new SubjectDao();
		    OptionDao dao3=new OptionDao();
		    int id=dao.findUserId(name);
			List<Subject> subjects=dao1.findSub(VS_TITLE,id);
		    List<SuOption> dao2=new LinkedList<SuOption>();
		    System.out.println("记录行数"+subjects.size());
			for(int i=0;i<subjects.size();i++){
				SuOption daos=new SuOption();
				daos.setSu(subjects.get(i));
				subjects.get(i).getNum();
				List<Option>  option=dao3.findOptions(subjects.get(i));
				daos.setOps(option);
				dao2.add(daos);
			}
			
			int version=dao.findUserVERSION(name);
			
		    request.setAttribute("version", version);	
			request.setAttribute("dao2",dao2);
			request.setAttribute("msg3", "主页");
			request.setAttribute("msg", "查找成功!");
			System.out.println("查找后.......");
			//转发
			request.getRequestDispatcher("list.jsp").forward(request,response);
		   


		
	}

}
