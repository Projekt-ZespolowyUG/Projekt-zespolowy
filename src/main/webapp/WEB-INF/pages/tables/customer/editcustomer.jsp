<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head lang="pl">
  <title>Projekt zespolowy</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Importy Jsy i Cssy -->
  <jsp:include page="../../sections/head.jsp" />
  
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" ></script>
  <script src="../../js/tables/customer/customer.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  
</head>
<body>
   <!--Nawigacja menuTop.scss-->
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  

  <div class="editSingle">
    <div class="large-4 medium-6 editSingleImage columns">
      <img src="../../img/klient.jpg" alt="Klient">
    </div>
    <div class="large-8 medium-6 columns editSingleInfo">
      <div class="row">
        <div class="column"><span>Imię:</span> <input type="text"/></div>
        <div class="column"><span>Nazwisko:</span> <input type="text"/></div>
        <div class="column"><span>Nr telefonu:</span><input type="text"/></div>

        <div class="columns buttonS">Zapisz</div>
      </div>
    </div>
  </div>
    <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>