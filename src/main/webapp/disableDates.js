var disableddates = ["20-05-2017", "12-11-2014", "12-25-2014", "12-20-2014"];


function DisableSpecificDates(date) {
    var string = jQuery.datepicker.formatDate('dd-mm-yy', date);
    return [disableddates.indexOf(string) == -1];
  }



$(function() {
  $("#callDate").datepicker({
    beforeShowDay: DisableSpecificDates
  });
});