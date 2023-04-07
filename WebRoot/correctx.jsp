<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  <link href="css/demo1.css" rel="stylesheet" type="text/css">
  
    <title>投票编辑页面</title>	
  </head>
  
  <body>
      
       <div class="demos-buttons">
        <a href="list" class="submit">返回</a><br/>    
    </div>
    <section id="getintouch" class="fadeInDownBig animated">
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>投票编辑页面</span>
            </h1>
        </div>
        <c:forEach items="${dao2}" var="dao">       
        <div class="container">
        <form class="contact" id="form" action="edit" method="post" >
            <input type="hidden"   name="VS_ID" value="${dao.su.VS_ID}" >
            <div class="row clearfix">
                <div class="lbl">
                    <label for="email">
                                                            投票问题</label><br>
                </div>
                <div class="ctrl">
                    <input type="text" id="email" name="VS_TITLE" value="${dao.su.VS_TITLE}" data-required="true" data-validation="email"
                        data-msg="Invalid E-Mail" >
                </div>
            </div><br>
            <div class="row clearfix">
                <div class="lbl">
                    <label for="name">
                                                           投票类型</label>
                </div>
                <div class="ctrl">
                    <input type="radio"  name="VS_TYPE" value="1" checked/>单选
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="VS_TYPE" value="2"/>多选   
                </div>
            </div>
            
             <c:forEach items="${dao.ops}" var="daoops" varStatus="i">
            <div class="row clearfix">
                <div class="lbl">
                <input type="hidden" name="VO_ID" value="${daoops.VO_ID}" size="20"/>
                    <label for="email">
                                                            选项选项${i.count}</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="phone" name="VO_OPTION" value="${daoops.VO_OPTION}" data-required="true" data-validation="custom"
                        data-msg="Invalid Phone #">
                </div>
            </div>
            </c:forEach>
            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input type="submit" name="submit" id="submit" class="submit" value="完成编辑">
                </div>
            </div>
            </form>  
                      
        </div>
         
       </c:forEach> 
         </section>
  </body>
</html>
