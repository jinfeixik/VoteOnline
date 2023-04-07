<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    
 <title>注册</title>
  </head>
  <body>
     <form action="add" method="post" >
          <table>
          <caption>注册页面</caption>
           <tr><td>注册账号：</td><td><input type="text" name="VU_USER_NAME" size="20"/></td></tr>
           <tr><td>注册密码：</td><td><input type="password" name="VU_PASSWORD" size="20"/></td></tr>
           <tr><td>确认密码：</td><td><input type="password" name="VU_PASSWORDX" size="20"/></td></tr>
            <tr><td>用户状态：</td><td><input type="radio" name="VU_STATUS" value="1" checked/>普通用户&nbsp;&nbsp;&nbsp;<input type="radio" name="VU_STATUS" value="2"/>管理员</td></tr>
             <tr><td colspan="2"><input type="submit" value="提交按钮"/></td></tr>
          </table>
         
       </form> 
  </body>
</html>
