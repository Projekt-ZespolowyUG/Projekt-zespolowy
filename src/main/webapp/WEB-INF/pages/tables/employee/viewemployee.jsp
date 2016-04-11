<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="viewEmp">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
   <!-- Importy Jsy i Cssy -->
   <jsp:include page="../../sections/head.jsp" />
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  <script src="../../js/tables/employee/viewemployee.js" type="text/javascript"></script>
</head>
<body>
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  <div class="showSingle">
    <div class="large-4 medium-6 showSingleImage columns">
      <img src="../../img/prac.jpg" alt="pracownik">
    </div>
    <div ng-controller="showSingleEmployeeCtrl" class="large-8 medium-6 columns showSingleInfo">
      <div class="row">
        <div class="column"><span>Imię:</span> {{ employee.firstName }}</div>
        <div class="column"><span>Nazwisko:</span> {{ employee.lastName }}</div>
        <div class="large-6 columns"><span>Miasto:</span> {{ employee.town }}</div>
        <div class="large-6 columns"><span>Kod pocztowy:</span> {{ employee.town }} </div>
        <div class="large-6 columns"><span>Nr telefonu:</span> {{ employee.telephoneNumber }} </div>
        <div class="large-6 columns"><span>Adres:</span> {{ employee.adress }}</div>
        <div class="large-6 columns"><span>Kraj:</span> {{ employee.country }}</div>
        <div class="large-6 columns"><span>Email:</span>{{ employee.email }}</div>
      </div>
    </div>
  </div>
  <div class="row showEmpSchedule" ng-controller="sheduleRedirectCtrl">
    <a  class="buttonS column" href="../schedule/schedule.jsp?id={{ idEmpl }}">Pokaż grafik pracownika</a>
  </div>
  
  <div class="addScheduleHours row" ng-controller="scheduleHoursCtrl">
    <div class="buttonS" id="addHours" >Dodaj godziny pracy</div>
    <div class="scheduleWeeks">
      <div class="medium-4 columns">Początkowa data: <input ng-model="startDate" type="date"></div>
      <div class="medium-4 columns">Końcowa data:<input ng-model="endDate" type="date"></div>
      <div class="medium-4 columns buttonS" id="scheduleList" ng-click="showScheduleDays() ">Pokaż</div>
    </div>
    <div class="scheduleHours" >
      <div class="scheduleDay" ng-repeat="schedule in schedules">
        <div class="medium-4 columns"> <!-- {{ schedule.dayofweek }}--> {{ schedule.dayofmonth }}.{{schedule.month}}.{{ schedule.year }} 
        	<!--  <div class="toggleButtons" id="imWorking" ><span class="toggleButtonNo"></span></div><-->
        </div>
        <div class="setScheduleHours"> 
          <label class="medium-4 columns">Od<input  type="text" ng-model="stTime[$index]"></label>
          <label class="medium-4 columns">Do<input type="text" ng-model="enTime[$index]"></label>
 
      	</div>
	 </div>
	 <div class="buttonS saveHours" ng-click="saveSchedulehours()">Zapisz godziny pracy</div> 
    </div>
    
  </div>
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>