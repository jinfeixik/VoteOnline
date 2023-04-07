package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.dao.ItemDao;
import com.qst.dao.OptionDao;
import com.qst.dao.SubjectDao;
import com.qst.entity.Item;
import com.qst.entity.Option;
import com.qst.entity.Subject;

public class EditServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			int  VS_ID=(Integer.parseInt(request.getParameter("VS_ID")));
			String  []VO_ID=request.getParameterValues("VO_ID"); 
			String VS_TITLE=request.getParameter("VS_TITLE");
			int  VS_TYPE=(Integer.parseInt(request.getParameter("VS_TYPE")));
			String []VO_OPTION=request.getParameterValues("VO_OPTION");
			//int i =Integer.parseInt(request.getParameter("i"));
			//System.out.println("hahahahahahah"+i);
			Subject subject=new Subject();
			subject.setVS_ID(VS_ID);
			subject.setVS_TITLE(VS_TITLE); 
			subject.setVS_TYPE(VS_TYPE);
			SubjectDao dao1=new SubjectDao();
			dao1.updateSubject(subject);
			System.out.println("修改标题成功......");
			int i=0;
			for(String c:VO_ID){
				Option opn=new Option();
				opn.setVO_ID(Integer.parseInt(c));
				opn.setVO_OPTION(VO_OPTION[i++]);
			    OptionDao daop=new OptionDao();
			    System.out.println("-----------------------");
			    System.out.println("选项是-----------------"+c);
			    System.out.println("-----------------------");
				daop.updateOption(opn);	 
		    }
			request.setAttribute("msg", "修改成功!");
			response.sendRedirect("list");
			
			
			
	}

}
