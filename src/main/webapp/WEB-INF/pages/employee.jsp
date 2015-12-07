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
  
  
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800,400italic,300italic,600italic,800italic,700italic|Lobster' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link href="css/foundation.css" rel="stylesheet" type="text/css">
  <link href="css/animate.css" rel="stylesheet" type="text/css">
  <link href="css/flexslider.css" rel="stylesheet" type="text/css">
  <link href="css/style.css" rel="stylesheet" type="text/css">

  <script src="js/jquery.js" type="text/javascript" ></script>
  <script src="js/modernizr.js" type="text/javascript" ></script>
  <script src="js/foundation.min.js" type="text/javascript" ></script>
  <script src="js/jquery.viewportchecker.js" type="text/javascript" ></script>
  <script src="js/jquery.flexslider-min.js" ></script>
  <script src="js/main.js" type="text/javascript"></script>
</head>
<body>
   <!--Nawigacja menuTop.scss-->
  <header class="menu">
    <div class="logo">
      <a href="${pageContext.request.contextPath}">Wizyty</a>
    </div>
    <ul class="menuDesktop">
      <li><a href="#">Pracownik</a>
        <ul class="rollOutMenu">
          <li><a href="${pageContext.request.contextPath}/pages/employee.jsp#showAllEmployee">Pokaż wszystkich</a></li>
          <li><a href="${pageContext.request.contextPath}/pages/employee.jsp#addEmployee">Dodaj</a></li>
          <li><a href="#">Usuń</a></li>
          <li><a href="${pageContext.request.contextPath}/showEmployee">Pokaż wszystkich</a></li>
          <li><a href="${pageContext.request.contextPath}/addEmployee">Dodaj</a></li>
          <li><a href="#">Usuń</a></li>
        </ul>
      </li>
      <li><a href="#">Menu2</a></li>
      <li><a href="#">Menu3</a></li>
      <li><a href="#">Menu4</a></li>
      <li><a href="#">Menu5</a></li>
    </ul>
    <div class="logInSection">
      <a href="#">Zarejestruj</a>
      <div class="">zaloguj</div>
    </div>
    <div class="bars">
      <a href="#">
        <i class="fa fa-bars"></i>
      </a>
    </div>
    <ul class="menuMobile">
      <li><a href="#">mob1</a></li>
      <li><a href="#">mob2</a></li>
      <li><a href="#">mob3</a></li>
      <li><a href="#">mob4</a></li>
      <li><a href="#">mob5</a></li>
      <li><a href="#">mob6</a></li>
    </ul>
  </header>

     <!--kotwica-->
  <a href="#" name="showAllEmployee"></a>
  <div class="showAllEmployee row">
    <table>
    <p:forEach  items="${employees}" var="employee" >  
      <tr>
        <td><b>imiÄ: </b><span> <p:out value="${employee.firstName}"/></span></td>
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
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addEmployee"></a> 
  <div class="addEmployee row">
    <h1>Dodaj Pracownika</h1>
    <form method="POST" modelAttribute="employee" action="${pageContext.request.contextPath}/add" >
      <div class="medium-6 large-6 columns">
        <label>Imię :<input type="text" placeholder="imię" path="firstName" id="eName"/></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nazwisko :<input type="text" placeholder="Nazwisko" path="lastName" id="eLastname" /></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Nr telefonu :<input type="text" placeholder="Nr telefonu" path="telephoneNumber" id="eTelephoneNumber"/></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Adres :<input type="text" placeholder="Adres" path="adress" id="eAdress" /></label>
      </div>
      <div class="medium-12 large-4 columns">
        <label>Kod pocztowy :<input type="text" placeholder="Kod pocztowy" path="postcode" id="ePostcode" /></label>
      </div>
      <div class="medium-12 large-4 columns">
        <label>Miasto :<input type="text" placeholder="Miasto" path="town" id="eTown" /></label>
      </div>
      <div class="medium-6 large-4 columns">
         <label>Kraj :
          <select>
            <option value="Polska" path="country">Polska</option>
            <option value="Afganistan" path="country">Afganistan</option>
            <option value="Anglia" path="country">Anglia</option>
            <option value="Francja" path="country">Francja</option>
          </select>
        </label>
      </div>
      <div class="medium-6 large-4 columns formSubmit">
        <input class="buttonL" type="submit" id="employeeAdd" value="Zatwierdź" id="employeeAddForm">
      </div>
    </form>
  </div>
  
</body>
</html>
</html>