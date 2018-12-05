<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String insertUrl = basePath + "MemberServlet/insert";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/mldn.css">
<script type="text/javascript" src="js/member_insert.js"></script>
<title>注册页</title>
</head>
<body>
	<div class="title">用户注册</div>
	<div id="formDiv">
		<form action="<%=insertUrl%>" method="post" id="memberForm">
			<table border="1" width="100%">
				<tr>
					<td width="20%">
						用户ID
					</td>
					<td width="30%">
						<input type="text" name="mid" id="mid" class="init" autocomplete="off"/>
					</td>
					<td width="60%">
						<span id="midMsg"></span>
					</td>
				</tr>
				<tr>
					<td>
						密码
					</td>
					<td>
						<input type="password" name="password" id="password" class="init"/>
					</td>
					<td>
						<span id="passwordMsg"></span>
					</td>
				</tr>
				<tr>
					<td>
						验证码
					</td>
					<td>
						<input type="text" name="code" id="code" size="4" maxlength="4" class="init" autocomplete="off"/>
						<img src="img.jsp" id="codeImg"/>
					</td>
					<td>
						<span id="codeMsg"></span>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="button" value="注册" id="subbut">
						<input type="reset" value="重置" >
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>