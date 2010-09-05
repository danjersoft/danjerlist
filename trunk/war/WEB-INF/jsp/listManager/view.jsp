<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>${list.name}</title>
</head>
<body>
<div id="content">
<p>${list.name}</p>
<div id="tabs">
<ul>
   <li><a href="#tabs-1">Still Need</a></li>
   <li><a href="#tabs-2">In Cart</a></li>
</ul>
<div id="tabs-1"><input id="availableItems" /> <img src="/img/shoppingcart_add.png"
   alt="Add item to list" align="top" id="addItem" /> <c:if test="${empty listItems}">
   <p id="warnMessage">Nothing here! Add something, quick!</p>
</c:if>
<ul id="toGet">
   <c:forEach items="${listItems}" var="item">
      <li>${item.name}</li>
   </c:forEach>
</ul>
</div>
<div id="tabs-2">
<p>list of items that are in your cart</p>
</div>
</div>
<script type="text/javascript">
$(function() {
   $("#tabs").tabs();
   var availableItems = [<c:forEach items="${availableItems}" var="item" varStatus="status">"${item.name}"<c:if test="${not status.last}">,</c:if></c:forEach>];
   $("#availableItems").autocomplete({source:availableItems});
   $("#addItem").click(function() {
      $('#toGet').prepend('<li>' + $('#availableItems').val() + '</li>');
      // TODO ajax this too
      $('#warnMessage').remove();
      $('#availableItems').val('');
   });
});
</script></div>
</body>
</html>