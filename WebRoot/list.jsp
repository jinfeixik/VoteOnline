<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.qst.servlet.ListServlet"%>

<html>
  <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
    
    <title>投票展示页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/demo.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/commonCopy.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <!--加载meta IE兼容文件-->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/jsp5shiv/3.7.0/jsp5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
    
   
  </head>
  
  <body>
  
 <nav style="height:60px">
<div class="demos-buttons">
<img  src="css/img/logoxx3.png" alt="logo">
    欢迎${sta}${name}&nbsp;&nbsp;&nbsp;<a class="submit" href="loginregister.jsp">注销</a>
    <c:if test="${sta == '管理员'}">
    <a class="submit" href="plus.jsp">添加新投票</a>
    <a class="submit" href="safe">维护</a>
    </c:if>
    <c:if test="${sta == '普通用户'&& version==1}">
    <a class="submit" href="plus.jsp">添加新投票</a>
    </c:if>
    <c:if test="${msg3 == '主页' }"> 
     <a class="submit" href="list">${msg3}</a>
    </c:if>
     <div class="msg" style="top:12px">
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
${msg}
    </div>
 </div>   
     <form action="search" method="post" > 
     <div class="formxx">
    <input type="text"  name="VS_TITLE" size="20"/>
    </div>
    <div class="formyy">
    <input type="submit" class="submit" value="搜索"/>
    </div>
    </form>
    </nav>
  
 <div id="wrap">
  <div class="data-div">
    <div class="row tableHeader">
      <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">  
   序号
   </div>
   <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">  
  标题
   </div>
   <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">  
  发起人
   </div>
   <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">  
   类型
   </div>
   <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 ">  
   选项
   </div>
   <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 ">  
   操作
   </div>
  </div>  
   <c:forEach items="${dao2}" var="dao" varStatus="i" begin="${x}" end="${x+3}" step="1"> 
   <form action="vote" method="post" >
     <div class="tablebody">
     <div class="row">
     	 
       <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
        <input name="VS_ID" type="hidden"  value="${dao.su.VS_ID}"/>
        ${i.index+1}
         </div>
         
         <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
        ${dao.su.VS_TITLE}<a>(已有</a><a style="font-weight:bold">${dao.su.num}</a><a>人参与)</a>
        </div>
         <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
        ${dao.su.VU_USER_NAME}
        </div>
        
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
       <c:choose>
           <c:when test="${dao.su.VS_TYPE==1}">
                                   单选
           </c:when> 
            <c:otherwise>
                                  多选
            </c:otherwise>  
          </c:choose>
          </div>
          
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
          <c:forEach items="${dao.ops}" var="daoops" varStatus="list" >
          <c:choose>
           <c:when test="${dao.su.VS_TYPE==1}">  
					<input type="radio" name="VO_ID" id="radiox" value="${daoops.VO_ID}"/>
					${daoops.VO_ORDER}.${daoops.VO_OPTION}<a>(</a><a style="font-weight:bold">${daoops.sum}</a><a>)</a>
					
					</c:when>
					<c:otherwise>
             <input type="checkbox" name="VO_ID" value="${daoops.VO_ID}"/>${daoops.VO_ORDER}.${daoops.VO_OPTION}<a>(</a><a style="font-weight:bold">${daoops.sum}</a><a>)</a>
            </c:otherwise>
             </c:choose>
          </c:forEach> 
          </div>
          
         <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 "> 
         <c:choose>
          <c:when test="${dao.su.flag==1}"> 
           <button style="background:#CCCCCC" class="submit" disabled="true">已投</button>      
        </c:when>
         <c:otherwise>     
         <button  class="submit"  type="submit">投票</button> 
        </c:otherwise>
        </c:choose>
        <c:if test="${dao.su.VU_USER_NAME == name}">
       
        <a class="submit" href="correct?VS_ID=${dao.su.VS_ID}">编辑</a>
        
        <a class="submit" onclick="myFunction(${dao.su.VS_ID})">删除</a>      
        </c:if>
        <c:if test="${dao.su.VU_USER_NAME ne name}">
        <c:if test="${sta == '管理员'}">
        &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
        <a class="submit" onclick="myFunction(${dao.su.VS_ID})">删除</a> 
        </c:if>
        <c:if test="${dao.su.VU_USER_NAME ne name && sta == '普通用户'}">
        &nbsp;&nbsp;&nbsp;  
        <a></a>
        &nbsp;&nbsp;&nbsp;
        <a></a>      
        </c:if>     
        </c:if>
        </div>
        </div>
        </div>
       
        
        </form>
        
       </c:forEach>
       <div style="margin-left:1100px">
      <a class="submit" href="list?x=${x-4}">上一页</a>
   <a class="submit" href="list?x=${x+4}">下一页</a>
      第${x/4+1}页
      </div>
       <script>
	function myFunction(VS_ID){
		var x;
		var r=confirm("确认删除？");
	   
		if (r==true){
			if(window.XMLHttpRequest)
	        {
	            var oAjax = new XMLHttpRequest();
	        }
	        else
	        {
	            var oAjax = new ActiveXObject("Microsoft.XMLHTTP");
	        }
			oAjax.open("GET","http://desktop-aa1pbs7:8080/VoteOnline_20164206158/delete?VS_ID="+VS_ID,true);
			
			oAjax.send();
			
			oAjax.onreadystatechange = function(){
				if(oAjax.readyState==4)
	            {
	                if(oAjax.status==200)//判断是否成功,如果是200，就代表成功
	                {
	                	 window.location="http://desktop-aa1pbs7:8080/VoteOnline_20164206158/list";
	                }
	            }
			};
		}
		else{
			
		}
	//document.getElementById("demo").innerHTML=x;
}
</script>
        </div>
       </div>
         
      
       
  </body>
</html>
