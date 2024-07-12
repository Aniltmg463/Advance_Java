<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.sun.model.Registration" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Here's the all data of Database</h1>
<form action = "ViewDB" method = "post">
	<a href="homepage.jsp" class = "button">Home</a>
	<% if(request.getAttribute("Result")!= null){
		List<Registration> obj = (List<Registration>)request.getAttribute("Result");%>
	
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
			<th>Permanent Address</th>
			<th>Email</th>
			<th>Contact</th>
		</tr>
		<%
		for(Registration record : obj){
		%>
			<tr>
				<td><%= record.getCourse() %></td>
				<td><%=record.getFname() %></td>
				<td><%=record.getLname() %></td>
				<td><%=record.getPname() %></td>
				<td><%=record.getSex() %></td>
				<td><%= record.getDob()%></td>
				<td><%=record.getJoindate() %></td>
				<td><%=record.getNationality() %></td>
				<td><%=record.getAddress() %></td>
				<td><%=record.getEmail() %></td>
				<td><%= record.getContactno()%></td>
		
					
			</tr>
		<%
		} 
	}
		%>
	</table>
</form>
</body>
</html>