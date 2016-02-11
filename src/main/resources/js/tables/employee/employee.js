/*$(document).ready(
		function() {
			$("#addEmployeeButton").click(
					function() {
					
						
						
						$.ajax({
							url : '/visiting/employee/add',
							type : 'POST',
							dataType: "json",
							contentType: 'application/json; charset=utf-8',
							data : JSON.stringify({
								firstName : $("#eFirstName").val(),
								lastName : $("#eLastName").val(),
								telephoneNumber : $("#eTelephoneNumber").val(),
								email : $("#eEmail").val(),
								adress : $("#eAdress").val(),
								postcode : $("#ePostcode").val(),
								town : $("#eTown").val(),
								country : $("#eCountry").val(),				
								outpost: {	
									id: $("#eOutpost").val().substring(0,$("#eOutpost").val().search("Nazwa:") - 1)
								}
							}),
							success : function() {
								alert("Udało się dodać "
										+ $("#eFirstName").val()
										+ " "
										+ $("#eLastName").val()
										+ " "
										+ $("#eTelephoneNumber").val()
										+ " "
										+ $("#eEmail").val()
										+ " "
										+ $("#eAdress").val()
										+ " "
										+ $("#ePostcode").val()
										+ " "
										+ $("#eTown").val()
										+ " "
										+ $("#eCountry").val()
										+ " "
										+ $("#eOutpost").val().substring(
												0,
												$("#eOutpost").val().search(
														"Nazwa:") - 1));
								window.location.replace("employee.jsp");
							},
							error : function() {
								alert("Nie udało się dodać "
										+ $("#eFirstName").val()
										+ " "
										+ $("#eLastName").val()
										+ " "
										+ $("#eTelephoneNumber").val()
										+ " "
										+ $("#eEmail").val()
										+ " "
										+ $("#eAdress").val()
										+ " "
										+ $("#ePostcode").val()
										+ " "
										+ $("#eTown").val()
										+ " "
										+ $("#eCountry").val()
										+ " "
										+ $("#eOutpost").val().substring(
												0,
												$("#eOutpost").val().search(
														"Nazwa:") - 1));
							}

						});

					});

		});
*/
var employ = angular.module("employee", []);

// listowanie Pracownik
employ.controller("listEmployeeCtrl", function($scope, $http) {

	$http.get('/visiting/employee/list').success(function(data) {
		$scope.employees = data;
		//$scope.$apply();
	});
	$http.get('/visiting/employee/list').error(function(data) {
		alert("listowanie nie działa");
	});
	
	$scope.removeEmployee = function(id){
		$http.get('visiting/employee/delete/' + id).success(function(){
			//alert("udało się");
			window.location.reload();
		});
	}
	
	
});

// importowanie do selecta listy departamentów
employ.controller("addEmployeeCtrl", function($scope, $http) {

	$http.get('/visiting/outpost/list').success(function(data) {
		$scope.departments = data;
		//$scope.$apply();
	});
	$http.get('/visiting/outpost/list').error(function(data) {
		alert("listowanie departamentów nie działa");
	});
    $scope.addEmployee = function(){
        $.ajax({
                url : '/visiting/employee/add',
                type : 'POST',
                dataType : "json",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                    firstName: $scope.firstName,
                    lastName: $scope.lastName,
                    telephoneNumber: $scope.telephoneNumber,
                    email: $scope.email,
                    adress: $scope.adress,
                    postcode: $scope.postcode,
                    town: $scope.town,
                    country: $scope.country,
                    outpost:{
                        id: $scope.outpost
                    }
                }),
            success : function(){
                alert("Udało się dodać: " 
                      + $scope.firstName 
                      + $scope.lastName
                      + $scope.telephoneNumber
                      + $scope.email
                      + $scope.adress
                      + $scope.postcode
                      + $scope.town
                      + $scope.country
                      + $scope.outpost
                     );   
                window.location.replace("employee.jsp");
            },
            error :function(){
                alert("Nie udało się dodać: " 
                      + $scope.firstName 
                      + $scope.lastName
                      + $scope.telephoneNumber
                      + $scope.email
                      + $scope.adress
                      + $scope.postcode
                      + $scope.town
                      + $scope.country
                      + $scope.outpost
                     );           
                window.location.replace("employee.jsp");
            }
        });
    }
});