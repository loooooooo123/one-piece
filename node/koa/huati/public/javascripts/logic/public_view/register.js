$(function () {

    //重置验证码
    function resetYzm() {
        $(".yzm").attr("src", '/api/code?' + Math.random());
    }

    //注册提交
    function registerSubmit() {

        //提交参数
        var getUserName = $("#uname").val();
        var getPsw = $("#upsw").val();
        var getPsw2 = $("#upsw2").val();
        var getCode = $("#ucode").val();
        var userInfo = {
            username: getUserName,
            password: getPsw,
            code: getCode
        };

        //表单验证
        if (getUserName == '' || getUserName.length > 10) {
            setTip("username", "用户名应为1-10位");
            return false;
        } else if (getPsw == '' || getPsw2 == '') {
            setTip("password2", "密码不能为空");
            return false;
        } else if (getPsw != getPsw2) {
            setTip("password2", "2次密码输入不一致");
            return false;
        } else if (getCode == '') {
            setTip("code", "请填写验证码");
            return false;
        }

        $.post("/api/register", userInfo, function (data) {
            //console.log(data);
            if (data.status == 1) {

                //存储登陆token
                base.setStoreage('token', data.token);
                //存储登陆用户名
                base.setStoreage('username', data.username);

                //返回上一页
                window.history.go(-1);
            } else if (data.status == 0 && data.text == "验证码错误") {
                setTip("code", "验证码错误");
            } else if (data.status == 0 && data.text == "用户名已存在") {
                setTip("username", data.text);
            }

            //验证码错误，刷新验证码
            resetYzm();
        });
    }

    //设置tip位置和提示信息
    function setTip(id, text) {
        $(".tip").remove();
        var dom = $("#" + id);
        dom.append($("<div class='tip'>" + text + "</div>"));
    }

    //绑定更换验证码事件
    $(".yzmReset").click(function () {
        resetYzm();
    });

    //绑定用户注册事件
    $(".loginBtn1").click(function () {
        registerSubmit();
    });
})