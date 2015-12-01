 <%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>  
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
<h1>List of employees</h1>  
<p>List of Employees</p>  
<c:foreach var="employee" items="${employees}">  
</c:foreach><table border="1px" cellpadding="0" cellspacing="0">  
<thead>  
<tr>  
<th width="10%">id</th><th width="15%">firstName</th><th width="10%">lastName</th><th width="10%">telephoneNumber</th>
<th width="10%">adress</th><th width="10%">postcode</th><th width="10%">town</th>
<th width="10%">country</th><th width="10%">actions</th>  
</tr>  
</thead>  
<tbody>  
<tr>  
    <td>${employee.employeeId}</td>  
    <td>${employee.firstName}</td>  
    <td>${employee.lastName}</td>  
       <td>${employee.telephoneNumber}</td>  
          <td>${employee.adress}</td>  
             <td>${employee.postcode}</td>  
                <td>${employee.town}</td>
                   <td>${employee.country}</td>    
    <td>  

    </td>  
</tr>  
  
</tbody>  
</table>  
  
<p><a href="${pageContext.request.contextPath}/index.jsp">Home page</a></p>  
  
	

</body>
</html>