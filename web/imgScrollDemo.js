/*多图片整行滚动*/

(function () {
    //初始高宽
    var parUl = $(".scroll_ul");
    var lidom = parUl.find("li");
    var lisdomW = $(window).width() / 10 - 50;
    lidom.width(lisdomW).height(lisdomW);
    var all_li_width = lidom.length * lidom.eq(0).outerWidth();
    var all_li_height = lidom.eq(0).find('img').height();
    parUl.width(all_li_width).height(all_li_height);

    var imgScrollDemo = function () {
        //左运动
        $("#rightNext").click(function () {
            if ((parUl.offset().left - lidom.eq(0).outerWidth() + 50) <= -parUl.outerWidth()) {
                parUl.stop().animate({"left": "0px"});
            } else {
                parUl.stop().animate({"left": "-=" + (lidom.eq(0).outerWidth() + 50) + "px"});
                console.log(1);
            }
        });
        //右运动
        $("#leftPrev").click(function () {
            if (parUl.offset().left + lidom.eq(0).outerWidth() <= (lidom.eq(0).outerWidth() + 50)) {
                parUl.stop().animate({"left": "0px"});
            } else {
                parUl.stop().animate({"left": "+=" + (lidom.eq(0).outerWidth() + 50) + "px"});
                console.log(1);
            }
        });
    }

    window.imgScrollDemo = imgScrollDemo;

})();