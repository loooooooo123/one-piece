/* 显示话题评论列表 */

//拼装html列表，参数list 为数据，参数flag 为支持取消 Y或N
function setCommentHtml(list, flag) {

    //dom结构
    function htmldom(list) {
        var allhtml = '';

        //单个dom
        function dom1(data) {

            var html = '';
            if (flag == data.type) {

                //用户未设置头像时显示默认头像
                var thisusercover = data.usercover ? data.usercover : "images/nocover.png";

                //cid为当前吐槽记录id，后续可进行赞同操作
                html += '<div class="userContent_left left" cid="' + data.id + '">';
                html += '	<div class="userContent_block left">';
                html += '		<div class="userContent_block_top left">';
                html += '			<div class="userLive right"> 赞成者165</div>';
                html += '			<img class="userImg left" src="' + thisusercover + '"/>';
                html += '			<div class="userName left">' + data.username + '</div>';
                html += '		</div>';
                html += '		<div class="userContent_block_bottom left">' + data.con + '</div>';
                html += '	</div>';
                html += '</div>';
            }

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
function get_comment_list(page) {

    if (!page) {
        page = 1;
    }

    $.post("/api/huaticomment", {
        page: page,
        id: $("#hid").val()
    }, function (data) {
        //console.log(data);

        $("#comment_list_left").append(setCommentHtml(data.data, "Y"));
        $("#comment_list_right").append(setCommentHtml(data.data, "N"));
    });
}

$(document).ready(function () {

    //初始化加载数据
    get_comment_list(1);

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

            get_comment_list(page);
            page++;
        }
    });

});