<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="Registration" method="post" name="register" onsubmit="function Validation();">

	<table>
		
		<tr><td>First Name :</td> <td><input type="text" name="fname"></td></tr>
		<tr><td>Last Name :</td> <td><input type="text" name="lname"></td></tr>
		<tr><td>E-mail :</td> <td><input type="text" name="email"></td></tr>
		<tr><td>Username :</td> <td><input type="text" name="uname"></td></tr>
		<tr><td>Password :</td> <td><input type="password" name="pass"></td></tr>
		<tr> <td><input type="submit" value="Submit"></td></tr>
		<tr><td><input type="submit" value="Clear"></td></tr>
		
		
	</table>
</form>
<script>

function Validation()
{
	if(document.register.fname.value == " ")
		{
			alert("Please enter first name");
			documemt.register.fname.focus();
			return false;
		
		}
	if(document.register.lname.value == " ")
	{
		alert("Please enter last name");
		documemt.register.lname.focus();
		return false;
	
	}
	if(document.register.email.value == " ")
	{
		alert("Please enter e-mail");
		documemt.register.email.focus();
		return false;
	
	}
	if(document.register.uname.value == " ")
	{
		alert("Please enter username");
		documemt.register.uname.focus();
		return false;
	
	}
	if(document.register.pass.value == " ")
	{
		alert("Please enter password");
		documemt.register.pass.focus();
		return false;
	
	}
}
</script>
</body>
</html>