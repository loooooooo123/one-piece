const router = require('koa-router')();

//引入封装好的上传模块
const { uploadFile } = require('../../my_modules/upload');
//生成token
var jwt = require('jsonwebtoken');
//mysql操作model
let huati = require('../../mysql_models/huati.js');

//首页
router.get('/', async(ctx, next) = > {
    await ctx.render('public_view/index');
})
;
//搜索页
router.get('/search', async(ctx, next) = > {
    // 从上下文的request对象中获取get传参
    let keyword = ctx.request.query.keyword;
await
ctx.render('public_view/search', {
    keyword: keyword
});
})
;

//用户注册
router.get('/register', async(ctx, next) = > {
    await ctx.render('public_view/register');
})
;
//用户登陆
router.get('/login', async(ctx, next) = > {
    await ctx.render('public_view/login');
})
;
//显示话题
router.get('/huati', async(ctx, next) = > {
    var getHuaTiId = ctx.query.id;
await
ctx.render('public_view/showHuaTi', {
    id: getHuaTiId
});
})
;
//发布话题
router.get('/addhuati', async(ctx, next) = > {
    await ctx.render('manage/huati/addHuaTi');
})
;
//文件上传
router.post('/upload', async(ctx, next) = > {

    //设置上传完成后的返回值
    let result = {success: false};

//设置上传路径
let serverFilePath = 'public/uploads';

//开始上传，返回值格式：
//{"success":true,"formData":{"picName":"'abc'"},"message":"文件上传成功"}
result = await
uploadFile(ctx, {
    fileType: 'huati', // 上传的子目录，这里是 uploads/swiper 下
    path: serverFilePath
});

//console.log(result);

let imgInfo = {
    errno: 0,
    data: result.fileStringPath
}

ctx.body = imgInfo;

})
;
//用户中心——个人信息
router.get('/user', async(ctx, next) = > {
    await ctx.render('manage/users/user', {
        leftnav_index: 1
    });
})
;
//用户中心——我的话题
router.get('/myhuati', async(ctx, next) = > {
    await ctx.render('manage/users/user_my_huati', {
        leftnav_index: 2
    });
})
;
//用户中心——参与话题
router.get('/mypartakehuati', async(ctx, next) = > {
    await ctx.render('manage/users/user_partake_huati', {
        leftnav_index: 3
    });
})
;
//用户中心——参与吐槽
router.get('/mycommenthuati', async(ctx, next) = > {
    await ctx.render('manage/users/user_comment_huati', {
        leftnav_index: 4
    });
})
;
//用户中心——修改头像
router.get('/edit_mycover', async(ctx, next) = > {
    await ctx.render('manage/users/user_my_cover', {
        leftnav_index: 5
    });
})
;
//用户中心——修改密码
router.get('/edit_mypsw', async(ctx, next) = > {
    await ctx.render('manage/users/user_edit_psw', {
        leftnav_index: 6
    });
})
;

module.exports = router;