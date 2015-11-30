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
        <ul>
          <li><a href="addEmployee.jsp">dodaj</a></li>
          <li><a href="showAllEmployee.jsp">pokaz pracownikow</a></li>
        </ul>
<p><a href="hello-page">Hello world link</a></p>  

<a href="${pageContext.request.contextPath}/employee/add.html">Add new employee</a><br>  
<a href="${pageContext.request.contextPath}/employee/list.html">Employees list</a><br>  
</body>
</html>