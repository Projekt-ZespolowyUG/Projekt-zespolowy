$(document).ready(function () {

  //Załadowanie strony 

  setTimeout(function () {
    $('body').addClass('loaded');
    $('h1').css('color', '#222222');
  }, 3000);
  if (screen.width <= 600) {
    $("#loader-wrapper").css("display", "none");
  }



  //Rozwijane Menu
  $(".menu .menuDesktop li").hover(function () {

    $(this).find(".rollOutMenu").fadeIn(0);

  }, function () {

    $(this).find(".rollOutMenu").fadeOut(0);

  });


  //Animacja Ładowania strony
  $('.menu .menuDesktop li a, .menu .logo a, .menu .logInSection .registerButton a').click(function (event) {
    event.preventDefault();
    var href = this.href;

    $(".menu .addMenuAnimation").addClass("animationMenuLoading");

    $('.menu .addMenuAnimation').animate({
        top: '3.25rem'
      }, 800,
      function () {

        window.location = href;
        $(".menu .addMenuAnimation").removeClass("animationMenuLoading");

      });
  });

  //Menu Mobilne
  $(".menu .menuMobile").css("display", "none");
  $(".menu .bars").click(function () {

    $(".menu .menuMobile").toggle();

  });

  //Logowanie panel rozwijany
  $("header .logInButton").click(function () {

    $(this).toggleClass("darkBackground");
    $(".logInForm").toggle(200);

  });


  
  //wygląd inputow
  $("input:not([type='submit'])").focus(function () {
    $(this).css({
      "border": "3px solid #2C4E67",
      "background-color": "#f5f5f5",
      "color": "#FFA500",
      "font-weight": "600"
    });

  });
  $("input:not([type='submit'])").blur(function () {
    $(this).css({

      "border": "1px solid #ccc",

      "background-color": "#FFF",

      "font-weight": "500"
    });
  });
/*
  //Pojawianie się informacji pod ikonami crodowymi
  $(".showAll table tr .crudIcons .iconDelete").hover(function () {
    $(".showAll table tr .crudIcons .iconDelete span").toggle();
  });
  $(".showAll table tr .crudIcons .iconEdit").hover(function () {
    $(".showAll table tr .crudIcons .iconEdit span").toggle();
  });
  $(".showAll table tr .crudIcons .iconSearch").hover(function () {
    $(".showAll table tr .crudIcons .iconSearch span").toggle();
  });*/

  ///wyszukiwanie departamentow
  $(".showAll .search .searchArea").css("display","none");
  $(".showAll .search .searchRollOut").click(function () {
	  
    $(".showAll .search .searchArea").toggle(300);

    if ($(".showAll .search .searchArea").is(':visible')) {
      $(".showAll .search .searchRollOut i").css({

        "transform": "rotate(180deg)",
        "-webkit-transform": "rotate(180deg)",
        "-moz-transform": "rotate(180deg)",
        "-o-transform": "rotate(180deg)"
      });
      $(".showAll .search .searchArea").css('display', 'inline-block');
    }
    if ($(".showAll .search .searchArea").is(':hidden')) {
      $(".showAll .search .searchRollOut i").css({

        "transform": "rotate(0deg)",
        "-webkit-transform": "rotate(0deg)",
        "-moz-transform": "rotate(0deg)",
        "-o-transform": "rotate(0deg)"
      });

    }

  });
  
  //Grafik na stronie pojedynczego pracownika dodawanie godzin
  $("#addHours").click(function () {
    $(".scheduleWeeks").toggle(200);
   // $(".scheduleHours").css("display","none");
   // $(".setScheduleHours").css("display","none");
    //$(".setMoreHours").css("display","block");
    //$(".toggleButtons span").removeClass("toggleButtonYes");
  });
/*  
 //po kliknieciu pokazuje dni tygodnia z godzinami pracy
  $("#scheduleList").click(function () {
    $(".scheduleHours").toggle();
  });*/
  //pokazuje po klknieciu toggla przedzialy czasowe
  $("#imWorking").click(function(){
    $(".setScheduleHours").toggle();
    $(".setMoreHours").toggle();
    $(".toggleButtons span").toggleClass("toggleButtonYes");
  });
  
  $("#setMoreHours").click(function(){
    var from = '<label class="medium-6 columns">Od<input type="time"></label>';
    var to = '<label class="medium-6 columns">Do<input type="time"></label>';
    $(".setScheduleHours").append(from,to);
  });
  
});