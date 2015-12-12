<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
</head>
<body>
<i>${message}</i><br/>
 <ul>

          <li><a href="${pageContext.request.contextPath}/employee/crud">CRUD dla Pracownika</a></li>
           <li><a href="${pageContext.request.contextPath}/outpost/crud">CRUD dla Placówki</a></li>
   
 </ul>
</body>
</html>