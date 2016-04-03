<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="schedule">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
   <!-- Importy Jsy i Cssy -->
   <jsp:include page="../../sections/head.jsp" />
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
  <script src="../../js/tables/schedule/schedule.js" type="text/javascript"></script>
</head>
<body ng-controller="showScheduleCtrl">
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  
  <!--kotwica-->
  <div class="findSchedule row" >
    <div class="medium-6 columns">
      Wybierz datę
      <input type="date" ng-model="startDate">
    </div>
    <div class="medium-6 columns">
      <div class="buttonS text-center" ng-click="showSchedule()">Pokaż grafik</div>
    </div>
  </div>
  
  
  <div class="scheduleSection">
    <h3 style="text-align:center">{{ fullDate  }}</h3>
    <table class="schedule">
      <tr ng-repeat="hour in range">
        <td>{{ hour }}</td>
        <td>
          <div class="scheduleMeeting">
            <h4>Spotkanie z Tomkiem</h4><span>{{ hour }}:00 - {{ hour+1 }}:00</span>
          </div>
        </td>
      </tr>
    </table>
    
    <!--  <div class="buttonS">Dodaj wizyte do grafiku</div>-->
  </div>
  
  <div class="addToSchedule row">
    <div class="medium-6 columns">
      Wybierz klienta
	    <select ng-model="customer">
	    	<option ng-repeat="customer in customers" value="{{customer.id}}">{{ customer.firstName }} {{ customer.lastName }}</option>
		</select>
    </div>
    <div class="medium-6 columns">
      Podaj czas rozpoczęcia
      <input type="time" ng-model="staT">
    </div>
    <div class="medium-6 columns" >
      Podaj czas zakończenia
      <input type="time" ng-model="endT">
    </div>

    <div class="medium-6 columns">
      <div class="buttonS text-center" ng-click="addVisit()">Dodaj</div>
    </div>
  </div>
  
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>