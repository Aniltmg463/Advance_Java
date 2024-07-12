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
<h1>Update the data</h1><a href="home.jsp" class = "button">Home</a>
<h2>Please Insert the Correct E-mail of Data to be Updated</h2>
<form action="UpdateData" method="post">
<table>
	<tr>
		<td><label>Enter the email</label></td>
		<td><input type="text" placeholder="Enter E-mail" name="Email"></td>
	</tr>
		<br>
		<br>
		
		<tr>
		<td>Course :</td> 
		<td><select id="course" name="course" >
			<option value="BIT">BIT</option>
			<option value="BCA">BCA</option>
			<option value="BsCSIT">BsCSIT</option>
			<option value="BIM">BIM</option>
		</select></td>	
		</tr>
		
		<tr>
		<td>First Name :</td> <td><input type="text" name="fname"></td>
		</tr>
		
		<tr>
		<td>Last Name :</td> <td><input type="text" name="lname"></td>
		</tr>
		
		<tr>
		<td>Name of Guardian :</td> <td><input type="text" name="parent"></td>
		</tr>
		
		<tr>
		<td>Gender :</td> 
		<td>
			<input type="radio" name="gender" value="Male"> Male
			<input type="radio" name="gender" value="Female"> Female
		</td>
		</tr>
		
		<tr>
		<td>Date of Birth :</td> <td><input type="date" name="dob"></td>
		</tr>
		
		<tr>
		<td>Join Date :</td> <td><input type="date" name="joinDate"></td>
		</tr>
		
		<tr>
		<td>Nationality :</td>
		 <td><select id="nationality" name="nationality">
			<option value="Nepali">Nepali</option>
			<option value="Indian">Indian</option>
			<option value="Bangladeshi">Bangladeshi</option>
			<option value="Chinese">Chinese</option>
		</select></td>
		 </tr>
		 
		<tr>
		<td>Permanent Address :</td> <td><textarea name="pAddress"></textarea></td>
		</tr>
		

		
		<tr>
		<td>Contact No. :</td> <td><input type="text" name="contact"></td>
		</tr>
		
		<tr>
		<td><input type="submit" value = "Udate"></td>
		</tr>
	</table>
</form>
</body>
</html>