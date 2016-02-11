var viewDepart = angular.module("viewDep",[]);
viewDepart.controller("viewDepartmentCtrl", function($scope, $http){
	var id = window.location.search.replace("?id=", "");
	$http.get('/visiting/outpost/get/' + id).success(function(data){
		$scope.department = data;
		//alert("udało się pobrać dane o departamencie o id:" + id);
	});
	$http.get('/visiting/outpost/get/' + id).error(function(data){
		alert("nie udało się pobrać danych");
	});
});

viewDepart.controller("viewDepartmentEmployeesCtrl",function($scope,$http){
	$http.get('/visiting/employee/list').success(function(data){
		$scope.employees = data;
		//Do poprawy nie filtruje pracownikow danego departamentu
	});
});