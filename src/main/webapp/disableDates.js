var disableddates = ["05-05-2017"];
//Jquery .val til at få values ud af inputs fra JSP.
var i = ($('input[id="i"]').val());
//loop igennem nogle forskellige inputs (hidden), vi har navngivet efter deres placering i tidligere ArrayList.
for(var j=0; j<i; j++){
     disableddates.push($('input[id="date'+j+'"]').val());
 } 


function DisableSpecificDates(date) {
  
    var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
    return [disableddates.indexOf(string) === -1];
  }
  
  

n =  new Date();
y = n.getFullYear();
m = n.getMonth() + 1;
d = n.getDate();
document.getElementById('callDate').value=m + "/" + d + "/" + y;





$(function() {
  $("#callDate").datepicker({
    beforeShowDay: DisableSpecificDates
  });
});