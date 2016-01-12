<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<html>
<head lang="pl">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pracownik</title>

</head>
<body>
	<ul>

		<li><a href="${pageContext.request.contextPath}/employee/crud">CRUD
				dla Pracownika</a></li>
		<li><a href="${pageContext.request.contextPath}/outpost/crud">CRUD
				dla Placówki</a></li>
		<li><a href="${pageContext.request.contextPath}">Powrót do
				strony głównej</a></li>
	</ul>



	<form:form method="POST" modelAttribute="employee"
		action="${pageContext.request.contextPath}/employee/add">
-
-        <label>Imię :<form:input path="firstName" /></label>
-  <label><form:errors path="firstName"
				cssStyle="color: red;   font-style: italic;
    font-weight: bold;" /></label>
-<br>
-        <label>Nazwisko :<form:input path="lastName" /></label>
- <label><form:errors path="lastName"
				cssStyle="color: red;   font-style: italic;
    font-weight: bold;" /></label>
- -<br>
-        <label>Nr telefonu :<form:input path="telephoneNumber" /></label>
- <label><form:errors path="telephoneNumber"
				cssStyle="color: red;   font-style: italic;
    font-weight: bold;" /></label>
-     -<br>
-         <label>Email :<form:input path="email" /></label>
		<label><form:errors path="email"
				cssStyle="color: red;   font-style: italic;
    font-weight: bold;" /></label>
-  -<br>
-
-        <label>Adres :<form:input path="adress" /></label>
-    <label><form:errors path="adress"
				cssStyle="color: red;   font-style: italic;
    font-weight: bold;" /></label>
-  -<br>
-        <label>Kod pocztowy :<form:input path="postcode" /></label>
-    <label><form:errors path="postcode"
				cssStyle="color: red;   font-style: italic;
    font-weight: bold;" /></label>
-  -<br>
-        <label>Miasto :<form:input path="town" /></label>
- <label><form:errors path="town"
				cssStyle="color: red;  font-style: italic;
    font-weight: bold;" /></label>
--<br>
-         <label>Kraj : <form:input path="country" /> -
		</label>
		<label><form:errors path="country"
				cssStyle="color: red;   font-style: italic;
    font-weight: bold;" /></label>
		<br>
		<label>Placówka ID : <form:input path="outpost.idOutpost" />
			-<br> - - <input type="submit" value="Zatwierdź"> - - 
	</form:form>


	<table style="text-align: center;" border="1px" cellpadding="0"
		cellspacing="0">
		<tbody>
			<p:forEach items="${employees}" var="employee">
				<tr>
					<td><b>imie: </b>
					<p:out value="${employee.firstName}" /></td>
					<td><b>nazwisko: </b> <p:out value="${employee.lastName}" /></td>
					<td><b>Nr telefonu: </b> <p:out
							value="${employee.telephoneNumber}" /></td>
					<td><b>Email: </b> <p:out value="${employee.email}" /></td>
					<td><b> Kod pocztowy:</b>
					<p:out value="${employee.postcode}" /></td>
				</tr>
				<tr>
					<td><b>Miasto: </b> <p:out value="${employee.town}" /></td>
					<td><b>Adres: </b>
					<p:out value="${employee.adress}" /></td>
					<td><b>Kraj: </b> <p:out value="${employee.country}" /></td>
					<td><b>Outpost: </b> <p:out value="${employee.outpost.name}" /></td>
			</p:forEach>
		</tbody>
	</table>





</body>
</html>
</html>