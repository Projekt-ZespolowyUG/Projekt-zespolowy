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
    <div ng-controller="departSearchCtrl">
    <div class="search">
      <div class="searchRollOut"><b>wyszukaj</b>
        <i class="fa fa-angle-up"></i>
      </div>
      <div class="searchArea" > 
        <div class="large-4 medium-6 columns">nazwa<input ng-model="name" type="text"/></div>
        <div class="large-4 medium-6 columns">Miasto<input ng-model="town" type="text"/></div>
        <div class="large-4 medium-6 columns">         
        Kraj :
          <select ng-model="data.country" >
            <option value="Polska" selected>Polska</option>
            <option value="Afganistan" >Afganistan</option>
            <option value="Anglia">Anglia</option>
            <option value="Francja" >Francja</option>
          </select>
        
        </div>
        <div class="large-4 medium-6 columns">Adres<input ng-model="adress" type="text"/></div>
        <div class="large-4 medium-6 columns">kod pocztowy<input ng-model="postcode"  type="text"/></div>
        <div class="large-4 medium-6 columns"><div class="buttonL" ng-click="searchDepartment()">Wyszukaj</div></div>

      </div>
    </div>
    <!-- Dane po filtrowaniu-->
    <div class="tableList">
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
          <a href="viewdepartment.jsp?id={{department.id}}" class="iconSearch"><i class="fa fa-search-plus"></i><span>pokaż</span></a>
          <a href="editdepartment.jsp?id={{department.id}}" class="iconEdit"><i class="fa fa-pencil-square-o"></i><span>edytuj</span></a>
          <a href="#" class="iconDelete" ng-click="removeDepartment(department.id)"><i class="fa fa-trash"></i><span>usuń</span></a>
        </td>
      </tr>
    </table>
    </div>
    
    
    </div>
    <div class="tableList departList" ng-controller="listDepartmentCtrl">
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
          <a href="viewdepartment.jsp?id={{department.id}}" class="iconSearch"><i class="fa fa-search-plus"></i><span>pokaż</span></a>
          <a href="editdepartment.jsp?id={{department.id}}" class="iconEdit"><i class="fa fa-pencil-square-o"></i><span>edytuj</span></a>
          <a href="#" class="iconDelete" ng-click="removeDepartment(department.id)"><i class="fa fa-trash"></i><span>usuń</span></a>
        </td>
      </tr>
    </table>
    </div>
  </div>
  <div class="paralax">
  </div>
  
  <!--kotwica-->
  <a href="#" name="addDepartmentLink"></a>
  <div class="add row" ng-controller="addDepartmentCtrl">
    <h1>Dodaj Placówkę</h1>
      <div class="medium-6 large-6 columns">
        <label>Nazwa:<input type="text" placeholder="nazwa" name="name" ng-model="name" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Adres :<input type="text" placeholder="Adres" name="adress" ng-model="adress"/></label>
      </div>
      <div class="medium-6 large-3 columns">
        <label>Kod pocztowy :<input type="text" placeholder="Kod pocztowy" ng-model="postcode" path="postcode" /></label>
      </div>
      <div class="medium-6 large-3 columns">
        <label>Miasto :<input type="text" placeholder="Miasto" ng-model="town" path="town" /></label>
      </div>
      <div class="medium-6 large-3 columns">
         <label>Kraj :
          <select ng-model="data.country" >
            <option value="Polska" selected>Polska</option>
            <option value="Afganistan" >Afganistan</option>
            <option value="Anglia">Anglia</option>
            <option value="Francja" >Francja</option>
          </select>
        </label>
      </div>
      <div class="medium-6 large-3 columns formSubmit">
        <div class="buttonL" ng-click="addDepartment()">Zatwierdź</div>
      </div>
     </div>
     
  <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>