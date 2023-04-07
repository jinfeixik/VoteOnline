package com.qst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.dao.ItemDao;
import com.qst.dao.OptionDao;
import com.qst.dao.SubjectDao;
import com.qst.dao.UserDao;
import com.qst.entity.Option;
import com.qst.entity.SuOption;
import com.qst.entity.Subject;
import com.qst.entity.User;

public class ListServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    System.out.println("开始打印表单");
		    HttpSession session=request.getSession();
			UserDao dao=new UserDao();
			String name=((String)session.getAttribute("name"));
			int id=dao.findUserId(name);
		    //调用dao类
		    SubjectDao dao1=new SubjectDao();
            //Subject das=new Subject();
		OptionDao dao3 = new OptionDao();
		// 调用查找方法将查到的数据存于subjects中
		List<Subject> subjects = dao1.findSubjects(id);
		List<SuOption> dao2 = new LinkedList<SuOption>();
		// 遍历所有标题，依次打印选项信息
		for (int i = 0; i < subjects.size(); i++) {
			// dao4.findItemVSID(subjects.get());
			// 得到标题内容存入SuOption()中
			SuOption daos = new SuOption();
			daos.setSu(subjects.get(i));
			// 得到选项信息存入List<SuOption>中
			List<Option> option = dao3.findOptions(subjects.get(i));
			daos.setOps(option);
			dao2.add(daos);
		}
			request.setAttribute("dao2",dao2);
             //Subject sub=new Subject();
             //System.out.println(":::::::::::::::"+sub.getX());
             //request.setAttribute("x",sub.getX());
			String x=request.getParameter("x");
			if(x==null){
				request.setAttribute("x",0);
			}
			else{ 
		     int a=Integer.parseInt(x);
				if(a<0){			
					request.setAttribute("x",0);
				}else if(a>=subjects.size()){
					request.setAttribute("x",a-4);
				}else{
					request.setAttribute("x",a);
				}
             }
	
				
			
			
			//List<Option> subjects=dao.findOptions();
			//向前台传值，前台通过EL表达式${subjects}获得值
			//request.setAttribute("subjects",subjects);
			//传递SuOption中所有值，再筛选
			
			int version=dao.findUserVERSION(name);
		    request.setAttribute("version", version);
			
			
			//request.setAttribute("dao2",dao2);
			
			System.out.println("表单打印完成");
			//转发
			request.getRequestDispatcher("list.jsp").forward(request,response);

	
	}
	public void init(ServletConfig config) throws ServletException {
		int x;
	
		
	}
	}


