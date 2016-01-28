<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="depart">
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
  <script src="../../js/tables/department/department.js" type="text/javascript"></script>
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
          <li><a href="employee.html#showAllEmployee">Pokaż wszystkich</a></li>
          <li><a href="employee.html#addEmployee">Dodaj</a></li>
          <li><a href="#">Usuń</a></li>
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="#">Placówka</a>
         <ul class="rollOutMenu">
          <li><a href="department.html#showAllDepartment">Pokaż wszystkich</a></li>
          <li><a href="department.html#addDepartment">Dodaj</a></li>
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
      <li><a href="department.html">Placówka</a></li>
      <li><a href="#">mob3</a></li>
      <li><a href="#">mob4</a></li>
      <li><a href="#">mob5</a></li>
      <li><a href="login.html">Zaloguj</a></li>
    </ul>
  </header>

     <!--kotwica-->
        

  
  <a href="#" name="showAllDepartmentLink"></a>
  <div class="showAll row ">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea">
        <div class="large-4 medium-6 columns">nazwa<input type="text"/></div>
        <div class="large-4 medium-6 columns">Miasto<input type="text"/></div>
        <div class="large-4 medium-6 columns">Kraj<input type="text"/></div>
        <div class="large-4 medium-6 columns">Adres<input type="text"/></div>
        <div class="large-4 medium-6 columns">kod pocztowy<input type="text"/></div>
        <div class="large-4 medium-6 columns"><input class="buttonL" type="submit" value="Wyszukaj"></div>

      </div>
    </div>
    <div ng-controller="listDepartmentCtrl">
    <table ng-repeat="department in departments">
      <tr> 
        <td><b>Nazwa: </b><span> {{ department.name }}</span></td>
        <td><b>Miasto: </b><span> {{ department.city }}</span></td>
        <td class="hideColumn"><b>Kraj: </b><span> {{ department.country }}</span></td>
      </tr>
      <tr>
        <td><b>Adres: </b><span> {{ department.adress }}</span></td>
        <td class="hideColumn"><b> Kod pocztowy:</b><span>{{ department.postcode }}</span></td>
        <td class="crudIcons">
          <a href="viewdepartment.html" class="iconSearch"><i class="fa fa-search-plus"></i><span>pokaż</span></a>
          <a href="#" class="iconEdit"><i class="fa fa-pencil-square-o"></i><span>edytuj</span></a>
          <a href="#" class="iconDelete"><i class="fa fa-trash"></i><span>usuń</span></a></td></td>
      </tr>
    </table>
    </div>
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addDepartmentLink"></a>
  <div class="add row">
    <h1>Dodaj Placówkę</h1>
   <!--  <form action="${pageContext.request.contextPath}/outpost/add" method="POST" >-->
      <div class="medium-6 large-6 columns">
        <label>Nazwa:<input type="text" placeholder="nazwa" name="name" path="name" id="dName" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Adres :<input type="text" placeholder="Adres" name="adress" path="adress" id="dAdress"/></label>
      </div>
      <div class="medium-6 large-3 columns">
        <label>Kod pocztowy :<input type="text" placeholder="Kod pocztowy" name="postcode" path="postcode" id="dPostcode"/></label>
      </div>
      <div class="medium-6 large-3 columns">
        <label>Miasto :<input type="text" placeholder="Miasto" name="town" path="town" id="dTown"  /></label>
      </div>
      <div class="medium-6 large-3 columns">
         <label>Kraj :
          <select name="country" id="dCountry">
            <option value="Polska" path="country">Polska</option>
            <option value="Afganistan" path="country">Afganistan</option>
            <option value="Anglia" path="country">Anglia</option>
            <option value="Francja" path="country">Francja</option>
          </select>
        </label>
      </div>
      <div class="medium-6 large-3 columns formSubmit">
        <div class="buttonL" id="addDepartmentButton">Zatwierdź</div>
      </div>
  <!--  </form>-->

</body>
</html>