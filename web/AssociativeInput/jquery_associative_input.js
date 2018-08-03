/* jquery 联想输入 */

(function ($) {
    /*
     @params domid string 联想父级div的节点id
     */
    $.fn.AssociativeInput = function (domid) {

        //模拟——搜索列表数据
        var getData = [
            "鞍山华夏电力电子设备有限公司",
            "鲁变",
            "友讯",
            "华商三优",
            "京东方"
        ];

        var flag = true;
        var thisipt = $(this);

        //获取与搜索词相关的数据
        function getFilterData(v) {
            var arr = [];
            for (var n = 0; n < getData.length; n++) {
                var reg = new RegExp(v);
                //如果字符串中不包含目标字符会返回-1
                if (getData[n].match(reg)) {
                    arr.push(getData[n]);
                }
            }
            return arr;
        }

        //输出查询列表
        function setHtml(data) {
            var html = '';
            for (var a = 0; a < data.length; a++) {
                html += '<div class="line">' + data[a] + '</div>';
            }
            $("#" + domid).empty().append(html);
            $('.line').on("click", function () {
                thisipt.val($(this).text());
                $("#" + domid).empty();
            });
        }

        //开始搜索
        $(this).keyup(function () {
            if (flag) {
                var getD = getFilterData($(this).val());
                setHtml(getD);
                flag = false;
                setTimeout(function () {
                    flag = true;
                }, 1000);
            }
        });

        return $(this);
    }
})(jQuery);