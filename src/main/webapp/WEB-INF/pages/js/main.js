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
  
  
});