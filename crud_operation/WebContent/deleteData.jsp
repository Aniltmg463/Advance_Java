<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<h1>Delete the data</h1>
<form action="DeleteBackend" method="post">

<table>
	<tr>
		<td><input type="text" placeholder="Enter E-mail" name="email"></td>
		<td><input type="submit" value = "Delete"></td>
		<td><a href="home.jsp" class = "button">Home</a></td>
	</tr>
</table>
</form>

</body>
</html>