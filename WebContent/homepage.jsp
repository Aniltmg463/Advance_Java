<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Navigation Buttons</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .button-container {
            display: flex;
            gap: 10px; /* Space between buttons */
        }
        .button {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            font-size: 16px;
            text-align: center;
            display: inline-block;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="button-container">
        <a href="Registration_form.jsp" class="button">Insert Data</a>
        <a href="Display.jsp" class="button">Display Data</a>
        <a href="searchData.jsp" class="button">Search Data</a>
        <a href="Update.jsp" class="button">Update Data</a>
        <a href="Delete.jsp" class="button">Delete Data</a>
    </div>
</body>
</html>
