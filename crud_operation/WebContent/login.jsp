<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loginBackend" method = "post">
	<table>
		<tr><h1>Login</h1></tr>
		<tr><td>Username:</td><td><input type="text" name="username" required></td></tr>
		<tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
		<tr><td colspan="2"><input type="submit" value="login"></td></tr>
		<tr><td>New account? </td><td><a href="Register.jsp">Sign up</a></td></tr>
	</table>
</form>

</body>
</html>