<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改用户</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
<form class="form-horizontal" action="<?php echo U('AuthInfo/editUser');?>" method="post">
    <input type="hidden" name="id" value="<?php echo ($userInfo["id"]); ?>"/>
    <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">用户名：</label>
        <div class="col-sm-10">
            <?php echo ($userInfo["username"]); ?>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="col-sm-2 control-label">密码：</label>
        <div class="col-sm-10">
            <input type="password" name="password" value="<?php echo ($userInfo["password"]); ?>" class="form-control" id="inputPassword" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword2" class="col-sm-2 control-label">再次输入密码：</label>
        <div class="col-sm-10">
            <input type="password" name="repassword" value="<?php echo ($userInfo["password"]); ?>" class="form-control" id="inputPassword2" placeholder="请再次输入密码">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword2" class="col-sm-2 control-label">是否启用：</label>
        <div class="col-sm-10">
            <select name="status" id="">
                <option value="1"
                <?php if($userInfo['status']==1): ?>selected<?php endif; ?>
                >启用</option>
                <option value="0"
                <?php if($userInfo['status']==0): ?>selected<?php endif; ?>
                >禁用</option>
            </select>
        </div>
    </div>

    <?php if($userInfo['username']!='admin'): ?><div class="form-group">
            <label for="inputPassword2" class="col-sm-2 control-label">所属分组：</label>
            <div class="col-sm-10">
                <?php if(is_array($Groups)): foreach($Groups as $key=>$group): ?><input type="checkbox"
                           name="groups[]"
                           value="<?php echo ($group["id"]); ?>"
                            <?php if($group['groupFocus']==1): ?>checked="checked"<?php endif; ?>
                    /><?php echo ($group["title"]); endforeach; endif; ?>
            </div>
        </div><?php endif; ?>

    <div class="form-group">
        <label for="inputPassword2" class="col-sm-2 control-label">再次输入密码：</label>
        <div class="col-sm-10">
            <input type="submit" value="修改" class="btn btn-success"/>
            <a href="<?php echo U('Index/userList');?>" class="btn btn-default">取消</a>
        </div>
    </div>

    <script src="/tp3_auth/Public/js/jquery.min.js"></script>
</form>
</body>
</html>