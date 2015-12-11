<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>  
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
</head>
<body>
<ul>
    		  
          <li><a href="${pageContext.request.contextPath}/showEmployee">Pokaż wszystkich</a></li>
          <li><a href="${pageContext.request.contextPath}/addEmployee">Dodaj</a></li>
          <li><a href="#">UsuÅ</a></li>
</ul>
 

  <a href="#" name="showAllEmployee"></a>
   <table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
   <tbody>
    <p:forEach  items="${employees}" var="employee" >  
      <tr>
        <td><b>imie: </b><p:out value="${employee.firstName}"/></td>
        <td><b>nazwisko: </b> <p:out value="${employee.lastName}"/></td>
        <td><b>Nr telefonu: </b> <p:out value="${employee.telephoneNumber}"/></td>
            <td><b>Email: </b> <p:out value="${employee.email}"/></td>
        <td class="hideColumn"><b> Kod pocztowy:</b><p:out value="${employee.postcode}"/></td>
      </tr>
      <tr>
        <td><b>Miasto: </b> <p:out value="${employee.town}"/></td>
        <td><b>Adres: </b><p:out value="${employee.adress}"/></td>
        <td><b>Kraj: </b> <p:out value="${employee.country}"/></td>
        <td><b>Outpost ID: </b> <p:out value="${employee.outpost}"/></td>

    </p:forEach>  
    </tbody>
    </table>
  <a href="#" name="addEmployee"></a> 

   

  
</body>
</html>
</html>