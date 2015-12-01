<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
  <link href="css/foundation.css" rel="stylesheet" type="text/css">
  <link href="css/animate.css" rel="stylesheet" type="text/css">
  <link href="css/style.css" rel="stylesheet" type="text/css">
  <script src="js/jquery.js" type="text/javascript" ></script>
  <script src="js/modernizr.js" type="text/javascript" ></script>
  <script src="js/foundation.min.js" type="text/javascript" ></script>
  <script src="js/jquery.viewportchecker.js" type="text/javascript" ></script>
  <script src="js/main.js" type="text/javascript"></script>
</head>
<body>
<form:form method="POST" commandname="employee" action="${pageContext.request.contextPath}/employee/add">  
<table>  
<tr>
<td>Employees number:</td>

<td><form:input path="firstName" /></td>
<td><form:input path="lastName" /></td>
<td><form:input path="telephoneNumber" /></td>
<td><form:input path="postcode" /></td>
<td><form:input path="adress" /></td>
<td><form:input path="town" /></td>
<td><form:input path="country" /></td>
<td><input type="submit" value="Create" /></td>

</tr>
</table>  
</form:form>
	<p><a href="${pageContext.request.contextPath}/index.jsp">Home page</a></p>  

</body>
</html>