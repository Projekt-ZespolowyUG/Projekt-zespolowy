var emp = angular.module("editEmp",[]);

emp.controller('editEmployeeCtrl', function($http,$scope){
	var id = window.location.search.replace("?id=", "");

	
	$http.get('/visiting/outpost/list').success(function(data) {
		$scope.departments = data;
		//$scope.$apply();
	});
	
	$.get('/visiting/employee/get/' + id).success(function(data){
		$scope.employee = data;
		
		
		$scope.saveEmployee = function() {
			$.ajax({
				url: '/visiting/employee/add',
				type : 'POST',
				dataType : "json",
				contentType: 'application/json; charset=utf-8',
				data :JSON.stringify({
					id: $scope.employee.id,
                    firstName: $scope.employee.firstName,
                    lastName: $scope.employee.lastName,
                    telephoneNumber: $scope.employee.telephoneNumber,
                    email: $scope.employee.email,
                    adress: $scope.employee.adress,
                    postcode: $scope.employee.postcode,
                    town: $scope.employee.town,
                    country: $scope.employee.country,
                    outpost:{
                        id: $scope.employee.outpost.id
                    }
					
				}),
				success: function() {
					window.location.replace("employee.jsp");
				},
				error: function() {
					alert("nie udało się zmienić danych");
					
				}
			});
		
		};
		
	});
});