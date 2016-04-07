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
  <script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/tables/employee/employee.js" type="text/javascript"></script>
</head>
<body>
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  
    
  <div class="logInPage row">
    <h1>Zaloguj</h1>
    <form method="POST" >
      <div class="medium-6 large-6 columns">
        <label>Imię :<input type="text" placeholder="imię" path="firstName" id="eName" /></label>
      </div>
      <div class="medium-6 large-6 columns">
        <label>Nazwisko :<input type="text" placeholder="Nazwisko" path="lastName" id="eLastname"/></label>
      </div>
      <div class="medium-6 large-4 columns">
        <label>Nr telefonu :<input type="text" placeholder="Nr telefonu" path="telephoneNumber" id="eTelephoneNumber"/></label>
      </div>
      <div class="medium-6 large-4 columns formSubmit">
        <input class="buttonL" type="submit" value="Zaloguj">
      </div>
    </form>
  </div>
  
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>