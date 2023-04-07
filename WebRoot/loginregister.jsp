<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>登录注册</title>
	<link rel="stylesheet" href="css/auth.css">
	<script type="text/javascript">
	   window.onload=function(){
	  var i=1;
	  document.getElementById("change").onclick=function(){
	  document.getElementById("change").src="validate?i="+i;
	  i++;
	  };
	   var val = document.getElementById("username").value;
/* 	   $.ajax({
 			type: "get",	
 			url: "login?id="+val,	
 			data :{"VU_USER_NAME":val},
 			dataType: "text",
 			success: function(data) {
 				alert(data);
 				
 				if(data=="登录成功"){
 				    f.submit();
 					alert("对不起，你已经投过票");
 					
 				}
 				else if(data=="可以投票"){
 					alert("投票成功");
 					
 				}else if(data=="对不起，投票时间已经过了"){
 					alert("对不起，投票时间已经过了");
 					
 				}
 			
 			},
 			error: function(e) {
 			alert(data);
 				alert("你已投过票");
 				console.log("error");
 				window.location.href = "list.jsp";
 			},
 		}); */
	   };
	   
	  </script>
	  
  </head>
  
  <body>
 
  <c:if test="${ error!=null }">
   <script  type="text/javascript"> alert('${error}');</script>
  </c:if>
  <div class="lowin">
		<div class="lowin-brand">
			<img src="img/kodinger.jpg" alt="logo">
		</div>
		<div class="lowin-wrapper">
			<div class="lowin-box lowin-login">
				<div class="lowin-box-inner">
					<form  method="post" id="loginForm">
						<p>在线投票系统登录</p>
						<div class="lowin-group">
							<label>账号 </label>
							<input type="text" id="username"  name="VU_USER_NAME" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>密码 <a href="#" class="forgot-link">忘记密码?</a></label>
							<input type="password" name="VU_PASSWORD" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>验证码</label>
							<input type="text" name="validate"  class="lowin-inputx"><img alt="没图片" id="change" src="validate">
						</div>
						<button class="lowin-btn login-btn"   onclick="commitLogin(5)">登录</button>
						<div class="text-foot">
							没有账号？<a href="" class="register-link">注册一个</a>
						</div>
					</form>
				</div>
			</div>
			
			
  

			<div class="lowin-box lowin-register">
				<div class="lowin-box-inner">
					<form action="register" method="post"  id="loginForm">
						<p>在线投票系统注册</p>
						<div class="lowin-group">
							<label>账号</label>
							<input type="text" name="VU_USER_NAME" class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>密码</label>
							<input type="password" name="VU_PASSWORD"  class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>确认密码</label>
							<input type="password" name="VU_PASSWORDX"  class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>用户身份</label>
							<label class="label3">
							<input type="radio" name="VU_STATUS" id="radiox" value="1" checked hidden/>
							<label for="radiox" class="yong"></label>
							<span class="radio-name">普通用户</span>
							</label>
							<label class="label2">
							<input type="radio"  name="VU_STATUS" id="radioy" value="2" hidden/>
							<label for="radioy" class="yong"></label>
							<span class="radio-name">管理员</span>
							</label>
						</div>
						<button class="lowin-btn" onclick="commitRegister(5)">
							注册
						</button>

						<div class="text-foot">
							已有账号? <a href="" class="login-link">登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	
		<footer class="lowin-footer">
			在线投票系统
		</footer>
	</div>

   <script src="js/auth.js"></script>
	<script>
		Auth.init({
			login_url: 'login',
			forgot_url: 'forgot'
		});
		function commitLogin(val){
			var f = document.getElementById("loginForm");
			f.submit();
		}
		function commitRegister(val){
			var g = document.getElementById("registerForm");
			g.submit();
		}
	</script>
		
  </body>
</html>
