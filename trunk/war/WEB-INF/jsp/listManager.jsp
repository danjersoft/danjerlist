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
      <table>
         <tbody>
            <c:forEach items="${lists}" var="list">
               <tr>
                  <td>${list.name} (${list.startedOn}) (${list.key})</td>
                  <td><delete name="${list.name}"><a
                     href="<c:url value="/listManager/delete/${list.key.id}.htm"/>"><img
                     src="/img/document_delete.png" /></a></delete></td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </c:otherwise>
</c:choose></div>
</body>
</html>