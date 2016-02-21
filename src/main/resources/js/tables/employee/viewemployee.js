var empl = angular.module('viewEmp', []);

empl.controller('showSingleEmployeeCtrl', function($http, $scope){
    
    id = window.location.search.replace("?id=", "");
    $http.get('/visiting/employee/get/' + id).success(function(data){
        $scope.employee = data;
    });
});
empl.controller('scheduleHoursCtrl', function($scope,$http){
	$scope.showScheduleDays = function(){
		$scope.numberOfDays = 0;	
		//Funkcja do obliczania dni w miesiącu
		$scope.daysInMonth = function(month,year) {
		    return new Date(year, month, 0).getDate();

		}
		//alert($scope.startDate.getYear()+1900);
		//alert("dni w miesiącu: " + $scope.daysInMonth(2,2016) );
		//Sprawdzenie czy dana data już była
		if(new Date() - $scope.startDate < 0 ){
			
			//Sprawdzenie czy dobrze wybralo sie zakres dat
			if($scope.endDate - $scope.startDate > 0){
					
				
				//Sprawdzenie czy wybrany przedział jest w tym samym miesiacu
				if($scope.startDate.getMonth() === $scope.endDate.getMonth()){
					alert("sa w tym samym miesiącu");
					$scope.startDateBox = $scope.startDate.getDate();
					
					
					//dopoki startDate === endDate zwiekszamy ilosc dni
					while($scope.startDateBox  < $scope.endDate.getDate()){
						$scope.startDateBox++;//
						$scope.numberOfDays++;//
					}
					alert("liczba dni do koncowej daty iterujac od 0 : " + $scope.numberOfDays);
					//ustawiamy limit w wybieraniu dat
					if($scope.numberOfDays<=15 ){
						//po kliknieciu pokazuje dni tygodnia z godzinami pracy
						$(".scheduleHours").toggle();
					}else{
						alert("Przekroczono limit w zakresie dat. Limit to 15 dni");
					}

					
				} else {
					alert("są w różnych miesiącach");
					 //Sprawdzamy ile dni jest w miesiącu początkowym
					 $scope.numberOfDaysInMonth = $scope.daysInMonth($scope.startDate.getMonth()+1,$scope.startDate.getYear()+1900);	 	  
			
					 $scope.numberOfDays =( $scope.numberOfDaysInMonth - $scope.startDate.getDate()) + $scope.endDate.getDate();
					 alert($scope.numberOfDays);
					 
					 //ustawiamy limit w wybieraniu dat
					 if($scope.numberOfDays<=15 ){
						 //po kliknieciu pokazuje dni tygodnia z godzinami pracy
						 $(".scheduleHours").toggle();
					 }else{
						 alert("Przekroczono limit w zakresie dat. Limit to 15 dni");
					 }
				}

			} else {
					alert("Data początkowa jest pozniej niż data koncowa");
			}
		}
		else{
			alert("Nie można wybrać daty która już była ! ");
		}
		
		alert($scope.numberOfDays);
		
	};
});