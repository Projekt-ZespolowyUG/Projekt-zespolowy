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
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea">
        <div class="large-4 medium-6 columns">Imię<input type="text"/></div>
        <div class="large-4 medium-6 columns">Nazwisko<input type="text"/></div>
        <div class="large-4 medium-6 columns">Miasto<input type="text"/></div>
        <div class="large-4 medium-6 columns">Kod pocztowy<input type="text"/></div>
        <div class="large-4 medium-6 columns">Nr telefonu<input type="text"/></div>
        <div class="large-4 medium-6 columns">Adres<input type="text"/></div>
        <div class="large-4 medium-4 columns">Kraj<input type="text"/></div>
        <div class="large-4 medium-4 columns">Kod pocztowy<input type="text"/></div>
        <div class="large-4 medium-4 columns"><input class="buttonL" type="submit" value="Wyszukaj"></div>

      </div>
    </div>
   <div ng-controller="addEmployeeCtrl">
    <table ng-repeat="employee in employees">
      <tr>
        <td class="small-6 medium-3 columns"><b>imię: </b><span>{{ employee.firstName }}</span></td>
        <td class="small-6 medium-3 columns"><b>nazwisko: </b><span>{{ employee.lastName }}</span></td>
        <td class="small-12 medium-2 columns"><b>placówka:</b><span> {{ employee.outpost.id }}</span></td>
        <td class="medium-2 columns hideColumn"><b>Miasto: </b><span>{{ employee.town }}</span></td>
        <td class="medium-2 columns hideColumn"><b> Kod pocztowy:</b><span>{{ employee.postcode }}</span></td>
      </tr>
      <tr>
        <td class="small-6 medium-3 columns" ><b>Nr telefonu: </b><span> {{ employee.telephoneNumber }}</span></td>
        <td class="medium-3 columns hideColumn"><b>Adres: </b><span> {{ employee.adress }}</span></td>
        <td class="medium-3 columns hideColumn"><b>Kraj: </b><span> {{ employee.country }}</span></td>
        <td class="small-6 medium-3 columns"><b>Email: </b><span> {{ employee.email }}</span></td>
      </tr>
    </table>
    </div>
    
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addEmployee"></a>
  <div class="add row">
    <h1>Dodaj Pracownika</h1>
    <div class="formError">
      <h2>Uzupełnij poprawnie formularz !</h2>
    </div>
      <div class="medium-6 large-6 columns">
        <label>Imię :<input type="text" placeholder="imię" id="eFirstName" minLength="2" maxlength="20" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nazwisko :<input type="text" placeholder="Nazwisko" id="eLastName" minLength="2" maxlength="40"/></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Nr telefonu :<input type="text" placeholder="Nr telefonu" id="eTelephoneNumber" minLength="2" maxlength="12"/></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Email :<input type="text" placeholder="Email" id="eEmail"  minLength="5" maxlength="40"/></label>
      </div>
      <div class="medium-4 large-4 columns">
        <label>Adres :<input type="text" placeholder="Adres" id="eAdress" minLength="2" maxlength="40"/></label>
      </div>
      <div class="medium-4 large-2 columns">
        <label>Kod pocztowy :<input type="text" placeholder="Kod pocztowy" id="ePostcode" minLength="2" maxlength="10"/></label>
      </div>
      <div class="medium-4 large-4 columns">
        <label>Miasto :<input type="text" placeholder="Miasto" id="eTown"  minLength="2" maxlength="40"/></label>
      </div>
      <div class="medium-4 large-6 columns">
        <label>Kraj :
          <select id="eCountry">
            <option>Polska</option>
            <option>Anglia</option>
            <option>Afganistan</option>
          </select>
        </label>
      </div>
      <div class="medium-4 large-6 columns">
      	<label>Placówka
	      <select ng-controller="importDepartmentCtrl" id="eOutpost">
	        <option ng-repeat="department in departments"><div>{{ department.id }}</div> Nazwa: {{ department.name }}</option>
	      </select>
	    </label>
	  </div>
      <div class="medium-4 large-6 columns formSubmit">
        <div class="buttonL" id="addEmployeeButton">Zatwierdź</div>
      </div>
  </div>
  
    <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>