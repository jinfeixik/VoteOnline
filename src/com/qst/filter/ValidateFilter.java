package com.qst.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateFilter implements Filter {

	public void destroy() {
		  System.out.println("FDestroy开始执行.....");
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		  System.out.println("doFilter开始执行.....");
		  HttpServletRequest request=(HttpServletRequest)arg0;
	      HttpServletResponse response=(HttpServletResponse)arg1;
		  String validate=request.getParameter("validate");
		  HttpSession session=request.getSession();
	      String code= (String)session.getAttribute("code");
	      System.out.println("doFilter执行中.....");
	      if(code.equalsIgnoreCase(validate)){
	    	  //相当于请求通过过滤器验证，继续执行请求相对应的servlet
	    	     
		    	   arg2.doFilter(request, response);
				  // session.invalidate();
		    	   //response.sendRedirect("index.jsp");
		    	   
 	    }else{
 	    	   session.invalidate();
 	    	//request.setAttribute("error", "验证码输入错误");
 	    	request.getRequestDispatcher("/loginregister.jsp").forward(request, response);
 	    	  
 	    }
	      
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Finit开始执行.....");
		
	}

}
