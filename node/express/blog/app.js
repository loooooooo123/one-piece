var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var session = require('express-session');
var fs = require('fs');

// 引入mongodb链接配置文件
var settings = require('./settings');

var app = express();

//访问日志 存储为access.log、错误日志功能 存储为error.log文件夹内
var accessLog = fs.createWriteStream('access.log', {flags: 'a'});
var errorLog = fs.createWriteStream('error.log', {flags: 'a'});

// 会话session、cookie
var MongoStore = require('connect-mongo')(session);
app.use(session({
    secret: settings.cookieSecret,
    key: settings.db,
    cookie: {maxAge: 1000 * 60 * 60 * 24 * 30},
    store: new MongoStore({
        db: settings.db,
        url: settings.url,
        port: settings.port
    }),
    resave: false,
    saveUninitialized: true
}));

// 引入路由
var index = require('./routes/index');
var login = require('./routes/login');
var arc = require('./routes/arc');

// 设置模板
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

//设置静态路径 /public
app.use(favicon(path.join(__dirname, 'public', 'favicon.png')));

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

//自定义，错误日志中间件
app.use(function (err, req, res, next) {
    var meta = '[' + new Date() + '] ' + req.url + '\n';
    errorLog.write(meta + err.stack + '\n');
    next();
});

// 使用路由
index(app);
login(app);
arc(app);

// 处理404 catch-all（中间件）
app.use(function (req, res, next) {
    res.status(404);
    res.render('404');
});

// 处理500错误（中间件）
app.use(function (err, req, res, next) {
    console.error(err.stack);
    res.status(500);
    res.render('500');
});

module.exports = app;
