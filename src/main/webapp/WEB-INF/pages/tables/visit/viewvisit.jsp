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
    <div class="columns showSingleInfo">
      <div class="row">
        <h4>Placówka</h4>
        <div class="column"><span>Nazwa:</span> DHL sp Z.O.O</div>
        <div class="large-6 columns"><span>Miasto:</span> Los Angeles</div>
        <div class="large-6 columns"><span>Adres:</span> polna 5/34a</div>
      </div>
    </div>
    <div class="columns showSingleInfo">
      <div class="row">
        <h4>Pracownik</h4>
        <div class="large-6 columns"><span>Imię:</span> Adam</div>
        <div class="large-6 columns"><span>Nazwisko:</span> Nowak</div>
        <div class="large-6 columns"><span>Nr telefonu:</span>666 666 666</div>
        <div class="large-6 columns"><span>Email:</span>nowak@op.pl</div>
      </div>
    </div>
    <div class="columns showSingleInfo">
      <div class="row">
        <h4>Spotkanie (zmienna rodzaj)</h4>
        <div class="large-6 columns"><span>Nazwa:</span>przegląd</div>
        <div class="large-6 columns"><span>Data:</span> 13.02.2016</div>
        <div class="large-6 columns"><span>czas rozpoczęcia:</span> 13:00</div>
        <div class="large-6 columns"><span>czas zakończenia:</span>16:00</div>
        <div class="large-12 columns"><span>Opis:</span> przegląd po 20tys KM</div>
      </div>
    </div>
  </div>
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>