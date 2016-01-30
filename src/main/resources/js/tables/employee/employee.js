$(document).ready(
            function(){
                      $("#addEmployeeButton").click(function(){

                              $.ajax({
                                url:'/visiting/employee/add',
                                type: 'POST',
                                data: {
                                  firstName: $("#eFirstName").val(),
                                  lastName: $("#eLastName").val(),
                                  telephoneNumber: $("#eTelephoneNumber").val(),
                                  email: $("#eEmail").val(),
                                  adress: $("#eAdress").val(),
                                  postcode: $("#ePostcode").val(),
                                  town: $("#eTown").val(),
                                  country: $("#eCountry").val(),
                                  outpost: $("#eOutpost").val().substring(0,$("#eOutpost").val().search("Nazwa:")-1 )
                                },
                                success : function() {
                                  alert("Udało się dodać " + $("#eFirstName").val() + " "
                                                           + $("#eLastName").val() + " "
                                                           + $("#eTelephoneNumber").val() + " "
                                                           + $("#eEmail").val() + " "
                                                           + $("#eAdress").val() + " "
                                                           + $("#ePostcode").val() + " " 
                                                           + $("#eTown").val() + " "
                                                           + $("#eCountry").val() + " " 
                                                           + $("#eOutpost").val().substring(0,$("#eOutpost").val().search("Nazwa:")-1 ));
                                 window.replace.location("employee.jsp"); 
                                },
                                error : function() {
                                  alert("Nie udało się dodać " + $("#eFirstName").val() + " "
                                                           + $("#eLastName").val() + " "
                                                           + $("#eTelephoneNumber").val() + " "
                                                           + $("#eEmail").val() + " "
                                                           + $("#eAdress").val() + " "
                                                           + $("#ePostcode").val() + " " 
                                                           + $("#eTown").val() + " "
                                                           + $("#eCountry").val() + " " 
                                                           + $("#eOutpost").val().substring(0,$("#eOutpost").val().search("Nazwa:")-1 ));   
                                }

                              });


                      });
              
            });








var employ = angular.module("employee",[]);

//listowanie Pracownik
employ.controller("addEmployeeCtrl", function($scope, $http){
                                               
   $http.get('/visiting/employee/list').success(function(data){
      $scope.employees = data;
      $scope.$apply();
  });
  $http.get('/visiting/employee/list').error(function(data){
      alert("listowanie nie działa"); 
  });
});


//importowanie do selecta listy departamentów
employ.controller("importDepartmentCtrl", function($scope,$http){
  
  $http.get('/visiting/outpost/list').success(function(data){
    $scope.departments = data;
    $scope.$apply(); 
  });
  $http.get('/visiting/outpost/list').error(function(data){
    alert("listowanie departamentów nie działa");
  })
  
});