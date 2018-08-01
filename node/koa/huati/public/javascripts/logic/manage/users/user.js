/* 用户中心 */

//编辑用户信息
function editUserInfo() {
    $(".edit_userInfo").click(function () {

        //隐藏用户信息
        $("#userShowInfo").hide();
        //显示编辑用户信息
        $("#userEditInfo").show();

        //查询用户信息
        showUserInfo(function (data) {
            //初始化赋值编辑用户信息表单
            setUserInfoDefaultForm(data);
        })

    });
}

//取消编辑用户信息
function backEditUserInfo() {
    $(".back_userInfo").click(function () {
        //隐藏用户信息
        $("#userShowInfo").show();
        //显示编辑用户信息
        $("#userEditInfo").hide();
    });
}

//保存用户信息
function saveUserInfo() {
    $(".save_userInfo").click(function () {
        //序列化表单
        var paramsdata = $("#userForm1").serializeArray();

        //请求
        $.post("/api/adduserinfo", {
            data: paramsdata,
            username: base.getStoreage('username', false),
            token: base.getStoreage('token', false)
        }, function (data) {
            if (data.status == 1) {
                //隐藏用户信息
                $("#userShowInfo").show();
                //显示编辑用户信息
                $("#userEditInfo").hide();

                //更新用户信息
                showUserInfo();
            } else {
                //console.log(data.error);
            }
        });
    });
}

//bootstrap 日期选择器
function bootstrap_date() {
    $("#datetime").datetimepicker({
        format: 'YYYY-MM-DD hh:mm',
        locale: moment.locale('zh-cn')
    });
}

//初始化时查询用户信息
function showUserInfo(callback) {

    var getusername = base.getStoreage('username', false);

    //请求
    $.post("/api/showuserinfo", {
        username: getusername,
        token: base.getStoreage('token', false)
    }, function (data) {
        //console.log(data);

        if (data.status == 0) {
            setUserInfoDefault({});
        } else {
            setUserInfoDefault(data.data);
        }

        //设置用户名
        $(".username").text(getusername);
        $(".username2").text(getusername);

        if (callback) {
            callback(data.data);
        }
    });
}

//初始化赋值用户信息
function setUserInfoDefault(data) {
    if (!data) {
        return;
    }
    var sexText = '男';
    if (data.sex == 0) {
        sexText = '女';
    } else if (data.sex == 2) {
        sexText = '保密';
    }

    //console.log(data);

    $(".show_sex").text(data.sex ? sexText : '未填写');
    $(".show_job").text(data.job ? data.job : '未填写');
    $(".show_birthday").text(data.birthday ? data.birthday : '未填写');
    $(".show_constellation").text(data.constellation ? data.constellation : '未填写');
    $(".show_hobby").text(data.hobby ? data.hobby : '未填写');
    $(".show_speciality").text(data.speciality ? data.speciality : '未填写');
    $(".show_ideal").text(data.ideal ? data.ideal : '未填写');
}
//初始化赋值编辑用户信息表单
function setUserInfoDefaultForm(data) {

    if (!data) {
        return;
    }

    var sexText = '男';
    if (data.sex == 0) {
        $("#userForm1").find("input[name='sex']").eq(1).attr("checked", "checked");
        sexText = '女';
    } else if (data.sex == 2) {
        $("#userForm1").find("input[name='sex']").eq(2).attr("checked", "checked");
        sexText = '保密';
    } else {
        $("#userForm1").find("input[name='sex']").eq(0).attr("checked", "checked");
    }

    //设置用户名
    $(".username3").text(base.getStoreage('username', false));

    //设置其他
    $("input[name='sex']").val(sexText);
    $("input[name='job']").val(data.job);
    $("input[name='birthday']").val(data.birthday);
    $("input[name='constellation']").val(data.constellation);
    $("input[name='hobby']").val(data.hobby);
    $("input[name='speciality']").val(data.speciality);
    $("input[name='ideal']").val(data.ideal);

}

$(function () {
    //初始化时查询用户信息
    showUserInfo();
    //编辑用户信息
    editUserInfo();
    //取消编辑用户信息
    backEditUserInfo();
    //保存用户信息
    saveUserInfo();
    //bootstrap 日期选择器
    bootstrap_date();
})