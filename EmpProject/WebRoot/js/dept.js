//负责编写相关的验证操作
function validateDeptno(){
	return validateEmpty("deptno");
}
function validateDname(){
	return validateEmpty("dname");
}
function validateLoc(){
	return validateEmpty("loc");
}

function validateinsert(){
	return validateDeptno() && validateDname() && validateLoc();
} 
function validateupdate(){
	return validateDname() && validateLoc();
}
