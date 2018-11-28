<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c"%>
<%  
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String inserturl = basePath + "page/back/admin/emp/EmpServlet/insert";
	String listurl = basePath+"page/back/admin/emp/EmpServlet/listSpilt";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script> 
    <base href="<%=basePath%>">  
    <title>雇员信息管理</title>
    <link rel="stylesheet" type="text/css" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/emp.js"></script>
</head>
<body>
 	<c:if test="emp" var="res">
 	<form action="<%=inserturl %>" method="post" onsubmit="return validateinsert()" enctype="multipart/form-data">
  		<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="70%">
  			<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this, '#F2F2F2')">
  				<td colspan="4"><span class="title">增加员工信息</span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td width="20%"><strong>雇员编号</strong></td>
   				<td width="20%"><input type="text" name="empno" id="empno" class="init" onblur="validateEmpno()"></td>
   				<td width="20%"><span id="empnoMsg"></span></td>
   				<td width="40%"><strong>雇员照片</strong></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员姓名</strong></td>
   				<td><input type="text" name="ename" id="ename" class="init" onblur="validateEname()"></td>
   				<td><span id="enameMsg"></span></td>
   				<td rowspan="9"><img src="" id="img0" height="200" width="250"></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员职位</strong></td>
   				<td><input type="text" name="job" id="job" class="init" onblur="validateJob()"></td>
   				<td><span id="jobMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员领导</strong></td>
   				<td>
   					<select name="mgr" id="mgr" class="init">
   						<option value="0">===选择领导===</option>
   						<c:if test="${allEmps!=null}" var="res">
   							<c:forEach items="${allEmps}" var="t_emp">
   								<option value="${t_emp.empno}">${t_emp.ename}</option>
   							</c:forEach>
   						</c:if>
   					</select>
   				</td>
   				<td><span id="mgrMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>入职时间</strong></td>
   				<td><input type="text" name="hiredate" id="hiredate" class="init" onblur="validateHiredate()"></td>
   				<td><span id="hiredateMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员工资</strong></td>
   				<td><input type="text" name="sal" id="sal" class="init" onblur="validateSal()"></td>
   				<td><span id="salMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员佣金</strong></td>
   				<td><input type="text" name="comm" id="comm" class="init" onblur="validateComm()"></td>
   				<td><span id="commMsg"></span></td>
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
   				<td><strong>雇员部门</strong></td>
   				<td>
   					<select name="dept" id="dept" class="init">
   						<option value="0">===选择部门===</option>
   						<c:if test="${allDepts!=null}" var="res">
   							<c:forEach items="${allDepts}" var="t_dept">
   								<option value="${t_dept.deptno}" ${t_dept.deptno==param.deptno?"selected":""}>${t_dept.dname}</option>
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
   					<textarea name="note" id="note" rows="" cols="" style="width: 650px;height: 200px;overflow: auto; resize:none;outline:none;"></textarea>
   				</td>
   				
   			</tr>
   			<tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
  				<td colspan="5">
  					<input type="submit" value="增加">
  					<input type="reset" value="重置">
  					<a href="<%=listurl%>">员工信息表</a>
  				</td>
   			</tr>
   			
  		</table>
  	</form>
  	</c:if>
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
