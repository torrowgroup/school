function days(string0){
    var myDate = new Date()
        myyear = myDate.getFullYear() 
        mymonth = myDate.getMonth()+1
        myday = myDate.getDate()
        month_day = new Array(0,31,28,31,30,31,30,31,31,30,31,30,31)
        strs= new Array();
        strs = string0.split("-");
    var day = 0
        Y = parseInt(strs[0])
        M = parseInt(strs[1])
        D = parseInt(strs[2]);
    if(myyear==Y){
        var rn = panduan(myyear);
        if(rn&& mymonth<=2){
            day = Mqiuhe(mymonth,M)+D-myday+1
        }
        else{
            day = Mqiuhe(mymonth,M)+D-myday
        }
    }
    else{
        if(panduan(Y)){
            day = Mqiuhe(mymonth,12)-myday+Mqiuhe(1,M)+D+1;
        }
        else{
            console.log(Mqiuhe(mymonth,12)+Mqiuhe(1,M)+"   "+myday-D);
            day = Mqiuhe(mymonth,12)-myday+Mqiuhe(1,M)+D;
            console.log(day);
        }
    }
    /**
     * 
     * @param {*传进去一个年份  判断是不是闰年} yeas 
     */
    function panduan(yeas){
        if((yeas%4==0&&yeas%100!=0)||yeas%400==0){
            return true
        }
        return false
    }
    /**
     * 
     * @param {*第一个月份  } month1
     * @param {*第二个月份  } month2
     */
    function Mqiuhe(month1,month2){
        var days= 0;
        for(month1;month1<month2;month1++){
            days = days+month_day[month1];
        }
        return days;
    }
    var obj = {
        time:"今天"+myyear+"年"+mymonth+"月"+myday+"日",
        days:day
    }
    return  obj;
}