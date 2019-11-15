function check_all(a){
    var hobby  =document.getElementsByClassName("body");
    for(var i  =0;i<hobby.length;i++){
        var h = hobby[i];
        h.checked = true;               
    }
    
    a.setAttribute("onclick","noCheck_all(this)");
}

function noCheck_all(a){
    var hobby  =document.getElementsByClassName("body");
    for(var i  =0;i<hobby.length;i++){
        var h = hobby[i];
        h.checked = false;
    }
    a.setAttribute("onclick","check_all(this)");
}
