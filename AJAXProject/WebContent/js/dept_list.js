var xmlHttpRequest;
var deptnoFlag = false;
window.onload = function() {
	document.getElementById("deptno").addEventListener("blur",validateDeptno,false);
	document.getElementById("dname").addEventListener("blur",validateDname,false);
	document.getElementById("loc").addEventListener("blur",validateLoc,false);
	document.getElementById("resetBut").addEventListener("click",resetForm,false);
	document.getElementById("addBut").addEventListener("click",addForm,false); 
	document.getElementById("selectAll").addEventListener("click",seleAll,false); 
	document.getElementById("deleteBut").addEventListener("click",deleteRow,false); 
	loadDeptDate();
}
function createXmlHttpRequest() {	
	if (window.ActiveXObject) {
		    xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
		    xmlHttpRequest = new XMLHttpRequest();
	}
}

function resetForm() {
	var inputElement = document.getElementsByTagName("input");
	for(var x= 0;x<inputElement.length;x++){
		if(inputElement[x].getAttribute("type")=="text"){
			inputElement[x].value="";
			inputElement[x].className="init";
			document.getElementById(inputElement[x].id+"Msg").innerHTML="";
		}
		
	}
}

function validateDeptno() { // 考虑进行异步验证
	if(validateRegex("deptno", /^\d+$/)){ // 如果验证成功进行AJAX异步验证
		var deptno = document.getElementById("deptno");
		createXmlHttpRequest();
		xmlHttpRequest.open("post","DeptServlet/checkDeptno?deptno="+deptno.value);
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.status==200){
				if(xmlHttpRequest.readyState==4){
					if(xmlHttpRequest.responseText == "true"){
						deptnoFlag = true;
					}
					var msg = document.getElementById("deptnoMsg");
					if(deptnoFlag){
						deptno.className = "right";
						if(msg!=null){
							msg.innerHTML="<font color='green'> 该部门编号可以使用 </font>"
						}
					}else{
						deptno.className = "wrong";
						if(msg!=null){
							msg.innerHTML="<font color='red'> 部门编号已存在，请更换！ </font>"
						}
					}
				}
			}
		};
		xmlHttpRequest.send(null);
	}
}
function validateDname() {
	return validateEmpty("dname");
}
function validateLoc() {
	return validateEmpty("loc");
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
function addForm() {
	if(validateDname&&validateLoc()&&deptnoFlag){
		var deptno = document.getElementById("deptno").value;
		var dname = document.getElementById("dname").value;
		var loc = document.getElementById("loc").value;
		createXmlHttpRequest();
		xmlHttpRequest.open("post","DeptServlet/insert?deptno="+deptno+"&dname="+dname+"&loc="+loc);
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.status==200){
				if(xmlHttpRequest.readyState==4){
					if(xmlHttpRequest.responseText == "true"){
						alert("部门数据增加成功");
						addRow(deptno,dname,loc);
						resetForm();
					}else{
						alert("部门数据增加失败");
					}
					
				}
			}
		};
		xmlHttpRequest.send(null);
	}
}
function loadDeptDate(){
	createXmlHttpRequest();
	xmlHttpRequest.open("post","DeptServlet/list");
	xmlHttpRequest.onreadystatechange=function(){
		if(xmlHttpRequest.status==200){
			if(xmlHttpRequest.readyState==4){
				var allDepts = xmlHttpRequest.responseXML;
				var deptnos = allDepts.getElementsByTagName("deptno");
				var dnames = allDepts.getElementsByTagName("dname");
				var locs = allDepts.getElementsByTagName("loc");
				for(var x= 0;x<deptnos.length;x++){
					var deptno = deptnos[x].firstChild.nodeValue;
					var dname = dnames[x].firstChild.nodeValue;
					var loc = locs[x].firstChild.nodeValue;
					addRow(deptno,dname,loc);
				}
			}
		}
	};
	xmlHttpRequest.send(null);
}

function addRow(deptno,dname,loc) {
	var deptno = document.getElementById("deptno").value;
	// 创建表格行
	
	var trEle = document.createElement("tr");
	//创建一个保存复选框
	var checkboxEle = document.createElement("td");
	// 表格列创建deptno
	var tdEle = document.createElement("td");
	var deptnoEle = document.createElement("td");
	var dnameEle = document.createElement("td");
	var locEle = document.createElement("td");
	var butEle = document.createElement("td");
	// 设置每一行ID属性，dept-部门编号
	trEle.setAttribute("id","dept-"+deptno);
	//在deptno列上增加部门编号显示，只是一个文本信息
	deptnoEle.appendChild(document.createTextNode(deptno));
	//设置复选框出现
	var checkboxInputEle = document.createElement("input");
	checkboxInputEle.setAttribute("type","checkbox");
	checkboxInputEle.setAttribute("id","deptno");
	checkboxInputEle.setAttribute("value",deptno);
	checkboxEle.appendChild(checkboxInputEle);
	//在dname上保存的是一个文本组件
	var dnameInputEle = document.createElement("input");
	dnameInputEle.setAttribute("value",dname);
	dnameInputEle.setAttribute("id","dname-"+deptno);
	dnameInputEle.setAttribute("class","init");
	dnameEle.appendChild(dnameInputEle);
	//在loc列上保存文本组件
	var locInputEle = document.createElement("input");
	locInputEle.setAttribute("value",loc);
	locInputEle.setAttribute("id","loc-"+deptno);
	locInputEle.setAttribute("class","init");
	locEle.appendChild(locInputEle);
	//创建一个按钮组件
	var butInputEle = document.createElement("input");
	butInputEle.setAttribute("value","修改");
	butInputEle.setAttribute("type","button");
	butEle.appendChild(butInputEle);	
	//绑定事件
	butInputEle.addEventListener("click",function(){
		var dnameEle = document.getElementById("dname-"+deptno);	
		var locEle = document.getElementById("loc-"+deptno);
		var dnameFlag = false;
		var locFlag = false;
		if(dnameEle.value==""){
			dnameEle.className="wrong";
		}else{
			dnameEle.className="right";
			dnameFlag = true;
		}
		if(locEle.value==""){
			locEle.className="wrong";
		}else{
			locEle.className="right";
			locFlag = true;
		}
		if(dnameFlag&&locFlag){
			createXmlHttpRequest();
			xmlHttpRequest.open("post","DeptServlet/update?deptno="+deptno+"&dname="+dnameEle.value+"&loc="+locEle.value);
			xmlHttpRequest.onreadystatechange=function(){
				if(xmlHttpRequest.status==200){
					if(xmlHttpRequest.readyState==4){
						if(xmlHttpRequest.responseText == "true"){
							alert("部门数据修改成功");
						}else{
							alert("部门数据修改失败");
						}
						dnameEle.className="init";
						locEle.className="init";
					}
				}
			};
			xmlHttpRequest.send(null);
		}
	},false);
	trEle.appendChild(deptnoEle);
	trEle.appendChild(dnameEle);
	trEle.appendChild(locEle);
	trEle.appendChild(butEle);
	trEle.appendChild(checkboxEle);
	document.getElementById("deptTab").appendChild(trEle);
}
function seleAll() {
	var obj = document.all("deptno");
	if(obj.length==undefined){
		obj.checked = this.checked;
	}else{
		for(var x=0;x<obj.length;x++){
			obj[x].checked = this.checked;
		}
	}
}
function deleteDept() {
	var obj = document.all("deptno");
	var ids = "";
	if(obj.length==undefined){
		ids+=obj.value;
	}else{
		for(var x=0;x<obj.length;x++){
			if(obj[x].cheked){
				ids+=obj[x].value+" ";
			}
		}
	} 
	if(ids==""){
		alert("您还未选择 删除的数据");
	}else{
		createXmlHttpRequest();
		xmlHttpRequest.open("post","DeptServlet/delete?ids="+ids);
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.status==200){
				if(xmlHttpRequest.readyState==4){
					if(xmlHttpRequest.responseText == "true"){
						alert("部门数据删除成功");
						deleteRow();
					}else{
						alert("部门数据删除失败");
					}
					
				}
			}
		};
		xmlHttpRequest.send(null);
	}
}
function deleteRow() {
	var obj = document.all("deptno");
	if(obj.length==undefined){
		if(obj.checked){
		var tr = document.getElementById("dept-"+obj.value);
		document.getElementById("deptTab").parentNode.removeChild(tr);
		}
	}else{
		for(var x=0;x<obj.length;x++){
			if(obj[x].checked){
			var tr = document.getElementById("dept-"+obj[x].value);
			document.getElementById("deptTab").parentNode.removeChild(tr);
		}
		}
	} 
}