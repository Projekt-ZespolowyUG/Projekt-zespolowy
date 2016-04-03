var visit = angular.module("visit",[]);

visit.controller("visitListCtrl",function($scope,$http){
	function timeConverter(UNIX_timestamp){
		  var a = new Date(UNIX_timestamp);
		  var months = ['Styczeń','Luty','Marzec','Kwiecień','Maj','Czerwiec','Lipiec','Sierpień','Wrzesień','Październik','Listopad','Grudzień'];
		  var year = a.getFullYear();
		  var month = months[a.getMonth()];
		  var date = a.getDate();
		  var hour = a.getHours();
		  var min = a.getMinutes();
		  var sec = a.getSeconds();
		  if (hour<10){
			  hour = '0' + hour;
		  }
		  if (min<10){
			  min= '0' + min;
		  }
		  var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min  ;
		  return time;
		}
	$http.get('/visiting/visit/list').success(function(data) {
		//alert("udało się");
		$scope.visits = data;
		//alert($scope.visits.startDate);
		for(x in $scope.visits){
			$scope.visits[x].startDate= timeConverter($scope.visits[x].startDate);
			$scope.visits[x].endDate= timeConverter($scope.visits[x].endDate);
		}
		//$scope.$apply();
	});
});