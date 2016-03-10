<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="visit">
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

     <!--kotwica-->
  <a href="#" name="showAllVisits"></a>
  <div class="showAll row ">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea">
        <div class="large-4 medium-6 columns">Nazwa<input type="text"/></div>
        <div class="large-4 medium-6 columns">Rodzaj      
          <select>
            <option>spotkanie</option>
            <option>przerwa</option>
          </select>
        </div>
        <div class="large-4 medium-6 columns">Podaj Datę<input type="date"/></div>
        <div class="large-4 medium-6 columns">Czas rozpoczęcia<input type="time"/></div>
        <div class="large-4 medium-6 columns">Czas zakończenia<input type="time"/></div>
        <div class="large-4 medium-4 columns"><input class="buttonL" type="submit" value="Wyszukaj"></div>

      </div>
    </div>
    <div ng-controller="visitListCtrl">
    <table ng-repeat="visit in visits">
      <tr>
       <td><b>Pracownik </b><span>{{visit.employee.firstName }} {{visit.employee.lastName }}</span></td>
        <td class="hideColumn"><b>Klient </b><span> {{visit.employee.firstName }}</span></td>
      </tr>
      <tr>
        <td><b>czas rozpoczęcia: </b><span> {{ visit.startDate }}</span></td>
        <td><b>czas zakończenia: </b><span> {{ visit.endDate }}</span></td>
      </tr>
    </table>
    </div>
    </div>
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html> 