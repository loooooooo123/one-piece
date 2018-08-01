window.onload = function () {

    //判断是否已登陆，用于访问权限
    function isLoginYes() {
        //console.log(base.getStoreage('username', false) == null || !base.getStoreage('token', false) == null);
        if (base.getStoreage('username', false) == null || !base.getStoreage('token', false) == null) {
            //返回上一页
            window.location.href = "/login";
        }
    }

    //判断是否已登陆
    isLoginYes();

}
