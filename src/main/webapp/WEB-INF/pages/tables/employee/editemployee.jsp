<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="editEmp">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
   <!-- Importy Jsy i Cssy -->
   <jsp:include page="../../sections/head.jsp" />
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  <script src="../../js/tables/employee/editemployee.js" type="text/javascript"></script>
</head>
<body>
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  
  <div class="editSingle">
    <div class="large-4 medium-6 editSingleImage columns">
      <img src="../../img/prac.jpg" alt="pracownik">
    </div>
    <div class="large-8 medium-6 columns editSingleInfo" ng-controller="editEmployeeCtrl">
      <div class="row">
        <div class="column"><span>Id:</span> <input type="text" ng-model="employee.id"/></div>
        <div class="column"><span>Imię:</span> <input type="text" ng-model="employee.firstName"/></div>
        <div class="column"><span>Nazwisko:</span> <input type="text" ng-model="employee.lastName"/></div>
        <div class="large-6 columns"><span>Miasto:</span> <input type="text" ng-model="employee.town"/></div>
        <div class="large-6 columns"><span>Kod pocztowy:</span> <input type="text" ng-model="employee.postcode"/></div>
        <div class="large-6 columns"><span>Nr telefonu:</span><input type="text" ng-model="employee.telephoneNumber"/></div>
        <div class="large-6 columns"><span>Adres:</span><input type="text" ng-model="employee.adress"/></div>
        <div class="large-6 columns"><span>Kraj:</span><input type="text" ng-model="employee.country"/></div>
        <div class="large-6 columns"><span>Email:</span><input type="text" ng-model="employee.email"/></div>
        <div class="large-6 columns">
      	  <label>Placówka
	        <select ng-model="employee.outpost.id">
	          <option ng-repeat="department in departments">{{ department.id }}</option>
	        </select>
	      </label>
	    </div>
        <div class="large-6 columns buttonS" ng-click="saveEmployee()">Zapisz</div>
      </div>
    </div>
  </div>
  
    <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>