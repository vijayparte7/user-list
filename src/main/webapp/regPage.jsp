<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form action="registeruser" method="post">
	<pre>
	
    First Name: <input name="firstname"/>
    Last Name: <input name="lastname" />
    Email ID: <input name="emailid" />
    Password: <input name="password" /><input name="employeeid" hidden value="1"/>
    Organization: <input name="organization" />

	<button type="submit" >Register</button>
	</pre>
	</form>
	<pre>
	
	<a href="loginPage">Login</a>
	</pre>

</body>
</html>