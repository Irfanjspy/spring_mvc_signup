<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update page</title>
</head>
<body>



<spring:form action="update" modelAttribute="emp" method="post">
Id:<spring:input path="id" readonly="true"/><br>
Name:<spring:input path="name"/><br>
Email:<spring:input path="email"/><br>
Mobile:<spring:input path="mobile"/><br>
Password:<spring:input path="password"/><br>
<spring:button>update</spring:button>

</spring:form>

</body>
</html>