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
  //wygląd inputow
  $("input:not([type='submit'])").focus(function(){
    $(this).css({
      
      "border":"3px solid #2C4E67",

      "background-color":"#f5f5f5",
      "color":"#FFA500",
      "font-weight":"600"
    });

  });
  $("input:not([type='submit'])").blur(function(){
    $(this).css({

      "border":"1px solid #ccc",

      "background-color": "#FFF",
      
      "font-weight":"500"
    });
  });
  
  
});
