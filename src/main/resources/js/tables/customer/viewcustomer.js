var cust = angular.module("viewCus",[]);

cust.controller('viewCustomerCtrl', function($scope,$http){
    var id = window.location.search.replace("?id=", "");
    $http.get('/visiting/customer/get/'+ id).success(function(data){
       
        $scope.customer = data;
    });
});