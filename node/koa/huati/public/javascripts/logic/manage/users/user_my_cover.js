$(function () {

    //上传选择按钮
    $("#fileupload_btn").on("click", function () {
        $("#fileupload").click();
    });

    /* 上传封面图 */
    $('#fileupload').fileupload({
        url: '/upload',//请求发送的目标地址
        Type: 'POST',//请求方式 ，可以选择POST，PUT或者PATCH,默认POST
        dataType: 'json',
        acceptFileTypes: /(gif|jpe?g|png)$/i,//验证图片格式
        maxNumberOfFiles: 1,//最大上传文件数目
        maxFileSize: 2000000, // 文件上限2MB
        minFileSize: 100,//文件下限  100b
        messages: {//文件错误信息
            acceptFileTypes: '文件类型不匹配',
            maxFileSize: '文件过大',
            minFileSize: '文件过小'
        },
        add: function (e, data) {
            //改变上传状态
            data.context = $('<button class="uploadsubBtn" />').text('保存头像')
                .appendTo(".cover_btn")
                .click(function () {
                    //改变上传状态
                    $(".cover_btn").append($('<span class="uploadInfoVal"/>').text('上传中...'));
                    data.submit();
                });
        },
        done: function (e, data) {
            $('.uploadInfoVal').text('上传完毕');
            if (data.result.data.length != 0) {
                //console.log(data.result.data[0]);
                $(".cover_img").attr("src", data.result.data[0]);

                /* 修改头像请求 */
                $.post("/api/editmycover", {
                    username: base.getStoreage('username', false),
                    token: base.getStoreage('token', false),
                    cover: data.result.data[0]
                }, function (data) {
                    if (data.status == 1) {
                        alertTpl('修改成功', 1.5);

                        //刷新当前页
                        setTimeout(function () {
                            window.history.go(0);
                        }, 1500);
                    } else if (data.status == 0 && data.error == "登陆失效") {
                        alertTpl("登陆超时，请重新登陆", 1.5);
                        window.location.href = "/login";
                    } else {
                        alertTpl('修改失败', 1.5);
                    }
                });

            }
        }
    });

});