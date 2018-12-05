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
<script type="text/javascript" src="js/emp.js"></script>
<title></title>
</head>
<body>
	<div>
		<table border="1"  id="empDiv">
			<tr>
				<td>雇员编号</td>
				<td>雇员名称</td>
				<td>雇员职位</td>
			</tr>
		</table>
	</div>
</body>
</html>