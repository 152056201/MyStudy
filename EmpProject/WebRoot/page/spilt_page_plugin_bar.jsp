<!-- 分页控制条 -->
<%@page pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%	
	String url = null;
	int currentpage = 1;
	int linesize = 5;
	String column = null;
	String keyword =null;
	int allRecorders = 0;
	int pagesize = 0;
	int lsDate[] = new int[]{1,5,10,15,20,25,30,35};//控制下拉列表显示数据量
	String paramName = request.getParameter("paramName");
	String paramValue = request.getParameter("paramValue");
%>
<%
	
	//接受传递的参数
	try{
		currentpage = (Integer)request.getAttribute("currentpage");
	}catch(Exception e){}
	try{
		allRecorders = (Integer)request.getAttribute("allRecorders");
	}catch(Exception e){}
	try{
		linesize = (Integer)request.getAttribute("linesize");
	}catch(Exception e){}
	
	column = (String)request.getAttribute("column");
	
	keyword = (String)request.getAttribute("keyword");
	url = (String)request.getAttribute("url");
%>
<%
	//对数据处理
	if(allRecorders>0){
		pagesize = (allRecorders+linesize-1) / linesize;
	}else{
		pagesize = 1;
	}
%>
<script type="text/javascript">
	function goSplit(vcp){
		var eles = document.getElementById("lsall").value;
		/* var cpsel = document.getElemetById("cpsel").value; */
		try{
			var kwle = document.getElementById("kw").value;
			var colel = document.getElementById("colsel").value;
			window.location = "<%=url %>?cp=" + vcp +"&ls=" + eles+ "&kw="+kwle+"&col=" + colel+"&<%=paramName%>=<%=paramValue%>" ;
		}catch(Exception){
			window.location = window.location = "<%=url %>?cp=" + vcp +"&ls=" + eles +"&<%=paramName%>=<%=paramValue%>" ;
		}
		
	}
</script>


<input type="button" value="首页" onclick="goSplit(1)" <%=currentpage==1?"disabled":"" %>>
<input type="button" value="上一页" onclick="goSplit(<%=currentpage-1%>)" <%=currentpage==1?"disabled":"" %>>
<input type="button" value="下一页" onclick="goSplit(<%=currentpage+1%>)" <%=currentpage==pagesize?"disabled":"" %>>
<input type="button" value="尾页" onclick="goSplit(<%=pagesize%>)" <%=currentpage==pagesize?"disabled":"" %>>
跳转到：<select id="cpsel" onchange="goSplit(this.value)">
	<%
		for(int x= 1; x<pagesize+1;x++){
	
	%>
		<option value="<%=x%>" <%=currentpage==x? "selected":"" %>><%=x%></option>
	<%
		}
	%>
</select>页&nbsp;&nbsp;
每页显示：<select id="lsall" onchange="goSplit(1)">
	<% 
		for(int x= 0;x<lsDate.length;x++){
			
	%>
		<option value="<%=lsDate[x]%>" <%=linesize==lsDate[x]?"selected":"" %>><%=lsDate[x] %></option>
			
	<%
		}
	%>
</select>行