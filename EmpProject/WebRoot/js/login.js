function validateaid(){
	return validateEmpty("username");
}
function validatepassword(){
	return validateEmpty("password");
}
function validatecode(){
	return validateRegex("code",/^[a-zA-Z0-9]{4}$/);
}

function validatelogin(){
	return validateaid()&&validatepassword()&&validatecode();
	
}