var disableddates = ["05-05-2017"];


function DisableSpecificDates(date) {
    var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
    return [disableddates.indexOf(string) == -1];
  }



$(function() {
  $("#callDate").datepicker({
    beforeShowDay: DisableSpecificDates
  });
});