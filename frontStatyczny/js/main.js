$(document).ready(function(){ 

  //Rozwijane Menu
  $(".menu .menuDesktop li").hover(function() {
    
      $(this).find(".rollOutMenu").fadeIn(200);
    
  },function() {
    
      $(this).find(".rollOutMenu").fadeOut(200);
    
  });
  
  //Animacja Ładowania strony
  $('.menu .menuDesktop li a, .menu .logo a, .menu .logInSection .registerButton a').click(function(event) {
      event.preventDefault();
      var href = this.href;
    
      $(".menu .addMenuAnimation").addClass("animationMenuLoading");
    
      $('.menu .addMenuAnimation').animate({
          top: '3.25rem'
      }, 800,
      function() {
        
          window.location = href;
          $(".menu .addMenuAnimation").removeClass("animationMenuLoading");
        
      });
  });
  
  //Menu Mobilne
  $(".menu .menuMobile").css("display","none");
  $(".menu .bars").click(function(){
    
      $(".menu .menuMobile").toggle();
    
  });
  
  //Logowanie panel rozwijany
  $("header .logInButton").click(function(){
    
      $(this).toggleClass("darkBackground");
      $(".logInForm").toggle(200);
    
  });
  
  //włączenie flexslidera
  $('.sliderSection .flexslider').flexslider({
    
      animation: "slide",
      direction: "horizontal",
    
  });
  
  //Walidacja formularza Employee
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
          return false;
        
      }
  });
  $(validateEmployee);

});
