<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html ng-app="custom">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
  
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800,400italic,300italic,600italic,800italic,700italic|Lobster' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link href="../../css/foundation.css" rel="stylesheet" type="text/css">
  <link href="../../css/animate.css" rel="stylesheet" type="text/css">
  <link href="../../css/style.css" rel="stylesheet" type="text/css">

  <script src="../../js/jquery.js" type="text/javascript" ></script>
  <script src="../../js/modernizr.js" type="text/javascript" ></script>
  <script src="../../js/foundation.min.js" type="text/javascript" ></script>
  <script src="../../js/jquery.viewportchecker.js" type="text/javascript" ></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" ></script>
  <script src="../../js/tables/customer/customer.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  
</head>
<body>
   <!--Nawigacja menuTop.scss-->
  <header class="menu">
    <div class="addMenuAnimation"></div>
    <div class="logo">
      <a href="../../index.jsp">Vitaneo</a>
    </div>
    <ul class="menuDesktop">
      <li><a href="#">Pracownik</a>
        <ul class="rollOutMenu">
          <li><a href="../employee/employee.jsp#showAllEmployee">Pokaż wszystkich</a></li>
          <li><a href="../employee/employee.jsp#addEmployee">Dodaj</a></li>
          <li><a href="#">Usuń</a></li>
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="#">Placówka</a>
         <ul class="rollOutMenu">
          <li><a href="../department/department.jsp#showAllDepartmentLink">Pokaż wszystkich</a></li>
          <li><a href="../department/department.jsp#addDepartmentLink">Dodaj</a></li>
          <li><a href="#">Edytuj</a></li>
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="#">Menu3</a></li>
      <li><a href="#">Menu4</a></li>
      <li><a href="#">Menu5</a></li>
    </ul>
    <div class="logInSection">
      <div class="registerButton">
        <a href="register.html">Zarejestruj</a>
      </div>
      <div class="logInButton">Zaloguj</div>
      <div class="logInForm">
        <label>email: <input type="text"></input></label>
        <label>haslo: <input type="password"></input></label>
      </div>
    </div>
    <div class="bars">
      <a href="#">
        <i class="fa fa-bars"></i>
      </a>
    </div>
    <ul class="menuMobile">
      <li><a href="employee.jsp">Pracownik</a></li>
      <li><a href="department.jsp">Placówka</a></li>
      <li><a href="#">mob3</a></li>
      <li><a href="#">mob4</a></li>
      <li><a href="#">mob5</a></li>
      <li><a href="login.html">Zaloguj</a></li>
    </ul>
  </header>

     <!--kotwica-->
  <a href="#" name="showAllCustomer"></a>
  <div class="showAll row ">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea">
        <div class="large-6 medium-12 columns">Imię<input type="text"/></div>
        <div class="large-6 medium-12 columns">Nazwisko<input type="text"/></div>
        <div class="large-6 medium-6 columns">Nr telefonu<input type="text"/></div>
        <div class="large-6 medium-6 columns"><input class="buttonL" type="submit" value="Wyszukaj"></div>
      </div>
    </div>
   
   <div ng-controller="customerAddCtrl">
    <table ng-repeat="customer in customers">
      <tr>
        <td><b>imię: </b><span> {{ customer.firstName }}</span></td>
        <td><b>nazwisko: </b><span> {{ customer.lastName }}</span></td>
        <td class="hideColumn"><b>nr telefonu: </b><span> {{ customer.telephoneNumber }}</span></td>
	  </tr>
    </table>
    </div>
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addCustomer"></a>
  <div class="add row">
    <h1>Dodaj Klienta</h1>
    <div class="formError">
      <h2>Uzupełnij poprawnie formularz !</h2>
    </div>
      <div class="medium-6 large-6 columns">
        <label>Imię :<input type="text" placeholder="imię" id="cFirstName" minLength="2" maxlength="20" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nazwisko :<input type="text" placeholder="Nazwisko" id="cLastName" minLength="2" maxlength="40"/></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nr telefonu :<input type="text" placeholder="Nr telefonu" id="cTelephoneNumber" minLength="2" maxlength="12"/></label>
      </div>
      <div class="medium-6 large-6 columns formSubmit">
        <div class="buttonL" id="addCustomerButton">Zatwierdź</div>
      </div>
  </div>
  
</body>
</html>