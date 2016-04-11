var custom = angular.module("custom", []);

custom.controller("customerAddCtrl", function($scope, $http) {
	$scope.addCustomer = function() {
		$scope.validation = "";
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
					window.location.replace("customer.jsp");
				},
				error : function() {
					alert("NIE dodano : " + $scope.firstName + " "
							+ $scope.lastName + " " + $scope.telephoneNumber + "źle wpisane dane");
				}
			});
		}
	};
});

custom.controller("customerGetCtrl", function($scope, $http) {
	$scope.pageNumber=0;
	$http.get('/visiting/customer/list').success(function(data) {
		$scope.customers = data;
	});
	
	$http.get('/visiting/customer/list').error(function(data) {
		alert("Listowanie nie dziala");
	});
	
   
    $scope.removeCustomer = function(id) {
        
    	$http.get('/visiting/customer/delete/' + id).success(function(data) {
 
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
			$(".customerList").css("display","none");
		});	
		
	};
});

