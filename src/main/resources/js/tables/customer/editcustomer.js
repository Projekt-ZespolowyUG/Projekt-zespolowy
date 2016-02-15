var cust = angular.module("editCust",[]);

cust.controller("editCustomerCtrl",function($http,$scope){
	
	var id = window.location.search.replace("?id=", "");
	$http.get('/visiting/customer/get/'+ id).success(function(data){
		
	$scope.customer = data;	
	
	$scope.saveCustomer = function() {
		$.ajax({
			url: '/visiting/customer/add/',
			type : 'POST',
			dataType : "json",
			contentType: 'application/json; charset=utf-8',
			data :JSON.stringify({
				id: $scope.customer.id,
				firstName: $scope.customer.firstName,
				lastName: $scope.customer.lastName,
				telephoneNumber: $scope.customer.telephoneNumber
			}),
				success : function() {
					alert("Udało się");
					window.location.replace("customer.jsp");
				},
				error : function() {
					alert("nie udało się");
				}
		});
		
	};

	});
});