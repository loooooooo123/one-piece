/* 显示我参与过的话题列表 */

//拼装html
function sethtml(list) {

    //无数据显示
    if (!list) {
        var nolist_html = '';
        nolist_html += '<div class="huatiBlock left optionAnimate">';
        nolist_html += '	<div class="huati_line">';
        nolist_html += '		<div class="noList left"> 暂无数据</div>';
        nolist_html += '	</div>';
        nolist_html += '</div>';
        return nolist_html;
    }


    //dom结构
    function htmldom(list) {
        var allhtml = '';

        //console.log(list);

        //单个dom
        function dom1(data) {
            var html = '';
            html += '<div class="huatiBlock left optionAnimate">';
            html += '	<div class="huati_line">';
            html += '		<a href="/huati?id=' + data.id + '">';
            html += '			<img class="img left" src="' + data.cover + '"/>';
            html += '			<div class="huati_line_con left">';
            html += '				<div class="title">' + data.title + '</div>';
            html += '				<div class="desc">' + data.description + '</div>';
            html += '				<div class="move right">查看话题&gt;&gt;</div>';
            html += '			</div>';
            html += '		</a>';
            html += '	</div>';
            html += '</div>';

            return html;
        }

        //拼装
        for (var a = 0; a < list.length; a++) {
            allhtml += dom1(list[a]);
        }


        return allhtml;
    }

    //有数据正常渲染列表
    return htmldom(list);

}

//请求数据
function get_huati_list(page) {

    if (!page) {
        page = 1;
    }

    $.post("/api/showuserpartakehuati", {
        username: base.getStoreage('username', false),
        token: base.getStoreage('token', false),
        page: page
    }, function (data) {
        //console.log(data);

        $("#huati_list_view").append(sethtml(data.data));
    });
}

$(document).ready(function () {

    //初始化加载数据
    get_huati_list(1);

    var flag = false;

    //滚动渲染列表
    $(window).scroll(function () {

        if (flag) {
            //数据加载中
            return false;
        }

        //   if ($(document).scrollTop()<=0){
        // 	alert("滚动条已经到达顶部为0");
        //   }

        if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
            flag = true;
            //alert("滚动条已经到达底部为" + $(document).scrollTop());

            get_huati_list(2);
        }
    });

});