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
<form method="POST" commandname="employee" action="${pageContext.request.contextPath}/employee/add/">  
<table>  
<tbody>  
    <tr>  
        <td>First Name:</td>  
        <td><input  path="firstName"></input></td>  
    </tr>  
    <tr>  
        <td>Last Name:</td>  
        <td><input  path="lastName"></input></td>  
    </tr>  
      <tr>  
        <td>Telephone number:</td>  
        <td><input  path="telephoneNumber"></input></td>  
    </tr>  
      <tr>  
        <td>Adress:</td>  
        <td><input path="adress"></input></td>  
    </tr>  
      <tr>  
        <td>Post code:</td>  
        <td><input path="postCode"></input></td>  
    </tr>  
      <tr>  
        <td>Town:</td>  
        <td><input  path="town"></input></td>  
    </tr>  
      <tr>  
        <td>Country:</td>  
        <td><input  path="Country"></input></td>  
    </tr>  
    
    <tr>  
        <td><input value="Add" type="submit"></td>  
        <td></td>  
    </tr>  
</tbody>  
</table>  
</form>
	<p><a href="${pageContext.request.contextPath}/index.jsp">Home page</a></p>  

</body>
</html>