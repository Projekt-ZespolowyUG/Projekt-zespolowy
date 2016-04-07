var visit = angular.module("visit",[]);

visit.controller("visitListCtrl",function($scope,$http){
	$http.get('/visiting/visit/list').success(function(data) {
		alert("udało się");
		$scope.visits = data;
		//$scope.$apply();
	});
});