window.onload = function(){
	document.getElementById("pid").addEventListener("change",loadCity,false);
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
//加载城市信息
function loadCity(){
	var pid = document.getElementById("pid").value;
	/*alert(pid);*/
	if(pid != "0"){
		createXmlHttpRequest();
		xmlHttpRequest.open("post","CityServlet?pid="+pid);
		xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.status==200){
				if(xmlHttpRequest.readyState==4){
					var allCitys = xmlHttpRequest.responseXML;
					var cids = allCitys.getElementsByTagName("cid");
					var city = allCitys.getElementsByTagName("city");
					var selectEle = document.getElementById("cid");
					selectEle.length=1;
					for(var x= 0;x<cids.length;x++){
						var optionElem = document.createElement("option");
						optionElem.setAttribute("value",cids[x].firstChild.nodeValue);
						optionElem.appendChild(document.createTextNode(city[x].firstChild.nodeValue));
						selectEle.appendChild(optionElem);
					}
				}
			}
		};
		xmlHttpRequest.send(null);
	}
}