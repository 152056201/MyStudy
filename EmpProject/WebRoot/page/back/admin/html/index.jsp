<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginUrl = basePath + "page/back/admin/html/login";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>Exact Login Form Flat Responsive Widget Template :: w3layouts</title>
	
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Exact login Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta-Tags -->

	<!-- Custom Theme files -->
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/mldn.js"></script>
	<link href="page/back/admin/html/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="page/back/admin/html/css/font-awesome.css" rel="stylesheet"> <!-- Font-Awesome-Icons-CSS -->
	<!-- //Custom Theme files -->
	
	<!-- web font --> 
	<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<!-- //web font --> 
	
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>用户登录</h1>
		<div class="main-w3lsrow">
			<!-- login form -->
			<div class="login-form login-form-left"> 
				<div class="agile-row">
					<div class="head">
						<h2>输入验证信息</h2>
						<span class="fa fa-lock"></span>
					</div>					
					<div class="clear"></div>
					<div class="login-agileits-top"> 	
						<form action="<%=loginUrl %>" method="post" onsubmit="return validatelogin()"> 
							<input type="text" id="username" name="username" Placeholder="用户名" required/>
							
							<input type="password" id="password" name="password" Placeholder="密码" required/>
				
							<input type="text" id="code" name="code" Placeholder="验证码" required autocomplete="off"  onclick="changeCode(this)"/>
							
							<img src="page/back/admin/img.jsp"/>
							<input type="submit" value="登录"/> 
						</form> 	
					</div> 
					<div class="login-agileits-bottom"> 
						<h6><a href="#">忘记密码了？</a></h6>
					</div> 

				</div>  
			</div>  
		</div>
		<!-- //login form -->
		
		<div class="login-agileits-bottom1"> 
			<h3>登录方式</h3>
		</div>
		
		<!-- social icons -->
		<div class="social_icons agileinfo">
			<ul class="top-links">
				<li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a></li>
				<li><a href="#" class="vimeo"><i class="fa fa-vimeo"></i></a></li>
			</ul>
		</div>
		<!-- //social icons -->
		
		<!-- copyright -->
		<div class="copyright">
			<p> Â© 2018 Exact Login Form. All rights reserved |<a href="http://w3layouts.com/" target="_blank"></a></p>
		</div>
		<!-- //copyright --> 
	</div>	
	<!-- //main -->
	
</body>
</html>