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
   
    <table>
      <tr>
       <td><b>nazwa: </b><span> Przegląd</span></td>
        <td class="hideColumn"><b>rodzaj: </b><span> spotkanie</span></td>
        <td><b>data: </b><span> 12.12.1994</span></td>
      </tr>
      <tr>
        <td><b>czas rozpoczęcia: </b><span> 16:00</span></td>
        <td><b>czas zakończenia: </b><span> 17:00</span></td>
      </tr>
    </table>
    <table>
      <tr>
       <td><b>nazwa: </b><span> Przegląd</span></td>
        <td class="hideColumn"><b>rodzaj: </b><span> spotkanie</span></td>
        <td><b>data: </b><span> 12.12.1994</span></td>
      </tr>
      <tr>
        <td><b>czas rozpoczęcia: </b><span> 16:00</span></td>
        <td><b>czas zakończenia: </b><span> 17:00</span></td>
      </tr>
    </table>
    </div>
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html> 