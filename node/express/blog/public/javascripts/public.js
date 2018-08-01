// 验证非空
function emptyRex(n) {
    if (n == null || n == '') {
        return false;
    }
    return true;
}

// 弹窗提示
function msg_window(err) {
    $('#messages').show();
    $('#msg1').html(err);
    clearTimeout(setT);
    var setT = setTimeout(function () {
        $('#messages').hide();
    }, 1500);
}

// 延迟1.5秒执行代码
function setTime1(callback) {
    setTimeout(function () {
        return callback();
    }, 1500);
}

//用户注册
function regAjax() {

    $('.submit').click(function () {

        //获取数据
        $getName = $('#username').val();
        $getPsw = $('#password').val();
        $getPswRe = $('#password_repeat').val();
        $getEmail = $('#email').val();
        $getUserImg = $('.userImgCon').attr('src');

        //验证数据
        if (emptyRex($getName) && emptyRex($getPsw) && emptyRex($getPswRe) && emptyRex($getEmail)) {
            $.ajax({
                url: '/reg',
                type: 'POST',
                data: {
                    username: $getName,
                    password: $getPsw,
                    password_repeat: $getPswRe,
                    email: $getEmail,
                    userImg: $getUserImg
                },
                success: function (data) {
                    if (data.errors) {
                        // 弹窗提示
                        msg_window(data.errors);
                        return;
                    }
                    // 弹窗提示
                    msg_window('注册成功');
                    // 延迟3秒执行代码
                    setTime1(function () {
                        location.href = "/";
                    });
                },
                error: function (err) {
                    console.log(err);
                },
            })
        } else {
            // 弹窗提示
            msg_window('不能为空，请认真核对！');
        }
    });
}

//用户登录
function loginAjax() {
    $('.submit').click(function () {

        //获取数据
        $getName = $('#username').val();
        $getPsw = $('#password').val();

        //验证数据
        if (emptyRex($getName) && emptyRex($getPsw)) {
            $.ajax({
                url: '/login',
                type: 'POST',
                data: {
                    username: $getName,
                    password: $getPsw
                },
                success: function (data) {
                    if (data.errors) {
                        // 弹窗提示
                        msg_window(data.errors);
                        return;
                    }
                    // 弹窗提示
                    msg_window('登录成功');
                    // 延迟3秒执行代码
                    setTime1(function () {
                        location.href = "/";
                    });
                },
                error: function (err) {
                    console.log(err);
                },
            })
        } else {
            // 弹窗提示
            msg_window('不能为空，请认真核对！');
        }
    });
}

// 用户登出
function logout() {
    $('#logout').click(function () {
        if (confirm('您确定要退出登录吗？')) {
            $.ajax({
                url: '/logout',
                type: 'GET',
                success: function (data) {
                    console.log(data.success);
                    if (data.success == 'Y') {
                        // 弹窗提示
                        msg_window('登出成功');
                        // 延迟3秒执行代码
                        setTime1(function () {
                            location.href = "/";
                        });
                    }
                },
                error: function (err) {
                    console.log(err);
                },
            });
        }
    });
}

//新增文章
function arcAjax(n) {

    $('.submit').click(function () {

        $getTitle = $('#arcTitle').val();
        $getBody = editor.html();

        $.ajax({
            url: '/post',
            type: 'POST',
            data: {
                title: $getTitle,
                text: $getBody
            },
            success: function (data) {

                if (data.errors != 'Y') {
                    // 弹窗提示
                    msg_window(data.errors);
                    return;
                }

                // 弹窗提示
                msg_window('发布成功');
                // 延迟3秒执行代码
                setTime1(function () {
                    location.href = "/post";
                });
            },
            error: function (err) {
                console.log(err);
            },
        });
    });
}

//首页限制图片大小
function indexImgMax() {
    $('.arcBodyCon').find('img').each(function () {
        if ($(this).width() > 770) {
            $(this).width('100%');
        }
    });
}

//删除文章
function removeArc() {
    $('.removeArcTT').click(function () {
        $re1 = $(this).attr('re1');

        var that = $(this);

        if (confirm('您确定要退出登录吗？')) {
            $.ajax({
                url: '/remove',
                type: 'POST',
                data: {
                    id: $re1
                },
                success: function (data) {

                    if (data.errors != 'Y') {
                        // 弹窗提示
                        msg_window('删除失败');
                        return;
                    }

                    // 弹窗提示
                    msg_window('删除成功！');
                    that.closest('.arcBlock').remove();
                },
                error: function (err) {
                    console.log(err);
                },
            });
        }

    });
}

//编辑文章
function editAjax() {
    $('#submit').click(function () {

        var that = $(this);

        $getTitle = $('#arcTitle').val();
        $getBody = editor.html();

        $.ajax({
            url: '/edit',
            type: 'POST',
            data: {
                id: that.attr('demoId'),
                title: $getTitle,
                text: $getBody
            },
            success: function (data) {

                if (data.errors != 'Y') {
                    // 弹窗提示
                    msg_window('修改失败');
                    return;
                }

                // 弹窗提示
                msg_window('修改成功！');
                setTime1(function () {
                    location.href = "/";
                });
            },
            error: function (err) {
                console.log(err);
            },
        });

    });
}

//发布留言
function replyAddAjax() {
    $('.ReplySubmit').click(function () {

        var that = $(this);

        $getId1 = $('.userTT1').attr('authorArc');
        $getReplyText = $('.Reply_text').val();

        $.ajax({
            url: '/replyAdd',
            type: 'POST',
            data: {
                id: $getId1,
                text1: $getReplyText
            },
            success: function (data) {

                if (data.errors != 'Y') {
                    // 弹窗提示
                    msg_window('回复失败');
                    return;
                }

                // 弹窗提示
                msg_window('回复成功！');
                setTime1(function () {
                    history.go(0);
                });
            },
            error: function (err) {
                console.log(err);
            },
        });

    });
}

//搜索包含关键词的所有文章
function findWordArcAjax() {
    $('.searchBtn').click(function () {

        var that = $(this);

        $getWordText = $('.searchIpt').val();

        $.ajax({
            url: '/search',
            type: 'POST',
            data: {
                keyWord: $getWordText
            },
            success: function (data) {
                console.log(data.posts);
            },
            error: function (err) {
                console.log(err);
            }
        });

    });
}

//用户头像上传
function uploadFile() {

    $('#userImgSubmit').click(function () {

        if ($('#upload').val() == null || $('#upload').val() == '') {
            return msg_window('请选择文件上传！');
            ;
        }

        var formData = new FormData($("#frmUploadFile")[0]);

        $.ajax({
            url: '/uploadUserImg',
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                if (data.error == '') {
                    $(".userImgCon").attr('src', data.url);
                    // 弹窗提示
                    msg_window('上传成功');
                } else {
                    // 弹窗提示
                    msg_window(data.error);
                }
            },
            error: function () {
                console.log("与服务器通信错误");
            }
        });
    });

}