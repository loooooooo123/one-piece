<?php
return array(

    //数据库配置
    'DB_TYPE'               =>  'mysql',     // 数据库类型
    'DB_HOST'               =>  '127.0.0.1', // 服务器地址
    'DB_NAME'               =>  'auth',          // 数据库名
    'DB_USER'               =>  'root',      // 用户名
    'DB_PWD'                =>  '123456',          // 密码
    'DB_PORT'               =>  '3306',        // 端口
    'DB_PREFIX'             =>  'think_',    // 数据库表前缀

    //用于在模版中控制权限
    'TAGLIB_BUILD_IN' => 'Cx,Html,Common\Tag\Auth', //加载自定义标签

    //auth权限配置
    'AUTH_CONFIG'=>array(
        'AUTH_ON'           => true,                // 认证开关
        'AUTH_TYPE'         => 1,                   // 认证方式，1为实时认证；2为登录认证。
        'AUTH_USER'         => 'user',             // 用户信息表
        'AUTH_SUPER'	     =>'admin',             //指定超级管理员
    )
);