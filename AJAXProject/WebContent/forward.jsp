<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>跳转页</title>
</head>
<body>
<script type="text/javascript">
	window.alert("${msg}");
	window.location = "<%=basePath%>${url}";
</script>
</body>
</html>