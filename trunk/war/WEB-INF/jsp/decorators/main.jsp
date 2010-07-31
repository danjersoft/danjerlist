<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,user-scalable=no" />
<link href="/css/listr.css" type="text/css" rel="stylesheet">
<title>Listr! - <decorator:title default="Home" /></title>
<script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
<decorator:head />
</head>
<body>
<div id="menu"><a href="/index.htm"><img src="/img/home.png" alt="Return to Home page" /></a>
<a href="/listManager/add.htm"><img src="/img/document_add.png" alt="Add List" /></a></div>
<decorator:body />
<script type="text/javascript" src="/js/listr.js"></script>
</body>
</html>
