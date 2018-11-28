<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String updateurl = basePath + "page/back/admin/emp/EmpServlet/update";
String listurl = basePath+"page/back/admin/emp/EmpServlet/listSplit";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>雇员信息管理</title>
    <link rel="stylesheet" type="text/css" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/emp.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>

  </head>
  
  <body>
 
  	<form action="<%=updateurl %>" method="post" onsubmit="return validateupdate()">
  		<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="50%">
  			<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this, '#F2F2F2')">
  				<td colspan="4"><span class="title">雇员信息编辑</span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>雇员编号</strong></td>
   				<td width="20%"><span class="init">${emp.empno}</span></td>
   				<td width="20%"><span id="empnoMsg"></span></td>
   				<td width="40%"><strong>雇员照片</strong></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员姓名</strong></td>
   				<td><input type="text" name="ename" id="ename" class="init" onblur="validateEname()" value="${emp.ename}"></td>
   				<td><span id="enameMsg"></span></td>
   				<td rowspan="9"><img src="upload/${emp.photo}" id="img0" height="200" width="250"></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员职位</strong></td>
   				<td><input type="text" name="job" id="job" class="init" onblur="validateJob()" value="${emp.job}"></td>
   				<td><span id="jobMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员领导</strong></td>
   				<td>
   					<select name="mgr" id="mgr" class="init">
   						<c:if test="${allEmps!=null}" var="res">
   							<c:forEach items="${allEmps}" var="t_emp">
   								<option value="${t_emp.empno}" ${emp.mgr.empno==t_emp.empno?"selected":""}>${t_emp.ename}</option>
   							</c:forEach>
   						</c:if>
   					</select>
   				</td>
   				<td><span id="mgrMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>入职时间</strong></td>
   				<td><input type="text" name="hiredate" id="hiredate" class="init" onblur="validateHiredate" value="${emp.hiredate}"></td>
   				<td><span id="hiredateMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员工资</strong></td>
   				<td><input type="text" name="sal" id="sal" class="init" onblur="validateSal()" value="${emp.sal}"></td>
   				<td><span id="salMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员佣金</strong></td>
   				<td><input type="text" name="comm" id="comm" class="init" onblur="validateComm()" value="${emp.comm}"></td>
   				<td><span id="commMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员部门</strong></td>
   				<td>
   					<select name="deptno" id="deptno" class="init">
   						<option value="0">===选择部门===</option>
   						<c:if test="${allDepts!=null}" var="res">
   							<c:forEach items="${allDepts}" var="t_dept">
   								<option value="${t_dept.deptno}" ${t_dept.deptno==emp.dept.deptno?"selected":""}>${t_dept.dname}</option>
   							</c:forEach>
   						</c:if>
   					</select>
   				</td>
   				<td><span id="deptnoMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员照片</strong></td>
   				<td><input type="file" name="photo" id="photo" class="init"></td>
   				<td><span id="photoMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员简介</strong></td>
   				<td colspan="2"></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td colspan="6">
   					<textarea name="note" id="note" rows="" cols="" style="width: 650px;height: 200px;overflow: auto; resize:none;outline:none;">
   						${emp.note}
   					</textarea>
   				</td>
   				
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
  				<td colspan="6">
  					<!-- 如果此代码不写，意味着更新条件不存在 -->
  					<input type="hidden" id="empno" name="empno" value="${emp.empno}">
  					<input type="hidden" id="oldpic" name="oldpic" value="${emp.photo}"> <!-- 旧的图片名称 -->
  					<input type="hidden" id="backurl" name="backurl" value="<%=request.getParameter("backurl")%>">
  					<input type="hidden" id="cp" name="cp" value="<%=request.getParameter("cp")%>">
  					<input type="hidden" id="ls" name="ls" value="<%=request.getParameter("ls")%>">
  					<input type="hidden" id="col" name="col" value="<%=request.getParameter("col")%>">
  					<input type="hidden" id="kw" name="kw" value="<%=request.getParameter("kw")%>">
  					<input type="hidden" id="backdeptno" name="backdeptno" value="<%=request.getParameter("deptno")%>">
  					<input type="submit" value="确认修改">
  					<input type="reset" value="重置">
  					<a href="<%=listurl%>">雇员信息表</a>
  				</td>
   			</tr>
  		</table>
  	</form>
  
<script>   
$("#photo").change(function(){  
		 var objUrl = getObjectURL(this.files[0]) ;//获取文件信息  
		 console.log("objUrl = "+objUrl);  
		  if (objUrl) {  
		  $("#img0").attr("src", objUrl);  
		 }   
}) ;  
function getObjectURL(file) {  
		 var url = null;   
		 if (window.createObjectURL!=undefined) {  
		  url = window.createObjectURL(file) ;  
		 } else if (window.URL!=undefined) { // mozilla(firefox)  
		  url = window.URL.createObjectURL(file) ;  
		 } else if (window.webkitURL!=undefined) { // webkit or chrome  
		  url = window.webkitURL.createObjectURL(file) ;  
		 }  
		 return url ;  
		}  
</script>  
  </body>
</html>
