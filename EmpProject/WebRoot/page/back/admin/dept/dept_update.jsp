<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.yh.vo.*" %>
<%@page import="cn.yh.dao.factory.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String updateurl = basePath + "page/back/admin/dept/DeptServlet/update";
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
  <%
  		//接收地址重写传递进来的部门编号
  		
  		Dept vo = (Dept)request.getAttribute("dept");
  		if(vo!=null){
   %>
  	<form action="<%=updateurl %>" method="post" onsubmit="return validateupdate()">
  		<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="50%">
  			<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this, '#F2F2F2')">
  				<td colspan="3"><span class="title">部门信息编辑</span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>部门编号</strong></td>
   				<td width="45%"><span class="init"><%=vo.getDeptno() %></span></td>
   				<td width="40%"><span id="deptnoMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>部门名称</strong></td>
   				<td width="45%"><input type="text" name="dname" id="dname" class="init" onblur="validateDname()" value="<%=vo.getDname()%>"></td>
   				<td width="40%"><span id="dnameMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>部门位置</strong></td>
   				<td width="45%"><input type="text" name="loc" id="loc" class="init" onblur="validateLoc()" value="<%=vo.getLoc()%>"></td>
   				<td width="40%"><span id="locMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
  				<td colspan="4">
  					<!-- 如果此代码不写，意味着更新条件不存在 -->
  					<input type="hidden" id="deptno" name="deptno" value="<%=vo.getDeptno() %>">
  					<input type="submit" value="确认修改">
  					<input type="reset" value="重置">
  					<a href="<%=listurl%>">部门信息表</a>
  				</td>
   			</tr>
  		</table>
  	</form>
  	<%
  		}
  	 %>
    
  </body>
</html>
