<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css">
    <style>
        html,body{
            height:100%;
        }
        .container{
            height:100%;
        }
        .table td{
            vertical-align:middle;
            padding:0;
        }
        .table td p{
            padding:0;
            margin:0;
        }
    </style>
</head>
<body>
<div class="container">
    <h5>欢迎：<?php if($username=='admin'): ?>超级管理员<?php else: echo ($username); endif; ?>登录</h5>
    <ul class="list-group col-xs-2">
        <li class="list-group-item">
            <a href="<?php echo U('Index/userList');?>" target="iframe1">用户列表</a>
        </li>
        <li class="list-group-item">
            <a href="<?php echo U('AuthInfo/groupList');?>" target="iframe1">分组列表</a>
        </li>
        <li class="list-group-item">
            <a href="<?php echo U('AuthInfo/ruleList');?>" target="iframe1">权限列表</a>
        </li>
        <li class="list-group-item">
            <a href="<?php echo U('Login/logout');?>">退出登录</a>
        </li>
    </ul>
    <iframe class="col-xs-10" src="<?php echo U('Index/def');?>" height="100%" frameborder="0" name="iframe1"></iframe>
</div>
</body>
</html>