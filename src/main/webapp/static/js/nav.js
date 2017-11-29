$(function(){
    // nav收缩展开
    $('.nav-item>a').on('click',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            if ($(this).next().css('display') == "none") {
                //展开未展开
                $('.nav-item').children('ul').slideUp(300);
                $(this).next('ul').slideDown(300);
                $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
            }else{
                //收缩已展开
                $(this).next('ul').slideUp(300);
                $('.nav-item.nav-show').removeClass('nav-show');
            }
        }
    });

});
// 左侧伸缩按钮js
$(function(){
    $("#side_switch").click(function(){
        $(".left").hide();
        $("#main").contents().find(".right_body").css('margin-left',0);
        $(this).hide();
        $("#side_switchl").show();
    })
})
$(function(){
    $("#side_switchl").click(function(){
        $(".left").show();
        $("#main").contents().find(".right_body").css('margin-left',200);
        $(this).hide();
        $("#side_switch").show();
    })
})