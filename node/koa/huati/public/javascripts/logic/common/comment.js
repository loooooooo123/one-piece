//我要吐槽
function addComment() {

    //支持或反对
    var flag = $(".select_vote label").attr('flag') == "Y" ? 'Y' : 'N';

    var params = {
        username: base.getStoreage('username', false),
        token: base.getStoreage('token', false),
        id: $("#hid").val(),
        comment: $("#comment").val(),    //吐槽内容
        type: flag    //支持或反对
    }

    if (!params.comment || params.comment == null || params.comment.trim() == '') {
        alertTpl('请输入吐槽内容', 1.5);
        $(".comment").show();
        $(".comment_bar").hide();
        $("#comment").focus();
        return;
    }

    $.post("/api/addcomment", params, function (data) {

        if (data.status == 1) {
            alertTpl('吐槽成功~', 1.5);

            //刷新当前页
            setTimeout(function () {
                window.history.go(0);
            }, 1500);
        } else if (data.status == 0 && data.error == 'no') {
            alertTpl('请登录后进行评论', 1.5);

            //跳转到登录页
            setTimeout(function () {
                window.location.href = "/login";
            }, 1500);
        } else {
            alertTpl(data.error, 1.5);

            //跳转到登录页
            setTimeout(function () {
                window.location.href = "/login";
            }, 1500);
        }
    })
}

//关闭吐槽窗
function closeComment() {
    $("#comment_close").click(function () {
        $("#comment").val('');
        $(".comment").hide();
        $(".comment_bar").show();
    });
}

$(function () {
    //显示吐槽窗
    $(".comment_bar").click(function () {
        $(".comment").show();
        $(".comment_bar").hide();
        $("#comment").focus();

        $(".select_vote label").click(function () {
            $(".select_vote label").removeClass('focus').attr('flag', "N");
            $(this).addClass('focus').attr('flag', "Y");
        });
        //关闭吐槽窗
        closeComment();
    });
    //隐藏吐槽窗，开始吐槽
    $(".comment_submit").click(function () {
        $(".comment").hide();
        $(".comment_bar").show();

        //我要吐槽
        addComment();
    });
});