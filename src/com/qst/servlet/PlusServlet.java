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
import com.qst.entity.User;

public class PlusServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          System.out.println("投票发起前......");
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 HttpSession session=request.getSession();
		 String VU_USER_NAME=((String)session.getAttribute("name"));
		 //获得从jsp页面get到的数据
		 String VS_TITLE=request.getParameter("VS_TITLE");
		 int  VS_TYPE=(Integer.parseInt(request.getParameter("VS_TYPE")));
		 //选项一
		 String VO_OPTION=request.getParameter("VO_OPTION");
		 int  VO_ORDER=1;
		 //选项二
		 String VO_OPTIONX=request.getParameter("VO_OPTIONX");
		 int  VO_ORDERX=2;
		//如果没有输入则不添加
		 if(VS_TITLE==""||VO_OPTION==""||VO_OPTIONX==""){
			 System.out.println("信息未填写完整");
			 response.sendRedirect("plus.jsp") ;
		 }else{
		 //从jsp页面中获取添加框的数量
		 int n =Integer.parseInt(request.getParameter("n")); 
		 System.out.println("投票标题:  "+VS_TITLE+"  投票类型:  "+VS_TYPE);
		 System.out.println("选项内容:  "+VO_ORDER+VO_OPTION+VO_ORDERX+VO_OPTIONX);
		 //将前台得到的数据存到数据表
		 //Subject中的数据
		 Subject subject=new Subject();
		 subject.setVS_TITLE(VS_TITLE);
		 subject.setVS_TYPE(VS_TYPE);
		 subject.setVU_USER_NAME(VU_USER_NAME);
		//Subject数据插入数据库
		 SubjectDao dao1=new SubjectDao();
		 dao1.addSubject(subject);
		 //从Subject表中获取VS_ID
		 dao1.findId(VS_TITLE);
		 //Option选项一的数据
		 Option option =new Option();
		 option.setVS_ID(dao1.findId(VS_TITLE));
		 option.setVO_OPTION(VO_OPTION);
		 option.setVO_ORDER(VO_ORDER);
		//Option选项二的数据
		 Option optionx =new Option();
		 optionx.setVS_ID(dao1.findId(VS_TITLE));
		 optionx.setVO_OPTION(VO_OPTIONX);
		 optionx.setVO_ORDER(VO_ORDERX);
		 //Option选项一插入数据库
		 OptionDao dao2=new OptionDao();
		 dao2.addOption(option);
		 //Option选项二插入数据库
		 OptionDao dao3=new OptionDao();
		 dao3.addOption(optionx);
		 //将选项信息依次存入链表中
		 List<Option> op=new LinkedList<Option>();
		 for(int i=1;i<=n;i++){
			    Option opn=new Option();
			    OptionDao daop=new OptionDao();
			    String VO_OPTIONXX= request.getParameter("VO_OPTIONX"+i);
			    System.out.println("选项是-----------------"+VO_OPTIONXX);
			    int  VO_ORDERXX=i+2;
			    System.out.println("序号是-----------------"+VO_ORDERXX);
			    opn.setVS_ID(dao1.findId(VS_TITLE));
				opn.setVO_OPTION(VO_OPTIONXX);
				opn.setVO_ORDER(VO_ORDERXX);		
				daop.addOption(opn);
			 
		 }
		 System.out.println("投票发起成功......");
		//如果没有输入则不能提交
		 System.out.println(VS_TITLE+VO_OPTION+VO_OPTIONX+"--------------------");
		 request.setAttribute("msg", "添加成功!");
		 response.sendRedirect("list");
		// request.getRequestDispatcher("/list").forward(request, response);
		 }
	}

}
