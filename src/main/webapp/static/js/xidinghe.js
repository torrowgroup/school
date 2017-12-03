function xiding(xid){
    var div1 = $(xid);
    var x = div1.offset();
    var t = true;
    $(window).scroll(function(){
        var scr = $(this).scrollTop();
        if(scr-div1.height()>x.top){
            if(t){
                div1.css({
                    "position":"fixed",
                    "top":-100+'px',
                    "opacity":"0.9"
                });
                setTimeout(function(){
                for(var i=-100;i<0;i++){
                        div1.css('top',i+'px');
                }
                },100);
            }
        t = false;
        }
        else{
            div1.css({
                "position":"",
                "top":"",
                "opacity":"1"
            });
            t = true;
        }
      });
}