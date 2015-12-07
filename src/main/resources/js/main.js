$(document).ready(function(){ 

//Rozwijane Menu
  $(".menu .menuDesktop li").hover(function() {
    $(this).find(".rollOutMenu").fadeIn(200);
  },function() {
    $(this).find(".rollOutMenu").fadeOut(200);
  });
  
//Menu Mobilne
  $(".menu .menuMobile").css("display","none");
  $(".menu .bars").click(function(){
    $(".menu .menuMobile").toggle();
  });
  //włączenie flexslidera
  $('.sliderSection .flexslider').flexslider({
    animation: "slide",
    direction: "horizontal",
  });
  
  //formularz Employee
  	$("#employeeAddForm").click(function(){
	    var name = document.getElementById("eName").value;
	    var lastname = document.getElementById("eLastname").value;
	    var telephoneNumber = document.getElementById("eTelephoneNumber").value;
	    var adress = document.getElementById("eAdress").value;
	    var postcode = document.getElementById("ePostcode").value;
	    var town = document.getElementById("eTown").value;
	    
	    if(name == "" || lastname == "" || telephoneNumber == "" || adress == "" || postcode == "" || town == ""){
	      $("#eName, #eLastName").css("border","3px solid red");
	    $("#eAdress, #eTelephoneNumber, #eTown, #ePostcode").css("border","3px solid red");
	      //alert("kupa");
	      return false;
	    } 
	 });
  
});