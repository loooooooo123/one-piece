/*多图片整行滚动*/

(function () {
    //初始高宽
    var parUl = $("#imgScrollDemo1");
    var lidom = parUl.find("li");
    var all_li_width = lidom.length * lidom.eq(0).outerWidth();
    var all_li_height = lidom.eq(0).find('img').height();
    parUl.width(all_li_width + lidom.eq(0).outerWidth()).height(all_li_height);

    var imgScrollDemo = function () {
        //左运动
        var flag = false;
        $("#rightNext").click(function () {

            if (flag) {
                return;
            }
            if ((parUl.offset().left - parUl.parent().width()) <= -parUl.outerWidth()) {
                parUl.stop().animate({"left": "0px"}, 1300);
            } else {
                parUl.stop().animate({"left": "-=" + parUl.parent().width() + "px"}, 1300);
            }
            flag = true;
            setTimeout(function () {
                flag = false;
            }, 1500);
        });
        //右运动
        $("#leftPrev").click(function () {
            if (flag) {
                return;
            }

            if (parUl.offset().left + lidom.eq(0).outerWidth() >= 0) {
                parUl.stop().animate({"left": "0px"}, 1300);
            } else {
                parUl.stop().animate({"left": "+=" + parUl.parent().width() + "px"}, 1300);
            }

            flag = true;
            setTimeout(function () {
                flag = false;
            }, 1500);
        });
    }

    window.imgScrollDemo = imgScrollDemo;

})();