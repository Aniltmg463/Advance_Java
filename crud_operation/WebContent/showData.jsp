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
<h1>Here's the result of search data</h1>
<a href="home.jsp" class = "button">Home</a>
<form>
	<table border=1px>
		<tr>
			<th>Course</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Parent</th>
			<th>Gender</th>
			<th>Date of Birth</th>
			<th>Join Date</th>
			<th>Nationality</th>
			<th>Permanet Address</th>
			<th>Email</th>
			<th>Contact</th>
		</tr>
		<tr>
			<td><%= request.getAttribute("course") %></td>
			<td><%=request.getAttribute("fname") %></td>
			<td><%=request.getAttribute("lname") %></td>
			<td><%=request.getAttribute("parent") %></td>
			<td><%=request.getAttribute("gender") %></td>
			<td><%= request.getAttribute("dob")%></td>
			<td><%=request.getAttribute("jdate") %></td>
			<td><%=request.getAttribute("nationality") %></td>
			<td><%=request.getAttribute("paddress") %></td>
			<td><%=request.getAttribute("email") %></td>
			<td><%= request.getAttribute("contact")%></td>
	
				
		</tr>
	
	</table>
</form>
</body>
</html>