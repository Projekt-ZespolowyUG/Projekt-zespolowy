$(document).ready(
		function() {
			// Dodawanie Departamentu
			$("#addDepartmentButton").click(
					function() {
						$.ajax({
							url : '/visiting/outpost/add',
							type : 'POST',
							data : {
								name : $("#dName").val(),
								adress : $("#dAdress").val(),
								postcode : $("#dPostcode").val(),
								town : $("#dTown").val(),
								country : $("#dCountry").val()
							},
							success : function() {
								alert("Dodałes Placówke" + $("#dName").val()
										+ " " + $("#dAdress").val() + " "
										+ $("#dPostcode").val() + " "
										+ $("#dTown").val() + " "
										+ $("#dCountry").val());
								window.location.replace("department.jsp");
							},
							error : function() {
								alert("Nie udało się dodać "
										+ $("#dName").val() + " "
										+ $("#dAdress").val() + " "
										+ $("#dPostcode").val() + " "
										+ $("#dTown").val() + " "
										+ $("#dCountry").val());
							}
						});
					});
		});

// Listowanie
var depart = angular.module('depart', []);

depart.controller("listDepartmentCtrl", function($scope, $http) {
	$http.get('/visiting/outpost/list').success(function(data) {
		$scope.departments = data;
		$scope.$apply();

	});
});