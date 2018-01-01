$('#submit').click(function(){
    var file = $("#file").val();
    $.ajax({
        type: "POST",
        url: '/upload/file',
        data: {file: file},
        success: function (data) {
            console.log(data);
            console.log(data.resultCode);
        }
    })
});