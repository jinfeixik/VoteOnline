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
import com.qst.entity.Option;
import com.qst.entity.SuOption;
import com.qst.entity.Subject;

public class CorrectServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			int  VS_ID=(Integer.parseInt(request.getParameter("VS_ID")));
			SubjectDao dao1=new SubjectDao();
			OptionDao dao3=new OptionDao();
			List<Subject> subjects=dao1.findSingleSubject(VS_ID);
			//判断是否有人投过票
			if((subjects.get(0).getNum())==0){
			List<SuOption> dao2=new LinkedList<SuOption>();
			SuOption daos=new SuOption();
			daos.setSu(subjects.get(0));
			subjects.get(0).getNum();
			//得到选项信息存入List<SuOption>中
			List<Option>  option=dao3.findOptions(subjects.get(0));
			daos.setOps(option);
			dao2.add(daos);
			request.setAttribute("dao2",dao2);
			System.out.println("编辑单条信息："+dao2.toString());
			request.getRequestDispatcher("correctx.jsp").forward(request,response);
			}else{
				System.out.println("投票数量不为0，无法编辑");
				request.setAttribute("msg","无法编辑，已有用户投票!");
				request.getRequestDispatcher("/list").forward(request,response);
			}
			
			 
	}

}
