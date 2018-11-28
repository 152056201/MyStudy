<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String deleteUrl = basePath + "page/back/admin/emp/EmpServlet/delete";
String updateUrl = basePath + "page/back/admin/emp/EmpServlet/updatePre";
String insertUrl = basePath + "page/back/admin/emp/EmpServlet/insertPre";
String showUrl = basePath +"page/back/admin/emp/EmpServlet/show";
String DeptshowUrl = basePath +"page/back/admin/dept/DeptServlet/show";
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/mldn.css">
<script type="text/javascript" src="js/mldn.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员信息</title>
</head>
<body>
<h1>雇员列表</h1>
<div id="searchdiv">
	<jsp:include page="/page/split_page_plugin_search.jsp"/>
</div><br>
<div id="bardiv">
	<jsp:include page="/page/spilt_page_plugin_bar.jsp"/>
</div>
<div id="dataList">	
<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="100%">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td width="5%"><input type="checkbox" id="selall" onclick="boxSelect(this,'empno')"></td>
 		<td width="10%"><strong>雇员编号</strong></td>
 		<td width="10%"><strong>雇员姓名</strong></td>
 		<td width="10%"><strong>雇员职位</strong></td>
 		<td width="10%"><strong>领导</strong></td>
 		<td width="15%"><strong>雇佣日期</strong></td>
 		<td width="10%"><strong>雇员工资</strong></td>
 		<td width="10%"><strong>雇员佣金</strong></td>
 		<td width="5%"><strong>部门</strong></td>
 		<td width="5%"><strong>操作</strong></td>
 	</tr>
 	<c:if test="${allEmps!=null }" var="res">
 	<c:forEach items="${allEmps}" var="t_emp">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td><input type="checkbox" id="empno" name="empno" value="${t_emp.empno}:${t_emp.photo}"></td>
 		<td>${t_emp.empno}</td>
 		<td><a href="<%=showUrl%>?empno=${t_emp.empno}">${t_emp.ename}</a></td>
 		<td>${t_emp.job}</td>
 		<td><a href="<%=showUrl%>?empno=${t_emp.mgr.empno}">${t_emp.mgr.ename}</a></td>
 		<td>${t_emp.hiredate}</td>
 		<td>${t_emp.sal}</td>
 		<td>${t_emp.comm}</td>
 		<td><a href="<%=DeptshowUrl%>?deptno=${t_emp.dept.deptno}">${t_emp.dept.dname}</a></td>
 		<td><a href="<%=updateUrl%>?empno=${t_emp.empno}&backurl=${url}&cp=${currentpage}&ls=${linesize}&col=${column}&kw=${keyword}">修改</a></td>
 		</tr>
 		</c:forEach>
 	</c:if>
 </table>
 <div>
 	<input type="button" value = "删除雇员数据" onclick="deleteAll('<%=deleteUrl%>?backurl=${url}&cp=${currentpage}&ls=${linesize}&col=${column}&kw=${keyword}','eno','empno')">
 	<a href="<%=insertUrl%>">增加雇员数据</a>
 </div>
 </div>
</body>
</html>