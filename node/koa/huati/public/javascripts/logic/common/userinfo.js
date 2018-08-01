/* 获取用户信息 */

//初始化时查询用户名称和头像
function getUsername_cover() {
    var getusername = base.getStoreage('username', false);
    $(".username").text(getusername);
    //console.log(getusername);
}

$(function () {
    getUsername_cover();
})