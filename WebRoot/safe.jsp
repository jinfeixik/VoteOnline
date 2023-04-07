<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>维护页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/commonCopy.css" />
    <link href="css/demo.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
 <nav style="height:60px">
<div class="demos-buttons">
 <img  src="css/img/logoxx3.png" alt="logo">
    欢迎${sta}${name}&nbsp;&nbsp;&nbsp;<a class="submit" href="loginregister.jsp">注销</a>
     <a class="submit" href="list">主页</a>
     <div class="msg" style="top:12px">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
    ${msg}
    </div>
 </div>   
    </nav>
  
 <div id="wrap">
  <div class="data-div">
    <div class="row tableHeader">
     <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">   
   序号
   </div>
   <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">  
  账号
   </div>
   <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">  
   状态
   </div>
    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">  
   操作
   </div>
  </div>  
   <c:forEach items="${users}" var="users" varStatus="i"> 
     <div class="tablebody">
     <div class="row">
     
       <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
        ${i.index+1}
         </div>
         
         <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
        ${users.VU_USER_NAME}
        </div>
        
         <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
       <c:choose>
           <c:when test="${users.VU_VERSION==1}">
                                   正常
           </c:when> 
            <c:otherwise>
                                     禁用
            </c:otherwise>  
          </c:choose>
          </div>
          
          <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
          <a class="submit" href="ban?VU_USER_ID=${users.VU_USER_ID}">禁用</a> 
          <a class="submit" href="resume?VU_USER_ID=${users.VU_USER_ID}">激活</a> 
        </div>
          
        </div>
        </div>
        
       </c:forEach>
       </div>
       </div>
       
      
  </body>
</html>
