/* 用户 登陆 路由 */

//引入路由中间件
const Router = require('koa-router');
//引入验证码生成模块
var captchapng = require('captchapng');
//引入md5，sha1加密模块
var md5 = require('md5');
var sha1 = require('sha1');
//生成token
var jwt = require('jsonwebtoken');

//声明路由
let login = new Router();

//mysql操作model
let models = require('../../mysql_models/login.js');

//验证用户是否登陆
login.post('/api/rexLogin', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//console.log(postData);

//必须存在token和username
if (!postData.token || postData.username) {
    //验证token
    return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
        if (data) {
            //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
            if (data.data == postData.username) {
                ctx.body = {
                    status: 1,
                    username: data.data
                };
            } else {
                ctx.body = {
                    status: 0
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

//用户登录
login.post('/api/login', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//验证码效验
if (ctx.session.codeval == postData.code) {

    //密码加密
    var psw = md5(sha1(postData.password) + 'huati');

    return models.loginAsync([postData.username, psw]).then(function (data) {
        //console.log(data);
        if (data.length != 0) {
            var getUserName = data[0].username;

            //生成token，传递给前端
            let token = jwt.sign({
                exp: Math.floor(Date.now() / 1000) + (60 * 60),
                data: getUserName
            }, 'huatixiaoxiang');   //最后一个参数为密码公匙

            ctx.body = {
                status: 1,
                username: getUserName,
                token: token
            };
        } else {
            ctx.body = {
                status: 0,
            };
        }
    });

} else {
    ctx.body = {
        status: 0,
        text: "验证码错误"
    };
}
})
;

exports.login = login;