/**
 * 测试json传参
 */

var vue1 = new Vue({
    el: "#div1",
    data: function () {
        return {
            list: [],
            user: {
                id: null,
                username: null,
                sex: null
            },
            id: 1
        };
    },
    monted: function () {

    },
    methods: {
        submit1: function () {
            var that = this;
            $.post(baseInfo.url + "/user/json", {
                id: that.id++,
                username: that.user.username,
                sex: that.user.sex
            }, function (data) {
                console.log(data);
                var data1 = JSON.parse(data);
                that.list.push(data1);
            });
        },
        submit2: function () {
            var that = this;
            $.post(baseInfo.url + "/user/xml", {
                id: that.id++,
                username: that.user.username,
                sex: that.user.sex
            }, function (data) {
                console.log(data);

                //用jquery解析xml
                var dom = $(data);
                var json1 = {
                    "id": dom.find("id").text(),
                    "username": dom.find("username").text(),
                    "sex": dom.find("sex").text()
                };

                //var data1=JSON.parse(data);
                that.list.push(json1);
            });
        }
    }
});