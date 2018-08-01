/* 用户注册 路由 */

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
let register = new Router();

//mysql操作model
let models = require('../../mysql_models/resgiter.js');

//路由路径 /api/register
register.post('/api/register', async(ctx, next) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

if (ctx.session.codeval == postData.code) {

    //用户名长度效验
    if (postData.username.length > 10 || !postData.username) {
        ctx.body = {
            status: 0,
            text: "用户名不正确"
        };
    } else if (postData.password > 10 || !postData.password) {
        ctx.body = {
            status: 0,
            text: "密码不正确"
        };
    }

    //导入异步mysql的query封装
    //models.addUser(postData);

    return models.isUsernameAsync([postData.username]).then(function (data) {
        //console.log(data);
        if (data.length != 0) {
            ctx.body = {
                status: 0,
                text: "用户名已存在"
            };
        } else {

            //密码加密
            var psw = md5(sha1(postData.password) + 'huati');

            return models.addUserAsync([postData.username, psw]).then(function (data) {
                if (data.affectedRows == 1) {

                    //用户名
                    var un = postData.username;

                    //生成token，传递给前端
                    let token = jwt.sign({
                        exp: Math.floor(Date.now() / 1000) + (60 * 60),
                        data: un
                    }, 'huatixiaoxiang');   //最后一个参数为密码公匙

                    ctx.body = {
                        status: 1,
                        text: "注册成功",
                        username: un,
                        token: token
                    };
                } else {
                    ctx.body = {
                        status: 0,
                        text: "注册失败"
                    };
                }
            });
        }
    });

} else {
    ctx.body = {
        status: 0,
        text: "验证码错误"
    };
}


// console.log(ctx.session.codeval);
// console.log(postData);

})
;

//验证码
register.get('/api/code', async(ctx) = > {

    //设置用于生成的字符
    var code = "0123456789";

//位数
var length = 4;

//最后生成的值
var randomcode = '';
for (let i = 0; i < length; i++) {
    randomcode += code[parseInt(Math.random() * 1000) % code.length];
}

//保存到session
ctx.session = {
    codeval: randomcode
}

// 输出图片
var p = new captchapng(80, 30, parseInt(randomcode)); // width,height,numeric captcha

//背景色 (red, green, blue, alpha)
p.color(65, 165, 200, 255);

//文字颜色 color: paint (red, green, blue, alpha)
p.color(255, 255, 255, 255);

//获取图片的base64格式
var img = p.getBase64();
var imgbase64 = new Buffer(img, 'base64');

//输出验证码
ctx.body = imgbase64;
//打印base64格式的验证码
//console.log(imgbase64);
//打印存储在session中的验证码
//console.log(ctx.session);

})
;

exports.register = register;