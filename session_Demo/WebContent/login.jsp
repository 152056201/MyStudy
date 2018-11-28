<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = basePath+"login.jsp";
String studenturl = basePath +"student.jsp";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>注册界面</title>
</head>
<body>
	<form action="<%=url%>" method="post">
		用户名：<input type="text" name="username"><br>
		密&nbsp;&nbsp;&nbsp;&nbsp;码  :<input type="password" name="password"><br>
		<input type="submit" value="提交">
		<input type="reset" value="重置">
	</form>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if(!(username==null||password==null)){
	if("yuanhao".equals(username)&&"yh123".equals(password)){
		session.setAttribute("uid", username);//保存session属性
		
		response.setHeader("refresh", "2;URL=student.jsp");
%>
	<h3>登陆成功！</h3>
	<h3>2秒后跳转到首页，如果没有跳转请按<a href="<%=studenturl%>">这里</a></h3>
<%		
	}else{
%>
	<h3>登陆失败，错误的用户名或密码</h3>
<%
	}
	
}
%>
</body>
</html>