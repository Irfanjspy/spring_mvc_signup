<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1 style="color:green">${Msg}</h1>


                     
 
<table border="5px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Password</th>
<th>Delete</th>
<th>edit</th>
</tr>
<c:forEach var="emp" items="${list}">
<tr>
<th>${emp.getId()}</th>
<th>${emp.getName()}</th>
<th>${emp.getEmail()}</th>
<th>${emp.getMobile()}</th>
<th>${emp.getPassword()}</th>
<th><a href="delete?id=${emp.getId()}"><button>Delete</button></a></th>
<th><a href="edit?id=${emp.getId()}"><button>edit</button></a></th>
</tr>
</c:forEach>

</table>


</body>
</html>