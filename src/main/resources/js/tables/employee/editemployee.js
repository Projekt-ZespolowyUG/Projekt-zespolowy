var emp = angular.module("editEmp",[]);

emp.controller('editEmployeeCtrl', function($http,$scope){
	var id = window.location.search.replace("?id=", "");

	$.get('/visiting/employee/get/' + id).success(function(data){
		$scope.employee = data;
	});
});