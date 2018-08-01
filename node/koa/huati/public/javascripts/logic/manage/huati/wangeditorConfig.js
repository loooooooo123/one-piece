/* 编辑器配置项 */
var E = window.wangEditor;
var editor1 = new E('#div1', '#div2');  // 两个参数也可以传入 elem 对象，class 选择器
// 配置服务器端地址
editor1.customConfig.uploadImgServer = '/upload';

// 将图片大小限制为 2M
editor1.customConfig.uploadImgMaxSize = 2 * 1024 * 1024;

// 限制一次最多上传 2 张图片
editor1.customConfig.uploadImgMaxLength = 2;

// 将 timeout 时间改为 3s
editor1.customConfig.uploadImgTimeout = 3000;

//开启debug
editor1.customConfig.debug = false;

//渲染编辑器
editor1.create();

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
            data.context = $('<button class="uploadsubBtn" />').text('上传')
                .appendTo(".fengImg")
                .click(function () {
                    //改变上传状态
                    $(".fengImg").append($('<span class="uploadInfoVal"/>').text('上传中...'));
                    data.submit();
                });
        },
        done: function (e, data) {
            //改变上传状态
            $('.uploadInfoVal').text('上传完毕');
            if (data.result.data.length != 0) {
                //console.log(data.result.data[0]);
                $(".contentFengImg").attr("src", data.result.data[0]);
            }
        }
    });

    /* 发布话题 */
    $(".addHuaTiSubmit").click(function () {

        //参数
        var title = $("#huati_title").val();    //标题
        var yinyan = $("#huati_yinyan").val();   //引言
        var content = editor1.txt.html(); //编辑器，正文
        var yulan = $(".contentFengImg").attr("src");   //预览图

        //表单验证
        if (title.length > 30) {
            alertTpl("标题过长了，请填写在30个字内", 1.5)
        } else if (title == '' || title.trim() == '' || yinyan == '' || yinyan.trim() == '' || content == '' || content.trim() == '' || yulan == '' || yulan.trim() == '') {
            alertTpl("请认真填写话题每项，不能有空白啊", 1.5);
        } else {
            $.post("/api/addhuati", {
                username: base.getStoreage('username', false),
                token: base.getStoreage('token', false),
                title: title,
                yinyan: yinyan,
                content: content,
                yulan: yulan
            }, function (data) {
                if (data.status == 1) {
                    alertTpl('发布成功', 1.5);

                    window.location.href = "/huati?id=" + data.id;
                } else if (data.status == 0 && data.error == "登陆失效") {
                    alertTpl("登陆超时，请重新登陆", 1.5);
                    window.location.href = "/login";
                } else if (data.status == 0 && data.error == "话题已存在，换个话题吧") {
                    alertTpl(data.error, 1.5);
                } else if (data.status == 0 && data.error == "请认真填写话题每项，不能有空白啊") {
                    alertTpl(data.error, 1.5);
                } else {
                    alertTpl('发布失败', 1.5);
                }
            });
        }
    });
});