 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!--Nawigacja menuTop.scss-->
  <header class="menu">
    <div class="addMenuAnimation"></div>
    <div class="logo">
      <a href="${pageContext.request.contextPath}/index.jsp">Vitaneo</a>
    </div>
    <ul class="menuDesktop">
      <li><a href="${pageContext.request.contextPath}/tables/employee/employee.jsp">Pracownik</a>
        <ul class="rollOutMenu">
          <li><a href="${pageContext.request.contextPath}/tables/employee/employee.jsp#showAllEmployeeLink">Pokaż wszystkich</a></li>
          <li><a href="${pageContext.request.contextPath}/tables/employee/employee.jsp#addEmployee">Dodaj</a></li>
         
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="${pageContext.request.contextPath}/tables/department/department.jsp">Placówka</a>
         <ul class="rollOutMenu">
          <li><a href="${pageContext.request.contextPath}/tables/department/department.jsp#showAllDepartmentLink">Pokaż wszystkie</a></li>
          <li><a href="${pageContext.request.contextPath}/tables/department/department.jsp#addDepartmentLink">Dodaj</a></li>
         
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="${pageContext.request.contextPath}/tables/customer/customer.jsp">Klient</a>
         <ul class="rollOutMenu">
          <li><a href="${pageContext.request.contextPath}/tables/customer/customer.jsp#showAllCustomerLink">Pokaż wszystkich</a></li>
          <li><a href="${pageContext.request.contextPath}/tables/customer/customer.jsp#addCustomerLink">Dodaj</a></li>
        </ul>
        <i class="fa fa-angle-up"></i>
      </li>
      <li><a href="${pageContext.request.contextPath}/tables/visit/visit.jsp">Wizyta</a></li>
      <li></li>
    </ul>
    <div class="logInSection">
      <div class="registerButton">
        <a href="register.html">Zarejestruj</a>
      </div>
      <div class="logInButton">Zaloguj</div>
      <div class="logInForm">
        <label>email: <input type="text"></input></label>
        <label>haslo: <input type="password"></input></label>
      </div>
    </div>
    <div class="bars">
      <a href="#">
        <i class="fa fa-bars"></i>
      </a>
    </div>
    <ul class="menuMobile">
      <li><a href="${pageContext.request.contextPath}/tables/employee/employee.jsp">Pracownik</a></li>
      <li><a href="${pageContext.request.contextPath}/tables/department/department.jsp">Placówka</a></li>
      <li><a href="${pageContext.request.contextPath}/tables/customer/customer.jsp">Klient</a></li>
      <li><a href="${pageContext.request.contextPath}/tables/visit/visit.jsp">Wizyty</a></li>
    </ul>
  </header>