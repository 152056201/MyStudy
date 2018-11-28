<%@page import="cn.yh.dao.factory.ServiceFactory"%>
<%@page import="cn.yh.dao.factory.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.yh.vo.*" %>
<%@page import="java.util.*"%>
<%@page import="cn.yh.service.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>学生信息</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	List<Student> list = ServiceFactory.getIStudentService().list();
	
%>
<body>
<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="100%">
	<tr>
 		<td width="5%"></td>
 		<td width="10%"><strong>学生学号</strong></td>
 		<td width="15%"><strong>学生姓名</strong></td>
 		<td width="15%"><strong>学生性别</strong></td>
 		<td width="15%"><strong>学生生日</strong></td>
 		<td width="15%"><strong>手机号</strong></td>
 		<td width="15%"><strong>学生住址</strong></td>
 	</tr>
 	
 <%
 	Iterator<Student> ite = list.iterator();
 	while(ite.hasNext()){
 		Student s = ite.next();
 %>
	<tr>
 		<td width="5%"></td>
 		<td width="10%"><strong><%=s.getNum() %></strong></td>
 		<td width="15%"><strong><%=s.getName() %></strong></td>
 		<td width="15%"><strong><%=s.getGander() %></strong></td>
 		<td width="15%"><strong><%=s.getBirth() %></strong></td>
 		<td width="15%"><strong><%=s.getPhone() %></strong></td>
 		<td width="15%"><strong><%=s.getAddress() %></strong></td>
 	</tr>
<%
 }
%>	
</table>

</body>
</html>