/* 异步mysql封装 */

//连接mysql
const mysql = require('mysql')
const pool = mysql.createPool({
    host: '127.0.0.1',
    user: 'root',
    password: '123456',
    database: 'huati',
})

/*
 * 执行sql语句的query方法
 * 参数sql为sql语句，形式为 INSERT INTO 表名(字段名,字段名,…) VALUES(?,?,…)
 * values为各个字段的值 数组形式 [值1,值2,…]
 */
let query = function (sql, values) {
    return new Promise(( resolve, reject ) = > {
            pool.getConnection(function (err, connection) {
                if (err) {
                    reject(err)
                } else {
                    connection.query(sql, values, ( err, rows) = > {

                        if ( err )
                    {
                        reject(err)
                    }
                else
                    {
                        resolve(rows)
                    }
                    connection.release()
                }
                )
            }
}
)
})
}

module.exports = {query}