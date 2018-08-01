//修改用户密码
function editUserPassword() {
    $("#psw_submit").click(function () {
        //序列化表单
        var params = $("#userfrom1").serializeObject();

        params.username = base.getStoreage('username', false);
        params.token = base.getStoreage('token', false);

        if (params.oldpassword == '' || params.oldpassword.length == 0 || params.oldpassword.trim() == '') {
            alertTpl('必须输入原密码', 1.5);
            return;
        } else if (params.oldpassword.length > 10) {
            alertTpl('原密码不能超过10位', 1.5);
            return;
        } else if (params.newpassword == '' || params.newpassword.length == 0 || params.newpassword.trim() == '') {
            alertTpl('必须输入新密码', 1.5);
            return;
        } else if (params.newpassword.length > 10) {
            alertTpl('新密码不能超过10位', 1.5);
            return;
        } else if (params.newpassword_repeat == '' || params.newpassword_repeat.length == 0 || params.newpassword_repeat.trim() == '') {
            alertTpl('必须再次输入新密码', 1.5);
            return;
        } else if (params.newpassword_repeat.length > 10) {
            alertTpl('再次输入密码不能超过10位', 1.5);
            return;
        } else if (params.newpassword != params.newpassword_repeat) {
            alertTpl('两次密码输入不一致', 1.5);
            return;
        }

        $.post("/api/edituserpsw", params, function (data) {
            //console.log(data);

            if (data.status == 1) {
                alertTpl('密码修改成功，请重新登录', 1.5);

                //清除登陆状态
                base.delStoreage('token');
                base.delStoreage('username');

                //刷新当前页
                setTimeout(function () {
                    location.href = "/login";
                }, 1500);
            } else {
                alertTpl(data.error, 1.5);
            }
        })
    });
}

$(function () {
    //修改用户密码
    editUserPassword();
})