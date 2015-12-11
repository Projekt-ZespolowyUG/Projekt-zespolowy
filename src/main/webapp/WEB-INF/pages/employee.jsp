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
      <a href="${pageContext.request.contextPath}">Wizyty</a>
          <li><a href="${pageContext.request.contextPath}/showEmployee">Pokaż wszystkich</a></li>
          <li><a href="${pageContext.request.contextPath}/addEmployee">Dodaj</a></li>
          <li><a href="#">UsuÅ</a></li>
</ul>
 

  <a href="#" name="showAllEmployee"></a>
    <table>
    <p:forEach  items="${employees}" var="employee" >  
      <tr>
        <td><b>imie: </b><span> <p:out value="${employee.firstName}"/></span></td>
        <td><b>nazwisko: </b><span> <p:out value="${employee.lastName}"/></span></td>
        <td><b>Nr telefonu: </b><span> <p:out value="${employee.telephoneNumber}"/></span></td>
        <td class="hideColumn"><b> Kod pocztowy:</b><span><p:out value="${employee.postcode}"/></span></td>
      </tr>
      <tr>
        <td><b>Miasto: </b><span> <p:out value="${employee.town}"/></span></td>
        <td><b>Adres: </b><span> <p:out value="${employee.adress}"/></span></td>
        <td><b>Kraj: </b><span> <p:out value="${employee.country}"/></span></td>
      </tr>
    </p:forEach>  
    </table>
  <a href="#" name="addEmployee"></a> 

    <h1>Dodaj Pracownika</h1>
    <form:form method="POST" modelAttribute="employee" action="${pageContext.request.contextPath}/add" >

        <label>Imię :<form:input  path="firstName" /></label>
  

        <label>Nazwisko :<form:input  path="lastName" /></label>
 
 
        <label>Nr telefonu :<form:input  path="telephoneNumber"/></label>
  

        <label>Adres :<form:input  path="adress" /></label>
    
  
        <label>Kod pocztowy :<form:input  path="postcode" /></label>
    
  
        <label>Miasto :<form:input  path="town" /></label>
 

         <label>Kraj : <form:input  path="country" />
        </label>

 
        <input class="buttonL" type="submit" value="Zatwierdź">

    </form:form>

  
</body>
</html>
</html>