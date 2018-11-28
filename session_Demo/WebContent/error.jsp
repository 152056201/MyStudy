<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>验证错误页面</title>
</head>
<body>
<h1>对不起出现错误，请与管理员联系</h1>
<script type="text/javascript">
	window.location = "<%=basePath%><%=request.getAttribute("page/back/admin/html/index.jsp")%>";
</script>
</body>
</html>