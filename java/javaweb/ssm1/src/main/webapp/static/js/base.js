//基础js

var baseInfo = {};

baseInfo.url = "/ssm1";
baseInfo.rd = function () {
    var random = Math.floor(Math.random() * (m - n + 1) + n);
    return random;
}