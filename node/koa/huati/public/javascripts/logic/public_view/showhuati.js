/* 显示话题内容 */

//话题dom结构
function htmldom(data) {
    var html = '';
    html += '<div class="relePar">'
    html += '	<div class="contentTitle bodyBg borderRadius">';
    html += '		<h2 class="h2">' + data.title + '</h2>';
    html += '		<div class="comment_count">有 <span class="text">' + data.allcom + '</span>人参与讨论 <span class="uname">发起者：<span class="text">' + data.username + '</span></span></div>';
    html += '		<div class="Introduction">';
    html += '			<div class="rele1">'
    html += '				<div class="Introduction_sup">“</div>';
    html += '				<div class="Introduction_con">' + data.description + '</div>';
    html += '				<div class="Introduction_sub">”</div>';
    html += '			</div>';
    html += '			<div class="contentText">';
    html += '				<div class="h3"></div>';
    html += '				<div class="contentText_con">' + data.con + '</div>';
    html += '			</div>';
    html += '		</div>';
    html += '	</div>';
    html += '</div>';

    return html;
}
//话题支持反对数dom结构
function htmldom2(data) {
    var html = '';
    html += '<div class="rateOfSupport_circle c2 right" flag="N">';
    html += '	<div class="line1 left">反对</div>';
    html += '	<div class="line1 line2 left">' + data.opposition + '</div>';
    html += '</div>';
    html += '<div class="rateOfSupport_circle c1 left" flag="Y">';
    html += '	<div class="line1 left">支持</div>';
    html += '	<div class="line1 line2 left">' + data.support + '</div>';
    html += '</div>';
    html += '<div class="rateOfSupport_vs">VS</div>';

    return html;
}


//请求数据，话题内容
function get_huati_list() {
    $.post("/api/showhuati", {
        id: $("#hid").val(),
    }, function (data) {
        //console.log(data);
        $("#huati_content_show").append(htmldom(data.data));
        $("#huati_vote_show").append(htmldom2(data.data));
        //支持反对
        vote_info();
    });
}

//请求数据，支持反对
function huati_vote(flag) {

    //提示文字内容
    var flagtext = '支持成功';
    if (flag == "N") {
        flagtext = "反对成功";
    }

    var params = {
        username: base.getStoreage('username', false),
        token: base.getStoreage('token', false),
        id: $("#hid").val(),
        vote: flag
    };

    //判断是否登录
    if (params.username == null && params.token == null) {
        location.href = "/login";
        return;
    }

    $.post("/api/huativote", params, function (data) {
        if (data.status == 1) {
            alertTpl(flagtext, 1.5);
            setTimeout(function () {
                window.history.go(0);
            }, 1500);
        } else {
            alertTpl("您已经吐槽过该话题", 1.5);
        }
    });
}

//支持反对
function vote_info() {
    $(".rateOfSupport_circle").click(function () {
        huati_vote($(this).attr('flag'));
    });
}

$(function () {
    //初始化加载数据
    get_huati_list();
});



