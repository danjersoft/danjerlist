<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Add a List</title>
</head>
<body>
<div id="content">
<form action="<c:url value="/listManager.htm"/>" method="post">
<p><label for="listName">Name of List</label><br />
<input id="listName" name="name" required="required" /></p>
<p><input type="submit" /> <a href="<c:url value="/"/>">Cancel</a></p>
</form>
</div>
</body>
</html>