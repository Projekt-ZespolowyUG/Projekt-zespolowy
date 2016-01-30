<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="depart">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
  <!-- Importy Jsy i Cssy -->
  <jsp:include page="../../sections/head.jsp" />
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" ></script>
  <script src="../../js/tables/department/department.js" type="text/javascript"></script>
  <script src="../../js/main.js" type="text/javascript"></script>
</head>
<body>
   <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />

  <!--kotwica-->
  <a href="#" name="showAllDepartmentLink"></a>
  <div class="showAll row ">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea">
        <div class="large-4 medium-6 columns">nazwa<input type="text"/></div>
        <div class="large-4 medium-6 columns">Miasto<input type="text"/></div>
        <div class="large-4 medium-6 columns">Kraj<input type="text"/></div>
        <div class="large-4 medium-6 columns">Adres<input type="text"/></div>
        <div class="large-4 medium-6 columns">kod pocztowy<input type="text"/></div>
        <div class="large-4 medium-6 columns"><input class="buttonL" type="submit" value="Wyszukaj"></div>

      </div>
    </div>
    <div ng-controller="listDepartmentCtrl">
    <table ng-repeat="department in departments">
      <tr> 
        <td class="medium-4 columns"><b>Nazwa: </b><span> {{ department.name }}</span></td>
        <td class="medium-4 columns"><b>Miasto: </b><span> {{ department.town }}</span></td>
        <td class="medium-4 columns hideColumn"><b>Kraj: </b><span> {{ department.country }}</span></td>
      </tr>
      <tr>
        <td class="small-7 medium-4 columns"><b>Adres: </b><span> {{ department.adress }}</span></td>
        <td class="medium-4 columns hideColumn"><b> Kod pocztowy:</b><span>{{ department.postcode }}</span></td>
        <td class="small-5 medium-4 columns  crudIcons">
          <a href="viewdepartment.html" class="iconSearch"><i class="fa fa-search-plus"></i><span>pokaż</span></a>
          <a href="#" class="iconEdit"><i class="fa fa-pencil-square-o"></i><span>edytuj</span></a>
          <a href="#" class="iconDelete"><i class="fa fa-trash"></i><span>usuń</span></a></td></td>
      </tr>
    </table>
    </div>
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addDepartmentLink"></a>
  <div class="add row">
    <h1>Dodaj Placówkę</h1>
      <div class="medium-6 large-6 columns">
        <label>Nazwa:<input type="text" placeholder="nazwa" name="name" path="name" id="dName" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Adres :<input type="text" placeholder="Adres" name="adress" path="adress" id="dAdress"/></label>
      </div>
      <div class="medium-6 large-3 columns">
        <label>Kod pocztowy :<input type="text" placeholder="Kod pocztowy" name="postcode" path="postcode" id="dPostcode"/></label>
      </div>
      <div class="medium-6 large-3 columns">
        <label>Miasto :<input type="text" placeholder="Miasto" name="town" path="town" id="dTown"  /></label>
      </div>
      <div class="medium-6 large-3 columns">
         <label>Kraj :
          <select name="country" id="dCountry">
            <option value="Polska" path="country">Polska</option>
            <option value="Afganistan" path="country">Afganistan</option>
            <option value="Anglia" path="country">Anglia</option>
            <option value="Francja" path="country">Francja</option>
          </select>
        </label>
      </div>
      <div class="medium-6 large-3 columns formSubmit">
        <div class="buttonL" id="addDepartmentButton">Zatwierdź</div>
      </div>
     </div>
     
  <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>