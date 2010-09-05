<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
<div id="content"><c:choose>
   <c:when test="${empty lists}">
      <p style="font-weight: bold">No Lists! You got everything!</p>
   </c:when>
   <c:otherwise>
      <c:forEach items="${lists}" var="list" varStatus="status">
         <div class="row <c:if test="${not status.last}">rowBorder</c:if>">
         <div class="right"><delete name="${list.name}"><a
            href="<c:url value="/listManager/delete/${list.key.id}.htm"/>"><img
            src="/img/document_delete.png" /></a></delete></div>
         <div><a href="/listManager/view/${list.key.id}.htm">${list.name}</a></div>
         </div>
      </c:forEach>
   </c:otherwise>
</c:choose></div>
</body>
</html>