<?php
namespace Home\Controller;
use Home\Controller\AuthController;
use Think\Auth;

//权限CURD操作控制器
class AuthInfoController extends AuthController {
 
    //添加用户，post请求处理表单提交，get请求返回表单模板
    public function addUser(){

        if(IS_POST){

            //获取已选分组id
            $getGroups=I('post.group_id',0,'intval');
            //获取输入的用户名
            $getUserName=I("post.username",'','trim');
            //获取输入的密码
            $getPassword=I("post.password",'','md5');
            //获取再次输入的密码
            $getRePassword=I('post.repassword','','md5');
            //获取已选择是否启用
            $getStatus=I('post.status',0,'intval');

            //拼装用户信息
            $user=array(
                'username'=>$getUserName,
                'password'=>$getPassword,
                'logintime'=>time(),
                'loginip'=>get_client_ip(),
                'status'=>$getStatus
            );

            //判断是否已选择用户组
            if(empty($getGroups)){
                $this->error("请选择用户组...");
            }

            //密码不为空
            if(empty($getUserName)||empty($getPassword)){
                $this->error("用户名或密码不能为空");                
            }

            //判断两次输入密码是否一致
            if($user['password']!=$getRePassword){
                $this->error("两次密码不一致...");
            }

            //判断用户名是否存在
            if(M("user")->where(array('username'=>$user['username']))->find()){
                $this->error("用户名已存在...");
            }

            //插入新用户
            if($lastInsertId=M("user")->add($user)){

                //循环插入此用户已选择的分组
                $arr=[];    //用于存储该用户所有分组
                foreach($getGroups as $k=>$v){
                    $arr[]=array(
                        'uid'=>$lastInsertId,
                        'group_id'=>$getGroups[$k]
                    );
                }
                M("auth_group_access")->addAll($arr);
                
                $this->success("添加成功...",U("Index/userList"));

            }else{

                $this->error("添加失败...");

            }

       }else{

            //查询所有分组
            $getAllGroup=M("auth_group")->field("id,title")->select();

            $this->assign("groupList",$getAllGroup);
            $this->display();

       }

    }

    //删除用户
    public function deleteUser(){

        if(IS_POST){

            //获取用户id
            $uid=I('post.id',0,'intval');

            //判断是否已选择用户
            if(empty($uid)){
                $this->error("请选择用户");
            }

            //删除用户
            if(M("user")->where(array("id"=>$uid))->delete()){

                //删除用户所属的所有分组关系
                M("auth_group_access")->where(array("uid"=>$uid))->delete();

                $this->ajaxReturn(array('msg'=>'Y'));

            }else{
                $this->ajaxReturn(array('msg'=>'N'));                
            }

        }

    }
    
    //修改用户，post请求处理表单提交，get请求返回表单模板
    public function editUser(){

        if(IS_POST){

            //获取输入的密码
            $getPassword=I("post.password",'','md5');
            //获取再次输入的密码
            $getRePassword=I('post.repassword','','md5');
            //获取用户id
            $getUserId=I('post.id',0,'intval');

            //拼装用户信息
            $user=array(
                'logintime'=>time(),
                'loginip'=>get_client_ip(),
                'status'=>I('post.status',0,'intval')
            );

            //验证非空，两次密码一致
            if(!empty($getPassword)){
                //判断两次输入密码是否一致
                if($getPassword!=$getRePassword){
                    $this->error("两次密码不一致...");
                }

                $user['password']=$getPassword;
            }

            //修改用户信息
            if(M("user")->where(array("id"=>$getUserId))->save($user)){

                //预先删除该用户所属分组
                M('auth_group_access')->where(array('uid'=>$getUserId))->delete();

                //循环插入该用户新的所属分组
                $datas=array();
                foreach(I('post.groups') as $v){
                    $datas[]=array(
                        'uid'=> I('post.id'),
                        'group_id'=> $v
                    );
                }
                M('auth_group_access')->addAll($datas);

                $this->success("修改成功...",U("Index/userList"));
            }else{
                $this->error("修改失败...");
            }

       }else{

            //获取用户id
            $getUserId=I('get.id',0,'intval');

            //查询用户信息
            $userInfo=M('user')->where(array('id'=>$getUserId))->field('id,username,status')->select();

            //查询该用户的所属分组
            $auth=new Auth();
            $userGroups=$auth->getGroups($getUserId);
            //过滤，只保留该用户的所属分组id
            $userGroups_groupIds=array();
            foreach($userGroups as $val){
                $userGroups_groupIds[]=$val['group_id'];
            }

            //查询所有分组
            $getAllGroup=M("auth_group")->field("id,title")->select();

            //所有分组中，如果该用户已存在分组中，标记为1
            $userGroupFocus=array();
            foreach($getAllGroup as $val){
                if(in_array($val['id'],$userGroups_groupIds)){
                    $val['groupFocus']=1;
                    $userGroupFocus[]=$val;
                }else{
                    $userGroupFocus[]=$val;
                }
            }

            //模版数据传递，用户信息
            $this->assign('userInfo',$userInfo[0]);
            //模版数据传递，分组信息
            $this->assign('Groups',$userGroupFocus);

            $this->display();
       }

    }

    //权限列表
    public function ruleList(){
        $ruleList=M("auth_rule")->select();
        $this->assign("ruleList",$ruleList);
        $this->display();
    }

    //添加权限，post请求处理表单提交，get请求返回表单模板
    public function addRule(){
        if(IS_POST){
            $data=array(
                'name'=>I('post.name'),
                'title'=>I('post.title'),      
                'type'=>I('post.type'),
                'status'=>I('post.status')
            );
            if(M('auth_rule')->add($data)){
                $this->success("添加成功",U("AuthInfo/ruleList"));
            }else{
                $this->error('添加失败');
            }
        }else{
            $this->display();            
        }
    }

    //删除权限
    public function deleteRule(){
        if(IS_POST){

            if(M('auth_rule')->where(array("id"=>I("post.rid")))->delete()){

                //循环清除分组表中，已删除的权限
                $getAuthGroup=M("auth_group")->select();
                for($a=0;$a<count($getAuthGroup);$a++){

                    //以逗号拆分该分组的每项权限
                    $ex = explode(",",$getAuthGroup[$a]['rules']);

                    //遍历是否和要删除的权限id一致，一致则移除
                    for($b=0;$b<count($ex);$b++) {
                        if(I("post.rid")==$ex[$b]){
                            unset($ex[$b]);
                        }
                    }

                    //重新写当前分组的权限
                    $getAuthGroup[$a]['rules']=implode(",",$ex);    //数组转换为字符串

                }

                //循环更新分组新的权限
                for($z=0;$z<count($getAuthGroup);$z++){
                    M("auth_group")->where(array("id"=>$getAuthGroup[$z]["id"]))->save($getAuthGroup[$z]);
                }

                $this->ajaxReturn(array('msg'=>'Y'));
            }else{
                $this->ajaxReturn(array('msg'=>'N'));
            }
        }
    }

    //修改权限，post请求处理表单提交，get请求返回表单模板
    public function editRule(){
        if(IS_POST){
            $data=array(
                'name'=>I('post.name'),
                'title'=>I('post.title'),
                'type'=>I('post.type'),
                'status'=>I('post.status')
            );
            if(M('auth_rule')->where(array("id"=>I("post.rid")))->save($data)){
                $this->success("修改成功",U("AuthInfo/ruleList"));
            }else{
                $this->error('修改失败');
            }
        }else{
            $ruleInfo=M("auth_rule")->where(array("id"=>I("get.rid")))->limit(1)->select();
            $this->assign("ruleInfo",$ruleInfo[0]);
            $this->display();
        }
    }

    //分组列表
    public function groupList(){
        $groupList=M("auth_group")->select();
        $this->assign("groupList",$groupList);
        $this->display();
    }

    //给分组分配权限，post请求处理表单提交，get请求返回表单模板
    public function editGroupRule(){

        if(IS_POST) {

            //分组id
            $getPostGroupId = I("post.gid");

            //当前分组新的权限
            $data['rules']=implode(",",I('post.rules'));    //数组转换为字符串

            //更新当前分组权限
            if(M("auth_group")->where(array("id"=>$getPostGroupId))->save($data)){
                $this->success("分配成功",U("AuthInfo/groupList"));
            }else{
                $this->error('分配失败');
            }

        }else{

            //分组id
            $getGroupId = I("get.gid");

            //获取所有权限
            $getAllRule=M("auth_rule")->select();

            //获取当前分组数据
            $getGroupInfo=M("auth_group")->where(array("id"=>$getGroupId))->limit(1)->select();

            //将当前分组的权限拆分为数组形式，1,2,3=>array(1,2,3)
            $getRules=explode(",",$getGroupInfo[0]['rules']);

            //当前分组中已有的权限，标记为1
            $getGroupFocusRule=array();
            foreach($getAllRule as $val){
                if(in_array($val['id'],$getRules)){
                    $val['ruleFocus']=1;
                    $getGroupFocusRule[]=$val;
                }else{
                    $getGroupFocusRule[]=$val;
                }
            }

            $this->assign("GroupFocusRule",$getGroupFocusRule);
            $this->assign("gid",$getGroupId);
            $this->display();

        }
    }

    //新增分组，post请求处理表单提交，get请求返回表单模板
    public function addGroup(){
        if(IS_POST){
            $data=array(
                'title'=>I('post.title'),
                'status'=>I('post.status')
            );

            //判断分组是否存在
            if(M("auth_group")->where(array('title'=>$data['title']))->find()){
                $this->error("分组已存在...");
            }

            if(M('auth_group')->add($data)){
                $this->success("新增成功",U("AuthInfo/groupList"));
            }else{
                $this->error('新增失败');
            }
        }else{
            $this->display();
        }
    }

    //删除分组
    public function deleteGroup(){

        if(IS_POST){

            $gid=I('post.gid');   //分组id

            if(empty($gid)){
                $this->error("请选择分组");
            }

            if(M("auth_group")->where(array("id"=>$gid))->delete()){

                $this->ajaxReturn(array('msg'=>'Y'));

            }else{
                $this->ajaxReturn(array('msg'=>'N'));
            }

        }

    }

    //修改分组，post请求处理表单提交，get请求返回表单模板
    public function editGroup(){
        if(IS_POST){
            $data=array(
                'title'=>I('post.title'),
                'status'=>I('post.status')
            );
            if(M('auth_group')->where(array("id"=>I("post.gid")))->save($data)){
                $this->success("修改成功",U("AuthInfo/groupList"));
            }else{
                $this->error('修改失败');
            }
        }else{
            $groupInfo=M("auth_group")->where(array("id"=>I("get.gid")))->limit(1)->select();
            $this->assign("groupInfo",$groupInfo[0]);
            $this->display();
        }
    }

}