<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分配权限</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
    <h4>所有操作如下，请勾选进行分配：</h4>
    <form class="form-horizontal" action="<?php echo U('AuthInfo/editGroupRule');?>" method="post">
        <input type="hidden" name="gid" value="<?php echo ($gid); ?>" />
        <table class="table table-bordered">
            <thead>
            <tr>
                <td><input type="checkbox" id="allRuleCheck" />全选</td>
                <td>序号</td>
                <td>权限名</td>
                <td>是否启用</td>
            </tr>
            </thead>
            <tbody id="ruleList1">
            <?php if(is_array($GroupFocusRule)): foreach($GroupFocusRule as $key=>$val): ?><tr>
                    <td>
                        <input type="checkbox"
                               value="<?php echo ($val["id"]); ?>"
                               name="rules[]"
                               class="ruleCheckIpt"
                            <?php if($val['ruleFocus']==1): ?>checked="checked"<?php endif; ?>
                        />
                    </td>
                    <td class="td_id"><?php echo ($val["id"]); ?></td>
                    <td><?php echo ($val["title"]); ?></td>
                    <td>
                        <?php if($val[status]==1): ?>启用
                            <?php else: ?>
                            禁用<?php endif; ?>
                    </td>
                </tr><?php endforeach; endif; ?>
            </tbody>
        </table>
        <div class="col-xs-12">
            <input type="submit" class="btn btn-success" value="确认分配"/>
            <a href="<?php echo U('AuthInfo/groupList');?>" class="btn btn-default">取消</a>
        </div>
    </form>

    <script src="/tp3_auth/Public/js/jquery.min.js"></script>
    <script>
        $(function(){
            $("#allRuleCheck").click(function(){
                if($(this).prop('checked')){
                    $("#ruleList1").find(".ruleCheckIpt").prop('checked',true);
                }else{
                    $("#ruleList1").find(".ruleCheckIpt").prop('checked',false);
                }
            });

            //全选checkbox
            function checkFn(){
                if($(".ruleCheckIpt:checked").length>=$(".ruleCheckIpt").length){
                    $("#allRuleCheck").prop('checked',true);
                }else{
                    $("#allRuleCheck").prop('checked',false);
                }
            }
            checkFn();  //加载dom时验证是否全选

            $(".ruleCheckIpt").click(function(){
                checkFn();
            });
        })
    </script>
</body>
</html>