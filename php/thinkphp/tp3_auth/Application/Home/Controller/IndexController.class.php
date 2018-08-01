<?php
namespace Home\Controller;
use Home\Controller\AuthController;
use Think\Auth;

class IndexController extends AuthController {

    //返回首台首页，左侧导航+右侧iframe
    public function index(){
        $this->assign('username',session('username'));
        $this->display();
    }

    //默认iframe首页，欢迎页
    public function def(){
        $this->display();
    }

    //用户列表
    public function userList(){

        //获取用户信息
        $userlist=D("user")->select();

        //获取所有用户的所属分组
        $auth = new Auth();
        foreach($userlist as $k=>$v){
            $userlist[$k]['groups']=$auth->getGroups($v['id']);
        }

        $this->assign('userlist',$userlist);

        $this->display();
    }

}