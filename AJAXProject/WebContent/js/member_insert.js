window.onload = function(){
	document.getElementById("mid").addEventListener("blur",validateMid,false);
	document.getElementById("password").addEventListener("blur",validatePassword,false);
	document.getElementById("code").addEventListener("blur",validateCode,false);
	document.getElementById("subbut").addEventListener("click",validateInsert,false);
}
var xmlHttpServlet;
var codeFlag;
var midFlag;
function createXmlHttpRequest() {	
	if (window.ActiveXObject) {
		    xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
		    xmlHttpRequest = new XMLHttpRequest();
		}
		
}
function validateMid() {
	if(validateEmpty("mid")){
		var code = document.getElementById("mid").value;
		createXmlHttpRequest();//创建xmlHttpRequest对象
		//设置要提交的路径以及定义数据提交模式，而后使用地址重写
		xmlHttpRequest.open("post","MemberServlet/checkCode?code="+code);
		xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.status==200){//服务器处理正常
				if(xmlHttpRequest.readyState==4){//数据处理完成
					//返回的都是文本数据，必须按照字符串的方式进行比较
					midFlag = xmlHttpRequest.responseText=="true";
					var obj = document.getElementById("mid");
					var msg = document.getElementById("midMsg");
					alert(midFlag);
					if(midFlag==true){
						obj.className = "right";
						if(msg!=null){
							msg.innerHTML="<font color='green'> 该用户名可以注册 </font>"
						}
					}else{
						obj.className = "wrong";
						if(msg!=null){
							msg.innerHTML="<font color='red'> 用户名重复请重新输入！ </font>"
							
						}
					}
				}
				
			}
		};
		xmlHttpRequest.send(null);//发送请求
	}
}
function validatePassword() {
	return validateEmpty("password");
}
function validateCode() {
	if(validateEmpty("code")){
		var code = document.getElementById("code").value;
		createXmlHttpRequest();//创建xmlHttpRequest对象
		//设置要提交的路径以及定义数据提交模式，而后使用地址重写
		xmlHttpRequest.open("post","MemberServlet/checkMid?mid="+code);
		xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.status==200){//服务器处理正常
				if(xmlHttpRequest.readyState==4){//数据处理完成
					//返回的都是文本数据，必须按照字符串的方式进行比较
					codeFlag = xmlHttpRequest.responseText == "true";
					var obj = document.getElementById("code");
					var msg = document.getElementById("codeMsg");
					alert(codeFlag);
					if(codeFlag){
						obj.className = "right";
						if(msg!=null){
							msg.innerHTML="<font color='green'> 验证码输入正确！ </font>"
						}
					}else{
						obj.className = "wrong";
						if(msg!=null){
							msg.innerHTML="<font color='red'> 验证码输入错误！ </font>"
							
						}
					}
				}
				
			}
		};
		xmlHttpRequest.send(null);//发送请求
	}
}
function validateEmpty(eleName){
	var obj = document.getElementById(eleName);
	var msg = document.getElementById(eleName+"Msg");
	if(obj.value==""){
		obj.className = "wrong";
		if(msg!=null){
			msg.innerHTML="<font color='red'> 内容不允许为空！ </font>"
		}
		return false;
	}else{
		obj.className = "right";
		if(msg!=null){
			msg.innerHTML="<font color='green'> 内容输入正确！ </font>"
			document.getElementById("codeImg").src = "img.jsp?p="+Math.random(); 
		}
		return true;
	}
}
function validateRegex(eleName,regex){
	var obj = document.getElementById(eleName);
	var msg = document.getElementById(eleName+"Msg");
	if(!regex.test(obj.value)){
		obj.className = "wrong";
		if(msg!=null){
			msg.innerHTML="<font color='red'> 内容格式错误！ </font>"
		}
		return false;
	}else{
		obj.className = "right";
		if(msg!=null){
			msg.innerHTML="<font color='green'> 内容格式正确！ </font>"
		}
		return true;
	}
}
function validateInsert(){
	if(midFlag&&validatePassword()&&codeFlag){
		document.getElementById("memberForm").submit();
	}
}