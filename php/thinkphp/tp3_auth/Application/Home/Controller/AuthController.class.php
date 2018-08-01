<?php
namespace Home\Controller;
use Think\Controller;
use Think\Auth;

//公共的权限认证控制器
class AuthController extends Controller {
    protected function _initialize(){

        //session不存在时，不允许直接访问
        if(!session('uid')){
            $this->error('还没有登录，正在跳转到登录页',U('Login/index'));
        }

        //session存在时，不需要验证的权限
        $not_check = array(
            "Home/Index/def",
            "Home/Index/index",
            "Home/Login/index",
            "Home/Login/loginInfo",
            "Home/Login/verify",
            "Home/Login/logout",
        );

        //如果当前操作在不需要验证的权限中，就可访问
        if(in_array(MODULE_NAME.'/'.CONTROLLER_NAME.'/'.ACTION_NAME, $not_check)){
            return true;
        }

        //下面代码动态判断权限，根据 模块/控制器/方法 来控制权限
        $auth = new Auth();

        //超级管理员不需要验证
        if(session('username')!='admin'){
            //其他用户需要验证
            if(!$auth->check(MODULE_NAME.'/'.CONTROLLER_NAME.'/'.ACTION_NAME,session('uid'))){
                $this->error('没有权限');
            }
        }

    }
}
