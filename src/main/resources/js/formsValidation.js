  
//Pracownik
function validate() {
    document.getElementById("addEmployeeForm").onsubmit = function() {
          
        var showError = 0;
        //Imie
        if(document.getElementById("eName").value.length < 3 || document.getElementById("eName").value.length > 20) {
            $("#eName").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eName").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Nazwisko
        if(document.getElementById("eLastname").value.length < 3 || document.getElementById("eLastname").value.length > 40) {
            $("#eLastname").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eLastname").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Nr telefonu
        if(document.getElementById("eTelephoneNumber").value.length < 3 || document.getElementById("eTelephoneNumber").value.length > 12) {
            $("#eTelephoneNumber").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eTelephoneNumber").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Email
        if(document.getElementById("eEmail").value.length < 6 || document.getElementById("eEmail").value.length > 40) {
            $("#eEmail").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eEmail").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Adres
        if(document.getElementById("eAdress").value.length < 3 || document.getElementById("eAdress").value.length >40) {
            $("#eAdress").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eAdress").innerHTML = "";
            $(".formError").css("none","block");

        }
        //Kod pocztowy
        if(document.getElementById("ePostcode").value.length < 3 || document.getElementById("ePostcode").value.length > 10) {
            $("#ePostcode").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("ePostcode").innerHTML = "";
            $(".formError").css("none","block");

        }
        ///miasto
        if(document.getElementById("eTown").value.length < 3 || document.getElementById("eTown").value.length > 40) {
            $("#eTown").css("border","3px solid #b22222");
            $(".formError").css("display","block");
            showError++;
        }
        else {
            document.getElementById("eTown").innerHTML = "";
            $(".formError").css("none","block");

        }
        //kraj
        if(document.getElementById("eCountry").value.length < 3 || document.getElementById("eCountry").value.length > 40 ) {
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