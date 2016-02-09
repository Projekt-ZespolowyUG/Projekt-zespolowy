<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html ng-app="custom">
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
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  
  <!--kotwica-->
  <a href="#" name="showAllCustomerLink"></a>
  <div class="showAll row ">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea">
        <div class="large-6 medium-12 columns">Imię<input type="text"/></div>
        <div class="large-6 medium-12 columns">Nazwisko<input type="text"/></div>
        <div class="large-6 medium-6 columns">Nr telefonu<input type="text"/></div>
        <div class="large-6 medium-6 columns"><input class="buttonL" type="submit" value="Wyszukaj"></div>
      </div>
    </div>
   
   <div ng-controller="customerGetCtrl">
    <table ng-repeat="customer in customers">
      <tr>
        <td class="small-6 medium-4 columns"><b>imię: </b><span> {{ customer.firstName }}</span></td>
        <td class="small-6 medium-4 columns"><b>nazwisko: </b><span> {{ customer.lastName }}</span></td>
        <td class="medium-4 columns "><b>nr telefonu: </b><span> {{ customer.telephoneNumber }}</span></td>
	  </tr>
    </table>
    </div>
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addCustomerLink"></a>
  <div ng-controller="customerAddCtrl" class="add row">
    <h1>Dodaj Klienta</h1>
    <div class="formError">
      <h2>Uzupełnij poprawnie formularz !</h2>
    </div>
      <div class="medium-6 large-6 columns">
        <label>Imię :<input type="text" placeholder="imię" id="cFirstName" minLength="2" maxlength="20" ng-model="firstName" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nazwisko :<input type="text" placeholder="Nazwisko" id="cLastName" minLength="2" maxlength="40" ng-model="lastName"/></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nr telefonu :<input type="text" placeholder="Nr telefonu" id="cTelephoneNumber" minLength="2" maxlength="12" ng-model="telephoneNumber"/></label>
      </div>
      <div class="medium-6 large-6 columns formSubmit">
        <div class="buttonL" id="addCustomerButton" ng-click="addCustomer()">Zatwierdź</div>
      </div>
  </div>
  
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
  
</body>
</html>