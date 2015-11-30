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
<form:form method="POST" commandname="employee" action="${pageContext.request.contextPath}/employee/add/process.html">  
<table>  
<tbody>  
    <tr>  
        <td>First Name:</td>  
        <td><form:input path="firstName"></form:input></td>  
    </tr>  
    <tr>  
        <td>Last Name:</td>  
        <td><form:input path="lastName"></form:input></td>  
    </tr>  
      <tr>  
        <td>Telephone number:</td>  
        <td><form:input path="telephoneNumber"></form:input></td>  
    </tr>  
      <tr>  
        <td>Adress:</td>  
        <td><form:input path="adress"></form:input></td>  
    </tr>  
      <tr>  
        <td>Post code:</td>  
        <td><form:input path="postCode"></form:input></td>  
    </tr>  
      <tr>  
        <td>Town:</td>  
        <td><form:input path="town"></form:input></td>  
    </tr>  
      <tr>  
        <td>Country:</td>  
        <td><form:input path="Country"></form:input></td>  
    </tr>  
    
    <tr>  
        <td><input value="Add" type="submit"></td>  
        <td></td>  
    </tr>  
</tbody>  
</table>  
</form:form>  
	<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>  

</body>
</html>