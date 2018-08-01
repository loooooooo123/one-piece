const Koa = require('koa');
const app = new Koa();
const views = require('koa-views');
const json = require('koa-json');
const onerror = require('koa-onerror');
const bodyparser = require('koa-bodyparser');
const logger = require('koa-logger');
//解决跨域
const cors = require('koa-cors');

//视图路由
const index = require('./routes/view/index');
//api路由
var login = require('./routes/api/login');
var register = require('./routes/api/register');
var huati = require('./routes/api/huati');
var users = require('./routes/api/users');

// error handler
onerror(app);

// middlewares
app.use(bodyparser({
    enableTypes: ['json', 'form', 'text']
}));
app.use(json());
app.use(logger());
app.use(require('koa-static')(__dirname + '/public'));
//跨域
app.use(cors());

//pug模板
app.use(views(__dirname + '/views', {
    extension: 'pug'
}));

//引入koa-bodyparse中间件
const bodyParser = require('koa-bodyparser');

// 使用koa-bodyparse中间件
app.use(bodyParser());

/* 配置sesssion */
//引入session中间件
const session = require('koa-session-minimal')
const MysqlSession = require('koa-mysql-session')
// 配置存储session信息的mysql
let store = new MysqlSession({
    user: 'root',
    password: '123456',
    database: 'huati',
    host: '127.0.0.1',
})

// 存放sessionId的cookie配置，这里配置的属性就是数据表中的字段
let cookie = {
    maxAge: 60 * 1000 * 5, //cookie有效时长
    path: '/', //写cookie所在的路径
    domain: 'baijiqian.cn', //写cookie所在的域名
    httpOnly: true, //是否只用于http请求中获取
    overwrite: false,  //是否允许重写
}
// 使用session中间件
app.use(session({
    key: 'SESSION_ID',
    store: store,
    cookie: cookie
}));

// logger
app.use(async(ctx, next) = > {
    const start = new Date()
    await next()
    const ms = new Date() - start
    console.log(
`${ctx.method} ${ctx.url}
-${ms}ms
`)
})
;

//视图路由
app.use(index.routes(), index.allowedMethods());
//api路由
app.use(login.login.routes(), login.login.allowedMethods());
app.use(register.register.routes(), register.register.allowedMethods());
app.use(huati.huati.routes(), huati.huati.allowedMethods());
app.use(users.users.routes(), users.users.allowedMethods());

// error-handling
app.on('error', (err, ctx) = > {
    console.error('server error', err, ctx);
})
;

app.use(async(ctx, next) = > {
    try {
        yield * next;
} catch
(e)
{
    ctx.status = 500;
    await
    ctx.render('public_view/404');
}
if (parseInt(this.status) === 404) {
    await
    ctx.render('public_view/500');
}
})
;

module.exports = app;
