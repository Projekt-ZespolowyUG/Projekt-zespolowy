  
//Pracownik
function validate() {
    document.getElementById("addEmployeeForm").onsubmit = function() {
          
        var showError = 0;
        //Imie
        if(document.getElementById("eName").value =="") {
            $("#eName").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eName").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Nazwisko
        if(document.getElementById("eLastname").value =="") {
            $("#eLastname").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eLastname").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Nr telefonu
        if(document.getElementById("eTelephoneNumber").value =="") {
            $("#eTelephoneNumber").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eTelephoneNumber").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Email
        if(document.getElementById("eEmail").value =="") {
            $("#eEmail").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eEmail").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Adres
        if(document.getElementById("eAdress").value =="") {
            $("#eAdress").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eAdress").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Kod pocztowy
        if(document.getElementById("ePostcode").value =="") {
            $("#ePostcode").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("ePostcode").innerHTML = "";
            $(".formError").css("none","block");

        }
        ///miasto
        if(document.getElementById("eTown").value =="") {
            $("#eTown").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eTown").innerHTML = "";
            $(".formError").css("none","block");

        }
        //kraj
        if(document.getElementById("eCountry").value =="") {
            $("#eCountry").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eCountry").innerHTML = "";
            $(".formError").css("none","block");

        }
        if(0<showError) {
         return false;
        }
        else if(showError ==0){
          return true;
        }
  }
}
  
  
window.onload = function() {
validate();
}