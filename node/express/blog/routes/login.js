// 引入数据module
// crypto 是 Node.js 的一个核心模块，我们用它生成散列值来加密密码。
var crypto = require('crypto');
var User = require('../models/user.js');
var Arc = require('../models/arc.js');

module.exports = function (app) {

    // 退出登录
    app.get('/logout', function (req, res) {

        //判断是否登录
        if (!req.session.user) {
            return res.redirect('back');
        }

        req.session.user = null;

        if (req.session.user == null) {
            res.send({success: 'Y'});  //成功，发送消息为 Y
        } else {
            res.send({success: 'N'});  //失败，发送消息为 N
        }
    });

    // 注册跳转
    app.get('/reg', function (req, res) {

        //判断是否登录
        if (req.session.user) {
            return res.redirect('back');
        }

        res.render('reg', {
            title: '注册',
            user: req.session.user,
            errors: ''
        });
    });

    // 注册逻辑
    app.post('/reg', function (req, res) {

        //判断是否登录
        if (req.session.user) {
            return res.redirect('back');
        }

        var name = req.body.username,
            password = req.body.password,
            password_re = req.body.password_repeat;
        email = req.body.email;
        userImg = req.body.userImg || req.body.userImg == '' ? req.body.userImg : '/upload/images/userImg/default.png';

        //检验用户两次输入的密码是否一致
        if (password_re != password) {
            return res.send({errors: '两次输入的密码不一致'});
        }

        //生成密码的 md5 值
        var md5 = crypto.createHash('md5'),
            password = md5.update(req.body.password).digest('hex');
        var newUser = {
            name: name,
            password: password,
            email: email,
            userImgUrl: userImg
        };

        // console.log(newUser.name);
        // console.log(newUser.password);
        // console.log(password_re);
        // console.log(newUser.email);

        //console.log(newUser);return;
        //检查用户名是否已经存在
        User.get(newUser, function (err, user) {

            if (err) {
                return res.send({errors: '错误'});
            }

            if (user) {
                //返回注册页
                return res.send({errors: '用户名已存在'});
            }

            //如果不存在则新增用户
            User.save(newUser, function (err, user) {
                if (err) {
                    return res.send({errors: '新增失败，错误'});
                }
                console.log('注册成功');
                // 后续可通过 req.session.user 读取session
                req.session.user = user.ops[0].name;  //用户信息存入 session
                //console.log(req.session.user);	//读取session的id
                res.redirect('/');  //注册成功后返回主页
            });
        });
    });

    // 登录跳转
    app.get('/login', function (req, res) {

        //判断是否登录
        if (req.session.user) {
            return res.redirect('back');
        }

        res.render('login', {
            title: '登录',
            user: req.session.user,
            errors: ''
        });

    });

    // 登录逻辑
    app.post('/login', function (req, res) {

        //判断是否登录
        if (req.session.user) {
            return res.redirect('back');
        }

        //生成密码的 md5 值
        var md5 = crypto.createHash('md5'),
            name = req.body.username,
            password = md5.update(req.body.password).digest('hex');

        var newUser = {
            name: req.body.username
        };

        //检查用户是否存在
        User.get(newUser, function (err, user) {

            if (!user) {
                //用户不存在通知
                return res.send({errors: '用户不存在'});
            }
            //检查密码是否一致
            if (user.password != password) {
                //密码错误通知
                return res.send({errors: '密码错误'});
            }
            //用户名密码都匹配后，将用户信息存入 session
            req.session.user = user.name;  //用户信息存入 session

            res.redirect('/');  //登陆成功后跳转到主页
        });
    });

}
