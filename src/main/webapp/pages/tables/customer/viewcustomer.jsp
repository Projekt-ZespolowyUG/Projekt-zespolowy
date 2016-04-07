<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html ng-app="viewCus">
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
   <!-- Importy Jsy i Cssy -->
   <jsp:include page="../../sections/head.jsp" />
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/tables/customer/viewcustomer.js" type="text/javascript"></script>
</head>
<body>
  <!--Menu górne i mobilne  -->
  <jsp:include page="../../sections/menuTop.jsp" />
  <div class="showSingle">
    <div class="large-4 medium-6 showSingleImage columns">
      <img src="${pageContext.request.contextPath}/img/klient.jpg" alt="Klient">
    </div>
    <div class="large-8 medium-6 columns showSingleInfo">
      <div ng-controller="viewCustomerCtrl" class="row">
        <div class="column"><span>Imię:</span> {{ customer.firstName }} </div>
        <div class="column"><span>Nazwisko:</span> {{ customer.lastName }} </div>
        <div class="columns"><span>Nr telefonu:</span> {{ customer.telephoneNumber }} </div>

      </div>
    </div>
  </div>

      <!--stopka  -->
  <jsp:include page="../../sections/footer.jsp" />
</body>
</html>