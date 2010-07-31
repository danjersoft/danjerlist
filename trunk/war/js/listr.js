$(document).ready(function() {
   $('delete').click(function() {
      return confirm('Delete ' + $(this).attr('name') + '?');
   });
});