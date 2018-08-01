<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>权限列表</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
    <a href="<?php echo U('AuthInfo/addRule');?>" target="iframe1" class="btn btn-success">添加权限</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td>序号</td>
            <td>规则</td>
            <td>权限名称</td>
            <td>类型</td>
            <td>启用</td>
            <td>表达式</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <?php if(is_array($ruleList)): foreach($ruleList as $key=>$val): ?><tr>
                <td class="td_id"><?php echo ($val["id"]); ?></td>
                <td><?php echo ($val["name"]); ?></td>
                <td><?php echo ($val["title"]); ?></td>
                <td><?php echo ($val["type"]); ?></td>
                <td>
                    <?php if($val[status]==1): ?>启用
                        <?php else: ?>
                        禁用<?php endif; ?>
                </td>
                <td><?php echo ($val["condition"]); ?></td>
                <td>
                    <a href="<?php echo U('AuthInfo/editRule',array('rid'=>$val['id']));?>" class="btn btn-info">修改权限</a>
                    <button type="button" class="btn btn-danger delBtn">删除</button>
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
                        url:"<?php echo U('AuthInfo/deleteRule');?>",
                        method:'post',
                        data:{
                            rid:getId
                        },
                        success:function(data){
                            if(data.msg=="Y"){
                                alert('删除成功');
                            }else{
                                alert('删除失败');
                            }
                            location.href="<?php echo U('AuthInfo/ruleList');?>";
                        }
                    });

                }
            });
        })
    </script>
</body>
</html>