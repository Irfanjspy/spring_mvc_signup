<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>

<h1 style="color: green">${Msg}</h1>
<h1>Login Form</h1>
<form action="login" method="post">
Email:<input type="text" name="email"><br><br>
Password:<input type="text" name="password"><br><br>
<button type="submit">Login</button>
<button type="reset">Cancel</button>
</form>
<br>
<a href="loademployee">New? Click here to Signup</a>

</body>
</html>