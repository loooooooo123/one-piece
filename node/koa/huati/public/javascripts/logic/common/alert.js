/* 
 美化alert弹窗提示
 @params text type:string value:提示文字
 @params time type:float value:弹窗多少秒后消失
 */
function alertTpl(text, time) {
    $(".alertCon").show().find(".text").text(text);
    setTimeout(function () {
        $(".alertCon").hide();
    }, time * 1000);
}