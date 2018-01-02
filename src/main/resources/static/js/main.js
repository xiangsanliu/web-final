window.onload=function(){
    var Oimage=document.getElementById('User');
    var Oshowlog=document.getElementById('showlog');
    var timer=null;

    Oimage.onmouseover=function()
    {
        clearTimeout(timer);
        Oshowlog.style.display='block';
    };
    Oimage.onmouseout=function ()
    {
        timer=setTimeout(function (){
            Oshowlog.style.display='none';
        },50);
    };

    Oshowlog.onmouseover=function ()
    {
        clearTimeout(timer);
    };
    Oshowlog.onmouseout=function ()
    {
        timer=setTimeout(function (){
            Oshowlog.style.display='none';
        }, 50);
    };
};

$(document).ready(function () {
    // $("#content_body").hide();
});

function displayDescription(name, description) {
    $("#content_header").text(name);
    $("#assign_body").text(description);
    $("#content_body").show();
    document.getElementById('type').value = name;
}
