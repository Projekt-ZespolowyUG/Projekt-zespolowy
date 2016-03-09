var custom = angular.module("custom", []);

custom.controller("customerAddCtrl", function($scope, $http) {
	$scope.addCustomer = function() {
		$scope.validation = "";
		//alert($scope.firstName);
		if($scope.firstName.length < 4){
			$scope.validation+= "za krótkie imię !\n";
		}
		else if($scope.lastName.length < 4)  {
			$scope.validation+= "za krótkie nazwisko!";
		}
		else if($scope.telephoneNumber.length <6){
			$scope.validation+= "za krótki numer telefonu!";
		}else {	
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
					/*alert("dodano : "
	                      + $scope.firstName 
	                      + " " 
	                      + $scope.lastName
					      + " " 
	                      + $scope.telephoneNumber);*/
					window.location.replace("customer.jsp");
				},
				error : function() {
					alert("NIE dodano : " + $scope.firstName + " "
							+ $scope.lastName + " " + $scope.telephoneNumber + "źle wpisane dane");
					//window.location.replace("customer.jsp");
				}
			});
		}
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

custom.controller('searchCustomerCtrl',function($scope,$http){
	$scope.searchCustomer = function(){
		$http({
			url : '/visiting/customer/filter',
			method : 'GET',
			params : {
				firstName : $scope.fName,
				lastName : $scope.lName,
				telephoneNumber : $scope.tNumber
			}
		}).success(function(data){
			$scope.customers = data;
			//alert("udało się : ");
			$(".customerList").css("display","none");
		});	
		
	};
});

