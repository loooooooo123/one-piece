/* 话题搜索结果列表 */

//拼装html
function sethtml(list) {

    //无数据显示
    if (list.length < 1) {
        var nolist_html = '';
        nolist_html += '<div class="huatiBlock left optionAnimate">';
        nolist_html += '	<div class="noList left"> 暂无数据</div>';
        nolist_html += '</div>';
        return nolist_html;
    }


    //dom结构
    function htmldom(list) {
        var allhtml = '';

        //console.log(list);

        //单个dom
        function dom1(data) {

            //计算支持率，反对率
            var st = data.support != null ? parseInt(data.support) : 0;	//支持数
            var on = data.opposition != null ? parseInt(data.opposition) : 0;	//反对数
            var getAllCount = st + on;	//总数
            var getSupport = st != 0 ? (parseFloat(st / getAllCount)) * 100 : 0;	//支持率
            var getOpposition = on != 0 ? (parseFloat(on / getAllCount)) * 100 : 0;	//反对率

            var nobgFlag = (getSupport == 0 && getOpposition == 0) ? ' nobg' : '';

            var html = '';
            html += '<div class="huatiBlock left optionAnimate">';
            html += '	<a href="/huati?id=' + data.id + '">';
            html += '		<img src="' + data.cover + '" class="img left">';
            html += '		<div class="huatiBlock_con left">';
            html += '			<div class="title">' + data.title + '</div>';
            html += '			<div class="desc">' + data.description + '</div>';
            html += '			<div class="voteContent left">';
            html += '				<span class="spanLeft1 right">反对</span>';
            html += '				<span class="spanLeft1 left">支持</span>';
            html += '				<div class="vote left' + nobgFlag + '">';
            html += '					<span class="voteSp1 right">' + getSupport + '%</span>';
            html += '					<div class="vote_line left" style="width:' + getOpposition + '%">' + getOpposition + '%</div>';
            html += '				</div>';
            html += '			</div>';
            html += '		</div>';
            html += '	</a>';
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

    var getK = $("#kekword_ipt").val();

    if (!page) {
        page = 1;
    }

    $.post("/api/searchhuati", {
        page: page,
        keyword: getK
    }, function (data) {
        //显示共找到多少个话题
        $("#searchCount").text(data.data.count);
        //话题列表
        $("#huati_list_view").append(sethtml(data.data.list));
    });
}

$(document).ready(function () {

    //初始化加载数据
    get_huati_list(1);

    var flag = false;
    var page = 2;

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

            get_huati_list(page);
            page++;
        }
    });

});