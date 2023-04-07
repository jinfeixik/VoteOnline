<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
  <head>
     <link href="css/demo1.css" rel="stylesheet" type="text/css">
    <title>添加新投票</title>
    <script type="text/javascript">
  window.onload = function(){
	  var x = 0;
	  document.getElementById("rr").onclick = function(){
		  // alert(".........................");
		   var element=document.createElement("a");
		   var txt=document.createElement("input");
		   var txt1=document.createElement("br");
		    var txt2=document.createElement("br");
		    var txt3=document.createElement("br");
		   txt.type="text";
		   txt.id="addinp";
		   //element.type="a";
		   element.id="a";
		   x=x+1;
		   txt.name="VO_OPTIONX"+x;
		   element.name=x+2;
		   txt.size="20";
		   element.innerHTML="选项"+(x+2);
		   document.getElementById("x2").appendChild(txt1);  
		   document.getElementById("x2").appendChild(element);
		   document.getElementById("x2").appendChild(txt2);
		   document.getElementById("x2").appendChild(txt);
		   document.getElementById("x2").appendChild(txt3);
		   
		 
		  return false;
		  };
		  
	 
	  
	document.getElementById("mit").onclick = function(){
		  
		  document.getElementById("num").value = x;
		 
		  //alert(".........................");
		  };
		  };
		 

  

</script>
  </head>
  
  <body>
        <div class="demos-buttons">
        <a href="list" class="submit">返回</a><br/>    
    </div>
    <section id="getintouch" class="fadeInDownBig animated">
        <div class="container" style="border-bottom: 0;">
            <h1>
                <span>添加投票页面</span>
            </h1>
        </div>
        <div class="container">
            <form name="vote" class="contact" id="form" action="plus" method="post">
            <div class="row clearfix">
                <div class="lbl">
                    <label for="name">
                                                           投票问题</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="name" name="VS_TITLE" data-required="true" data-validation="text"
                        data-msg="Invalid Name">
                </div>
            </div>
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
            <div class="row clearfix">
                <div class="lbl">
                    <label for="email">
                                                            选项1</label>
                </div>
                <div class="ctrl">
                    <input type="text" id="phone" name="VO_OPTION" data-required="true" data-validation="custom"
                        data-msg="Invalid Phone #">
                </div>
            </div>
            <div class="row clearfix" id="x2">
                <div class="lbl">
                    <label for="email">
                                                            选项2</label>
                </div>
                <div class="ctrl" >
                    <input type="text" id="phone" name="VO_OPTIONX" data-required="true" data-validation="custom"
                        data-msg="Invalid Phone #">
                </div>
            </div>
            <br><a class="submit"  id="rr" href="javascript:void(0)">添加选项</a><br>
            <div class="row clearfix">
                <div class="lbl">
                    <label for="email">
                     </label>
                </div>
                <div class="ctrl" >
                    <input id="num" type="hidden" name="n">
                </div>
            </div>
            
            <div class="row  clearfix">
                <div class="span10 offset2">
                    <input type="submit" name="submit" id="mit" class="submit" value="完成添加">
                </div>
            </div>
            </form>   
                 
        </div>
     </section>   
   
  </body>
</html>
