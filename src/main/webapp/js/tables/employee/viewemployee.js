var empl = angular.module('viewEmp', []);

empl.controller('showSingleEmployeeCtrl', function($http, $scope){
    
    id = window.location.search.replace("?id=", "");
    $http.get('/visiting/employee/get/' + id).success(function(data){
        $scope.employee = data;
    });
});
empl.controller('scheduleHoursCtrl', function($scope,$http){
	id = window.location.search.replace("?id=", "");
	$scope.showScheduleDays = function(){
		$scope.numberOfDays = 0;	
		//alert($scope.startDate);

		//Funkcja do obliczania dni w miesiącu
		$scope.daysInMonth = function(month,year) {
		    return new Date(year, month, 0).getDate();

		}
		
		//Funkcja do zmiany formatu daty
		
		 function formatDate(date) {
			    var d = new Date(date),
			        month = '' + (d.getMonth() + 1),
			        day = '' + d.getDate(),
			        year = d.getFullYear();

			    if (month.length < 2) month = '0' + month;
			    if (day.length < 2) day = '0' + day;

			    return [year, month, day].join('-');
			}
		 
		//alert($scope.startDate.getYear()+1900);
		//Sprawdzenie czy dana data już była
		if(new Date() - $scope.startDate < 0 ){
			
			//Sprawdzenie czy dobrze wybralo sie zakres dat
			if($scope.endDate - $scope.startDate > 0){
					
				
				//Sprawdzenie czy wybrany przedział jest w tym samym miesiacu
				if($scope.startDate.getMonth() === $scope.endDate.getMonth()){

					//alert("sa w tym samym miesiącu");
					$scope.startDateBox = $scope.startDate.getDate();
					
					
					//dopoki startDate === endDate zwiekszamy ilosc dni
					while($scope.startDateBox  < $scope.endDate.getDate()){
						$scope.startDateBox++;//
						$scope.numberOfDays++;//
					}
					//alert("liczba dni do koncowej daty iterujac od 0 : " + $scope.numberOfDays);
					//ustawiamy limit w wybieraniu dat
					if($scope.numberOfDays<=15 ){
						$scope.startD = formatDate($scope.startDate);
						$scope.endD =formatDate($scope.endDate);
						
					    $.ajax({
					        url : '/visiting/schedule/returnSchedules',
					        type : 'GET',

					        data: {
					        	startDate: $scope.startD,
					        	endDate: $scope.endD,
					        	idEmployee: id
					        },
					    success : function(data){
					    	$scope.schedules = data.days;
					    	for(x in $scope.schedules){
					    	  if($scope.schedules[x].dayofweek === 2){
					    		  $scope.schedules[x].dayofweek = "Poniedziałek";
					    		  console.log($scope.schedules[x].dayofweek);
					    	  }else if($scope.schedules[x].dayofweek === 3){
					    		  $scope.schedules[x].dayofweek = "Wtorek";
					    		  console.log($scope.schedules[x].dayofweek);
					    	  }else if($scope.schedules[x].dayofweek === 4){
					    		  $scope.schedules[x].dayofweek = "Środa";
					    		  console.log($scope.schedules[x].dayofweek);
					    	  }else if ($scope.schedules[x].dayofweek === 5){
					    		  $scope.schedules[x].dayofweek = "Czwartek";
					    		  console.log($scope.schedules[x].dayofweek);
					    	  }else if ($scope.schedules[x].dayofweek === 6){
					    		  $scope.schedules[x].dayofweek = "Piątek";
					    		  console.log($scope.schedules[x].dayofweek);
					    	  }else if ($scope.schedules[x].dayofweek === 7){
					    		  $scope.schedules[x].dayofweek = "Sobota";
					    		  console.log($scope.schedules[x].dayofweek);
					    	  }else if ($scope.schedules[x].dayofweek === 1){
					    		  $scope.schedules[x].dayofweek = "Niedziela";
					    		  console.log($scope.schedules[x].dayofweek);
					    	  }	    	  
					    	  
					    	}
							//po kliknieciu pokazuje dni tygodnia z godzinami pracy
					    	// $(".scheduleHours").css("visibility","visible");
					    	 
					    	 
					    	 
					       // window.location.reload();
					    },
					    error :function(){
					        alert("Nie udało się  ");
					    }
					});
						
						
					}else{
						alert("Przekroczono limit w zakresie dat. Limit to 15 dni");
					}

					
				} else {
					 //alert("są w różnych miesiącach");
					 //Sprawdzamy ile dni jest w miesiącu początkowym
					 $scope.numberOfDaysInMonth = $scope.daysInMonth($scope.startDate.getMonth()+1,$scope.startDate.getYear()+1900);	 	  
					 $scope.numberOfDays =( $scope.numberOfDaysInMonth - $scope.startDate.getDate()) + $scope.endDate.getDate();
					// alert($scope.numberOfDays);
					 
					 //ustawiamy limit w wybieraniu dat
					 if($scope.numberOfDays<=15 ){

						$scope.startD= formatDate($scope.startDate);
						$scope.endD =formatDate($scope.endDate);
						 
						    $.ajax({
						        url : '/visiting/schedule/returnSchedules',
						        type : 'GET',
						        data: {
						        	startDate: $scope.startD,
						        	endDate: $scope.endD,
						        	idEmployee: id
						        },
							    success : function(data){
							    	$scope.schedules = data.days;
							    	$scope.availableTParts = [];

							    	
							    	for(x in $scope.schedules){
							    		/*$scope.availableTParts = $scope.schedules[x].availableTimeParts;
							    		
							    		for(y in $scope.availableTParts){
							    			$scope.startT[y] = $scope.availableTParts[y].startHour 
							    				  + ":" + $scope.availableTParts[y].startMinute;
							    			$scope.endT[y] = $scope.availableTParts[y].endHour 
						    				  + ":" + $scope.availableTParts[y].endMinute;
							    		}*/
							    		/* alert($scope.schedules[x].availableTimeParts[0].startHour);
							    		$scope.stTime[x] = $scope.schedules[x].startHour
							    						 + ":" + 
							    						 $scope.schedules[x].startMinute;
							    		console.log("stTime: " +$scope.stTime[x] );
							    		*/
							    		
								    	  if($scope.schedules[x].dayofweek === 2){
								    		  $scope.schedules[x].dayofweek = "Poniedziałek";
								    		  console.log($scope.schedules[x].dayofweek);
								    	  }else if($scope.schedules[x].dayofweek === 3){
								    		  $scope.schedules[x].dayofweek = "Wtorek";
								    		  console.log($scope.schedules[x].dayofweek);
								    	  }else if($scope.schedules[x].dayofweek === 4){
								    		  $scope.schedules[x].dayofweek = "Środa";
								    		  console.log($scope.schedules[x].dayofweek);
								    	  }else if ($scope.schedules[x].dayofweek === 5){
								    		  $scope.schedules[x].dayofweek = "Czwartek";
								    		  console.log($scope.schedules[x].dayofweek);
								    	  }else if ($scope.schedules[x].dayofweek === 6){
								    		  $scope.schedules[x].dayofweek = "Piątek";
								    		  console.log($scope.schedules[x].dayofweek);
								    	  }else if ($scope.schedules[x].dayofweek === 7){
								    		  $scope.schedules[x].dayofweek = "Sobota";
								    		  console.log($scope.schedules[x].dayofweek);
								    	  }else if ($scope.schedules[x].dayofweek === 1){
								    		  $scope.schedules[x].dayofweek = "Niedziela";
								    		  console.log($scope.schedules[x].dayofweek);
								    	  }	    	  
								    	  
								    }
						    },
						    error :function(){
						        alert("Nie udało się  ");
						    }
						});
						 
						 
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
		
		//alert($scope.numberOfDays);
		
	};
	id = window.location.search.replace("?id=", "");
	
	

});

empl.controller("sheduleRedirectCtrl",function($scope){
	
	$scope.idEmpl= window.location.search.replace("?id=", "");
	

});