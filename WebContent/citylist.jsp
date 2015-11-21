<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, main.java.com.collaborative_project.domain.City" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head lang="pl">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Projekt zespolowy</title>
  
  <link href="css/foundation.css" rel="stylesheet" type="text/css">
  <link href="css/style.css" rel="stylesheet" type="text/css">
  <script src="js/jquery.js" type="text/javascript" ></script>
  <script src="js/modernizr.js" type="text/javascript" ></script>
  <script src="js/foundation.min.js" type="text/javascript" ></script>
  <script src="js/main.js" type="text/javascript"></script>
</head>
<body>
<div class="row">
    <h2>Lista miast:</h2>
    <a href="index.jsp">Powrót do Strony głównej</a>
    <table style="width:50%" border="1">
    <tr>
        <th>Nazwa</th>
        <th>Populacja</th>
    </tr>
    
    <%
        List<City> cityList = (List<City>)request.getAttribute("cityList");
        if(cityList != null)
            for(City city: cityList) {
    %>
        <tr>
            <td><%= city.getName() %></td>
            <td><%= city.getPopulation() %></td>
        </tr>
    <%
            }
    %>
    
    </table>
</div>
</body>
</html>