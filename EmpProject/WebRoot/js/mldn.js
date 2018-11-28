function validateEmpty(eleName){
	var obj = document.getElementById(eleName);
	var msg = document.getElementById(eleName+"Msg");
	if(obj.value !=""){
		obj.className ="right";
		if(msg!=null){
			msg.innerHTML="<font color='green'>内容输入正确</font>";
		}
		return true;
	}else{
		obj.className ="wrong";
		if(msg!=null){
			msg.innerHTML="<font color='red'>内容不能为空</font>";
		}
		return false;
	}
}

function validateRegex(eleName,regex){
	var obj = document.getElementById(eleName);	
	var msg = document.getElementById(eleName+"Msg");
	if(regex.test(obj.value)){
		obj.className="right";
		if(msg!=null){
			msg.innerHTML="<font color='green'>输入内容正确</font>";
		}
		return true;
	}else{
		obj.className="wrong";
		if(msg==null){
			msg.innerHTML="<font color='red'>内容格式错误！</font>";
		}
		return false;
	}
}

function changeColor(obj,color) {
	obj.bgColor = color;
}

function boxSelect(obj,eleName) {
	var item = document.all(eleName);
	if(item.length == undefined){
		document.getElementById(eleName).checked = this.checked;
	}else{
		for(var x= 0;x<item.length;x++){
			item[x].checked = obj.checked;
		}
	}
}
//paramName表示要传递参数的名称
//eleNmae表示要取得数据的ID名称
//url表示要删除内容的路径
function deleteAll(url,paramName,eleName) {
	var data = "";//保存要删除数据编号
	//数据可能是一个，也有可能是一组
	var item = document.all(eleName);
	var count =0;
	//判断是否有要删除的数据
	if(item.length == undefined){//表示只有一个元素而不是数组
		if(document.getElementById(eleName).checked==true){//数据选中
			data+=document.getElementById(elName).value+" ";
			count++;
		}
	}else{
		for(var x= 0;x<item.length;x++){
			if(item[x].checked == true){//有删除的数据
				count++;
				data+=item[x].value+" ";
			}
		}
		
	}
	if(count>0){ //如果有数据
		if(window.confirm("确定要删除数据么？")){
			//console.log(url + "?" + paramName + "=" + data);
			window.location = url + "&" + paramName + "=" + data;
		}
	}else{
		alert("您还未选中要删除的数据!");
	}
}

function deleteAllP(url,paramName,eleName) {
	var data = "";//保存要删除数据编号
	//数据可能是一个，也有可能是一组
	var item = document.all(eleName);
	var count =0;
	//判断是否有要删除的数据
	if(item.length == undefined){//表示只有一个元素而不是数组
		if(document.getElementById(eleName).checked==true){//数据选中
			data+=document.getElementById(elName).value+" ";
			count++;
		}
	}else{
		for(var x= 0;x<item.length;x++){
			if(item[x].checked == true){//有删除的数据
				count++;
				data+=item[x].value+" ";
			}
		}
		
	}
	if(count>0){ //如果有数据
		if(window.confirm("确定要删除数据么？")){
			//console.log(url + "?" + paramName + "=" + data);
			window.location = url + "?" + paramName + "=" + data;
		}
	}else{
		alert("您还未选中要删除的数据!");
	}
}

function openPage(url) {
	window.open(url,"查看详细信息","width=600;height=500;scollable=yse");
}

function changeCode(obj) {
	obj.scr = " page/back/admin/img.jsp?tm= "+Math.random();
}
  

