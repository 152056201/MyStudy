<%@page import="cn.yh.factory.ServiceFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.yh.vo.*" %>
<%@page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<script type="text/javascript" src="js/city.js"></script>
<title>联级菜单</title>
</head>
<body>
	<div>
		省份:<select id="pid">
				<option value="0">===========请选择省份===========</option>
				<%
					List<Provinces> list = (List<Provinces>)request.getAttribute("allPros");
					Iterator<Provinces> ite = list.iterator();
					while(ite.hasNext()){
						Provinces vo = ite.next();
				%>
					<option value="<%=vo.getPid()%>"><%=vo.getTitle() %></option>
				<%		
					}
				%>
			</select>
		城市:<select id="cid">
				<option value="0">===========请选择城市===========</option>
			</select>
	</div>
</body>
</html>