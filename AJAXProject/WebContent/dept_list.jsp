<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<script type="text/javascript" src="js/dept_list.js"></script>
<link type="text/css" rel="stylesheet" href="css/mldn.css">
<title>AJAX无刷新CRUD</title>
</head>
<body>
	<div id="deptInsert">
		<table>
			<tr>
				<td>部门编号：</td>
				<td>
					<input type="text" name="deptno" id="deptno" class="init" autocomplete="off">
				</td>
				<td><span id="deptnoMsg"></span></td>
			</tr>
			<tr>
				<td>部门名称：</td>
				<td>
					<input type="text" name="dname" id="dname" class="init" autocomplete="off">
				</td>
				<td><span id="dnameMsg"></span></td>
			</tr>
			<tr>
				<td>部门地点：</td>
				<td>
					<input type="text" name="loc" id="loc" class="init" autocomplete="off">
				</td>
				<td><span id="locMsg"></span></td>
			</tr>
			<tr>
				
				<td colspan="3">
					<input type="button" value="提交" id="addBut">
					<input type="button" value="重置" id="resetBut">
				</td>
				<td><span id="locMsg"></span></td>
			</tr>
		</table>
	</div>
	<div id="deptlist">
		<table	border="1" width="100%" id="deptTab">
			<tr id="dept-title">
				<td><input type="checkbox" id="selectAll"></td>
				<td>部门编号</td>
				<td>部门名称</td>
				<td>部门地点</td>
				<td>操作</td>
			</tr>
			
		</table>
		<input type="button" value="删除" id="deleteBut">
	</div>
</body>
</html>