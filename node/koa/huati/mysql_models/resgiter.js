/* 用户注册model */

//导入异步mysql的query封装
const { query } = require('../my_modules/async-db');

/*
 * 用户注册，注册成功后自动登陆
 * @parmas values [字段值,字段值,…]
 * @return promise对象：addUserAsync.then(function(data){…})
 */
async
function addUserAsync(values) {
    let sql = "INSERT INTO users(username,password,registerdate) VALUES(?,?,now())";
    let dataList = await
    query(sql, values);
    return dataList;
}

/*
 * 用户注册，验证用户名是否存在
 * @parmas values [字段值,字段值,…]
 * @return promise对象：isUsernameAsync.then(function(data){…})
 */
async
function isUsernameAsync(values) {
    let sql = "SELECT * FROM users WHERE username = ?";
    let dataList = await
    query(sql, values);
    //console.log(dataList);
    return dataList;
}

module.exports = {addUserAsync, isUsernameAsync};