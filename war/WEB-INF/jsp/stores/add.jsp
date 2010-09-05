<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width = device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Store Form</title>
</head>
<body>
<form action="/a/stores" method="post">
<p><label for="name">Store Name:</label><br />
<input id="name" name="name" required="required"></p>
<p><input type="submit"> <a href="../stores">Cancel</a></p>
</form>
</body>
</html>