<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.button {
    display: inline-block;
    padding: 12px 24px;
    margin: 10px;
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    text-decoration: none;
    color: #fff;
    background-color: #007bff; /* Primary blue color */
    border: none;
    border-radius: 2rem;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow */
    transition: background-color 0.3s ease, box-shadow 0.3s ease; /* Smooth transition */
}



</style>
</head>
<body>
<h1>Welcome to home page</h1>
<table>
<tr>
<td><a href="insertData.jsp" class = "button">Insert</a></td>
<td><a href="searchData.jsp" class = "button">Search</a></td>
<td><a href="updateData.jsp" class = "button">Update</a></td>
<td><a href="deleteData.jsp" class = "button">Delete</a></td>
<td><a href="viewData.jsp" class = "button">View</a></td>
<td><a href="login.jsp" class = "button">Exit</a></td>


</tr>
</table>

</body>
</html>