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
  
  <div class="register row">
    <h1>Zarejestruj się</h1>
    <form method="POST" >
      <div class="columns">
        <label>email :<input type="text" placeholder="email"  /></label>
      </div>
      <div class="columns">
        <label>Hasło :<input type="password" placeholder="hasło" /></label>
      </div>

      <div class="large-6 large-offset-6 columns formSubmit ">
        <input class="buttonL" type="submit" value="Zatwierdź">
      </div>
    </form>
  </div>
  
      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>