<%@page import="java.util.Iterator"%>
<%@page import="cn.yh.dao.factory.ServiceFactory"%>
<%@page import="cn.yh.dao.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.yh.vo.*" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page import ="java.util.Date" %>
<%@page import="java.text.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String deleteUrl = basePath + "page/back/admin/emp/emp_delete_do.jsp";
String updateUrl = basePath + "page/back/admin/emp/emp_update.jsp";
String insertUrl = basePath + "page/back/admin/emp/emp_insert.jsp";
String showUrl = basePath +"page/back/admin/emp/emp_show.jsp";
String DeptshowUrl = basePath +"page/back/admin/dept/dept_show.jsp";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/mldn.css">
<script type="text/javascript" src="js/mldn.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员信息</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	String url = basePath + "page/back/admin/dept/dept_show.jsp";
	int currentpage = 1;
	int linesize = 5;
	String keyword="";//设置查询关键字
	int allRecorders = 0;//保存总记录数
	int pagesize = 0;//保存总页数
	String column = "ename";//设置默认查询列
	int lsDate[] = new int[]{1,5,10,15,20,25,30,35};//控制下拉列表显示数据量
	String columnDate = "编号:empno 姓名:ename 工作:job"; 
	String paramName = request.getParameter("paramName");
	String paramValue = request.getParameter("paramValue");
%>
<%
	try{
		//如果没有传入参数那么就会是null，null无法变为数字
		currentpage = Integer.parseInt(request.getParameter("cp"));
	}catch(Exception e){}
	try{
		linesize = Integer.parseInt(request.getParameter("ls"));
	}catch(Exception e){}
	if(request.getParameter("kw")!=null){
		//表示有查询关键字
		keyword = request.getParameter("kw");
	}
	if(request.getParameter("col")!=null){
		column = request.getParameter("col");
	}
%>

<%	
	
	Dept dept = ServiceFactory.getIDeptService().show(deptno, currentpage, linesize, column, keyword);
	List<Emp> list = dept.getEmps();//查询全部雇员
	allRecorders = (Integer)dept.getStat().get("count");
%>
<h1>部门基础信息</h1>
<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="100%">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td width="10%"><strong>部门编号</strong></td>
 		<td width="15%"><strong>部门名称</strong></td>
 		<td width="15%"><strong>部门位置</strong></td>
 		<td width="10%"><strong>部门人数</strong></td>
 		<td width="10%"><strong>总工资</strong></td>
 		<td width="10%"><strong>平均工资</strong></td>
 		<td width="10%"><strong>最高工资</strong></td>
 		<td width="10%"><strong>最低工资</strong></td>
 	</tr>
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td><%=dept.getDeptno() %></td>
 		<td><%=dept.getDname() %></td>
 		<td><%=dept.getLoc()%></td>
 		<td><%=dept.getStat().get("count") %></td>
 		<td><%=dept.getStat().get("sum")%></td>
 		<td><%=dept.getStat().get("avg")%></td>
 		<td><%=dept.getStat().get("max")%></td>
 		<td><%=dept.getStat().get("min")%></td>
 	</tr>
 	
</table>
<hr>
<div id="searchdiv">
	<jsp:include page="/page/split_page_plugin_search.jsp">
		<jsp:param value="<%=columnDate%>" name="columnDate"/>
		<jsp:param value="<%=keyword%>" name="keyword"/>
		<jsp:param value="<%=allRecorders%>" name="allRecorders"/>
		<jsp:param value="<%=column%>" name="column"/>
	</jsp:include>
</div><br>
<div id="bardiv">
	<jsp:include page="/page/spilt_page_plugin_bar.jsp">
		<jsp:param value="<%=currentpage%>" name="currentpage"/>
		<jsp:param value="<%=linesize%>" name="linesize"/>
		<jsp:param value="<%=column%>" name="column"/>
		<jsp:param value="<%=keyword%>" name="keyword"/>
		<jsp:param value="<%=allRecorders%>" name="allRecorders"/>
		<jsp:param value="<%=url%>" name="url"/>
		<jsp:param value="deptno" name="paramName"/>
		<jsp:param value="<%=deptno%>" name="paramValue"/>
	</jsp:include>
</div>
<div id="dataList">	
<table border="1" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2" width="100%">
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td width="5%"><input type="checkbox" id="selall" onclick="boxSelect(this,'empno')"></td>
 		<td width="10%"><strong>雇员编号</strong></td>
 		<td width="10%"><strong>雇员姓名</strong></td>
 		<td width="10%"><strong>雇员职位</strong></td>
 		<td width="10%"><strong>领导</strong></td>
 		<td width="15%"><strong>雇佣日期</strong></td>
 		<td width="10%"><strong>雇员工资</strong></td>
 		<td width="10%"><strong>雇员佣金</strong></td>
 		<td width="5%"><strong>部门</strong></td>
 		<td width="5%"><strong>操作</strong></td>
 	</tr>
 	<%
 		Iterator<Emp> ite = list.iterator();
 		while(ite.hasNext()){
 			Emp vo = ite.next();
 	%>
 	<tr onmouseover="changeColor(this,'#FFFFFF')"  onmouseout="changeColor(this,'#F2F2F2')">
 		<td><input type="checkbox" id="empno" name="empno" value=<%=vo.getEmpno() %>></td>
 		<td><%=vo.getEmpno() %></td>
 		<td><a href="<%=showUrl%>?empno=<%=vo.getEmpno()%>"><%=vo.getEname() %></a></td>
 		<td><%=vo.getJob() %></td>
 		<td><a href="<%=showUrl%>?empno=<%=vo.getMgr().getEmpno()%>"><%=vo.getMgr().getEname()==null?"" : vo.getMgr().getEname()%></a></td>
 		<td><%=vo.getHiredate() %></td>
 		<td><%=vo.getSal() %></td>
 		<td><%=vo.getComm() %></td>
 		<td><a href="<%=DeptshowUrl%>?deptno=<%=vo.getDept().getDeptno()%>"><%=vo.getDept().getDname()==null?"":vo.getDept().getDname() %></a></td>
 		<td><a href="<%=updateUrl%>?empno=<%=vo.getEmpno()%>&backurl=<%=url%>&cp=<%=currentpage%>&ls=<%=linesize%>&col=<%=column%>&kw=<%=keyword%>">修改</a></td>
 		</tr>
 	<%
 		}
 	%>
 </table>
 <div>
 	<input type="button" value = "删除雇员数据" onclick="deleteAll('<%=deleteUrl%>?backurl=<%=url%>&cp=<%=currentpage%>&ls=<%=linesize%>&col=<%=column%>&kw=<%=keyword%>','eno','empno')">
 	<a href="<%=insertUrl%>">增加雇员数据</a>
 </div>
 </div>
</body>
</html>