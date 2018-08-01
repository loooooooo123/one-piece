/* 多图上传 

 @使用例子：

 //文件上传
 router.post('/upload', async (ctx, next) => {

 //设置上传完成后的返回值
 let result = { success: false };

 //设置上传路径
 let serverFilePath ='public/uploads';

 //开始上传，返回值格式：
 //{"success":true,"formData":{"picName":"'abc'"},"message":"文件上传成功"}
 result = await uploadFile( ctx, {
 fileType: 'huati', // 上传的子目录，这里是 uploads/swiper 下
 path: serverFilePath
 });

 console.log(result);

 let imgInfo = {
 errno: 0,
 data: result.fileStringPath
 }

 ctx.body = imgInfo;

 });

 @返回值：
 {
 success: true,
 formData: {},
 message: '文件上传成功',
 fileStringPath: [
 'uploads\\huati\\0bc5f6e1a935b.jpg',
 'uploads\\huati\\6bc3ec4aa481f.jpg'
 ]
 }

 */

const inspect = require('util').inspect
const path = require('path')
const os = require('os')
const fs = require('fs')
const Busboy = require('busboy')

/**
 * 同步创建文件目录
 * @param  {string} dirname 目录绝对地址
 * @return {boolean}        创建目录结果
 */
function mkdirsSync(dirname) {
    if (fs.existsSync(dirname)) {
        return true
    } else {
        if (mkdirsSync(path.dirname(dirname))) {
            fs.mkdirSync(dirname)
            return true
        }
    }
}

/**
 * 获取上传文件的后缀名
 * @param  {string} fileName 获取上传文件的后缀名
 * @return {string}          文件后缀名
 */
function getSuffixName(fileName) {
    let nameList = fileName.split('.')
    return nameList[nameList.length - 1]
}

/**
 * 上传文件
 * @param  {object} ctx     koa上下文
 * @param  {object} options
 * 文件上传参数 { fileType:上传的子目录, path:文件存放路径 }
 * 示例：uploadFile(ctx,{fileType:'swiper', path:'uploads'});
 * 上传后的目录为：/uploads/swiper/ 下
 * @return {promise}
 */
function uploadFile(ctx, options) {
    let req = ctx.req
    let res = ctx.res
    let busboy = new Busboy({headers: req.headers})

    // 获取类型
    let fileType = options.fileType || 'common'
    let filePath = path.join(options.path, fileType)
    let mkdirResult = mkdirsSync(filePath)

    return new Promise((resolve, reject) = > {
            console.log('文件上传中...')
    let result = {
        success: false,
        formData: {},
    }

    // 解析请求文件事件
    var fileArr1 = [];  //保存上传的所有文件路径
    busboy.on('file', function (fieldname, file, filename, encoding, mimetype) {
        let fileName = Math.random().toString(16).substr(2) + '.' + getSuffixName(filename)
        let _uploadFilePath = path.join(filePath, fileName)
        let saveTo = path.join(_uploadFilePath)

        // 文件保存到制定路径
        file.pipe(fs.createWriteStream(saveTo))

        //完整的文件保存路径
        //console.log(_uploadFilePath.replace('public\\',''));
        let fileSavePath1 = _uploadFilePath.replace('public\\', '');
        fileArr1.push(fileSavePath1);

        // 文件写入事件结束
        file.on('end', function () {
            result.success = true
            result.message = '文件上传成功'
            result.fileStringPath = fileArr1;

            console.log('文件上传成功！')
            resolve(result)
        })
    })

    // 解析表单中其他字段信息
    busboy.on('field', function (fieldname, val, fieldnameTruncated, valTruncated, encoding, mimetype) {
        console.log('表单字段数据 [' + fieldname + ']: value: ' + inspect(val));
        result.formData[fieldname] = inspect(val);
    });

    // 解析结束事件
    busboy.on('finish', function () {
        console.log('文件上结束')
        resolve(result)
    })

    // 解析错误事件
    busboy.on('error', function (err) {
        console.log('文件上出错')
        reject(result)
    })

    req.pipe(busboy)
}
)

}

//接口为 uploadFile 函数
module.exports = {
    uploadFile
}