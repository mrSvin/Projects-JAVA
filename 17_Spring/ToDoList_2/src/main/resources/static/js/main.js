$(function(){

    //Show adding
    $('#show-add-add-form').click(function(){
        $('#add-form').css('display', 'flex');
    });

    //Closing adding
    $('#add-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Show adding
    $('#show-update-update-form').click(function(){
        $('#update-form').css('display', 'flex');
    });

    //Closing updateing
    $('#update-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Show adding
    $('#show-delete-form').click(function(){
        $('#delete-form').css('display', 'flex');
    });

    //Closing deleteing
    $('#delete-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

});