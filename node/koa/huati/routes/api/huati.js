/* 发布话题，浏览话题 路由 */

//引入路由中间件
const Router = require('koa-router');
//生成token
var jwt = require('jsonwebtoken');

//声明路由
let huati = new Router();

//mysql操作model
let models = require('../../mysql_models/huati.js');

//发布话题
huati.post('/api/addhuati', async(ctx) = > {

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

                //检查必填项
                if (postData.title == '' || postData.title.trim() == '' || postData.yinyan == '' || postData.yinyan.trim() == '' || postData.content == '' || postData.content.trim() == '' || postData.yulan == '' || postData.yulan.trim() == '') {
                    ctx.body = {
                        status: 0,
                        error: "请认真填写话题每项，不能有空白啊"
                    };
                } else {
                    //查询是否存在相同话题
                    return models.isHuaTiRepeatAsync([postData.title]).then(function (data) {
                        //console.log(data);
                        if (data.length == 0) {
                            //入库操作
                            return models.addHuaTiAsync([postData.title, postData.yinyan, postData.content, postData.yulan], postData.username).then(function (data) {
                                //console.log(data);
                                if (data.affectedRows == 1) {
                                    ctx.body = {
                                        status: 1,
                                        id: data.insertId
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
                                error: "话题已存在，换个话题吧"
                            };
                        }
                    });
                }

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

//显示话题
huati.post('/api/showhuati', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

if (postData.id == '' || postData.id == null) {
    ctx.body = {
        status: 0,
        error: "额，当前话题被外星人带走了… ┭┮﹏┭┮"
    };
} else {
    //显示话题
    return models.showHuaTiAsync([postData.id]).then(function (data) {
        //console.log(data);
        if (data.length != 0) {
            ctx.body = {
                status: 1,
                data: data[0]
            };
        } else {
            ctx.body = {
                status: 0,
                error: "额，当前话题被外星人带走了… ┭┮﹏┭┮"
            };
        }
    });
}

})
;

//显示话题列表，带分页
huati.post('/api/huatilist', async(ctx) = > {

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

//console.log(start,end,page);

//获取指定分页的话题
return models.huatiListAsync([start, end]).then(function (data) {
    //console.log(data);
    if (data.length != 0) {
        ctx.body = {
            status: 1,
            data: data
        };
    } else {
        ctx.body = {
            status: 0,
            data: []
        };
    }
});

})
;

//支持，反对当前话题
huati.post('/api/huativote', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//必须存在token和username
if (!postData.token || postData.username) {
    //验证token
    return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
        if (data) {
            //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
            if (data.data == postData.username) {

                //console.log(postData);

                //获取指定分页的话题
                return models.huatiVoteAsync([postData.id], postData.vote, postData.username).then(function (data) {
                    console.log(data);
                    if (data == 'yes') {
                        ctx.body = {
                            status: 1
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

//评论/吐槽当前话题
huati.post('/api/addcomment', async(ctx) = > {

    //获取post传参
    let postData = ctx.request.body;  //使用ctx.request.body获取post参数

//必须存在token和username
if (!postData.token || postData.username) {
    //验证token
    return jwt.verify(postData.token, 'huatixiaoxiang', function (err, data) {
        if (data) {
            //返回值类似：{ exp: 1528642266, data: 'aba', iat: 1528638666 }
            if (data.data == postData.username) {

                //console.log(postData);

                //获取指定分页的话题
                return models.huatiCommentAsync([postData.id, postData.comment, postData.type], postData.username).then(function (data) {
                    console.log(data);
                    if (data.affectedRows == 1) {
                        ctx.body = {
                            status: 1
                        };
                    } else if (data == 'no') {
                        ctx.body = {
                            status: 0,
                            error: 'no'
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
                    error: '登陆失效，请重新登录'
                };
            }
        } else {
            ctx.body = {
                status: 0,
                error: '登陆失效，请重新登录'
            };
        }
    });
} else {
    ctx.body = {
        status: 0,
        error: '请登录后进行吐槽'
    };
}

})
;

//显示话题评论列表，带分页
huati.post('/api/huaticomment', async(ctx) = > {

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

//console.log(start,end,page);

//获取指定分页的话题
return models.showHuaTiCommentAsync([postData.id, start, end]).then(function (data) {
    //console.log(data);
    if (data.length != 0) {
        ctx.body = {
            status: 1,
            data: data
        };
    } else {
        ctx.body = {
            status: 0,
            data: []
        };
    }
});

})
;

//显示搜索话题的结果列表，带分页
huati.post('/api/searchhuati', async(ctx) = > {

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

//console.log(start,end,page);

//获取指定分页的话题
return models.searchHuatiListAsync([start, end], postData.keyword).then(function (data) {
    //console.log(data);
    if (data.list.length != 0) {
        ctx.body = {
            status: 1,
            data: data
        };
    } else {
        ctx.body = {
            status: 0,
            data: {
                list: [],
                count: 0
            }
        };
    }
});

})
;

exports.huati = huati;