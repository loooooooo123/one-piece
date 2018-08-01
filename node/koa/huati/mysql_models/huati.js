/* 发布话题，显示话题 model */

//导入异步mysql的query封装
const { query } = require('../my_modules/async-db');

/*
 * 发布话题
 * @parmas values [字段值,字段值,…],用户名
 * @return promise对象：addHuaTiAsync.then(function(data){…})
 */
async
function addHuaTiAsync(values, uname) {

    // //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    var dataList = [];
    if (users_data.length != 0) {
        let sql = "INSERT INTO huaticontent(uid,title,description,con,cover) VALUES(" + users_data[0].id + ",?,?,?,?)";
        dataList = await
        query(sql, values);
    }

    //console.log(dataList);
    return dataList;
}

/*
 * 是否存在相同话题
 * @parmas values [字段值,字段值,…]
 * @return promise对象：isHuaTiRepeatAsync.then(function(data){…})
 */
async
function isHuaTiRepeatAsync(values) {
    let sql = "SELECT * FROM huaticontent WHERE title = ?";
    let dataList = await
    query(sql, values);
    //console.log(dataList);
    return dataList;
}

/*
 * 显示话题内容
 * @parmas values [字段值,字段值,…]
 * @return promise对象：showHuaTiAsync.then(function(data){…})
 */
async
function showHuaTiAsync(values) {

    //多表联查，查当前话题内容，以及吐槽/评论表的总记录数（该话题的参与者数量统计，allcom字段）
    let sql = "SELECT hc.id,hc.title,hc.description,hc.con,hc.support,hc.opposition,count(hm.id) as allcom,us.username FROM huaticontent as hc,huaticomment as hm,users as us WHERE hc.id = ?";
    let dataList = await
    query(sql, values);
    //console.log(dataList);

    return dataList;
}

/*
 * 获取指定分页的话题，默认第一页
 * @parmas values [开始位置,结束位置]
 * @return promise对象：huatiListAsync.then(function(data){…})
 */
async
function huatiListAsync(values) {
    let sql = "SELECT * FROM huaticontent limit ?,?";
    let dataList = await
    query(sql, values);
    //console.log(dataList);
    return dataList;
}

/*
 * 获取当前用户指定分页的话题，默认第一页
 * @parmas values [开始位置,结束位置],用户名
 * @return promise对象：userHuatiListAsync.then(function(data){…})
 */
async
function userHuatiListAsync(values, uname) {

    // //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    var dataList = [];
    if (users_data.length != 0) {
        var sql = "SELECT * FROM huaticontent WHERE uid = " + users_data[0].id + " LIMIT ?,?";
        dataList = await
        query(sql, values);
    }

    //console.log(dataList);
    return dataList;
}

/*
 * 支持，反对当前话题
 * @parmas values [话题id],'是否支持 Y 或 N',用户名
 * @return promise对象：huatiVoteAsync.then(function(data){…})
 */
async
function huatiVoteAsync(values, isvote, uname) {

    // //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    var is_user_vote_dataList = [];
    if (users_data.length != 0) {

        var is_user_vote_sql = "SELECT * FROM huativote WHERE hid = ? AND uid = " + users_data[0].id;
        is_user_vote_dataList = await
        query(is_user_vote_sql, values);

        //检查该用户是否对该话题进行过投票，防止重复投票
        if (is_user_vote_dataList.length == 0) {

            var sql;
            //支持或反对该话题
            if (isvote == 'Y') {
                sql = "UPDATE huaticontent SET support=support+'1' WHERE id = ?";
            } else {
                sql = "UPDATE huaticontent SET opposition=opposition+'1' WHERE id = ?";
            }
            dataList = await
            query(sql, values);

            //用户投票后增加投票记录，防止重复投票
            var user_yes_vote_sql = "INSERT INTO huativote(hid,uid) VALUES(?," + users_data[0].id + ")";
            var user_yes_vote_sql_dataList = await
            query(user_yes_vote_sql, values);

            //操作成功返回值
            if (dataList.affectedRows == 1 && user_yes_vote_sql_dataList.affectedRows == 1) {
                return "yes";
            } else {
                return "no";
            }
        } else {
            return "no";
        }
    } else {
        return "no";
    }
}

/*
 * 评论/吐槽当前话题
 * @parmas values [话题id,评论内容,支持或反对 Y或N],用户名
 * @return promise对象：huatiCommentAsync.then(function(data){…})
 */
async
function huatiCommentAsync(values, uname) {

    // //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    var is_user_vote_dataList = [];
    if (users_data.length != 0) {

        var comment_sql = "INSERT INTO huaticomment(uid,hid,con,type,commenttime) VALUES(" + users_data[0].id + ",?,?,?,now())";
        comment_dataList = await
        query(comment_sql, values);

        return comment_dataList;

    } else {
        return "no";
    }
}

/*
 * 显示话题的评论，带分页
 * @parmas values [话题id,开始位置,结束位置]
 * @return promise对象：showHuaTiCommentAsync.then(function(data){…})
 */
async
function showHuaTiCommentAsync(values) {

    //返回huaticomment表（左表中）的记录，对应查出huaticomment.uid=users.id 和 huaticomment.uid=userinfo.uid 的字段值
    var sql = "SELECT users.username,h.con,h.type,userinfo.usercover,h.id FROM huaticomment as h LEFT JOIN users ON users.id=h.uid LEFT JOIN userinfo ON userinfo.uid = h.uid WHERE h.hid = ? LIMIT ?,?"
    var dataList = await
    query(sql, values);

    dataList

    //console.log(dataList);
    return dataList;
}

/*
 * 显示当前用户参与（支持或反对）过的话题，带分页
 * @parmas values [开始位置,结束位置],用户名
 * @return promise对象：userPartakeHuatiListAsync.then(function(data){…})
 */
async
function userPartakeHuatiListAsync(values, uname) {

    // //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    var dataList = [];
    if (users_data.length != 0) {
        var sql = "SELECT hc.id,hc.title,hc.description,hc.cover FROM huaticontent as hc JOIN huativote ON huativote.uid = " + users_data[0].id + " AND hc.id = huativote.hid LIMIT ?,?";
        dataList = await
        query(sql, values);
    }

    //console.log(dataList);
    return dataList;
}

/*
 * 显示当前用户评论（吐槽）过的话题，带分页
 * @parmas values [开始位置,结束位置],用户名
 * @return promise对象：userCommentHuatiListAsync.then(function(data){…})
 */
async
function userCommentHuatiListAsync(values, uname) {

    // //查询当前用户的id
    let users_sql = "SELECT id FROM users WHERE username = ?";
    let users_data = await
    query(users_sql, uname);

    //如果存在该用户
    var dataList = [];
    if (users_data.length != 0) {
        var sql = "SELECT hc.id,hc.title,hc.description,hc.cover FROM huaticontent as hc JOIN huaticomment ON huaticomment.uid = " + users_data[0].id + " AND hc.id = huaticomment.hid GROUP BY huaticomment.hid LIMIT ?,?";
        dataList = await
        query(sql, values);
    }

    //console.log(dataList);
    return dataList;
}

/*
 * 获取指定关键词的话题（搜索），带分页
 * @parmas values [开始位置,结束位置],关键词
 * @return promise对象：searchHuatiListAsync.then(function(data){…})
 */
async
function searchHuatiListAsync(values, keyword) {
    let sql = "SELECT id,title,description,cover,support,opposition FROM huaticontent WHERE title LIKE '%" + keyword + "%' LIMIT ?,?";
    let dataList = await
    query(sql, values);

    let sql2 = "SELECT COUNT(id) as searchcount FROM huaticontent WHERE title LIKE '%" + keyword + "%'";
    let dataList2 = await
    query(sql2, values);

    //console.log(dataList);
    return {
        list: dataList,
        count: dataList2[0].searchcount
    };
}

module.exports = {
    addHuaTiAsync,
    isHuaTiRepeatAsync,
    showHuaTiAsync,
    huatiListAsync,
    userHuatiListAsync,
    huatiVoteAsync,
    huatiCommentAsync,
    showHuaTiCommentAsync,
    userPartakeHuatiListAsync,
    userCommentHuatiListAsync,
    searchHuatiListAsync
};