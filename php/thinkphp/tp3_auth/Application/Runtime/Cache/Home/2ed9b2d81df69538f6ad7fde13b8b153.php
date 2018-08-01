<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
    <a href="<?php echo U('AuthInfo/addUser');?>" target="iframe1" class="btn btn-success">添加用户</a>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>登陆时间</td>
            <td>登录ip</td>
            <td>用户分组</td>
            <td>操作</td>
        </tr>
        <?php if(is_array($userlist)): foreach($userlist as $key=>$val): ?><tr>
                <td class="td_id"><?php echo ($val["id"]); ?></td>
                <td><?php echo ($val["username"]); ?></td>
                <td><?php echo ($val["logintime"]); ?></td>
                <td><?php echo ($val["loginip"]); ?></td>
                <td>
                    <?php if($val['username']=='admin'): ?><p>超级管理员</p>
                        <?php else: ?>
                            <?php if(is_array($val['groups'])): foreach($val['groups'] as $key=>$group): ?><p><?php echo ($group["title"]); ?></p><?php endforeach; endif; endif; ?>
                </td>
                <td>
                    <a href="<?php echo U('AuthInfo/editUser',array('id'=>$val['id']));?>" class="btn btn-primary"" target="iframe1">修改</a>
                    <button type="button" class="btn btn-danger delBtn">删除</button>
                </td>
            </tr><?php endforeach; endif; ?>
    </table>

    <script src="/tp3_auth/Public/js/jquery.min.js"></script>
    <script>
    $(function(){
        $(".delBtn").click(function(){

            if(window.confirm('确认删除？')){

                var getId=parseInt($(this).closest("tr").find(".td_id").text());

                $.ajax({
                    url:"<?php echo U('AuthInfo/deleteUser');?>",
                    method:'post',
                    data:{
                        id:getId
                    },
                    success:function(data){
                        if(data.msg=="Y"){
                            alert('删除成功');
                        }else{
                            alert('删除失败');
                        }
                        location.href="<?php echo U('Index/userList');?>";                        
                    }
                });

            }
        });
    })
    </script>

</body>
</html>