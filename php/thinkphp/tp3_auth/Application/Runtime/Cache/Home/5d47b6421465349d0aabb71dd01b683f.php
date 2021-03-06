<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改分组</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
    <form class="form-horizontal" action="<?php echo U('AuthInfo/editGroup');?>" method="post">
        <input type="hidden" name="gid" value="<?php echo ($groupInfo["id"]); ?>"/>
        <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">分组名：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="<?php echo ($groupInfo["title"]); ?>" id="inputName" name="title" placeholder="请输入分组名称"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputStatus" class="col-sm-2 control-label"> 是否启用：</label>
            <div class="col-sm-10">
                <select name="status" id="inputStatus">
                    <option value="1"
                        <?php if($groupInfo['status']==1): ?>selected="selected"<?php endif; ?>
                    >启用</option>
                    <option value="0"
                        <?php if($groupInfo['status']==0): ?>selected="selected"<?php endif; ?>
                    >禁用</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="sub" class="col-sm-2 control-label"> </label>
            <div class="col-sm-10">
                <input type="submit" value="修改" class="btn btn-success" id="sub"/>
                <a href="<?php echo U('AuthInfo/groupList');?>" class="btn btn-default">取消</a>
            </div>
        </div>
    </form>
</body>
</html>