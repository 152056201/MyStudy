<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	var obj = {"name":"袁浩","age":22,"gander":"男"};//这是一个对象
	alert("姓名："+obj.name);
	alert("年龄："+obj.age);
	alert("性别："+obj.gander);
</script>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>json_Demo</title>
</head>
<body>
</body>
</html>