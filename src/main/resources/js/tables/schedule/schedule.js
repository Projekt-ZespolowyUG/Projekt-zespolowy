var sched = angular.module("schedule",[]);

sched.controller("showScheduleCtrl", function($http,$scope){
	
	//Zmiana formatu Daty
	function formatDate(date) {
		    var d = new Date(date),
		        month = '' + (d.getMonth() + 1),
		        day = '' + d.getDate(),
		        year = d.getFullYear();

		    if (month.length < 2) month = '0' + month;
		    if (day.length < 2) day = '0' + day;

		    return [year, month, day].join('-');
	}
	 
	/*$scope.showSchedule = function(){
		//alert(formatDate($scope.startDate));
		$scope.idE = window.location.search.replace("?id=", ""); //ID
		$scope.sDate = formatDate($scope.startDate); 	//StartDate
		$scope.eDate = $scope.sDate;					//EndDate
		
		//pobieranie informacji o dniu
		$.ajax({
	        url : '/visiting/schedule/returnSchedules',
	        type : 'GET',

	        data: {
	        	startDate: $scope.sDate,
	        	endDate: $scope.eDate,
	        	idEmployee: $scope.idE
	        },
		    success : function(data){
		    	$scope.schedule = data.days;
		    	//alert($scope.schedule[0].dayofweek);
		    	$scope.fullDate = $scope.schedule[0].dayofweek;
		    	//ustawienie Dania tygodnia
		    	if($scope.fullDate === 2 ){
		    		$scope.fullDate = "Poniedziałek";
		    	}else if ($scope.fullDate === 3 ){
		    		$scope.fullDate = "Wtorek";
		    	}else if ($scope.fullDate === 4 ){
		    		$scope.fullDate = "Środa";
		    	}else if ($scope.fullDate === 5 ){
		    		$scope.fullDate = "Czwartek";
		    	}else if ($scope.fullDate === 6 ){
		    		$scope.fullDate = "Piątek";
		    	}else if ($scope.fullDate === 7 ){
		    		$scope.fullDate = "Sobota";
		    	}else if ($scope.fullDate === 1 ){
		    		$scope.fullDate = "Niedziela";
		    	}
		        
		    	$scope.fullDate += 
		    					 " " +
		    					   $scope.schedule[0].dayofmonth
		    					+ "." +
		    					   $scope.schedule[0].month
		    					+ "." +
		    					   $scope.schedule[0].year;
		    	$scope.$watch('fullDate',function(){
		    		console.log("fullDate zostało zmienione: " +$scope.fullDate );
		    		
		    	$scope.range = [];
		        $scope.rangeFrom = $scope.schedule[0].occupiedTimeParts[0].startHour;	
		    	$scope.rangeTo = $scope.schedule[0].occupiedTimeParts[0].endHour;
		    	
		    	for(i = $scope.rangeFrom ; i<= $scope.rangeTo ; i++){
		    		//ustawienie obiektu range posiadającego godziny dostępnosci danego pracownika
		    		$scope.range[i]=$scope.rangeFrom +i;
		    	}
		    	console.log($scope.range);
		    	});
		    	//alert($scope.fullDate);
		    },
		    error :function(){
		        alert("Nie udało się  ");
		    }
		});
	
	};*/
	$scope.showSchedule = function(){
		//alert(formatDate($scope.startDate));
		$scope.idE = window.location.search.replace("?id=", ""); //ID
		$scope.sDate = formatDate($scope.startDate); 	//StartDate
		$scope.eDate = $scope.sDate;					//EndDate
		
		//pobieranie informacji o dniu
		$.ajax({
	        url : '/visiting/visit/returnvisitdto',
	        type : 'GET',

	        data: {
	        	startDate: $scope.sDate,
	        	endDate: $scope.eDate,
	        	idEmployee: $scope.idE
	        },
		    success : function(data){
		    	
		    	$scope.freeTimes = data.days[0].freeVisits;
		    	for(x in $scope.freeTimes){
		    		//alert($scope.freeTimes[x].startHour);
		    		if($scope.freeTimes[x].startHour < 10){
		    			$scope.freeTimes[x].startHour = '0' + $scope.freeTimes[x].startHour;
		    		}
		    		if($scope.freeTimes[x].startMinute < 10){
		    			$scope.freeTimes[x].startMinute = '0' + $scope.freeTimes[x].startMinute;
		    		}
		    		if($scope.freeTimes[x].endHour < 10){
		    			$scope.freeTimes[x].endHour = '0' + $scope.freeTimes[x].endHour;
		    		}
		    		if($scope.freeTimes[x].endMinute < 10){
		    			$scope.freeTimes[x].endMinute = '0' + $scope.freeTimes[x].endMinute;
		    		}
		    	}

		    },
		    error :function(){
		        alert("Nie udało się  ");
		    }
		});
	 //$(".addToSchedule").toggle();
	};
	//Dodawanie Wizyt
	
	//select z klientami
	$http.get('/visiting/customer/list').success(function(data) {
		$scope.customers = data;
		//$scope.$apply();
	});
	
	$scope.addVisit = function(){
		$scope.staTH =$scope.staT.getHours();
		$scope.staTM =$scope.staT.getMinutes();
		
		$scope.endTH =$scope.endT.getHours();
		$scope.endTM =$scope.endT.getMinutes();
		
		if($scope.staT.getHours()<10){
			$scope.staTH = '0'+ $scope.staT.getHours();
		}
		if($scope.staT.getMinutes()<10){
			$scope.staTM = '0'+ $scope.staT.getMinutes();
		}
		if($scope.endT.getHours()<10){
			$scope.endTH = '0'+ $scope.endT.getHours();
		}
		if($scope.endT.getMinutes()<10){
			$scope.endTM = '0'+ $scope.endT.getMinutes();
		}
		
		
		$scope.sTime = formatDate($scope.startDate) + "T" + $scope.staTH +":"+ $scope.staTM ;
		$scope.eTime = formatDate($scope.startDate) + "T" + $scope.endTH +":"+ $scope.endTM;
		//alert($scope.customer + " " + $scope.sTime + "T" + $scope.eTime);
		id = window.location.search.replace("?id=", "");
		
		
		$.ajax({
			url : '/visiting/visit/add', //+ '?idEmployee=' + id + '&idCustomer=' + $scope.customer + '&startTime=' + $scope.sTime + '&endTime=' + $scope.eTime ,
			type : 'POST',
			dataType : "json",
			contentType: 'application/json; charset=utf-8',
			data :JSON.stringify({
				
				employee:{
		              id: id
		        },
				customer:{
					 id: $scope.customer
				},
                startDate: $scope.sTime + ':00.000+02:00',
                endDate: $scope.eTime + ':00.000+02:00'
			}),
			success : function() {
				//alert("udało się")
				//window.location.reload();
				alert("udało się !");
			},
			error : function() {
				//alert("nie udalo sie");
				alert("udało się !");
				//window.location.replace("customer.jsp");
			}
		});
		
	};
	
	//wyszukiwanie wizyty
	$scope.searchVisit = function(){
		$http({
			url : '/visiting/visit/filter',
			method : 'GET',
			params : {
				firstName : $scope.fName,
				lastName : $scope.lName,
				telephoneNumber : $scope.tNumber
			}
		}).success(function(data){
			$scope.customers = data;
			//alert("udało się : ");
			$(".customerList").css("display","none");
		});	
		
	};
	
	
});