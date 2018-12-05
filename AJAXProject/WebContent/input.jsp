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
<title>AJAX demo</title>
<script type="text/javascript">
	window.onload = function(){
		document.getElementById("sendbut").addEventListener("click",sendEcho,false);
	}
	// 声明的时候不能表示任何意义
	var xmlHttpRequest; //定义一个ajax核心处理对象
	// 一般都会定义一个操作函数，这个函数主要用户xmlHttpRequset对象实例化
	function createXmlHttpRequest() {	
		if (window.ActiveXObject) {
			    xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
			    xmlHttpRequest = new XMLHttpRequest();
		}
	}
	function sendEcho() {
		//取出输入的数据内容
		var info = document.getElementById("info").value;
		if(info != ""){
			createXmlHttpRequest();//创建xmlHttpRequest对象
			//设置要提交的路径以及定义数据提交模式，而后使用地址重写
			xmlHttpRequest.open("post","EchoServlet?msg="+info);
			xmlHttpRequest.onreadystatechange = sendEchoCallback;
			xmlHttpRequest.send(null);//发送请求
		}
		document.getElementById("info").value="";
	}
	function sendEchoCallback() { //ajax异步处理回调函数
		if(xmlHttpRequest.status==200){//服务器处理正常
			if(xmlHttpRequest.readyState==2||xmlHttpRequest.readyState==3){
				alert("请稍后，正在加载.......");
			}
			if(xmlHttpRequest.readyState==4){//数据处理完成
				var data= xmlHttpRequest.responseText;
				//所有回应数据都应该保存在"echoDiv"中
				var divElement = document.createElement("div");
				divElement.appendChild(document.createTextNode(data));
				document.getElementById("echoDiv").appendChild(divElement);
			}
		}
	}
</script>
</head>
<body>
	<div id="mydiv">
		<input type="text" name="info" id="info"/>
		<input type="button" id="sendbut" value="发送信息" />
	</div>
	<div id="echoDiv"></div>
</body>
</html>