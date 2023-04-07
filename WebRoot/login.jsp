<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    <script type="text/javascript">
	  window.onload=function(){
	  var i=1;
	  document.getElementById("change").onclick=function(){
	  document.getElementById("change").src="validate?i="+i;
	  i++;
	  };
	  };
	  </script>
  </head>
  
  <body>
    <form action="login" method="post" >
          <table>
          <caption>登录页面</caption>
           <tr><td>账号：<input type="text" name="VU_USER_NAME" size="20"/></td></tr>
            <tr><td>密码：<input type="password" name="VU_PASSWORD" size="20"/></td></tr>
            <tr><td>验证码:<input type="text" name="validate" size="15"/> <img alt="" id="change" src="validate"></td></tr>
             <tr><td colspan="2"><input type="submit" value="提交按钮"/></td></tr>
             <tr><td> <a href="register.jsp">没有账号？注册一个</a> </td></tr>
          </table>         
       </form> 
  </body>
</html>
