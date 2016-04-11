var dep = angular.module("editDep",[]);

dep.controller("editDepartmentCtrl", function($http,$scope){
	var id = window.location.search.replace("?id=", "");
	$http.get('/visiting/outpost/get/' + id).success(function(data){
		$scope.department = data;
		
		$scope.saveDepartment = function(){
			$.ajax({
				url:'/visiting/outpost/add/',
				type : 'POST',
				dataType : "json",
				contentType: 'application/json; charset=utf-8',
				data :JSON.stringify({
					id: $scope.department.id,
                    name: $scope.department.name,
                    adress: $scope.department.adress,
                    postcode: $scope.department.postcode,
                    town: $scope.department.town,
                    country: $scope.department.country
					
				}),
				success: function() {         
	                      window.location.replace("department.jsp");	
				},
				error: function(){
	                   alert("Nie Udało się dodać :");               
	                      window.location.replace("department.jsp");
				}
			});
		};
	});
	
});