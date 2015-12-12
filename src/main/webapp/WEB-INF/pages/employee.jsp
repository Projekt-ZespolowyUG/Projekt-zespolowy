<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false" %>  
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Pracownik</title>
  
</head>
<body>
<ul>
    		  
         <li><a href="${pageContext.request.contextPath}/employee/crud">CRUD dla Pracownika</a></li>
           <li><a href="${pageContext.request.contextPath}/outpost/crud">CRUD dla Placówki</a></li>
             <li><a href="${pageContext.request.contextPath}">Powrót do strony głównej</a></li>
</ul>
 


 <form:form method="POST" modelAttribute="employee" action="${pageContext.request.contextPath}/employee/adding" >
-
-        <label>Imię :<form:input  path="firstName" /></label>
-  
-
-        <label>Nazwisko :<form:input  path="lastName" /></label>
- 
- 
-        <label>Nr telefonu :<form:input  path="telephoneNumber"/></label>
-        
-         <label>Email :<form:input  path="email"/></label>
-  
-
-        <label>Adres :<form:input  path="adress" /></label>
-    
-  
-        <label>Kod pocztowy :<form:input  path="postcode" /></label>
-    
-  
-        <label>Miasto :<form:input  path="town" /></label>
- 
-
-         <label>Kraj : <form:input  path="country" />
-        </label>
-
<label>Placowka : <form:input  path="outpost" />
-        </label>
- 
-        <input  type="submit" value="Zatwierdź">
-
-    </form:form>


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
  

   

  
</body>
</html>
</html>