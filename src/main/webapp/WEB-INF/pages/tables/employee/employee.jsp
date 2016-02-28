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

     <!--kotwica-->
  <a href="#" name="showAllEmployee"></a>
  <div class="showAll row ">
    <div ng-controller="employeeSearchCtrl">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea" >
        <div class="large-4 medium-6 columns">Imię<input ng-model="firstName" type="text"/></div>
        <div class="large-4 medium-6 columns">Nazwisko<input ng-model="lastName" type="text"/></div>
        <div class="large-4 medium-6 columns">Miasto<input ng-model="town" type="text"/></div>
        <div class="large-4 medium-6 columns">Kod pocztowy<input ng-model="postcode" type="text"/></div>
        <div class="large-4 medium-6 columns">Nr telefonu<input ng-model="telephoneNumber" type="text"/></div>
        <div class="large-4 medium-6 columns">Adres<input ng-model="adress" type="text"/></div>
        <div class="large-4 medium-4 columns">Kraj
        Kraj :
          <select ng-model="country" >
            <option value="Polska" selected>Polska</option>
            <option value="Afganistan" >Afganistan</option>
            <option value="Anglia">Anglia</option>
            <option value="Francja" >Francja</option>
          </select>
        </div>
	    <div class="medium-4 large-6 columns">
	      <label>Placówka
		    <select ng-model="outpost">
		      <option ng-repeat="department in departments" value="{{department.id}}">{{ department.name }}</option>
		    </select>
		  </label>
		</div>
        <div class="large-4 medium-4 columns">Email<input ng-model="email" type="text"/></div>
        <div class="large-4 medium-4 columns"><div class="buttonL" ng-click="searchEmployee()">Wyszukaj</div></div>

      </div>
    </div>
    </div>
   <div class="tableList" ng-controller="listEmployeeCtrl">
    <table ng-repeat="employee in employees">
      <tr>
        <td class="small-6 medium-3 columns"><b>imię: </b><span>{{ employee.firstName }}</span></td>
        <td class="small-6 medium-3 columns"><b>nazwisko: </b><span>{{ employee.lastName }}</span></td>
        <td class="small-12 medium-2 columns"><b>placówka: </b><span> {{ employee.outpost.name }}</span></td>
        <td class="medium-2 columns hideColumn"><b>Miasto: </b><span>{{ employee.town }}</span></td>
        <td class="medium-2 columns hideColumn"><b> Kod pocztowy:</b><span>{{ employee.postcode }}</span></td>
      </tr>
      <tr>
        <td class="small-6 medium-3 columns" ><b>Nr telefonu: </b><span> {{ employee.telephoneNumber }}</span></td>
        <td class="medium-3 columns hideColumn"><b>Adres: </b><span> {{ employee.adress }}</span></td>
        <td class="medium-2 columns hideColumn"><b>Kraj: </b><span> {{ employee.country }}</span></td>
        <td class="small-6 medium-2 columns"><b>Email: </b><span> {{ employee.email }}</span></td>
        <td class="small-12 medium-2 columns  crudIcons">
          <a href="viewemployee.jsp?id={{ employee.id }}" class="iconSearch"><i class="fa fa-search-plus"></i><span>pokaż</span></a>
          <a href="editemployee.jsp?id={{ employee.id }}" class="iconEdit"><i class="fa fa-pencil-square-o"></i><span>edytuj</span></a>
          <a href="#" class="iconDelete" ng-click="removeEmployee(employee.id)"><i class="fa fa-trash"></i><span>usuń</span></a>
        </td>
      </tr>
    </table>
    </div>
    
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addEmployee"></a>
  <div class="add row" ng-controller="addEmployeeCtrl">
    <h1>Dodaj Pracownika</h1>
    <div class="formError">
      <h2>Uzupełnij poprawnie formularz !</h2>
    </div>
      <div class="medium-6 large-6 columns">
        <label>Imię :<input type="text" placeholder="imię" ng-model="firstName"  /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nazwisko :<input type="text" placeholder="Nazwisko" ng-model="lastName"/></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Nr telefonu :<input type="text" placeholder="Nr telefonu" ng-model="telephoneNumber" /></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Email :<input type="text" placeholder="Email" ng-model="email" /></label>
      </div>
      <div class="medium-4 large-4 columns">
        <label>Adres :<input type="text" placeholder="Adres" ng-model="adress" /></label>
      </div>
      <div class="medium-4 large-2 columns">
        <label>Kod pocztowy :<input type="text" placeholder="Kod pocztowy" ng-model="postcode" /></label>
      </div>
      <div class="medium-4 large-4 columns">
        <label>Miasto :<input type="text" placeholder="Miasto" ng-model="town" /></label>
      </div>
      <div class="medium-4 large-6 columns">
        <label>Kraj :
          <select ng-model="country" value="1">
            <option>Polska</option>
            <option>Anglia</option>
            <option>Afganistan</option>
          </select>
        </label>
      </div>
      <div class="medium-4 large-6 columns">
      	<label>Placówka
	      <select ng-model="outpost">
	        <option ng-repeat="department in departments" value="{{department.id}}">{{ department.name }}</option>
	      </select>
	    </label>
	  </div>
      <div class="medium-4 large-6 columns formSubmit">
        <div class="buttonL" ng-click="addEmployee()">Zatwierdź</div>
      </div>
  </div>
  
    <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>