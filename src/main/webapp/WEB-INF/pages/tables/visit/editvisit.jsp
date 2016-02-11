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
  
  <div class="editSingle">
    <div class="large-4 medium-6 editSingleImage columns">
      <img src="img/emplo.jpg" alt="DHL">
    </div>
    <div class="large-8 medium-6 columns editSingleInfo">
      <div class="row">
        <div class="large-6 columns"><span>Nazwa:</span> <input type="text"/></div>
        <div class="large-6 columns"><span>Rodzaj:</span>        
         <select>
          <option>spotkanie</option>
          <option>przerwa</option>
        </select></div>
        <div class="large-6 columns"><span>Data:</span> <input type="date"/></div>
        <div class="large-6 columns"><span>Czas rozpoczecia:</span> <input type="time"/></div>
        <div class="large-6 columns"><span>Czas zakonczenia:</span> <input type="time"/></div>
        <div class="large-6 columns"><span>Opis:</span> <textarea></textarea></div>

      </div>
    </div>
  </div>  
    <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>