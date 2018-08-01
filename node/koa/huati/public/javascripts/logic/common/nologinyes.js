window.onload = function () {

    //判断是否未登陆，用于访问登陆注册
    function noLoginYes() {
        //console.log(base.getStoreage('username', false) != null && !base.getStoreage('token', false) != null);
        if (base.getStoreage('username', false) != null && !base.getStoreage('token', false) != null) {
            //返回上一页
            window.history.go(-1);
        }
    }

    //判断是否未登陆
    noLoginYes();

}