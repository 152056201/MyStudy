<!-- 分页的搜索框 -->
<%@page pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%	String url = null;
	String columnDate = null;
	String keyword = null;
	int allRecorders = 0;
	String column = null; 
%>
<%
	try{
		allRecorders = (Integer)request.getAttribute("allRecorders");
	}catch(Exception e){}
		columnDate = (String)request.getAttribute("columnDate");
		keyword = (String)request.getAttribute("keyword");
		column = (String)request.getAttribute("column");
%>

请输入查询关键字：
<%
	if(columnDate!=null){
%>
<select id="colsel">
<%
	String result[] = columnDate.split(" ");
	for(int x = 0;x<result.length;x++){
		String temp[] = result[x].split(":");
%>		

	<option value="<%=temp[1]%>"<%=column.equals(temp[1])?"selected":""%>><%=temp[0] %></option>
<%	
	}
%>
</select>
<%
	}
%>
<input type="text" name="kw" id="kw" value="<%=keyword%>">

<input type="button" value="搜索" onclick="goSplit(1)">
<span>一共查询到：<%=allRecorders %>&nbsp;&nbsp;条记录</span><br>
