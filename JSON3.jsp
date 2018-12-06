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
	var data = "{\"dname\":\"开发部\",\"people\":22,\"emps\":[{\"ename\":\"名字0\",\"job\":\"工作0\"},{\"ename\":\"名字1\",\"job\":\"工作1\"},{\"ename\":\"名字2\",\"job\":\"工作2\"}]}";//这是一个对象
	var obj = eval("("+data+")");
	alert("部门名称："+obj.dname);
	alert("部门人数："+obj.people);
	for(var x=0;x<obj.emps.length;x++){
		alert(obj.emps[x].ename+","+obj.emps[x].job);
	}
</script>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>json_Demo</title>
</head>
<body>
</body>
</html>