<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width = device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Form</title>
</head>
<body>
<form action="/a/items" method="post">
<p><label for="name">Item Name:</label><br />
<input id="name" name="name" required="required"></p>
<p><label for="shortcuts">Shortcuts:</label><br />
<input id="shortcuts" name="shortcuts"></p>
<p><input type="submit"> <a href="../items">Cancel</a></p>
</form>
</body>
</html>