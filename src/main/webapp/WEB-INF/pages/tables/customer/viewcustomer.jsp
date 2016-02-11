<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
   <!-- Importy Jsy i Cssy -->
   <jsp:include page="../../sections/head.jsp" />
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  <script src="../../js/tables/employee/employee.js" type="text/javascript"></script>
</head>
<body>
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  <div class="showSingle">
    <div class="large-4 medium-6 showSingleImage columns">
      <img src="img/dhl.jpg" alt="DHL">
    </div>
    <div class="large-8 medium-6 columns showSingleInfo">
      <div class="row">
        <div class="column"><span>Imię:</span> Adam</div>
        <div class="column"><span>Nazwisko:</span> Nowak</div>
        <div class="large-6 columns"><span>Miasto:</span> Gdańsk</div>
        <div class="large-6 columns"><span>Kod pocztowy:</span> 90-929</div>
        <div class="large-6 columns"><span>Nr telefonu:</span>666 666 666</div>
        <div class="large-6 columns"><span>Adres:</span>ul.długa 7</div>
        <div class="large-6 columns"><span>Kraj:</span>Anglia</div>
        <div class="large-6 columns"><span>Email:</span>nowak@op.pl</div>
      </div>
    </div>
  </div>
  <div class="footer">
    <div class="row">
      <div class="leftFooter medium-8 columns text-center">
        <div class="row">
          <ul>
            <li class="small-4 medium-3 columns"><a href="employee.html">Pracownik</a></li>
            <li class="small-4 medium-2 columns"><a href="department.html">Placówki</a></li>
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
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>