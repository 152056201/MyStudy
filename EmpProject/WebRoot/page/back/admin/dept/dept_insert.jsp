<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String inserturl = basePath + "page/back/admin/dept/DeptServlet/insert";
String listurl = basePath+"page/back/admin/dept/DeptServlet/list";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>雇员信息管理</title>
    <link rel="stylesheet" type="text/css" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/dept.js"></script>
	

  </head>
  
  <body>
  	<form action="<%=inserturl %>" method="post" onsubmit="return validateinsert()">
  		<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="50%">
  			<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this, '#F2F2F2')">
  				<td colspan="3"><span class="title">增加部门信息</span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>部门编号</strong></td>
   				<td width="45%"><input type="text" name="deptno" id="deptno" class="init" onblur="validateDeptno()"></td>
   				<td width="40%"><span id="deptnoMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>部门名称</strong></td>
   				<td width="45%"><input type="text" name="dname" id="dname" class="init" onblur="validateDname()"></td>
   				<td width="40%"><span id="dnameMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>部门位置</strong></td>
   				<td width="45%"><input type="text" name="loc" id="loc" class="init" onblur="validateLoc()"></td>
   				<td width="40%"><span id="locMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
  				<td colspan="3">
  					<input type="submit" value="增加">
  					<input type="reset" value="重置">
  					<a href="<%=listurl%>">部门信息表</a>
  				</td>
   			</tr>
  		</table>
  	</form>
    
  </body>
</html>
