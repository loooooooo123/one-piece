// 引入数据module
// crypto 是 Node.js 的一个核心模块，我们用它生成散列值来加密密码。
var crypto = require('crypto');
var User = require('../models/user.js');
var Arc = require('../models/arc.js');

module.exports = function (app) {

    // 首页
    app.get('/', function (req, res) {

        var getUser = req.session.user;
        var page1 = 1;

        // 显示文章内容
        Arc.getPageList(10, page1, function (err, posts, total) {
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
                    res.render('index', {
                        title: '主页',
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
                    res.render('index', {
                        title: '主页',
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

    // 获取分页数据
    app.get('/pageList/:page', function (req, res) {

        var getUser = req.session.user;

        var page1 = req.params.page;

        if (!page1 || page1 <= 0) {
            page1 = 1;
        }

        // 显示文章内容
        Arc.getPageList(10, page1, function (err, posts, total) {
            if (err) {
                posts = []; // 如果出错，清空结果集
            }

            if (total == undefined || total == null) {
                total = 0; // 如果没有任何记录
            }

            //求最大页数
            var maxTotal = Math.ceil(total / 10);

            if (page1 > maxTotal) {
                page1 = maxTotal;
            }

            //检查用户是否存在
            var UserInfo1 = {name: getUser};
            User.get(UserInfo1, function (err, userInfo) {

                if (maxTotal == 0) {
                    res.render('indexList', {
                        title: '主页',
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
                    res.render('indexList', {
                        title: '主页',
                        user: getUser,
                        userInfo: userInfo,
                        posts: posts,
                        page: page1,
                        firstPage: page1 - 1 <= 1 ? 1 : page1 - 1,
                        lastPage: parseInt(page1) + 1 > maxTotal ? maxTotal : page1 + 1,
                        allPage: maxTotal,
                        error: ''
                    });
                }

            });

        });
    });

}
