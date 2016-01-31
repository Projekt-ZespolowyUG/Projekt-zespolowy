$(document).ready(
		function() {
			$("#addCustomerButton").click(function(){
				$.ajax({
                  url: '/visiting/customer/add',
                  type: 'POST',
                  data: {
                     firstName: $("#cFirstName").val(),
                     lastName: $("#cLastName").val(),
                     telephoneNumber: $("#cTelephoneNumber").val()
                  },
                  success : function() {
                        alert("dodano : " 
                                      + $("#cFirstName").val() + " " 
                                      + $("#cLastName").val() + " " 
                                      + ("#cTelephoneNumber").val());  
                    window.location.replace("customer.jsp");
                  },
                  error : function() {
                    alert("Bład w dodaniu : " 
                                      + $("#cFirstName").val() + " " 
                                      + $("#cLastName").val() + " " 
                                      + $("#cTelephoneNumber").val());
                  }                  
                });
				
				
			});
		});


var custom = angular.module("custom",[]);


custom.controller("customerAddCtrl", function($scope,$http){
    $http.get('/visiting/customer/list').success(function(data){
        $scope.customers = data;
        $scope.$apply();
    });
    $http.get('/visiting/customer/list').error(function(data){
        alert("Listowanie nie dziala");
    });
});