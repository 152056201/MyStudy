<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String showUrl = basePath +"page/back/admin/emp/EmmpServlet/show";
String spliturl = basePath+"page/back/admin/emp/EmpServlet/listSplit";
String DeptshowUrl = basePath +"page/back/admin/dept/DeptServlet/show";
String url = basePath + "page/back/admin/emp/emp_list_detail.jsp";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>雇员信息管理</title>
    <link rel="stylesheet" type="text/css" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/emp.js"></script>
	

  </head>
  
  <body>
  <c:if test="${emp!=null}" var="res">
  	
  		<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="50%">
  			<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this, '#F2F2F2')">
  				<td colspan="3"><span class="title">雇员信息编辑</span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="15%"><strong>雇员编号</strong></td>
   				<td width="45%"><span class="init">${emp.empno}</span></td>
   				<td width="40%"><strong>雇员照片</strong></td>
   			</tr>
   			
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="15%"><strong>雇员姓名</strong></td>
   				<td width="45%">${emp.ename}</td>
   				<td width="45%" rowspan="9"><img src="upload/${emp.photo}" width="200" height="170"/></td>
   				
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>雇员职位</strong></td>
   				<td width="45%">${emp.job}</td>
   					
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>入职时间</strong></td>
   				<td width="45%">${emp.hiredate}</td>
   				
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>雇员领导</strong></td>
   				<td width="45%"><a href="<%=showUrl%>?empno=${emp.mgr.empno}">${emp.mgr.ename}</a></td>
   				
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>雇员工资</strong></td>
   				<td width="45%">${emp.sal }</td>
   				
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>雇员佣金</strong></td>
   				<td width="45%">${emp.comm }</td>
   				
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>部门</strong></td>
   				<td width="45%"><a href="<%=DeptshowUrl%>?deptno=${emp.dept.deptno}">${emp.dept.dname}</a></td>
   				
   			</tr>
   			
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td  width="20%"><strong>雇员简介</strong></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td colspan="2" height="60px">${emp.note}</td>
   			</tr>
  		</table>
  		
  	
  </c:if>
   <a href="<%=spliturl%>"><input type="button" value="返回"/></a>
  </body>
</html>
