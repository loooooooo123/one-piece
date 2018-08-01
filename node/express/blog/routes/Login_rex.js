var Login_rex = {};


//访问权限，判断是否已登录
Login_rex.checkLogin = function (req, res) {
    if (!req.session.user) {
        return res.redirect('/login');
    }
}

// 判断是否已登陆，防止在登录时注册
Login_rex.LoginYes = function (req, res) {
    if (!req.session.user) {
        return res.redirect('back');
    }
}

module.exports = Login_rex;
