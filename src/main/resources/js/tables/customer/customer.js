var custom = angular.module("custom", []);

custom.controller("customerAddCtrl", function($scope, $http) {
	$scope.addCustomer = function() {
		$.ajax({
			url : '/visiting/customer/add',
			type : 'POST',
			dataType : "json",
			contentType: 'application/json; charset=utf-8',
			data :JSON.stringify({
				firstName : $scope.firstName,
				lastName : $scope.lastName,
				telephoneNumber : $scope.telephoneNumber
			}),
			success : function() {
				alert("dodano : "
                      + $scope.firstName 
                      + " " 
                      + $scope.lastName
				      + " " 
                      + $scope.telephoneNumber);
				window.location.replace("customer.jsp");
			},
			error : function() {
				alert("NIE dodano : " + $scope.firstName + " "
						+ $scope.lastName + " " + $scope.telephoneNumber);
				window.location.replace("customer.jsp");
			}
		});
	};
});

custom.controller("customerGetCtrl", function($scope, $http) {
	$scope.pageNumber=0;
	//$scope.$apply(pagneNumber);
	//$scope.watch();
	//$scope.$watch('pageNumber', function(){
	//	alert($scope.pageNumber);
//	});
	$http.get('/visiting/customer/list').success(function(data) {
		$scope.customers = data;
		//$scope.$apply();
	});
	
	$http.get('/visiting/customer/list').error(function(data) {
		alert("Listowanie nie dziala");
	});
	
   
    $scope.removeCustomer = function(id) {
        
    	$http.get('/visiting/customer/delete/' + id).success(function(data) {
    		//alert("usuwanie dziala");
    		window.location.reload();
    	});


    }  
});

customer.controller('searchCustomerCtrl',function($scope,$http){
	$scope.searchCustomer = function($scope){
		$.ajax({
			url : '/visiting/customer/filter',
			type : 'GET',
			dataType : "json",
			contentType: 'application/json; charset=utf-8',
			data :JSON.stringify({
				firstName : $scope.fName,
				lastName : $scope.lName,
				telephoneNumber : $scope.tNumber
			}),
			success : function(data) {
				$scope.customers = data;
				alert("dodano : ");
				window.location.replace("customer.jsp");
			},
			error : function() {
				alert("nie udalo się");
				window.location.replace("customer.jsp");
			}
		});
	};
});

