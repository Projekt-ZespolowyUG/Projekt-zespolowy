<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="employee">
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
      <img src="img/dhl.jpg" alt="DHL">
    </div>

    <div class="large-8 medium-6 columns editSingleInfo">
      <div class="row">
        <div class="column"><span>Nazwa:</span><input type="text"/></div>
        <div class="large-6 columns"><span>Miasto:</span><input type="text"/></div>
        <div class="large-6 columns"><span>Kraj:</span><input type="text"/></div>
        <div class="large-6 columns"><span>Adres:</span> <input type="text"/></div>
        <div class="large-6 columns"><span>Kod pocztowy:</span><input type="text"/></div>
      </div>
    </div>

    <div class="column">
      <h3>Lista pracowników</h3>
      <div class="showAll row ">
        <table>
          <tr>
            <td><b>imię: </b><span> Andrzej</span></td>
            <td><b>nazwisko: </b><span> Kowalkiewicz</span></td>
            <td class="hideColumn"><b>Miasto: </b><span> Los Angeles</span></td>
            <td class="hideColumn"><b> Kod pocztowy:</b><span>90-999</span></td>
          </tr>
          <tr>
            <td ><b>Nr telefonu: </b><span> 700-800-700</span></td>
            <td class="hideColumn"><b>Adres: </b><span> polna 5/34a</span></td>
            <td class="hideColumn"><b>Kraj: </b><span> Azerbejdzan</span></td>
            <td><b>Email: </b><span> Adamek@op.pl</span></td>
          </tr>
        </table>

        <table>
          <tr>
            <td><b>imię: </b><span> Andrzej</span></td>
            <td><b>nazwisko: </b><span> Kowalkiewicz</span></td>
            <td class="hideColumn"><b>Miasto: </b><span> Los Angeles</span></td>
            <td class="hideColumn"><b> Kod pocztowy:</b><span>90-999</span></td>
          </tr>
          <tr>
            <td ><b>Nr telefonu: </b><span> 700-800-700</span></td>
            <td class="hideColumn"><b>Adres: </b><span> polna 5/34a</span></td>
            <td class="hideColumn"><b>Kraj: </b><span> Azerbejdzan</span></td>
            <td><b>Email: </b><span> Adamek@op.pl</span></td>
          </tr>
        </table>

      </div>
    </div>
  </div>
  
    <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />

</body>

</html>