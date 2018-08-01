<?php
namespace Home\Controller;
use Think\Controller;
use \Org\Util\Rbac;

//用户登录、登出控制器
class LoginController extends Controller {
    //用户登陆-显示登陆页面
    public function index(){
        $this->display();
    }
    //用户登陆处理逻辑
    public function loginInfo(){
        //是否是post方式访问
        if(!IS_POST){
            halt('页面不存在');
        } 
        //验证码校对
        function check_verify($code,$id=""){
            $v=new \Think\Verify();    
            return $v->check($code,$id);
        }

        if(!check_verify(I('post.code',$id=""))){
            $this->error('验证码错误');
        }
        //校对用户名和密码
        $username=I('post.username');
        $pwd=I('post.password','','md5');
        $user=M('user')->where(array('username'=>$username))->find();
        if(!$user||$user['password']!=$pwd){
            $this->error('账号或密码错误');
        }

        //验证用户是否被锁定
        if($user['lock']){
            $this->error('用户被锁定');
        }

        //记录用户登陆信息
        $data=array(
            'id'=>$user['id'],
            'logintime'=>time(),
            'loginip'=>get_client_ip(),
        );
        M('user')->save($data);

        //将用户信息存进session
        session('uid',$user['id']);
        session('username',$user['username']);
        session('logintime',date('Y-m-d H:i:s',$user['logintime']));
        session('loginip',$user['loginip']);

        //重定向跳转
        $this->redirect('Index/index');
    }

    //验证码方法
    public function verify(){
        $v=new \Think\Verify();
        $v->fontsize=30;
        $v->length=4;
        $v->uaeNoise=false;
        $v->entry();
    }

    //退出登录
    public function logout(){
        //清空session
        session("username",null);
        session('uid',null);
        $this->success('退出登录成功', U("Login/index"));
    }
}