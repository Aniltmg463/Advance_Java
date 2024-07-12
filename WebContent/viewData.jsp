<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.sun.model.Record" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Here's the result of search data</h1>
<form action = "ViewData" method = "post">
	<input type = "submit" value ="Show all data">
	<a href="home.jsp" class = "button">Home</a>
	<% if(request.getAttribute("Record")!= null){
		List<Record> obj = (List<Record>)request.getAttribute("Record");%>
	
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
		<%
		for(Record record : obj){
		%>
			<tr>
				<td><%= record.getCourse() %></td>
				<td><%=record.getFirstname() %></td>
				<td><%=record.getLastname() %></td>
				<td><%=record.getParent() %></td>
				<td><%=record.getGender() %></td>
				<td><%= record.getDateOfBirth()%></td>
				<td><%=record.getJoinDate() %></td>
				<td><%=record.getNationality() %></td>
				<td><%=record.getPermanentAddress() %></td>
				<td><%=record.getEmail() %></td>
				<td><%= record.getContact()%></td>
		
					
			</tr>
		<%
		} 
	}
		%>
	</table>
</form>
</body>
</html>