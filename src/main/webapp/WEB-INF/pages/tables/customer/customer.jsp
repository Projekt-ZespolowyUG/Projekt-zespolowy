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
      <div class="searchArea" ng-controller="searchCustomerCtrl">
        <div class="large-6 medium-12 columns">Imię<input type="text" ng-model="fName"/></div>
        <div class="large-6 medium-12 columns">Nazwisko<input type="text" ng-model="lName"/></div>
        <div class="large-6 medium-6 columns">Nr telefonu<input type="text" ng-model="tNumber"/></div>
        <div class="large-6 medium-6 columns"><div class="buttonL" ng-click="searchCustomer()">Wyszukaj</div></div>
      </div>
    </div>
   
   <div class="tableList" ng-controller="customerGetCtrl">
    <table ng-repeat="customer in customers">

      <tr>
        
        <td class="small-6 medium-3 columns"><b>imię:  {{ pageNumber=$index+1 }}</b><span>{{ customer.firstName }}</span></td>
        <td class="small-6 medium-3 columns"><b>nazwisko: </b><span> {{ customer.lastName }}</span></td>
        <td class="medium-3 columns "><b>nr telefonu: </b><span> {{ customer.telephoneNumber }}</span></td>
        <td class="small-12 medium-3 columns  crudIcons">
          <a href="viewcustomer.jsp?id={{ customer.id }}" class="iconSearch"><i class="fa fa-search-plus"></i><span>pokaż</span></a>
          <a href="editcustomer.jsp?id={{ customer.id }}" class="iconEdit"><i class="fa fa-pencil-square-o"></i><span>edytuj</span></a>
          <a href="#"  class="iconDelete" ng-click="removeCustomer(customer.id)"><i class="fa fa-trash"></i><span>usuń</span></a>
        </td>
        
	  </tr>
    </table>
    	<div style="display:none" class="beforeDelete"> czy na pewno chcesz usunac
    		<span class="yesDelete">Tak</span>
    	</div>
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