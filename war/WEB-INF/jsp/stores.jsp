<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
   isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width = device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stores</title>
</head>
<body>
<div><a href="stores/add">Add Store</a></div>
<div><c:choose>
   <c:when test="${empty stores}">No Stores currently available</c:when>
   <c:otherwise>
      <c:forEach items="${stores}" var="store">
         <p>${store.name}</p>
      </c:forEach>
   </c:otherwise>
</c:choose></div>
<div><a href="stores/add">Add Store</a></div>
<div><a href="/">Home</a></div>
</body>
</html>