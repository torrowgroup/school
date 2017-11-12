/*
var obj = {
    w_id:'',   //必要参数 
    c_id:'',    //必要参数
    c_copy_id:'' //必要参数
}

*/
function loop(obj){
    function gitId(a){
        return document.getElementById(a);
    }
    var speed=30,
        tab=gitId(obj.w_id),
        tab1=gitId(obj.c_id),
        tab2=gitId(obj.c_copy_id);
    tab2.innerHTML=tab1.innerHTML;
    function Marquee(){
        if(tab2.offsetWidth-tab.scrollLeft<=0)
            tab.scrollLeft-=tab1.offsetWidth
        else{
            tab.scrollLeft++;
        }
    }
    var MyMar=setInterval(Marquee,speed);
    tab.onmouseover=function() {
        clearInterval(MyMar)
    };
    tab.onmouseout=function() {
        MyMar=setInterval(Marquee,speed)
    };
}



