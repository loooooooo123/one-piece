/* 用户中心 model */

//导入异步mysql的query封装
const { query } = require('../my_modules/async-db');

/*
 * 新增用户信息
 * @parmas values [字段值,字段值,…]
 * @parmas uname 用户名
 * @return promise对象：addUserInfoAsync.then(function(data){…})
 */
async
function addUserInfoAsync(values, uname) {

    //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    if (users_data.length != 0) {

        //如果该用户信息不存在，则新增，否则更新
        let userinfo_sql = "SELECT id FROM userinfo WHERE uid = ?";
        let userinfo_data = await
        query(userinfo_sql, users_data[0].id);

        let dataList;

        if (userinfo_data.length == 0) {
            let sql = "INSERT INTO userinfo(uid,sex,job,birthday,constellation,hobby,speciality,ideal,updatetime) VALUES(" + users_data[0].id + ",?,?,?,?,?,?,?,now())";
            dataList = await
            query(sql, values);
        } else {
            let sql = "UPDATE userinfo SET uid=" + users_data[0].id + ",sex=?,job=?,birthday=?,constellation=?,hobby=?,speciality=?,ideal=?,updatetime=now()";
            dataList = await
            query(sql, values);
        }

        //console.log(dataList);
        return dataList;
    } else {
        return [
            {
                status: 0,
                error: "当前用户不存在"
            }
        ]
    }

}

/*
 * 查询用户信息
 * @parmas uname 用户名
 * @return promise对象：showUserInfoAsync.then(function(data){…})
 */
async
function showUserInfoAsync(uname) {

    //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    if (users_data.length != 0) {

        //如果该用户信息不存在，则新增，否则更新
        let userinfo_sql = "SELECT *,DATE_FORMAT(birthday,'%Y-%m-%d %H:%i:%s') as birthday FROM userinfo WHERE uid = ?";
        let userinfo_data = await
        query(userinfo_sql, users_data[0].id);

        //console.log(userinfo_data);
        return userinfo_data;
    } else {
        return [
            {
                status: 0,
                error: "当前用户不存在"
            }
        ]
    }

}

/*
 * 修改用户头像
 * @parmas values [用户头像上传后的保存路径]
 * @return promise对象：editUserCoverAsync.then(function(data){…})
 */
async
function editUserCoverAsync(values, uname) {

    //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    if (users_data.length != 0) {

        //如果该用户信息不存在，则新增，否则更新
        let userinfo_sql = "SELECT id FROM userinfo WHERE uid = ?";
        let userinfo_data = await
        query(userinfo_sql, users_data[0].id);

        let dataList;
        let sql

        if (userinfo_data.length == 0) {
            sql = "INSERT INTO userinfo(uid,sex,job,birthday,constellation,hobby,speciality,ideal,usercover,updatetime) VALUES(" + users_data[0].id + ",null,null,null,null,null,null,null,?,now())";
        } else {
            sql = "UPDATE userinfo SET usercover=?,updatetime=now() WHERE uid=" + users_data[0].id;
        }
        dataList = await
        query(sql, values);

        return dataList;

    } else {
        return {
            status: 0,
            error: "当前用户不存在"
        }
    }

}

/*
 * 获取用户头像
 * @parmas values 用户名
 * @return promise对象：getUserCoverAsync.then(function(data){…})
 */
async
function getUserCoverAsync(uname) {

    //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    if (users_data.length != 0) {

        //如果该用户信息不存在，则新增，否则更新
        let usercover_sql = "SELECT usercover FROM userinfo WHERE uid = ?";
        let usercover_data = await
        query(usercover_sql, users_data[0].id);

        if (usercover_data.length != 0) {
            return {
                usercover: usercover_data[0].usercover
            }
        } else {
            return {
                usercover: null
            }
        }

    } else {
        return {
            usercover: null
        }
    }

}

/*
 * 修改用户密码
 * @parmas values 用户名,旧密码,新密码
 * @return promise对象：getUserCoverAsync.then(function(data){…})
 */
async
function editUserPasswordAsync(uname, oldpsw, newpsw) {

    //查询当前用户用户名与密码
    let users_sql = "SELECT id FROM users WHERE username = ? AND password = ?";
    let users_data = await
    query(users_sql, [uname, oldpsw]);

    //验证用户名与密码
    if (users_data.length != 0) {

        //如果该用户信息不存在，则新增，否则更新
        let userpsw_sql = "UPDATE users SET password = ? WHERE id = ?";
        let userpsw_data = await
        query(userpsw_sql, [newpsw, users_data[0].id]);

        //console.log(userpsw_data);

        if (userpsw_data.affectedRows == 1) {
            return "yes";
        } else {
            return "error";
        }

    } else {
        //密码不对
        return "nopsw";
    }

}

module.exports = {addUserInfoAsync, showUserInfoAsync, editUserCoverAsync, getUserCoverAsync, editUserPasswordAsync};