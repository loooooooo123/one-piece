/*多图片整行滚动*/

(function () {
    //初始高宽
    var parUl = $("#imgScrollDemo1");
    var lidom = parUl.find("li");
    var all_li_width = lidom.length * lidom.eq(0).outerWidth();
    var all_li_height = lidom.eq(0).find('img').height();
    parUl.width(all_li_width + lidom.eq(0).outerWidth()).height(all_li_height);

    var imgScrollDemo = function () {

        //防止多次重复点击
        var flag = false;

        //移动
        $(".imgScrollDemo_btn").click(function () {
            //防止多次重复点击
            if (flag) {
                return;
            }

            if ($(this).attr("type") == "left") {
                if ((parUl.offset().left - parUl.parent().width()) <= -parUl.outerWidth()) {
                    parUl.stop().animate({"left": "0px"}, 1300);
                } else {
                    parUl.stop().animate({"left": "-=" + parUl.parent().width() + "px"}, 1300);
                }
            } else if ($(this).attr("type") == "right") {
                if (parUl.offset().left + lidom.eq(0).outerWidth() >= 0) {
                    parUl.stop().animate({"left": "0px"}, 1300);
                } else {
                    parUl.stop().animate({"left": "+=" + parUl.parent().width() + "px"}, 1300);
                }
            }

            //防止多次重复点击
            flag = true;
            setTimeout(function () {
                flag = false;
            }, 1300);
        });
    }

    window.imgScrollDemo = imgScrollDemo;

})();