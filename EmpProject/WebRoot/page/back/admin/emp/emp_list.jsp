<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String deleteUrl = basePath + "page/back/admin/emp/EmpServlet/delete";
String updateUrl = basePath + "page/back/admin/emp/EmpServlet/updatePre";
String insertUrl = basePath + "page/back/admin/emp/EmpServlet/insertPre";
String backUrl = basePath + "page/back/admin/emp/EmpServlet/list";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
<link rel="stylesheet" type="text/css" href="css/mldn.css">
<script type="text/javascript" src="js/mldn.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员信息</title>
</head>
<body>
<h1>雇员列表</h1>
<div id="dataList">	
<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="100%">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td width="5%"><input type="checkbox" id="selall" onclick="boxSelect(this,'empno')"></td>
 		<td width="10%"><strong>雇员编号</strong></td>
 		<td width="15%"><strong>雇员姓名</strong></td>
 		<td width="15%"><strong>雇员职位</strong></td>
 		<td width="15%"><strong>雇佣日期</strong></td>
 		<td width="15%"><strong>雇员工资</strong></td>
 		<td width="15%"><strong>雇员佣金</strong></td>
 		<td width="10%"><strong>操作</strong></td>
 	</tr>
 	<c:if test="${allEmps!=null}" var="res">
 	<c:forEach items="${allEmps}" var="t_emp">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td><input type="checkbox" id="empno" name="empno" value="${t_emp.empno}" ></td>
 		<td>${t_emp.empno}</td>
 		<td>${t_emp.ename}</td>
 		<td>${t_emp.job}</td>
 		<td>${t_emp.hiredate}</td>
 		<td>${t_emp.sal}</td>
 		<td>${t_emp.comm}</td>
 		<td><a href="<%=updateUrl%>?empno=${t_emp.empno}&backurl=<%=backUrl%>">修改</a></td>
 	</tr>
 	</c:forEach>
 	</c:if>
 </table>
 <div>
 	<input type="button" value = "删除雇员数据" onclick="deleteAll('<%=deleteUrl%>?backurl=<%=backUrl%>','eno','empno')">
 	<a href="<%=insertUrl%>">增加雇员数据</a>
 </div>
 </div>
</body>
</html>