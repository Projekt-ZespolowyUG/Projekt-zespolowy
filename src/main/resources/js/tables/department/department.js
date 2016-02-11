var depart = angular.module('depart', []);
//Dodawanie
depart.controller("addDepartmentCtrl",function($scope,$http){
    $scope.addDepartment = function () 
    {
        $.ajax({
                url : '/visiting/outpost/add',
                type : 'POST',
                dataType : "json",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify({
                    name: $scope.name,
                    adress: $scope.adress,
                    postcode: $scope.postcode,
                    town: $scope.town,
                    country: $scope.data.country
                }),
                success : function(){
                   alert("Udało się dodać :" 
                         + $scope.name 
                         + $scope.adress
                         + $scope.postcode
                         + $scope.town
                         + $scope.data.country);               
                    window.location.replace("department.jsp");
                },
                error: function(){
                   alert("Nie udało się dodać :" 
                         + $scope.name 
                         + $scope.adress
                         + $scope.postcode
                         + $scope.town
                         + $scope.data.country);    
                    window.location.replace("department.jsp");
                }
        });
    };
    
});
//Listowanie
depart.controller("listDepartmentCtrl", function($scope, $http) {
	$http.get('/visiting/outpost/list').success(function(data) {
		$scope.departments = data;
		//$scope.$apply();
	});
    $http.get('/visiting/outpost/list').error(function(data){
        alert("Listowanie nie działa");
    });
});