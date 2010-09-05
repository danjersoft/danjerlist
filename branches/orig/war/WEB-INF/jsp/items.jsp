<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
   isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width = device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Items</title>
</head>
<body>
<div><a href="items/add">Add Item</a></div>
<div><c:forEach items="${items}" var="item">
   <p>${item.name}</p>
</c:forEach></div>
<div><a href="items/add">Add Item</a></div>
<div><a href="/">Home</a></div>
</body>
</html>