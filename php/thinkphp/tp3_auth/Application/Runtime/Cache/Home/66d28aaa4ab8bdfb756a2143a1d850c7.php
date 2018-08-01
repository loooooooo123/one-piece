<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加用户</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
    <form class="form-horizontal" action="<?php echo U('AuthInfo/addUser');?>" method="post">
        <input type="hidden" name="id" value="<?php echo ($userInfo["id"]); ?>"/>
        <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputName" name="username" value="<?php echo ($userInfo["username"]); ?>" placeholder="请输入用户名">
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
                    <option value="1" selected>启用</option>
                    <option value="0">禁用</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword2" class="col-sm-2 control-label">所属分组：</label>
            <div class="col-sm-10">
                <?php if(is_array($groupList)): foreach($groupList as $key=>$val): ?><input type="checkbox" name="group_id[]" value="<?php echo ($val["id"]); ?>"/><?php echo ($val["title"]); endforeach; endif; ?>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword2" class="col-sm-2 control-label">再次输入密码：</label>
            <div class="col-sm-10">
                <input type="submit" value="新增" class="btn btn-success"/>
                <a href="<?php echo U('Index/userList');?>" class="btn btn-default">取消</a>
            </div>
        </div>
    </form>

    <script src="/tp3_auth/Public/js/jquery.min.js"></script>
    <script>
        $(function(){
            //预先清除所有checkbox选中
            $("input[type='checkbox']").removeAttr("checked");
        });
    </script>
</body>
</html>