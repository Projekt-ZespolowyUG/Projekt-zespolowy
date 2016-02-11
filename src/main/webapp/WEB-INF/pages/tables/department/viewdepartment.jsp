<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="viewDep">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
   <!-- Importy Jsy i Cssy -->
   <jsp:include page="../../sections/head.jsp" />
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  <script src="../../js/tables/department/viewdepartment.js" type="text/javascript"></script>
</head>
<body>
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  <div class="showSingle">
    <div class="large-4 medium-6 showSingleImage columns">
      <img src="../../img/firma.jpg" alt="DHL">
    </div>
    <div class="large-8 medium-6 columns showSingleInfo" ng-controller="viewDepartmentCtrl">
      <div class="row">
        <div class="column"><span>Nazwa:</span> {{ id }}{{ department.name }}</div>
        <div class="large-6 columns"><span>Miasto:</span> {{ department.town }}</div>
        <div class="large-6 columns"><span>Kraj:</span> {{ department.country }}</div>
        <div class="large-6 columns"><span>Adres:</span> {{ department.adress }}</div>
        <div class="large-6 columns"><span>Kod pocztowy:</span>{{ department.postcode }}</div>
      </div>
    </div>
    <div class="column">
      <h3>Lista pracowników</h3>
      <div class="showAll row ">
        <div ng-controller="viewDepartmentEmployeesCtrl">
        <table ng-repeat="employee in employees">
          <tr>
            <td><b>imię: </b><span> {{ employee.firstName }}</span></td>
            <td><b>nazwisko: </b><span> {{ employee.lastName }}</span></td>
            <td class="hideColumn"><b>Miasto: </b><span> {{employee.town }}</span></td>
            <td class="hideColumn"><b> Kod pocztowy:</b><span>{{ employee.postcode }}</span></td>
          </tr>
          <tr>
            <td ><b>Nr telefonu: </b><span> {{ employee.telephoneNumber }}</span></td>
            <td class="hideColumn"><b>Adres: </b><span> {{ employee.adress }}</span></td>
            <td class="hideColumn"><b>Kraj: </b><span> {{ employee.country }}</span></td>
            <td><b>Email: </b><span> {{ employee.getEmployees() }}</span></td>
          </tr>
        </table>
        </div>
      </div>
    </div>
  </div>
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>