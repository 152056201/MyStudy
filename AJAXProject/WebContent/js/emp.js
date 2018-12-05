window.onload = function(){
	loadData();
}
var xmlHttpRequest;
function createXmlHttpRequest() {	
	if (window.ActiveXObject) {
		    xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
		    xmlHttpRequest = new XMLHttpRequest();
	}
}
function loadData() {
	
	
		createXmlHttpRequest();//创建xmlHttpRequest对象
		//设置要提交的路径以及定义数据提交模式，而后使用地址重写
		xmlHttpRequest.open("post","EmpServlet");
		xmlHttpRequest.onreadystatechange = function(){
			if(xmlHttpRequest.status==200){
				if(xmlHttpRequest.readyState==4){
					/*alert(xmlHttpRequest.responseXML);*/
					var allEmpsElement = xmlHttpRequest.responseXML;
					var empnoNodeList = allEmpsElement.getElementsByTagName("empno");
					var enameNodeList = allEmpsElement.getElementsByTagName("ename");
					var jobNodeList = allEmpsElement.getElementsByTagName("job");
					/*alert(empNodeList.length);*/
					for(var x = 0;x<empnoNodeList.length;x++){
						var empno = empnoNodeList[x].firstChild.nodeValue;
						var ename = enameNodeList[x].firstChild.nodeValue;
						var job = jobNodeList[x].firstChild.nodeValue;
						addRow(empno,ename,job);
					}
					
				}
				
			}
		};
		xmlHttpRequest.send(null);//发送请求
}
function addRow(empno,ename,job) {
	var trEle = document.createElement("tr");
	var empnotdEle = document.createElement("td");
	empnotdEle.appendChild(document.createTextNode(empno));
	var enametdEle = document.createElement("td");
	enametdEle.appendChild(document.createTextNode(ename));
	var jobtdEle = document.createElement("td");
	jobtdEle.appendChild(document.createTextNode(job));
	trEle.appendChild(empnotdEle);
	trEle.appendChild(enametdEle);
	trEle.appendChild(jobtdEle);
	document.getElementById("empDiv").appendChild(trEle);
}