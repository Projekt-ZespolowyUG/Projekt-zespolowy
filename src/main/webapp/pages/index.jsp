<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800,400italic,300italic,600italic,800italic,700italic|Lobster' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link href="${pageContext.request.contextPath}/css/foundation.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/startloading.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
  <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript" ></script>
  <script src="${pageContext.request.contextPath}/js/modernizr.js" type="text/javascript" ></script>
  <script src="${pageContext.request.contextPath}/js/foundation.min.js" type="text/javascript" ></script>
  <script src="${pageContext.request.contextPath}/js/jquery.viewportchecker.js" type="text/javascript" ></script>
  <script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/formsValidation.js" type="text/javascript"></script>
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
  
  <!--Menu górne i mobilne  -->
  <jsp:include page="sections/menuTop.jsp" />

 
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
   
  <!-- stopka --> 
  <jsp:include page="sections/footer.jsp" />
  
</body>
</html>