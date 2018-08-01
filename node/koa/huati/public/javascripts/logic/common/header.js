//获取用户头像
function getUserCover(callback) {
    $.post("/api/getmycover", {
        username: base.getStoreage('username', false),
        token: base.getStoreage('token', false)
    }, function (data) {
        //console.log(data);
        if (data.status == 1) {
            //保存用户头像
            base.setStoreage('usercover', data.data.usercover);
            var getusercover = base.getStoreage('usercover', false);

            if (callback) {
                callback(getusercover);
            }
        } else {
            callback(null);
        }
    });
}

//搜索
function search() {
    $("#searchSubmit").click(function () {
        var getSearchVal = $("#searchIpt").val();

        if (getSearchVal == null || getSearchVal.trim() == '') {
            return;
        }

        window.location.href = "/search?keyword=" + getSearchVal;

    })
}

$(function () {
    //验证是否登陆
    function isLoginRex() {
        $.post("/api/rexLogin", {
            username: base.getStoreage('username', false),
            token: base.getStoreage('token', false)
        }, function (data) {
            //console.log(data);
            if (data.status == 1) {
                //获取登陆状态
                $("#usersp1 .text1").text(data.username);
                //显示登陆后的用户菜单
                $("#usernav").show();
                //隐藏未登录时的菜单
                $("#noLogin").hide();
            } else {
                //清除登陆状态
                base.delStoreage('token');
                base.delStoreage('username');
                //获取登陆状态
                $("#usersp1 .text1").text('');
                //显示登陆后的用户菜单
                $("#usernav").hide();
                //隐藏未登录时的菜单
                $("#noLogin").show();
            }
        });
    }

    //退出登陆
    function logoutFn() {
        //清除登陆状态
        base.delStoreage('token');
        base.delStoreage('username');

        //清空登陆状态
        $("#usersp1 .text1").text("");
        //隐藏登陆后的用户菜单
        $("#usernav").hide();
        //显示未登录时的菜单
        $("#noLogin").show();

        //跳转到登录页
        window.location.href = "/login";
    }

    isLoginRex();

    //绑定退出登陆事件
    $("#logoutA").click(function () {
        logoutFn();
    });


    //搜索
    search();
});