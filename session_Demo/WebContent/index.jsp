<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = basePath+"login";
String studenturl = basePath +"main2.jsp";
%>
<html>
  <head>
    <title>登录界面</title>
    <base href="<%=basePath%>">
  </head>
  <link rel="stylesheet" href="./css/index.css">
  <body>
  <div class="container">
    <div class="header">
    <h3>用户登录</h3>
    </div>
    <div class="body">
      <form action="<%=url%>" method="post">
        <div class="txt">
          <span>
            用户名:
            <input type="text" name="username" placeholder="请输入用户名">
          </span>
          <span>
            密码:
            <input type="password" name="password" placeholder="请输入密码">
          </span>

        </div>
        <hr>
        <div class="btn">
          <input type="submit" value="登录" class="login">
          <input type="button" value="注册" class="register">
        </div>
      </form>

    </div>
  </div>
  
  </body>
</html>
