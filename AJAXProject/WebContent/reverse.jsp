<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>反向AJAX</title>
<script type="text/javascript">
	var count = 2; 
	window.onload = function(){
		document.getElementById("sendBut").addEventListener("click",function(){
			var msg = document.getElementById("msg").value;
			loadDate(msg);
			count = 2;
			
		},false);
		
	}
	var xmlHttpRequest; //定义一个ajax核心处理对象
	// 一般都会定义一个操作函数，这个函数主要用户xmlHttpRequset对象实例化
	function createXmlHttpRequest() {	
		if (window.ActiveXObject) {
			    xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
			    xmlHttpRequest = new XMLHttpRequest();
		}
	}
	function loadDate(msg){
		createXmlHttpRequest();
		xmlHttpRequest.open("post","ReverseServlet?msg="+msg);
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.status==200){
				if(xmlHttpRequest.readyState==4){
					if(count>0){
						var divElement = document.createElement("div");
						divElement.appendChild(document.createTextNode(xmlHttpRequest.responseText));
						document.getElementById("contentDiv").appendChild(divElement);
						window.setTimeout("loadDate('啦啦啦啦啦')",2);
						
						count--;
					}
					
			}
				
		};
		xmlHttpRequest.send(null);
	}
	}
</script>
</head>
<body>
	<div id="inputDiv">
			请输入数据:<input type="text" name="msg" id="msg" autocomplete="off">
			<input type="button" value="发送" id="sendBut">
		</div>
	<div id="contentDiv" style="height: 800px;border: 1px solid;">
		
	</div>
	
	
</body>
</html>