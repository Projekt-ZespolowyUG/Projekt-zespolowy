<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="editDep">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
   <!-- Importy Jsy i Cssy -->
   <jsp:include page="../../sections/head.jsp" />
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  <script src="../../js/tables/department/editdepartment.js" type="text/javascript"></script>
</head>
<body>
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  <div class="editSingle">
  
    <div class="large-4 medium-6 editSingleImage columns">
      <img src="../../img/firma.jpg" alt="firma">
    </div>

    <div class="large-8 medium-6 columns editSingleInfo" ng-controller="editDepartmentCtrl">
      <div class="row">
        <div class="column" style="display:none"><span>ID:</span><input type="text" ng-model="department.id"/></div>
        <div class="column"><span>Nazwa:</span><input type="text" ng-model="department.name"/></div>
        <div class="large-6 columns"><span>Miasto:</span><input type="text" ng-model="department.town"/></div>
        <div class="large-6 columns"><span>Kraj:</span><input type="text" ng-model="department.country"/></div>
        <div class="large-6 columns"><span>Adres:</span> <input type="text" ng-model="department.adress"/></div>
        <div class="large-6 columns"><span>Kod pocztowy:</span><input type="text" ng-model="department.postcode"/></div>
        <div class="columns buttonS" ng-click="saveDepartment()">Zapisz</div>
      </div>
    </div>
  </div>

    <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />

</body>

</html>