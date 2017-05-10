var disableddates = [];
//Jquery .val til at få values ud af inputs fra JSP.
var i = ($('#i').val());
//loop igennem nogle forskellige inputs (hidden), vi har navngivet efter deres placering i tidligere ArrayList.
for(var j=0; j<i; j++){
     disableddates.push($('#date'+j).val());
 } 

function disableSpecificDates(date) {
    var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
    return [disableddates.indexOf(string) === -1];
  }
  
var date = new Date();
date.setDate(date.getDate() + 20);
var dateString = ('0' + (date.getMonth()+1)).slice(-2) + '/'
             + ('0' + date.getDate()).slice(-2)  + '/'
             + date.getFullYear();
document.getElementById('callDate').value = dateString;

$(function() {
  $("#callDate").datepicker({
    beforeShowDay: disableSpecificDates
  });
});
