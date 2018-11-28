<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<script src="./js/jquery.min.js"></script>
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
                <thead>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>出生日期</th>
                <th>籍贯</th>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
    <div id="footer">
        <h2>版权信息</h2>
    </div>
</div>
</body>
</html>