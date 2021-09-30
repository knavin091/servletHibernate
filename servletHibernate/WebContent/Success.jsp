<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body bgcolor="yellow">

 <h1>Registration successFull</h1>
 <% String un=(String)request.getAttribute("Username"); %>
 <font color="red" size="5">registered UserName is<%=un%></font>
</body>
</html>