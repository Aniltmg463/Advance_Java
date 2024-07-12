<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
   
    <script type="text/javascript">
        function validation() {
            var fname = document.forms["nm"]["fname"].value;
            if (fname == "") {
                alert("Please enter your first name");
                document.forms["nm"]["fname"].focus();
                return false;
            }
            // Additional validations can be added here.
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Registration Form</h1>
        <form action="Registration" name="nm" method="post" onsubmit="return validation();">
            <table>
                <tr>
                    <td><label for="fname">First Name:</label></td>
                    <td><input type="text" id="fname" name="fname"></td>
                </tr>
                <tr>
                    <td><label for="lname">Last Name:</label></td>
                    <td><input type="text" id="lname" name="lname"></td>
                </tr>
                <tr>
                    <td><label for="emailid">Email ID:</label></td>
                    <td><input type="text" id="emailid" name="emailid"></td>
                </tr>
                <tr>
                    <td><label for="username">User Name:</label></td>
                    <td><input type="text" id="username" name="username"></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"></td>
                    <td><input type="reset" value="Reset"></td>
                </tr>
            </table>
        </form>
         <div class="register-link">
        Don't have an account? <a href="Login.jsp">Sign In</a>
    </div>
    </div>
</body>
</html>
