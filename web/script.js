$(document).ready(function() {
// Datepicker Popups calender to Choose date.
$(function() {
$( "#datepicker" ).datepicker({ 
            yearRange: '1937:c+1' ,
            changeYear: true,
            minDate: new Date(1937, 10 - 1, 25),
            maxDate: new Date(1997, 12 - 1, 31),
			dateFormat: 'yy-mm-dd'
        });
});
});