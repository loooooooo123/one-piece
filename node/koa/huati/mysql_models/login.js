/* 用户登陆model */

//导入异步mysql的query封装
const { query } = require('../my_modules/async-db');

/*
 * 用户登陆，验证用户名 密码
 * @parmas values [字段值,字段值,…]
 * @return promise对象：loginAsync.then(function(data){…})
 */
async
function loginAsync(values) {
    let sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    let dataList = await
    query(sql, values);
    //console.log(dataList);
    return dataList;
}

module.exports = {loginAsync};