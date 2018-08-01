// 引入mongodb库模块
var mongodb = require('./db');

var User = {};

// 用户信息存储
User.save = function (user, callback) {

    // 打开数据库
    mongodb.open(function (err, db) {

        // 捕获错误
        if (err) {
            return callback(err);   // 错误，返回err信息
        }

        // 读取users集合
        db.collection('users', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);   // 错误，返回err信息
            }

            // 将用户数据插入users集合
            collection.insert(user, {
                safe: true
            }, function (err, user) {
                mongodb.close();
                if (err) {
                    return callback(err);   // 错误，返回err信息
                }
                // 成功，err为null，并返回存储后的用户信息
                callback(null, user == null ? null : user);
            });
        });

    });
}

// 读取用户信息
User.get = function (user, callback) {

    // 打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            console.log('数据库读取错误', err);
            mongodb.close();
            return callback(err);   // 错误，返回err信息
        }

        // 读取users集合
        db.collection('users', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);   // 错误，返回err信息
            }

            // 查询
            collection.findOne({
                name: user.name
            }, function (err, user) {
                mongodb.close();
                if (err) {
                    return callback(err);   // 错误，返回err信息
                }
                // 成功，err为null，并返回存储后的用户信息
                callback(null, user == null ? null : user);
            });
        });
    });
}

module.exports = User;

