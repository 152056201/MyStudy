<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.yh.vo.*" %>
<%@page import="java.util.Iterator" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String inserturl = basePath+"page/back/admin/dept/dept_insert.jsp";
String updatePreurl = basePath+"page/back/admin/dept/DeptServlet/updatePre";
String deleteurl = basePath+"page/back/admin/dept/DeptServlet/delete";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>部门管理</title>
    
	
	
	<link rel="stylesheet" type="text/css" href="css/mldn.css">
	<script type="text/javascript" src="js/mldn.js"></script>
	

  </head>
  
 <body>
<%	
	List<Dept> all = (List<Dept>) request.getAttribute("allDepts");
	Iterator<Dept> iter = all.iterator();
 %>
 <table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="100%">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td width="5%"><input type="checkbox" id="selall" onclick="boxSelect(this,'deptno')"></td>
 		<td width="5%">部门编号</td>
 		<td width="25%">部门名称</td>
 		<td width="25%">部门位置</td>
 		<td width="10%">操作</td>
 	</tr>
 	<%
 		while(iter.hasNext()){
 			Dept vo = iter.next();
 			//System.out.print(vo.toString());
 		
 	 %>
 	 <tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td><input type="checkbox" id="deptno" name="deptno" value="<%=vo.getDeptno()%>"></td>
 		<td><%=vo.getDeptno() %></td>
 		<td><%=vo.getDname() %></td>
 		<td><%=vo.getLoc()%></td>
 		<td><a href="<%=updatePreurl%>?deptno=<%=vo.getDeptno()%>">修改</a></td>
 	</tr>
 	 <%
 	 	}
 	  %>
 	  <tr>
 	  	<td colspan="5">
 	  	<input type="button" value="删除部门信息" onclick="deleteAllP('<%=deleteurl%>','dno','deptno')">
 	  	<a href="<%=inserturl%>">返回</a>
 	  	</td>
 	  </tr>
 </table>
 </body>
</html>
