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
							    	$scope.stTime=[];
							    	$scope.enTime=[];
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
								    	  //czas Od obliczanie i wklejanie w value na stronie
								    	  if ($scope.schedules[x].availableTimeParts[0].startHour < 10){
								    		  $scope.stH = "0" + $scope.schedules[x].availableTimeParts[0].startHour;
								    		  console.log("startHour : "+ $scope.stH);
								    	  }else {
								    		  $scope.stH= $scope.schedules[x].availableTimeParts[0].startHour;
								    		  console.log("startHour : "+ $scope.stH);
								    	  }
								    	  
								    	  if ($scope.schedules[x].availableTimeParts[0].startMinute < 10){
								    		  $scope.stM = "0" + $scope.schedules[x].availableTimeParts[0].startMinute;
								    		  console.log("startHour : "+ $scope.stM);
								    	  }else {
								    		  $scope.stM= $scope.schedules[x].availableTimeParts[0].startMinute;
								    		  console.log("startHour : "+ $scope.stM);
								    	  }
								    	  
								    	  $scope.stTime[x] = $scope.stH + ":" + $scope.stM;
								    	  console.log("stTime: " + $scope.stTime[x]);
								    	  
								    	  
								    	  //czas Do obliczanie i wklejanie w value na stronie
								    	  if ($scope.schedules[x].availableTimeParts[0].endHour < 10){
								    		  $scope.enH = "0" + $scope.schedules[x].availableTimeParts[0].endHour;
								    		  console.log("endHour : "+ $scope.enH);
								    	  }else {
								    		  $scope.enH= $scope.schedules[x].availableTimeParts[0].endHour;
								    		  console.log("endHour : "+ $scope.enH);
								    	  }
								    	  
								    	  if ($scope.schedules[x].availableTimeParts[0].endMinute < 10){
								    		  $scope.enM = "0" + $scope.schedules[x].availableTimeParts[0].endMinute;
								    		  console.log("endHour : "+ $scope.enM);
								    	  }else {
								    		  $scope.enM= $scope.schedules[x].availableTimeParts[0].endMinute;
								    		  console.log("startHour : "+ $scope.enM);
								    	  }
								    	  
								    	  $scope.enTime[x] = $scope.enH + ":" + $scope.enM;
								    	  console.log("enTime: " + $scope.enTime[x]);
								    	  
								    }
							    	id = window.location.search.replace("?id=", "");

							    	$scope.saveSchedulehours = function() {
							    		//alert("udalo sieee");
								    	for(x in $scope.schedules){
								    		
								    	$scope.stHour=	$scope.stTime[x].substring(0,2);
								    	//Sprawdzenie czy pierszy znak nie jest 0
								    	if($scope.stHour.substring(0,1) === '0') {
								    		$scope.stHour=$scope.stHour.substring(1,2);
								    		console.log("godzina:" + $scope.stHour);
								    	}
								    	$scope.stMinute= $scope.stTime[x].substring(3,5)
								    	if($scope.stMinute.substring(0,1) === '0') {
								    		$scope.stMinute=$scope.stMinute.substring(1,2);
								    		console.log("minuta:" + $scope.stMinute);
								    	}
								    	
								    	
							    		
								    	$scope.enHour=	$scope.enTime[x].substring(0,2);
								    	//Sprawdzenie czy pierszy znak nie jest 0
								    	if($scope.enHour.substring(0,1) === '0') {
								    		$scope.enHour=$scope.enHour.substring(1,2);
								    		console.log("godzina:" + $scope.enHour);
								    	}
								    	$scope.enMinute= $scope.enTime[x].substring(3,5)
								    	if($scope.enMinute.substring(0,1) === '0') {
								    		$scope.enMinute=$scope.enMinute.substring(1,2);
								    		console.log("minuta:" + $scope.enMinute);
								    	}
								    	
								    	
								    	//alert($scope.stHour.substring(0,1));
								    		
							    	       $.ajax({
							                   url : '/visiting/schedule/addScheduleDTO?idEmployee='+ id,
							                   type : 'POST',
							                   dataType : "json",
							                   contentType: 'application/json; charset=utf-8',
							                   data: JSON.stringify({
							          				                	   
								                       days: [{
								                           dayofweek:  $scope.schedules[x].dayofweek,
								                           dayofmonth: $scope.schedules[x].dayofmonth,
								                           dayofyear: $scope.schedules[x].dayofyear,
								                           month: $scope.schedules[x].month,
								                           year: $scope.schedules[x].year,
								                           occupiedTimeParts: $scope.schedules[x].occupiedTimeParts,
								                           availableTimeParts:[{
								                        	   startHour: $scope.stHour,
								                        	   startMinute: $scope.stMinute,
								                        	   endHour: $scope.enHour,
								                        	   endMinute: $scope.enMinute,
								                           }]
								                       }]
							                	  
							                	   //idEmployee:id
							                   }),success : function(){
							                	   alert("udałoo siee");
							           
							                     },
							                     error :function(){
							                    	 alert("nie udałoo siee");
							 
							                     }
							                 });
								    	}
							    		
							    	};
							    	
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
							    	$scope.stTime=[];
							    	$scope.enTime=[];
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
								    	  //czas Od obliczanie i wklejanie w value na stronie
								    	  if ($scope.schedules[x].availableTimeParts[0].startHour < 10){
								    		  $scope.stH = "0" + $scope.schedules[x].availableTimeParts[0].startHour;
								    		  console.log("startHour : "+ $scope.stH);
								    	  }else {
								    		  $scope.stH= $scope.schedules[x].availableTimeParts[0].startHour;
								    		  console.log("startHour : "+ $scope.stH);
								    	  }
								    	  
								    	  if ($scope.schedules[x].availableTimeParts[0].startMinute < 10){
								    		  $scope.stM = "0" + $scope.schedules[x].availableTimeParts[0].startMinute;
								    		  console.log("startHour : "+ $scope.stM);
								    	  }else {
								    		  $scope.stM= $scope.schedules[x].availableTimeParts[0].startMinute;
								    		  console.log("startHour : "+ $scope.stM);
								    	  }
								    	  
								    	  $scope.stTime[x] = $scope.stH + ":" + $scope.stM;
								    	  console.log("stTime: " + $scope.stTime[x]);
								    	  
								    	  
								    	  //czas Do obliczanie i wklejanie w value na stronie
								    	  if ($scope.schedules[x].availableTimeParts[0].endHour < 10){
								    		  $scope.enH = "0" + $scope.schedules[x].availableTimeParts[0].endHour;
								    		  console.log("endHour : "+ $scope.enH);
								    	  }else {
								    		  $scope.enH= $scope.schedules[x].availableTimeParts[0].endHour;
								    		  console.log("endHour : "+ $scope.enH);
								    	  }
								    	  
								    	  if ($scope.schedules[x].availableTimeParts[0].endMinute < 10){
								    		  $scope.enM = "0" + $scope.schedules[x].availableTimeParts[0].endMinute;
								    		  console.log("endHour : "+ $scope.enM);
								    	  }else {
								    		  $scope.enM= $scope.schedules[x].availableTimeParts[0].endMinute;
								    		  console.log("startHour : "+ $scope.enM);
								    	  }
								    	  
								    	  $scope.enTime[x] = $scope.enH + ":" + $scope.enM;
								    	  console.log("enTime: " + $scope.enTime[x]);
								    	  
								    }
							    	id = window.location.search.replace("?id=", "");

							    	$scope.saveSchedulehours = function() {
							    		//alert("udalo sieee");
								    	for(x in $scope.schedules){
								    		
								    	$scope.stHour=	$scope.stTime[x].substring(0,2);
								    	//Sprawdzenie czy pierszy znak nie jest 0
								    	if($scope.stHour.substring(0,1) === '0') {
								    		$scope.stHour=$scope.stHour.substring(1,2);
								    		console.log("godzina:" + $scope.stHour);
								    	}
								    	$scope.stMinute= $scope.stTime[x].substring(3,5)
								    	if($scope.stMinute.substring(0,1) === '0') {
								    		$scope.stMinute=$scope.stMinute.substring(1,2);
								    		console.log("minuta:" + $scope.stMinute);
								    	}
								    	
								    	
							    		
								    	$scope.enHour=	$scope.enTime[x].substring(0,2);
								    	//Sprawdzenie czy pierszy znak nie jest 0
								    	if($scope.enHour.substring(0,1) === '0') {
								    		$scope.enHour=$scope.enHour.substring(1,2);
								    		console.log("godzina:" + $scope.enHour);
								    	}
								    	$scope.enMinute= $scope.enTime[x].substring(3,5)
								    	if($scope.enMinute.substring(0,1) === '0') {
								    		$scope.enMinute=$scope.enMinute.substring(1,2);
								    		console.log("minuta:" + $scope.enMinute);
								    	}
								    	
								    	
								    	//alert($scope.stHour.substring(0,1));
								    		
							    	       $.ajax({
							    	    	   url : '/visiting/schedule/addScheduleDTO?idEmployee='+ id,
							                   type : 'POST',
							                   dataType : "json",
							                   contentType: 'application/json; charset=utf-8',
							                   data: JSON.stringify({
							                	   
							                	   scheduledto: [{
								                       days: [{
								                           dayofweek:  $scope.schedules[x].dayofweek,
								                           dayofmonth: $scope.schedules[x].dayofmonth,
								                           dayofyear: $scope.schedules[x].dayofyear,
								                           month: $scope.schedules[x].month,
								                           year: $scope.schedules[x].year,
								                           occupiedTimeParts: $scope.schedules[x].occupiedTimeParts,
								                           availableTimeParts:[{
								                        	   startHour: $scope.stHour,
								                        	   startMinute: $scope.stMinute,
								                        	   endHour: $scope.enHour,
								                        	   endMinute: $scope.enMinute,
								                           }]
								                       }]
							                	   }],
							                	   idEmployee:id
							                   }),success : function(){
							                	   alert("udałoo siee");
							           
							                     },
							                     error :function(){
							                    	 alert("nie udałoo siee");
							 
							                     }
							                 });
								    	}
							    		
							    	};
							    	
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