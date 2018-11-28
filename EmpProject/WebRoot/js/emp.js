function validateEmpno(){
	return validateEmpty("empno",/^\d{4}$/);
}
function validateEname(){
	return validateEmpty("ename");
}
function validateJob(){
	return validateEmpty("job");
}
function validateHiredate(){
	return validateEmpty("hiredate",/^\d{4}-\d{2}-\d{2}$/);
}
function validateSal(){
	return validateEmpty("sal",/^\d+(\.\d{1,2})?$/);
}
function validateComm(){
	return validateEmpty("comm",/^\d+(\.\d{1,2})?$/);
}

function validateinsert(){
	return validateEmpno() && validateEname() && validateJob() && validateHiredate() && validateSal() && validateComm();
}
function validateupdate(){
	return validateEname() && validateJob() && validateHiredate() && validateSal() && validateComm();
}