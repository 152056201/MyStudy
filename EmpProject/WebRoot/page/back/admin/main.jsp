 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginUrl = basePath + "page/back/admin/check.jsp";
String dengUrl = basePath + "page/back/admin/html/index.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="page/back/admin/html/css/style1.css"/>
<title>界面</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
	<div class="all">
			<div class="head">
				<p>管理员:<%=session.getAttribute("username")==null?"":session.getAttribute("username")%>你好，感谢登录使用！</p>
			<button><a href="<%=dengUrl%>">退出</a></button>
			</div>
			<div class="section">
				<p class="se">后台管理系统</p>
			</div>
		</div>
		<div class="main">
			<div class="left">
				<ul>
					<li>网站基本信息</li>
					<li>作者：MLDN</li>
					<li>雇员信息</li>
					<li><a href="<%=basePath%>page/back/admin/emp/EmpServlet/list" target="main">雇员列表</a></li>
					<li><a href="<%=basePath%>page/back/admin/emp/EmpServlet/insertPre">雇员增加</a></li>
					<li><a href="<%=basePath%>page/back/admin/emp/emp_update.jsp">雇员修改</a></li>
					<li><a href="<%=basePath%>page/back/admin/emp/EmpServlet/listSplit">分页列表</a></li>
					<li><a href="<%=basePath%>page/back/admin/emp/EmpServlet/listDetail">详细列表</a></li>
					<li class="dept">部门信息</li>
					<li><a href="<%=basePath%>page/back/admin/dept/DeptServlet/list">部门列表</a></li>
					<li><a href="<%=basePath%>page/back/admin/dept/DeptServlet/listDetails">详细列表</a></li>
					<li>注册用户管理</li>
				</ul>
			</div>
			<div class="right">
				<h1>欢迎光临后台管理程序</h1>
				</div>
		</div>
</body>
</html>