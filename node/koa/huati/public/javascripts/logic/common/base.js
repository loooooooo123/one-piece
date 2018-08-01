var base = {};

//基础api路径
base.apiUrl = "localhost:3000";

//存储本地存储
base.setStoreage = function (key, val) {
    window.localStorage.setItem(key, val);
}
//获取本地存储，如果存在第二个参数则转换成JSON
base.getStoreage = function (key, flag) {
    return flag ? JSON.parse(window.localStorage.getItem(key)) : window.localStorage.getItem(key);
}
//清空本地存储
base.delStoreage = function (key) {
    window.localStorage.removeItem(key);
}