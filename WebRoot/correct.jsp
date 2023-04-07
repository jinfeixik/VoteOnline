<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>修改页面</title>
  </head>  
  <body> 
  <c:forEach items="${dao2}" var="dao"> 
   <form action="edit" method="post" >
   <table>
    <caption>编辑投票页面</caption>
    <tr><td><input type="hidden" name="VS_ID" value="${dao.su.VS_ID}" size="20"/></td></tr>
    <tr><td>投票问题：<input type="text" name="VS_TITLE" value="${dao.su.VS_TITLE}" size="20"/></td></tr>
    <tr><td>投票类型：<input type="radio" name="VS_TYPE" value="1" checked/>单选&nbsp;&nbsp;&nbsp;<input type="radio" name="VS_TYPE" value="2"/>多选</td></tr>   
   <c:forEach items="${dao.ops}" var="daoops" varStatus="i">
    <tr><td><input type="hidden" name="VO_ID" value="${daoops.VO_ID}" size="20"/></td></tr>
  <tr><td> 选项${i.count}：
            <input type="text" name="VO_OPTION" value="${daoops.VO_OPTION}" size="20"/></td></tr>
   </c:forEach>
           
             <tr><td><input type="submit" value="提交按钮"/></td></tr>
             </table>
       </form> 
       </c:forEach> 
  </body>
</html>
