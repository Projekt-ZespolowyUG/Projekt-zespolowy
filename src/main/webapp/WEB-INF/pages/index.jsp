<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
  
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800,400italic,300italic,600italic,800italic,700italic|Lobster' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link href="../css/foundation.css" rel="stylesheet" type="text/css">
  <link href="../css/animate.css" rel="stylesheet" type="text/css">
  <link href="../css/flexslider.css" rel="stylesheet" type="text/css">
  <link href="../css/style.css" rel="stylesheet" type="text/css">

  <script src="../js/jquery.js" type="text/javascript" ></script>
  <script src="../js/modernizr.js" type="text/javascript" ></script>
  <script src="../js/foundation.min.js" type="text/javascript" ></script>
  <script src="../js/jquery.viewportchecker.js" type="text/javascript" ></script>
  <script src="../js/jquery.flexslider-min.js" ></script>
  <script src="../js/main.js" type="text/javascript"></script>
</head>
<body>
   <!--Nawigacja menuTop.scss-->
  <header class="menu">
    <div class="logo">
      <a href="${pageContext.request.contextPath}/pages/">Wizyty</a>
    </div>
    <ul class="menuDesktop">
      <li><a href="#">Pracownik</a>
        <ul class="rollOutMenu">
          <li><a href="${pageContext.request.contextPath}/pages/employee.jsp#showAllEmployee">Pokaż wszystkich</a></li>
          <li><a href="${pageContext.request.contextPath}/pages/employee.jsp#addEmployee">Dodaj</a></li>
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
   
  <section class="sliderSection">
    <div class="flexslider">
      <ul class="slides">
        <li>
          <div class="slideContent" style="position:absolute; top:220px; z-index:100; color:red;">lalal</div>

          <img src="../img/slider/slide.jpg" style="z-index:-1;"/>
        </li>
        <li>
          <img src="../img/slider/slide.jpg" />
        </li>
        <li>
          <img src="../img/slider/slide3.jpg" />
        </li>
        <li>
          <img src="../img/slider/slide.jpg" />
        </li>
        <li>
          <img src="../img/slider/slide5.jpg" />
        </li>
      </ul>
    </div>
  </section>

 <!--
  <div class="mainPage">
   <div class="row">
    <h1>Witaj</h1>
    </div>
  </div>
   -->

</body>
</html>