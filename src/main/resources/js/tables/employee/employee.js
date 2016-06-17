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
		$http.get('/visiting/employee/delete/' + id).success(function(){
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
                console.log("Udało się dodać: " 
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
                alert("Nie udało się dodać: "  );           
                window.location.replace("employee.jsp");
            }
        });
    }
});

//filtrowanie

employ.controller("employeeSearchCtrl",function($scope,$http){
	//Do selecta departamenty
	$http.get('/visiting/outpost/list').success(function(data) {
		$scope.departments = data;
		//$scope.$apply();
	});
	
	$scope.searchEmployee = function(){
		$http({
			url : '/visiting/employee/filter',
			method : 'GET',
			params : {
                firstName: $scope.firstName,
                lastName: $scope.lastName,
                telephoneNumber: $scope.telephoneNumber,
                email: $scope.email,
                adress: $scope.adress,
                postcode: $scope.postcode,
                town: $scope.town,
                country: $scope.country,
                idOutpost: $scope.outpost
                
			}
		}).success(function(data){
			$(".employeeList").css("display","none");
			$scope.employees = data;
			//alert("udało się : " );
			
		});
	};
});