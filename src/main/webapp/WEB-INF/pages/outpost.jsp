<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Placówka</title>
</head>
<body>
<ul>
    		  
         <li><a href="${pageContext.request.contextPath}/employee/crud">CRUD dla Pracownika</a></li>
           <li><a href="${pageContext.request.contextPath}/outpost/crud">CRUD dla Placówki</a></li>
             <li><a href="${pageContext.request.contextPath}">Powrót do strony głównej</a></li>
</ul>
<i>${message}</i><br/>
<form:form method="POST" modelAttribute="outpost" action="${pageContext.request.contextPath}/outpost/add" >

        <label>Nazwa :<form:input  path="name" /></label>
        <br>
  		<label><form:errors path="name" cssStyle="color: red;"/></label>
		<br>
        <label>Adres :<form:input  path="adress" /></label>
		 <br>
  		<label><form:errors path="adress" cssStyle="color: red;"/></label>
 		<br>
        <label>Kod pocztowy :<form:input  path="postcode"/></label>
          <br>
  		<label><form:errors path="postcode" cssStyle="color: red;"/></label>
 		<br>
        <label>Miasto :<form:input  path="town" /></label>
 		<br>
  		<label><form:errors path="town" cssStyle="color: red;"/></label>
		<br>
         <label>Kraj : <form:input  path="country" /> </label>
         <br>
  		<label><form:errors path="country" cssStyle="color: red;"/></label>
       



       <input  type="submit" value="Zatwierdź">

    </form:form>
    
      <table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
   <tbody>
    <p:forEach  items="${outposts}" var="outpost" >  
      <tr>
        <td><b>Nazwa: </b><p:out value="${outpost.name}"/></td>
        <td><b>Adres: </b><p:out value="${outpost.adress}"/></td>
        <td><b> Kod pocztowy:</b><p:out value="${outpost.postcode}"/></td>
        <td><b>Miasto: </b> <p:out value="${outpost.town}"/></td>  
        <td><b>Kraj: </b> <p:out value="${outpost.country}"/></td>

    </p:forEach>  
    </tbody>
    </table>
    
</body>
</html>