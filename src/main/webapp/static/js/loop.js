/*


var obj1 = {
    container_id:'loop',
    ul_id:'loop_ul',
    span_left_id:'spanleft',
    span_right_id:'spanright',
    li_one_class:'old',
    li_chance_class:'chance'
}
*/
function Carousel_opcity(obj){
    function getId(a){
        return document.getElementById(a);
    }
    var container = getId(obj.container_id),
        imgs = container.getElementsByTagName('img'),
        index = 0,
        timer_1,
        ultorf = true,
        spans = true;
    if(obj.ul_id==''){
        ultorf = false;
    }
    //如果  有ul  为每个li绑定 点击事件；
    else{
        var ul_l = getId(obj.ul_id),
        lis = ul_l.getElementsByTagName('li');
        for(var i = 0;i<lis.length;i++){
            !function(i){
                    lis[i].onclick = function(){
                        index = i-1;
                        clearInterval(timer_1);
                        auto_loop2(1);
                        open_1();
                    }
            }(i)
        }
    }
    if(obj.span_left_id==''&&obj.span_left_id==''){
        spans = false;
    }
    else{
       var span_left = getId(obj.span_left_id),
           span_right = getId(obj.span_right_id);
        span_left.onclick = function(){
            auto_loop2(-1);
            open_1();
        }
        span_right.onclick = function(){
            auto_loop2(1);
            open_1();
        }
    }
    //  图片又规律的自动显示
    function open_1(){
        clearInterval(timer_1);
        timer_1=setInterval(function(){
        auto_loop2(1);
        },4000);
    }
    //  图片 显示 与隐藏  的单个方法；
    function auto_loop2(a){
        index = index+a;
        if(index==imgs.length){
            index=0;
        }
        else if(index<0){
            index=imgs.length-1;
        }
        for(var i=0;i<imgs.length;i++){
            imgs[i].style.opacity = 0;
            imgs[index].style.opacity = 1;
            if(ultorf){
                lis[i].className = obj.li_one_class;
                lis[index].className = obj.li_chance_class;
            }
        }
    }
    open_1();
}