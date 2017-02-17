$(function () {
    var checkCount = "/lotteryNumber";
    var lotteryUrl = "/lottery";

    function lottery() {
        var userId = $("#userId"),
            sessionKey = CM.queryString("sessionKey"),
            recordId = CM.queryString("recordId"),
            bd = $("body"),
            plate = $(".plate"),
            platePhoto = plate.children("img"),
            pointerPhoto = $(".pointer > img"),
            btnRotate = $(".btn-rotate"),
            lottery = $("#lottery"),
            sum = plate.data("sum"),
            lotteryCount = 0;
        btnRotate.text('');

        //关闭弹窗
        function popupClose() {
            var popup = $(".popup, .popup-overlay");
            popup.css("opacity", 0);
            setTimeout(function () {
                popup.remove();
            }, 500);
        }

        bd.on("click", ".opera-close", popupClose);

        function popupTips(text) {
            popupClose();
            bd.append('\
                    <div class="popup-overlay"></div>\
                    <div class="popup popup-gold-confirm">\
                        <div class="matter">' + text + '</div>\
                        <div class="btn-box">\
                            <a class="btn btn-short opera-close">知道了</a>\
                            <a class="btn btn-close opera-close">关闭</a>\
                        </div>\
                    </div>');
        }

        //抽
        function lotteryFn() {
            var userId = $.trim($("#userId").val());
            if (userId) {
                if (/^\d{5}$/.test(userId)) {
                    userId = parseInt(userId);
                } else {
                    popupTips('请输入正确的用户ID');
                    return;
                }
            } else {
                popupTips('请先输入用户ID');
                return;
            }
            var lotteryCount = parseInt(btnRotate.attr("data-count"));
            if (lotteryCount < 1) {
                popupTips("亲，在lottery中消耗5张房卡，即可获得一次抽奖机会哦！！！");
                return;
            }
            lotteryCount--;
            btnRotate.attr("data-count", lotteryCount);
            btnRotate.text("剩余" + lotteryCount + "次");
            $.ajax({
                dataType: "json",
                url: lotteryUrl,
                data: {userId: userId},
                success: function (json) {
                    console.log(json);
                    if (json.code === 0 && json.prize) {
                        var id = json.prize.indexNo;
                        var type = json.prize.type;
                        var icon = json.prize.icon;
                        var name = json.prize.name;
                        var lucky = new turntable({
                            elem: platePhoto[0],
                            sum: sum,
                            num: sum - id + 1,
                            callback: function () {
                                if (type == 4) {
                                    bd.append('<div class="popup-overlay"></div>\
                                                                <div class="popup popup-notprize">\
                                                                    <div class="matter">哎呦，差一点就中奖咯<br/>再来一次吧！</div>\
                                                                    <div class="btn-box">\
                                                                        <a class="btn btn-close opera-close">关闭</a>\
                                                                    </div>\
                                                                </div>');
                                } else {
                                    if (type == 1) {
                                        matter = "温馨提示：您的房卡已成功充值，如有疑问请联系官方客服微信[lottery]。";
                                    } else if (type > 1) {
                                        matter = "温馨提示：请联系官方客服微信[lottery]兑换，并提供游戏大厅截图!";
                                    }
                                    bd.append('<div class="popup-overlay"></div>\
                                            <div class="popup popup-prize">\
                                                <div class="info">\
                                                    <div class="photo"><img src="' + ctx + '/resoures/images/' + icon + '"></div>\
                                                    <div class="name ell">' + name + '</div>\
                                                    <div class="name ell" style="width:300px;">ID:' + userId +'['+json.prize.uniqueCode+ ']</div>\
                                                </div>\
                                                <div class="matter">' + matter + '</div>\
                                                <div class="btn-box">\
                                                    <a class="btn btn-share">确定</a>\
                                                    <a class="btn btn-close opera-close">关闭</a>\
                                                </div>\
                                            </div>');
                                }
                            }
                        });
                    }
                }
            });


        }

        function initLotteryFn() {
            var userId = $.trim($("#userId").val());
            if (userId) {
                if (/^\d{5}$/.test(userId)) {
                    userId = parseInt(userId);
                } else {
                    popupTips('请输入正确的用户ID');
                    return;
                }
            } else {
                popupTips('请先输入用户ID');
                return;
            }
            $.ajax({
                dataType: "json",
                url: checkCount,
                data: {userId: userId},
                success: function (json) {
                    console.log(json);
                    if (json.code === 0) {
                        btnRotate.text("剩余" + json.lotteryCount + "次");
                        btnRotate.attr("data-count", json.lotteryCount);
                    }else if(json.code==-100){
                        popupTips("亲,您操作太频繁,请稍后再试!");
                    } else {
                        popupTips("亲，在lottery中消耗5张房卡，即可获得一次抽奖机会哦！！！");
                    }
                }
            });
        }

        btnRotate.on("click", lotteryFn);
        lottery.on("click", initLotteryFn);

        //模拟抽
        function draw_moni(options) {
            //lotteryCount--;
            btnRotate.text("剩余5次");
            btnRotate.attr("data-drawing", "1");
            var id = options.id, type = options.type;
            var icon =options.icon;
            var name = options.name;
            userId.val(10001);
            var lucky = new turntable({
                elem: platePhoto[0],
                sum: sum,
                num: sum - id + 1,
                callback: function () {
                    if (type == 4) {
                        bd.append('<div class="popup-overlay"></div>\
                                                                <div class="popup popup-notprize">\
                                                                    <div class="matter">哎呦，差一点就中奖咯<br/>再来一次吧！</div>\
                                                                    <div class="btn-box">\
                                                                        <a class="btn btn-close opera-close">关闭</a>\
                                                                    </div>\
                                                                </div>');
                    } else {
                        if (type == 1) {
                            matter = "温馨提示：您的房卡已成功充值，如有疑问请联系官方客服微信[lottery]。";
                        } else if (type > 1) {
                            matter = "温馨提示：请联系官方客服微信[lottery]兑换，并提供游戏大厅截图!";
                        }
                        bd.append('<div class="popup-overlay"></div>\
                        <div class="popup popup-prize">\
                            <div class="info">\
                                <div class="photo"><img src="/resoures/images/' + icon + '"></div>\
                                <div class="name ell">' + name + '</div>\
                                <div class="name ell" style="width:300px;">ID:' + options.uid + '</div>\
                            </div>\
                            <div class="matter">' + matter + '</div>\
                            <div class="btn-box">\
                                <a class="btn btn-share">确定</a>\
                                <a class="btn btn-close opera-close">关闭</a>\
                            </div>\
                        </div>');
                    }
                }
            });
        }
        //测试中奖
        //var options={id:1,type:2,icon:'iphone7.png',name:'iPhone 7',uid:19969};
        //draw_moni(options);
    }

    lottery();
});


