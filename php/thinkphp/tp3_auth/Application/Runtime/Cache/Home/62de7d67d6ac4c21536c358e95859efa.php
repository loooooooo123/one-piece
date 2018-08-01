<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加权限</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
</head>
<body>
    <form class="form-horizontal" action="<?php echo U('AuthInfo/addRule');?>" method="post">
        <div class="form-group">
            <label for="inputName" class="col-sm-3 control-label">规则/路由：</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="inputName" name="name" placeholder="模块名/控制器名/方法名"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputName" class="col-sm-3 control-label">规则/路由：</label>
            <div class="col-sm-9">
                <span>格式：模块名/控制器名/方法名 ，</span>
                <span>或者：{score}&lt;5 and {score}&gt;100</span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputTitle" class="col-sm-3 control-label">权限名：</label>
            <div class="col-sm-9">
                <input type="text" name="title" class="form-control" id="inputTitle" placeholder="请输入权限名称">
            </div>
        </div>
        <div class="form-group">
            <label for="inputType" class="col-sm-3 control-label">是否支持条件验证：</label>
            <div class="col-sm-9">
                <select name="type" id="inputType">
                    <option value="1">是</option>
                    <option value="0">否</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="inputStatus" class="col-sm-3 control-label"> 是否启用：</label>
            <div class="col-sm-9">
                <select name="status" id="inputStatus">
                    <option value="1">启用</option>
                    <option value="0">禁用</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="sub" class="col-sm-3 control-label"> </label>
            <div class="col-sm-9">
                <input type="submit" value="新增" class="btn btn-success" id="sub"/>
                <a href="<?php echo U('AuthInfo/ruleList');?>" class="btn btn-default">取消</a>
            </div>
        </div>
    </form>
</body>
</html>