<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分组列表</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
    <a href="<?php echo U('AuthInfo/addGroup');?>" target="iframe1" class="btn btn-success">添加分组</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td>序号</td>
            <td>分组名</td>
            <td>是否启用</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <?php if(is_array($groupList)): foreach($groupList as $key=>$val): ?><tr>
                <td class="td_id"><?php echo ($val["id"]); ?></td>
                <td><?php echo ($val["title"]); ?></td>
                <td>
                    <?php if($val[status]==1): ?>启用
                        <?php else: ?>
                        禁用<?php endif; ?>
                </td>
                <td>
                    <a href="<?php echo U('AuthInfo/editGroupRule',array('gid'=>$val['id']));?>" class="btn btn-info">分配权限</a>
                    <a href="<?php echo U('AuthInfo/editGroup',array('gid'=>$val['id']));?>" class="btn btn-info">修改分组</a>
                    <button type="button" class="btn btn-danger delBtn">删除分组</button>
                </td>
            </tr><?php endforeach; endif; ?>
        </tbody>
    </table>

    <script src="/tp3_auth/Public/js/jquery.min.js"></script>
    <script>
        $(function(){
            $(".delBtn").click(function(){

                if(window.confirm('确认删除？')){

                    var getId=parseInt($(this).closest("tr").find(".td_id").text());

                    $.ajax({
                        url:"<?php echo U('AuthInfo/deleteGroup');?>",
                        method:'post',
                        data:{
                            gid:getId
                        },
                        success:function(data) {
                            if (data.msg == "Y") {
                                alert('删除成功');
                                window.location.href="<?php echo U('AuthInfo/groupList');?>";
                            } else {
                                alert('删除失败');
                            }
                        }
                    });

                }
            });
        })
    </script>
</body>
</html>