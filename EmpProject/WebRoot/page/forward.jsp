<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+
		":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>forward页面</title>
</head>
<body>
<script type="text/javascript">
	alert("<%=request.getAttribute("msg")%>");
	window.location = "<%=basePath%><%=request.getAttribute("url")%>";
</script>
</body>
</html>