<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登陆</title>
    <link rel="stylesheet" href="/tp3_auth/Public/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
    <style>
    .center{
        width:650px;
        height:400px;
        position: absolute;
        top:40%;
        left:50%;
        transform: translate(-50%,-50%);
        border:1px solid #cecece;
        padding:10px 20px 20px 20px;
        box-sizing: border-box;
        border-radius: 10px;
    }
    .h2{
        text-align: center;
        line-height: 30px;
    }
    .center .formMarTop{
        margin-top:30px;
    }
    .center .formMarTop2{
        margin-top:20px;
    }
    .codeImg{
        cursor: pointer;
    }
    </style>
</head>

<body>
    <div class="container">
        <div class="center">
            <form class="form-horizontal" action="<?php echo U('Login/loginInfo');?>" method="post">
                <h2 class="h2">用户登录</h2>
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="psw" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">验证码：</label>
                    <div class="col-sm-10 radio">
                        <input type="text" class="form-control" name="code" id="code" placeholder="请输入验证码">
                        <img src="<?php echo U('Login/verify');?>" alt="" class="codeImg formMarTop2">
                    </div>
                </div>
                <div id="last" class="form-group formMarTop">
                    <div class="col-sm-2">
    
                    </div>
                    <div class="col-sm-10">
                        <input type="submit" value="登陆" class="btn btn-success subBtn" />
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script type="text/javascript" src="/tp3_auth/Public/js/jquery.min.js"></script>
    <script>
        $(function () {
            $(".codeImg").click(function(){
                $(this).attr("src","<?php echo U('Login/verify');?>");
            });
        })
    </script>
</body>

</html>