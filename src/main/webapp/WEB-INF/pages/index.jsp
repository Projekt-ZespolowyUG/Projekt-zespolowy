<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800,400italic,300italic,600italic,800italic,700italic|Lobster' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link href="css/foundation.css" rel="stylesheet" type="text/css">
  <link href="css/animate.css" rel="stylesheet" type="text/css">
  <link href="css/startloading.css" rel="stylesheet" type="text/css">
  <link href="css/style.css" rel="stylesheet" type="text/css">
  <script src="js/jquery.js" type="text/javascript" ></script>
  <script src="js/modernizr.js" type="text/javascript" ></script>
  <script src="js/foundation.min.js" type="text/javascript" ></script>
  <script src="js/jquery.viewportchecker.js" type="text/javascript" ></script>
  <script src="js/main.js" type="text/javascript"></script>
  <script src="js/formsValidation.js" type="text/javascript"></script>
</head>
<body>
  <!--Ładowanie głównej stronie-->
  <div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right">
      <span>Vitaneo</span>
    </div>
  </div>
  
   <!--Nawigacja menuTop.scss-->
  <header class="menu">
    <div class="addMenuAnimation"></div>
    <div class="logo">
      <a href="index.jsp">Vitaneo</a>
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
          <li><a href="tables/department/department.jsp#showAllDepartmentLink">Pokaż wszystkich</a></li>
          <li><a href="tables/department/department.jsp#addDepartmentLink">Dodaj</a></li>
          <li><a href="#">Edytuj</a></li>
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="#">Klient</a>
         <ul class="rollOutMenu">
          <li><a href="customer.html#showAllCustomer">Pokaż wszystkich</a></li>
          <li><a href="customer.html#addCustomer">Dodaj</a></li>
          <li><a href="#">Edytuj</a></li>
        </ul>
        <i class="fa fa-angle-up"></i></li>
      <li><a href="#">Wizyta</a>
         <ul class="rollOutMenu">
          <li><a href="visit.html#showAllVisits">Pokaż wszystkie</a></li>
          <li><a href="visit.html#addVisit">Dodaj</a></li>
          <li><a href="#">Edytuj</a></li>
        </ul>
        <i class="fa fa-angle-up"></i></li>
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
      <li><a href="tables/department/department.jsp">Placówka</a></li>
      <li><a href="#">mob3</a></li>
      <li><a href="#">mob4</a></li>
      <li><a href="#">mob5</a></li>
      <li><a href="login.html">Zaloguj</a></li>
    </ul>
  </header>

 
  <div class="mainPage">
    <div class="row">
      <div class="columns helloSection ">
        <h1>Witaj na <span>Vitaneo</span> !</h1>
      </div>
      <div class="large-3 columns ">
        <p>stwórz konto </p>
        <i class="fa fa-user"></i>
      </div>
      <div class="large-1 columns directArrow  ">
        <i class="fa fa-long-arrow-right"></i>
      </div>
      <div class="large-4 columns ">
        <p>znajdź osobę z którą chcesz się umówić</p>
        <i class="fa fa-search"></i>
      </div>
      <div class="large-1 columns directArrow ">
        <i class="fa fa-long-arrow-right"></i>
      </div>
      <div class="large-3 columns  ">
        <p>umów się na wizytę</p>
        <i class="fa fa-calendar-check-o"></i>
      </div>
    </div>
    <div class="redirectRegister ">
      <a href="register.html" class="buttonS">Zarejestruj się</a>
    </div>
  </div>
   
  <div class="footer">
    <div class="row">
      <div class="leftFooter medium-8 columns text-center">
        <div class="row">
          <ul>
            <li class="small-4 medium-3 columns"><a href="employee.html">Pracownik</a></li>
            <li class="small-4 medium-2 columns"><a href="tables/department/department.jsp#">Placówki</a></li>
            <li class="small-4 medium-2 columns"><a href="#">menu3</a></li>
            <li class="small-6 medium-2 columns"><a href="#">menu4</a></li>
            <li class="small-6 medium-3 columns"><a href="#">menu5</a></li>
          </ul>
          <div class="large-12 columns">
            Projekt zespołowy UG <br>
            Krzysztof Stelmach - Martin Zelek  - Robert Knop
          </div>
        </div>
      </div>
      <div class="rightFooter medium-4 columns text-center">
        <a href="#"><i class="fa fa-facebook-square"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-google-plus-square"></i></a>
        <a href="#"><i class="fa fa-git"></i></a>
      </div>
    </div>
  </div>
  
</body>
</html>