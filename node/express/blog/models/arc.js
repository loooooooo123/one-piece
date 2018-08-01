var mongodb = require('./db');
var ObjectID = require('mongodb').ObjectID; //根据id查询

var Arc = {};

/* 新增 */
//新增文章，传入json数据，返回callback(错误/或者空)
Arc.save = function (post, callback) {
    var date = new Date();

    //存储各种时间格式，方便以后扩展
    var time = {
        date: date,
        year: date.getFullYear(),
        month: date.getFullYear() + "-" + (date.getMonth() + 1),
        day: date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate(),
        minute: date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " +
        date.getHours() + ":" + (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()),
        reply: [],
        pv: 0
    }

    post.time = time;

    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            return callback(err);
        }
        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }
            //将文档插入 posts 集合
            collection.insert(post, {
                safe: true
            }, function (err) {
                mongodb.close();
                if (err) {
                    return callback(err);//失败！返回 err
                }
                callback(null);//返回 err 为 null
            });
        });
    });
};

/* 新增 */
//新增一条留言/回复，返回callback(错误/或者空)
Arc.replyNew = function (id, replys1, callback) {

    var date = new Date();

    //获取当前时间
    var time = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " +
        date.getHours() + ":" + (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes());

    replys1.datetime = time;

    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            mongodb.close();
            return callback(err);
        }
        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }
            //将文档插入 posts 集合
            collection.update({
                _id: ObjectID(id)
            }, {
                $push: {'reply': replys1}
            }, {
                safe: true
            }, function (err) {
                mongodb.close();
                if (err) {
                    return callback(err);//失败！返回 err
                }
                callback(null);//返回 err 为 null
            });
        });
    });
};

/* 删除 */
//删除文章，传入id、session里的用户名，返回callback(Y/N)
Arc.remove = function (id, sessionUser1, callback) {

    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            mongodb.close();
            return callback(err);
        }

        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }

            var getUser1 = '';

            // 查询
            collection.findOne({
                _id: ObjectID(id)
            }, function (err, user) {
                mongodb.close();
                if (err) {
                    getUser1 = 'NoUser';   // 错误，返回err信息
                    return;
                }

                //如果不是当前用户的文章，则不可删除
                if (user.name != sessionUser1) {
                    getUser1 = 'NoUser';
                } else {
                    getUser1 = '';
                }

            });

            //删除
            if (getUser1 == '') {
                //根据用户名、日期和标题查找并删除一篇文章
                collection.remove({
                    _id: ObjectID(id),
                }, function (err, result) {

                    mongodb.close();
                    if (err) {
                        getUser1 = 'NoUser';
                    }
                });

                if (result.result.ok == 1) {
                    callback('Y');
                } else {
                    callback('N');
                }

            } else {
                callback('N');
            }

        });
    });
};

/* 修改 */
//修改指定id的一篇文章，返回callback(错误/或者空)
Arc.update = function (id, title1, text1, callback) {
    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            return callback(err);
        }
        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }
            //更新文章内容
            collection.update({
                _id: ObjectID(id)
            }, {
                $set: {title: title1, text: text1}
            }, function (err) {
                mongodb.close();
                if (err) {
                    return callback(err);
                }
                callback(null);
            });
        });
    });
};

/* 修改 */
//修改文章访问数
Arc.updatePv = function (id, callback) {
    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            return callback(err);
        }
        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }
            //更新文章内容
            collection.update({
                _id: ObjectID(id)
            }, {
                $inc: {"pv": 1}
            }, function (err) {
                mongodb.close();
                if (err) {
                    return callback(err);
                }
                callback(null);
            });
        });
    });
};

/* 查询 */
//获取分页文章，返回callback(错误/数据, 特定查询的文档数)
//参数Num1为每页取多少条数据
//参数page为当前页码
Arc.getPageList = function (Num1, page, callback) {

    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            return callback(err);
        }
        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }

            //使用 count 返回特定查询的文档数 total
            collection.count(function (err, total) {

                if (page > Math.ceil(total / Num1)) {
                    page = Math.ceil(total / Num1);
                }

                //根据 query 对象查询文章
                collection.find({},
                    {
                        skip: (page - 1) * Num1,
                        limit: Num1
                    }).sort({
                        time: -1
                    }).toArray(function (err, docs) {
                        mongodb.close();
                        if (err) {
                            return callback(err);//失败！返回 err
                        }

                        callback(null, docs, total);//成功！以数组形式返回查询的结果
                    });
            });

        });

    });
};

/* 查询 */
//获取指定用户分页文章，返回callback(错误/数据)
//参数Num1为每页取多少条数据
Arc.getUserTen = function (Num1, page, name, callback) {

    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            return callback(err);
        }

        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }

            //使用 count 返回特定查询的文档数 total
            collection.find({name: name}).count(function (err, total) {

                if (page > Math.ceil(total / Num1)) {
                    page = Math.ceil(total / Num1);
                }

                if (!name) {
                    return callback('用户名为空');//失败！返回 err
                }

                //根据 query 对象查询文章
                collection.find({
                        name: name
                    },
                    {
                        skip: (page - 1) * Num1,
                        limit: Num1
                    }).sort({
                        time: -1
                    }).toArray(function (err, docs) {
                        mongodb.close();
                        if (err) {
                            return callback(err);//失败！返回 err
                        }

                        //对html进行转义，防止攻击
                        // docs.forEach(function(doc,index){
                        //    doc.text = codeDemo.html_decode(doc.text);
                        // });

                        callback(null, docs, total);//成功！以数组形式返回查询的结果
                    });

            });
        });
    });
};

/* 查询 */
//获取指定id的一篇文章，返回callback(错误/数据)
Arc.findOneArc = function (id, callback) {

    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            mongodb.close();
            return callback(err);
        }

        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }

            // 查询
            collection.findOne({
                _id: ObjectID(id)
            }, function (err, user) {
                mongodb.close();
                if (err) {
                    return callback(err);
                }
                callback(null, user);
            });

        });
    });
};

/* 查询 */
//搜索指定关键词的所有文章，返回callback(错误/数据)
Arc.findKeyWordArc = function (keyWord, callback) {

    //打开数据库
    mongodb.open(function (err, db) {
        if (err) {
            mongodb.close();
            return callback(err);
        }

        //读取 posts 集合
        db.collection('posts', function (err, collection) {
            if (err) {
                mongodb.close();
                return callback(err);
            }

            // 查询
            collection.find({
                title: {$regex: keyWord}
            }).toArray(function (err, docs) {
                mongodb.close();
                if (err) {
                    return callback(err);//失败！返回 err
                }

                callback(null, docs);//成功！以数组形式返回查询的结果
            });
            ;

        });
    });
};

module.exports = Arc;