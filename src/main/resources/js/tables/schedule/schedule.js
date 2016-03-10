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
	 
	$scope.showSchedule = function(){
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
	        $scope.rangeFrom = $scope.schedule[0].availableTimeParts[0].startHour;	
	    	$scope.rangeTo = $scope.schedule[0].availableTimeParts[0].endHour;
	    	
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
		
		
		
		
		
	};
});