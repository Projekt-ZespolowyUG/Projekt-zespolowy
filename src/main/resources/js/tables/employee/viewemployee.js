var empl = angular.module('viewEmp', []);

empl.controller('showSingleEmployeeCtrl', function($http, $scope){
    
    id = window.location.search.replace("?id=", "");
    $http.get('/visiting/employee/get/' + id).success(function(data){
        $scope.employee = data;
    });
});