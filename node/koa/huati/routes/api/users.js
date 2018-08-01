/* 用户中心 路由 */

//引入路由中间件
const Router = require('koa-router');
//生成token
var jwt = require('jsonwebtoken');
//引入md5，sha1加密模块
var md5 = require('md5');
var sha1 = require('sha1');

//声明路由
let users = new Router();

//mysql操作model
let models = require('../../mysql_models/users.js');
let huati = require('../../mysql_models/huati.js');


//新增用户信息
users.post('/api/adduserinfo', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//验证token
return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
    if (data) {
        //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
        if (data.data == postData.username) {

            //解析传参，序列化的表单
            var postp = [];
            for (let a = 0; a < postData.data.length; a++) {
                postp.push(postData.data[a].value);
            }

            //新增用户信息，如果已存在则更新，否则新增
            return models.addUserInfoAsync(postp, postData.username).then(function (data) {
                //console.log(data);
                if (data.length != 0) {
                    ctx.body = {
                        status: 1,
                        data: data
                    };
                } else {
                    ctx.body = {
                        status: 0,
                        error: "额，基地被外星人攻陷了，保存失败… ┭┮﹏┭┮"
                    };
                }
            });

        }
    }
});

})
;

//查询用户信息
users.post('/api/showuserinfo', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//验证token
return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
    if (data) {
        //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
        if (data.data == postData.username) {

            //新增用户信息，如果已存在则更新，否则新增
            return models.showUserInfoAsync(postData.username).then(function (data) {
                //console.log(data);
                if (data.length != 0) {
                    ctx.body = {
                        status: 1,
                        data: data[0]
                    };
                } else {
                    ctx.body = {
                        status: 0,
                        error: "额，似乎没有找到此用户哦… ┭┮﹏┭┮"
                    };
                }
            });

        }
    }
});

})
;

//查询用户发布的话题，带分页
users.post('/api/showuserhuati', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//验证token
return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
    if (data) {
        //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
        if (data.data == postData.username) {

            //初始化分页参数
            var limit = 10;    //每页条数
            var start = 0;
            var end = 3;

            //获取post传参
            let postData = ctx.request.body;  //使用ctx.request.body获取post参数
            let page = parseInt(postData.page);

            //有传参则配置分页参数
            if (!page || page == 1) {
                page = 1;
                start = 0;
            } else {
                start = (page - 1) * limit;
            }
            end = page * limit;

            //获取当前用户指定分页的话题
            return huati.userHuatiListAsync([start, end], postData.username).then(function (data) {
                //console.log(data);
                if (data.length != 0) {
                    ctx.body = {
                        status: 1,
                        data: data
                    };
                } else {
                    ctx.body = {
                        status: 0,
                        error: "额，似乎没有找到话题哦… ┭┮﹏┭┮"
                    };
                }
            });

        }
    }
});

})
;

//修改头像
users.post('/api/editmycover', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//必须存在token和username
if (!postData.token || postData.username) {
    //验证token
    return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
        if (data) {
            //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
            if (data.data == postData.username) {

                //修改头像
                return models.editUserCoverAsync([postData.cover], postData.username).then(function (data) {
                    //sconsole.log(data);
                    if (data.affectedRows == 1) {
                        ctx.body = {
                            status: 1,
                            text: "修改成功"
                        };
                    } else {
                        ctx.body = {
                            status: 0
                        };
                    }
                });

            } else {
                ctx.body = {
                    status: 0,
                    error: '登陆失效'
                };
            }
        } else {
            ctx.body = {
                status: 0
            };
        }
    });
} else {
    ctx.body = {
        status: 0
    };
}
})
;

//获取用户头像
users.post('/api/getmycover', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//验证token
return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
    if (data) {
        //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
        if (data.data == postData.username) {

            //新增用户信息，如果已存在则更新，否则新增
            return models.getUserCoverAsync(postData.username).then(function (data) {
                //console.log(data);
                if (data != null) {
                    ctx.body = {
                        status: 1,
                        data: data
                    };
                } else {
                    ctx.body = {
                        status: 0,
                        error: "额，似乎没有找到此用户哦… ┭┮﹏┭┮"
                    };
                }
            });

        }
    }
});

})
;

//修改用户密码
users.post('/api/edituserpsw', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数


if (postData.oldpassword == '' || postData.oldpassword.trim() == '' || !postData.oldpassword || postData.newpassword == '' || !postData.newpassword || postData.newpassword.trim() == '') {
    return ctx.body = {
        status: 0,
        error: "参数错误"
    };
}

//验证token
return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
    //console.log(data);
    if (data) {
        //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
        if (data.data == postData.username) {


            //密码加密
            var opsw = md5(sha1(postData.oldpassword) + 'huati');
            var npsw = md5(sha1(postData.newpassword) + 'huati');

            //新增用户信息，如果已存在则更新，否则新增
            return models.editUserPasswordAsync(postData.username, opsw, npsw).then(function (data) {
                //console.log(data);
                if (data == "nopsw") {
                    ctx.body = {
                        status: 0,
                        error: "原密码错误… ┭┮﹏┭┮"
                    };
                } else if (data == "error") {
                    ctx.body = {
                        status: 0,
                        error: "密码修改失败… ┭┮﹏┭┮"
                    };
                } else if (data == "yes") {
                    ctx.body = {
                        status: 1,
                        data: data
                    };
                }
            });

        }
    }
});

})
;

//查询当前用户参与（支持或反对）过的话题，带分页
users.post('/api/showuserpartakehuati', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//验证token
return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
    if (data) {
        //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
        if (data.data == postData.username) {

            //初始化分页参数
            var limit = 10;    //每页条数
            var start = 0;
            var end = 3;

            //获取post传参
            let postData = ctx.request.body;  //使用ctx.request.body获取post参数
            let page = parseInt(postData.page);

            //有传参则配置分页参数
            if (!page || page == 1) {
                page = 1;
                start = 0;
            } else {
                start = (page - 1) * limit;
            }
            end = page * limit;

            //获取当前用户指定分页的话题
            return huati.userPartakeHuatiListAsync([start, end], postData.username).then(function (data) {
                //console.log(data);
                if (data.length != 0) {
                    ctx.body = {
                        status: 1,
                        data: data
                    };
                } else {
                    ctx.body = {
                        status: 0,
                        error: "额，似乎没有找到话题哦… ┭┮﹏┭┮"
                    };
                }
            });

        }
    }
});

})
;

//查询当前用户评论（吐槽）过的话题，带分页
users.post('/api/showuserCommenthuati', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//验证token
return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
    if (data) {
        //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
        if (data.data == postData.username) {

            //初始化分页参数
            var limit = 10;    //每页条数
            var start = 0;
            var end = 3;

            //获取post传参
            let postData = ctx.request.body;  //使用ctx.request.body获取post参数
            let page = parseInt(postData.page);

            //有传参则配置分页参数
            if (!page || page == 1) {
                page = 1;
                start = 0;
            } else {
                start = (page - 1) * limit;
            }
            end = page * limit;

            //获取当前用户指定分页的话题
            return huati.userCommentHuatiListAsync([start, end], postData.username).then(function (data) {
                //console.log(data);
                if (data.length != 0) {
                    ctx.body = {
                        status: 1,
                        data: data
                    };
                } else {
                    ctx.body = {
                        status: 0,
                        error: "额，似乎没有找到话题哦… ┭┮﹏┭┮"
                    };
                }
            });

        }
    }
});

})
;

exports.users = users;