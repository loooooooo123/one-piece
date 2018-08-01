// 引入数据module
// crypto 是 Node.js 的一个核心模块，我们用它生成散列值来加密密码。
var crypto = require('crypto');
var User = require('../models/user.js');
var Arc = require('../models/arc.js');
var codeDemo = require('../models/codeDemo.js');  //html转义
var formidable = require('formidable');		//图片上传模块
var path = require('path');
var fs = require('fs');

module.exports = function (app) {

    // 发表文章跳转
    app.get('/post', function (req, res) {

        //判断是否登录
        if (!req.session.user) {
            return res.redirect('/login');
        }

        var getUser = req.session.user;

        //检查用户是否存在
        var UserInfo1 = {name: getUser};
        User.get(UserInfo1, function (err, userInfo) {
            res.render('article', {
                title: '发表',
                user: req.session.user,
                userInfo: userInfo,
                error: ''
            });
        });
    });

    // 发布文章逻辑
    app.post('/post', function (req, res) {

        //判断是否登录
        if (!req.session.user) {
            return res.redirect('/login');
        }

        var currentUser = req.session.user;

        // 要插入的文章数据
        var data1 = {
            name: currentUser,
            title: req.body.title,
            text: req.body.text
        }

        Arc.save(data1, function (err) {
            if (err) {
                //发布错误通知
                return res.send({errors: '文章发布失败，出错了'});
            }
            res.send({errors: 'Y'});  //发布成功，发送消息为 Y
        });
    });

    //图片上传处理路由
    app.post('/uploadImg', function (req, res, next) {

        //创建表单上传
        var form = new formidable.IncomingForm();

        //保留后缀
        form.keepExtensions = true;

        //设置文件存储路径
        form.uploadDir = __dirname + '/../public/upload/images';

        form.parse(req, function (err, fields, files) {
            if (err) {
                throw err;
            }

            var image = files.imgFile;
            var path = image.path;

            var subDemo = path.substr(path.lastIndexOf('\\'), path.length).replace('\\', '');
            var url = '/upload/images/' + subDemo;

            var info = {
                error: 0,
                url: url
            };
            res.send(info);
        });
    });

    //用户头像上传
    app.post('/uploadUserImg', function (req, res) {

        // 创建formidable文件解析上传数据
        // 注:下载安装formidable，引入formidable再创建formidable
        var form = new formidable.IncomingForm();

        //保留后缀
        form.keepExtensions = true;

        // 设置路径
        // 注：把路径设置为静态路径下的uploads，需在public下创建upload/images
        form.uploadDir = __dirname + '/../public/upload/images/userImg/';

        // uploadDir设置文件的上传的路径

        //获取图片类型/后戳
        function getImgType(imagePath) {
            var suffix;
            //判断上传图片类型
            if (imagePath.indexOf('.jpg') >= 0) {
                suffix = '.jpg';
            } else if (imagePath.indexOf('.png') >= 0) {
                suffix = '.png';
            } else if (imagePath.indexOf('.gif') >= 0) {
                suffix = '.gif';
            } else {
                suffix = '';
            }

            return suffix;
        }

        // 解析上传内容
        form.parse(req, function (err, fields, files) {
            if (err) {
                throw err;
            }

            //获取图片路径
            var imagePath = '';

            //获取图片路径，为了验证是否是jpg、jpeg、png、gif等格式图片
            imagePath = files.upload.path;

            if (getImgType(imagePath) == '') {
                return res.send({error: '图片格式错误，请上传jpg、png、gif格式的图片'});
            }

        });

        // 监听file事件(在服务器的路径下，有上传的文件)，处理上传内容
        form.on('file', function (field, file) {  //file是上传的文件

            if (getImgType(file.path) == '') {
                return res.send({error: '图片格式错误，请上传jpg、png、gif格式的图片'});
            }

            //获取当前时间
            var date = new Date();
            var time = date.getFullYear().toString() +
                (date.getMonth() + 1).toString() +
                date.getDate().toString() +
                date.getHours().toString() +
                (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()).toString() +
                date.getSeconds().toString();

            // 更改上传文件的名字
            // 使用同步更改
            fs.renameSync(file.path, path.join(form.uploadDir, time + getImgType(file.path)));

            // 第一个参数file.path表示上传的文件所在的路径
            // 发送给浏览器端(客户端)
            res.send({
                error: '',
                url: '/upload/images/userImg/' + time + getImgType(file.path)
            });

        });

        // 监听end事件，判断是否上传结束
        form.on('end', function () {
            console.log('upload success');
        });

    })

    // 获取某个用户的分页第一页文章
    app.get('/arc/:user', function (req, res) {

        var page1 = 1;

        //判断是否登录
        if (req.session.user) {
            var getUser = req.session.user;

            //如果为我的文章
            if (req.params.user == 'my') {
                req.params.user = getUser;
            }
        }

        // 显示文章内容
        Arc.getUserTen(10, page1, req.params.user, function (err, posts, total) {
            if (err) {
                posts = []; // 如果出错，清空结果集
            }

            if (total == undefined || total == null) {
                total = 0; // 如果没有任何记录
            }

            //求最大页数
            var maxTotal = Math.ceil(total / 10);

            //检查用户是否存在
            var UserInfo1 = {name: getUser};
            User.get(UserInfo1, function (err, userInfo) {
                if (maxTotal == 0) {
                    res.render('userArcList', {
                        title: '用户：' + req.params.user + '的主页',
                        user: req.params.user == 'my' ? getUser : req.params.user,
                        userInfo: userInfo,
                        posts: posts,
                        page: page1,
                        firstPage: 0,
                        lastPage: 0,
                        allPage: 0,
                        error: ''
                    });
                } else {
                    res.render('userArcList', {
                        title: '用户：' + req.params.user + '的主页',
                        user: req.params.user == 'my' ? getUser : req.params.user,
                        userInfo: userInfo,
                        posts: posts,
                        page: page1,
                        firstPage: page1 - 1 <= 1 ? 1 : page1 - 1,
                        lastPage: page1 + 1 >= maxTotal ? maxTotal : page1 + 1,
                        allPage: maxTotal,
                        error: ''
                    });
                }
            });
        });
    });

    // 获取某个用户的分页文章
    app.get('/arcUser/:user/page/:page', function (req, res) {

        var page1 = req.params.page;

        //判断是否登录
        if (req.session.user) {
            var getUser = req.session.user;

            //如果为我的文章
            if (req.params.user == 'my') {
                req.params.user = getUser;
            }
        }

        // 显示文章内容
        Arc.getUserTen(10, page1, req.params.user, function (err, posts, total) {
            if (err) {
                posts = []; // 如果出错，清空结果集
            }

            if (total == undefined || total == null) {
                total = 0; // 如果没有任何记录
            }

            //求最大页数
            var maxTotal = Math.ceil(total / 10);

            //检查用户是否存在
            var UserInfo1 = {name: getUser};
            User.get(UserInfo1, function (err, userInfo) {
                if (maxTotal == 0) {
                    res.render('userArcList', {
                        title: '用户：' + req.params.user + '的主页',
                        user: getUser,
                        userInfo: userInfo,
                        posts: posts,
                        page: page1,
                        firstPage: 0,
                        lastPage: 0,
                        allPage: 0,
                        error: ''
                    });
                } else {
                    res.render('userArcList', {
                        title: '用户：' + req.params.user + '的主页',
                        user: getUser,
                        userInfo: userInfo,
                        posts: posts,
                        page: page1,
                        firstPage: page1 - 1 <= 1 ? 1 : page1 - 1,
                        lastPage: page1 + 1 >= maxTotal ? maxTotal : page1 + 1,
                        allPage: maxTotal,
                        error: ''
                    });
                }
            });
        });
    });

    //当前用户删除自己的文章
    app.post('/remove', function (req, res) {

        //判断是否登录
        if (!req.session.user) {
            return res.redirect('/login');
        }

        var currentUser = req.session.user;

        Arc.remove(req.body.id, req.session.user, function (err) {

            if (err == 'N') {
                res.send({errors: 'N'});  //删除失败，发送消息为 N
            }
            res.send({errors: 'Y'});  //删除成功，发送消息为 Y
        });
    });

    //当前用户编辑自己的文章——文章编辑页跳转
    app.get('/editFind/:id', function (req, res) {

        //判断是否登录
        if (!req.session.user) {
            return res.redirect('/login');
        }

        var currentUser = req.session.user;

        Arc.findOneArc(req.params.id, function (err, con) {

            if (err) {
                res.redirect('/');  //跳转到主页
            }

            //如果不是当前用户的文章，则不可编辑
            if (con.name != currentUser) {
                res.redirect('/');  //跳转到主页
            }

            //检查用户是否存在
            var UserInfo1 = {name: currentUser};
            User.get(UserInfo1, function (err, userInfo) {
                res.render('editArc', {
                    title: '编辑文章',
                    user: currentUser,
                    userInfo: userInfo,
                    posts: con,
                    error: ''
                });
            });

        });
    });

    //当前用户编辑自己的文章——文章编辑
    app.post('/edit', function (req, res) {

        //判断是否登录
        if (!req.session.user) {
            return res.redirect('/login');
        }

        var currentUser = req.session.user;

        Arc.update(req.body.id, req.body.title, req.body.text, function (err) {

            if (err) {
                res.redirect('/');  //跳转到主页
            }
            res.send({errors: 'Y'});  //编辑成功，发送消息为 Y
        });
    });

    //获取指定id文章
    app.get('/arcBody/:id', function (req, res) {

        var currentUser = req.session.user;
        var getAid = req.params.id;

        //获取文章信息
        Arc.findOneArc(getAid, function (err, ArcCon) {

            if (err) {
                res.redirect('/');  //跳转到主页
            }

            //获取留言信息
            Arc.updatePv(getAid, function (err) {

                if (err) {
                    res.redirect('/');  //跳转到主页
                }

                //检查用户是否存在
                var UserInfo1 = {name: currentUser};
                User.get(UserInfo1, function (err, userInfo) {
                    res.render('arcBody', {
                        title: '',
                        user: currentUser,
                        userInfo: userInfo,
                        posts: ArcCon,
                        error: ''
                    });
                });
            });

        });

    });

    //搜索指定关键词的所有文章
    app.post('/search/', function (req, res) {

        var currentUser = req.session.user;
        var getWord = req.body.keyWord;

        //获取文章信息
        Arc.findKeyWordArc(getWord, function (err, ArcCon) {

            if (err) {
                res.redirect('/');  //跳转到主页
            }

            //检查用户是否存在
            var UserInfo1 = {name: currentUser};
            User.get(UserInfo1, function (err, userInfo) {
                res.render('search', {
                    title: '文章搜索',
                    user: currentUser,
                    userInfo: userInfo,
                    posts: ArcCon,
                    error: ''
                });
            });

        });

    });

    //新增一条留言/回复
    app.post('/replyAdd', function (req, res) {

        //判断是否登录
        if (!req.session.user) {
            return res.redirect('/login');
        }

        var currentUser = req.session.user;

        //要存储的数据
        var replyJson = {
            aid: req.body.id,
            replyUser: currentUser,
            text: req.body.text1
        }

        Arc.replyNew(req.body.id, replyJson, function (err) {

            if (err) {
                res.redirect('/');  //跳转到主页
            }
            res.send({errors: 'Y'});  //留言成功，发送消息为 Y
        });
    });

}