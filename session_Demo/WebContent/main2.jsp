<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/index1.css">
<script src="js/index.js"></script>
<body>

<div id="container">

    <div id="header">
        <h2>学生信息管理系统</h2>
    </div>
    <div id="nav">
        <h3>首页</h3>
        <h3>学生信息管理</h3>
    </div>
    <div id="body">
        <div class="menu">
            <ul>
                <h4>信息管理</h4>
                <li>学生信息管理</li>
                <li>班级信息管理</li>
                <li>宿舍信息管理</li>
            </ul>
            <ul>
                <h4>数据报表</h4>
                <li>学生信息报表</li>
                <li>班级信息报表</li>
                <li>宿舍信息报表</li>
            </ul>
        </div>
        <div class="whitespace"></div>
        <div class="main">
            <div class="btn">
                <input type="button" value="浏览">
                <input type="button" value="新增">
            </div>
            
            <table border="0" cellspacing="0">
            
                <tr>
                <td>学生学号</td>
                <td>学生姓名</td>
                <td>学生性别</td>
                <td>出生日期</td>
                <td>手机号</td>
                <td>学生住址</td>
                </tr>
                <c:if test="${allStudents!=null}" var="res">
                <c:forEach items="${allStudents}" var="stu">
                <tr>
                    <td>${stu.num}</td>
				 	<td>${stu.name}</td>
				 	<td>${stu.gander}</td>
				 	<td>${stu.birth}</td>
				 	<td>${stu.phone}</td>
				 	<td>${stu.address}</td>
				 </tr>
			</c:forEach>
    		</c:if>
</table>

        </div>
    </div>
    <div id="footer">
        <h2>版权信息</h2>
    </div>
</div>
</body>
</html>