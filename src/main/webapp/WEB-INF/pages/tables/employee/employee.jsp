<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="employee">
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
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  <script src="../../js/tables/employee/employee.js" type="text/javascript"></script>
</head>
<body>
   <!--Nawigacja menuTop.scss-->
  <header class="menu">
    <div class="addMenuAnimation"></div>
    <div class="logo">
      <a href="${pageContext.request.contextPath}/index.jsp">Vitaneo</a>
    </div>
    <ul class="menuDesktop">
      <li><a href="#">Pracownik</a>
        <ul class="rollOutMenu">
          <li><a href="employee.html#showAllEmployee">Pokaż wszystkich</a></li>
          <li><a href="employee.html#addEmployee">Dodaj</a></li>
          <li><a href="${pageContext.request.contextPath}/tables/employee/employee.jsp">Usuń</a></li>
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="#">Placówka</a>
         <ul class="rollOutMenu">
          <li><a href="department.jsp#showAllDepartmentLink">Pokaż wszystkich</a></li>
          <li><a href="department.jsp#addDepartmentLink">Dodaj</a></li>
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
      <li><a href="employee.html">Pracownik</a></li>
      <li><a href="department.jsp">Placówka</a></li>
      <li><a href="#">mob3</a></li>
      <li><a href="#">mob4</a></li>
      <li><a href="#">mob5</a></li>
      <li><a href="login.html">Zaloguj</a></li>
    </ul>
  </header>

     <!--kotwica-->
  <a href="#" name="showAllEmployee"></a>
  <div class="showAll row ">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea">
        <div class="large-4 medium-6 columns">Imię<input type="text"/></div>
        <div class="large-4 medium-6 columns">Nazwisko<input type="text"/></div>
        <div class="large-4 medium-6 columns">Miasto<input type="text"/></div>
        <div class="large-4 medium-6 columns">Kod pocztowy<input type="text"/></div>
        <div class="large-4 medium-6 columns">Nr telefonu<input type="text"/></div>
        <div class="large-4 medium-6 columns">Adres<input type="text"/></div>
        <div class="large-4 medium-4 columns">Kraj<input type="text"/></div>
        <div class="large-4 medium-4 columns">Kod pocztowy<input type="text"/></div>
        <div class="large-4 medium-4 columns"><input class="buttonL" type="submit" value="Wyszukaj"></div>

      </div>
    </div>
   <div ng-controller="addEmployeeCtrl">
    <table ng-repeat="employee in employees">
      <tr>
        <td><b>imię: </b><span>{{ employee.firstName }}</span></td>
        <td><b>nazwisko: </b><span>{{ employee.lastName }}</span></td>
        <td><b>placówka:</b><span> {{ employee.outpost.name }}</span></td>
        <td class="hideColumn"><b>Miasto: </b><span>{{ employee.town }}</span></td>
        <td class="hideColumn"><b> Kod pocztowy:</b><span>{{ employee.postcode }}</span></td>
      </tr>
      <tr>
        <td ><b>Nr telefonu: </b><span> {{ employee.telephoneNumber }}</span></td>
        <td class="hideColumn"><b>Adres: </b><span> {{ employee.adress }}</span></td>
        <td class="hideColumn"><b>Kraj: </b><span> {{ employee.country }}</span></td>
        <td><b>Email: </b><span> {{ employee.email }}</span></td>
      </tr>
    </table>
    </div>
    
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addEmployee"></a>
  <div class="add row">
    <h1>Dodaj Pracownika</h1>
    <div class="formError">
      <h2>Uzupełnij poprawnie formularz !</h2>
    </div>
      <div class="medium-6 large-6 columns">
        <label>Imię :<input type="text" placeholder="imię" id="eFirstName" minLength="2" maxlength="20" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nazwisko :<input type="text" placeholder="Nazwisko" id="eLastName" minLength="2" maxlength="40"/></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Nr telefonu :<input type="text" placeholder="Nr telefonu" id="eTelephoneNumber" minLength="2" maxlength="12"/></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Email :<input type="text" placeholder="Email" id="eEmail"  minLength="5" maxlength="40"/></label>
      </div>
      <div class="medium-4 large-4 columns">
        <label>Adres :<input type="text" placeholder="Adres" id="eAdress" minLength="2" maxlength="40"/></label>
      </div>
      <div class="medium-4 large-2 columns">
        <label>Kod pocztowy :<input type="text" placeholder="Kod pocztowy" id="ePostcode" minLength="2" maxlength="10"/></label>
      </div>
      <div class="medium-4 large-3 columns">
        <label>Miasto :<input type="text" placeholder="Miasto" id="eTown"  minLength="2" maxlength="40"/></label>
      </div>
      <div class="medium-6 large-3 columns">
        <label>Kraj :
          <select id="eCountry">
            <option>Polska</option>
            <option>Anglia</option>
            <option>Afganistan</option>
          </select>
        </label>
      </div>
      <select ng-controller="importDepartmentCtrl" id="eOutpost">
        <option ng-repeat="department in departments">{{ department.id }} Nazwa: {{ department.name }}</option>
      </select>
      <div class="medium-6 large-4 columns formSubmit">
        <div class="buttonL" id="addEmployeeButton">Zatwierdź</div>
      </div>
  </div>
  
</body>
</html>