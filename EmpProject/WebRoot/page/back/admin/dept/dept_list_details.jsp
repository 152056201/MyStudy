<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.yh.vo.*" %>
<%@page import="cn.yh.dao.factory.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String inserturl = basePath+"page/back/admin/dept/dept_insert.jsp";
String updatePreurl = basePath+"page/back/admin/dept/dept_update.jsp";
String deleteurl = basePath+"page/back/admin/dept/dept_delete_do.jsp";
String empinsert = basePath+"page/back/admin/emp/emp_insert.jsp";
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
	
	List<Dept> all = (List<Dept>)request.getAttribute("allDepts");
	
	Iterator<Dept> iter = all.iterator();
 %>
 <table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="100%">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td width="10%"><strong>部门编号</strong></td>
 		<td width="15%"><strong>部门名称</strong></td>
 		<td width="15%"><strong>部门位置</strong></td>
 		<td width="10%"><strong>部门人数</strong></td>
 		<td width="10%"><strong>总工资</strong></td>
 		<td width="10%"><strong>平均工资</strong></td>
 		<td width="10%"><strong>最高工资</strong></td>
 		<td width="10%"><strong>最低工资</strong></td>
 		<td width="10%"><strong>操作</strong></td>
 		
 	</tr>
 	<%
 		while(iter.hasNext()){
 			Dept vo = iter.next();
 			//System.out.print(vo.toString());
 		
 	 %>
 	 <tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td><%=vo.getDeptno() %></td>
 		<td><%=vo.getDname() %></td>
 		<td><%=vo.getLoc()%></td>
 		<td><%=vo.getStat().get("count") %></td>
 		<td><%=vo.getStat().get("sum")%></td>
 		<td><%=vo.getStat().get("avg")%></td>
 		<td><%=vo.getStat().get("max")%></td>
 		<td><%=vo.getStat().get("min")%></td>
 		<td width="10%"><a href="<%=empinsert%>?deptno=<%=vo.getDeptno()%>">增加雇员</a></td>
 	</tr>
 	 <%
 	 	}
 	  %>
 	  
 </table>
 </body>
</html>
