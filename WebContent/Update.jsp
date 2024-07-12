<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Data</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 20px;
    }
    
    .container {
        max-width: 600px;
        margin: auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    h1 {
        text-align: center;
        color: #333;
    }
    
    form {
        max-width: 400px;
        margin: auto;
    }
    
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
    }
    
    input[type="text"],
    input[type="tel"],
    textarea,
    select {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    
    select {
        height: 40px; /* Adjust height to match other input fields */
    }
    
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Registration Form</h1>

    <form action="Updatesuccess" method="post">
       <label>Course Offered:</label>
        <select name="courseOffered">
            <option value="bca">BCA</option>
            <option value="bba">BBA</option>
            <option value="bbm">BBM</option>
            <!-- Add more options based on the courses offered -->
        </select>
        <label>First Name:</label> <input type="text" name="fname" required>
        <label>Last Name:</label> <input type="text" name="lname" required>
        <label>Name of Parent:</label> <input type="text" name="parentName">
        
        <label>Gender:</label>
        <input type="radio" name="gender" value="male"> Male
        <input type="radio" name="gender" value="female"> Female
        
        
        <label>Date of Birth:</label> <input type="date" name="dob">
        <label>Join Date:</label> <input type="date" name="joinDate">
        
        <label>Nationality:</label>
        <select name="nationality">
            <option value="nepal">Nepal</option>
            <option value="india">India</option>
            <option value="nri">NRI</option>
            <option value="bangla">Bangladesh</option>
            <option value="others">Others</option>
            
            <!-- Add more options as needed -->
        </select>
        
        <label>Address:</label> <textarea name="address" rows="3"></textarea>
        <label>Email:</label> <input type="text" name="email">
        <label>Contact Number:</label> <input type="tel" name="contact">
        
     
        
        <input type="submit" value="Update">
        <input type="submit" value="Reset">
    </form>
     <div class="register-link">
         <a href="homepage.jsp">Go TO Homepage</a>
    </div>
</div>
</body>
</html>



