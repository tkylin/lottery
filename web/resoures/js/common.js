var CM = {
    //load js or css
    loadFile: function(url, callback) {
        var elem;
        if (url.match(/\.js/i)) {
            elem = document.createElement("script");
            elem.src = url + '?ver=' + pet.version;
            document.body.appendChild(elem);
        } else {
            elem = document.createElement("link");
            elem.href = url + '?ver=' + pet.version;
            elem.rel = "stylesheet";
            document.head.appendChild(elem);
        }
        elem.onload = elem.onreadystatechange = function() {
            if (!this.readyState || this.readyState == "loaded" || this.readyState == "complete") {
                if (callback) {
                    callback();
                }
            }
        };
    },

    //获取UR参数
    queryString: function(key) {
        return (document.location.search.match(new RegExp("(?:^\\?|&)" + key + "=(.*?)(?=&|$)")) || ['', null])[1];
    },

    //去除数组中重复的
    unique: function(arr) {
        var result = [],
            hash = {};
        for (var i = 0, elem;
            (elem = arr[i]) != null; i++) {
            if (!hash[elem]) {
                result.push(elem);
                hash[elem] = true;
            }
        }
        return result;
    },

    //本地存储
    storage: {
        ls: window.localStorage,
        setItem: function() {
            return this.ls.setItem.apply(this.ls, arguments);
        },
        getItem: function() {
            return this.ls.getItem.apply(this.ls, arguments);
        },
        removeItem: function() {
            return this.ls.removeItem.apply(this.ls, arguments);
        },
        clear: function() {
            return this.ls.clear.apply(this.ls, arguments);
        }
    },

    //对话框
    alert: function(obj, callback) {
        var content = obj.content || String(obj) || "",
            btnText = obj.btnText || "确定",
            boxClass = obj.boxClass || "",
            alertHtml = '\
                <div class="dialog ' + boxClass + '">\
                    <div class="dialog-box">\
                        <div class="dialog-detail">' + content + "" + '</div>\
                        <div class="dialog-opera">\
                            <button class="dialog-btn dialog-btn-close">' + btnText + '</button>\
                        </div>\
                    </div>\
                    <div class="dialog-overlay"></div>\
                </div>';
        //document.body.insertAdjacentHTML("beforeend", alertHtml);
        $(".dialog").remove();
        $("body").append(alertHtml);
        var dialog = $(".dialog"),
            btnClose = $(".dialog-btn-close");
        btnClose.on("click", function() {
            dialog.remove();
            if (callback) {
                callback();
            }
        });
    },
    confirm: function(obj, callback) {
        var content = obj.content || String(obj) || "",
            okText = obj.okText || "确定",
            cancelText = obj.cancelText || "取消",
            boxClass = obj.boxClass || "",
            confirmHtml = '\
                <div class="dialog ' + boxClass + '">\
                    <div class="dialog-box">\
                        <div class="dialog-detail">' + content + "" + '</div>\
                        <div class="dialog-opera">\
                            <button class="dialog-btn dialog-btn-cancel">' + cancelText + '</button>\
                            <button class="dialog-btn dialog-btn-ok">' + okText + '</button>\
                        </div>\
                    </div>\
                    <div class="dialog-overlay"></div>\
                </div>';
        $(".dialog").remove();
        $("body").append(confirmHtml);
        var dialog = $(".dialog"),
            btnOk = $(".dialog-btn-ok"),
            btnCancel = $(".dialog-btn-cancel"),
            flag = true,
            oprea = function() {
                dialog.remove();
                if (callback) {
                    callback(flag);
                }
            };
        btnOk.on("click", function() {
            flag = true;
            oprea();
        });
        btnCancel.on("click", function() {
            flag = false;
            oprea();
        });
    },
    prompt: function(obj, callback) {
        var content = obj.content || String(obj) || "",
            boxClass = obj.boxClass || "",
            delay = obj.delay || 2000,
            msgHtml = '<div class="dialog-prompt ' + boxClass + '">' + content + '</div>';
        $(".dialog-prompt").remove();
        $("body").append(msgHtml);
        var prompt = $(".dialog-prompt"),
            promptWidth = prompt.width();
        prompt.css({ "margin-left": -promptWidth / 2 });
        if (delay < 0) return;
        setTimeout(function() {
            prompt.css({ "opacity": 0 });
            setTimeout(function() {
                prompt.remove();
                if (callback) {
                    callback();
                }
            }, 500);
        }, delay);
    },
    loading: function(obj) {
        var content = obj.content || String(obj) || "处理中",
            loadingHtml = '<div id="loadingToast" class="weui_loading_toast" style="display: none;">\
            <div class="weui_toast">\
            <div class="weui_loading">\
            <div class="weui_loading_leaf weui_loading_leaf_0"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_1"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_2"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_3"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_4"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_5"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_6"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_7"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_8"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_9"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_10"></div>\
            <div class="weui_loading_leaf weui_loading_leaf_11"></div>\
            </div>\
            <p class="weui_toast_content">' + content + '</p>\
            </div>\
            </div>';
        $('body').append(loadingHtml);
        $('#loadingToast').show();

    },
    removeLoading: function() {
        $('#loadingToast').remove();
    },

    //移动端环境判断
    ua: navigator.userAgent,
    url: window.location.href,
    isShare: function() {
        return this.url.match(/petShareFrom/i);
    },
    isMobile: function() {
        return this.ua.match(/AppleWebKit.*Mobile/i);
    },
    isIos: function() {
        return this.ua.match(/iPhone|iPod|iPad/i);
    },
    isAndroid: function() {
        return this.ua.match(/Android/i)
    },
    isWeixin: function() {
        return this.ua.match(/MicroMessenger/i);
    },

    //rem
    adaptive: function(num, width) {
        var doc = document,
            win = window,
            num = num || 50,
            width = width || 320,
            docElem = doc.documentElement,
            resizeEvent = "orientationchange" in window ? "orientationchange" : "resize",
            recalc = function() {
                var clientWidth = docElem.clientWidth;
                if (!clientWidth) return;
                docElem.style.fontSize = num * ((clientWidth > 640 ? 640 : clientWidth) / width) + 'px';
            };
        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvent, recalc, false);
        doc.addEventListener("DOMContentLoaded", recalc, false);
    },

    //判断是否支持0.5px border
    hair: function() {
        if (window.devicePixelRatio && devicePixelRatio >= 2) {
            var elem = document.createElement('div');
            elem.style.border = '.5px solid transparent';
            document.body.appendChild(elem);
            if (elem.offsetHeight == 1) {
                document.querySelector('html').classList.add('hairlines');
            }
            document.body.removeChild(elem);
        }
    },
    wxShare: function(wxData, type, cb) {
        var url = encodeURIComponent(pet.url.split("#")[0]),
            wxData = wxData || {},
            title = wxData.title || $('title').text() || '有宠',
            shareTimeline = '',
            desc = wxData.desc,
            img = wxData.img || "http://res.ycw.com/app/images/icon-x300.png",
            link = wxData.link || pet.url;
        switch (type) {
            case 1:
                shareTimeline = title;
                break;
            case 2:
                shareTimeline = desc;
                break;
            case 3:
                shareTimeline = title + '，' + desc;
                break;
            default:
                break;
        }
        $.ajax({
            dataType: "jsonp",
            url: pet.weixinRequest + "weixin/share.do?url=" + url + "&jsonCallback=?",
            success: function(data) {
                pet.loadFile("http://res.wx.qq.com/open/js/jweixin-1.0.0.js", function() {
                    var shareData = eval(data);
                    //配置信息
                    wx.config({
                        debug: false,
                        appId: pet.appId,
                        timestamp: shareData.timestamp,
                        nonceStr: shareData.nonceStr,
                        signature: shareData.signature,
                        jsApiList: [
                            'onMenuShareTimeline',
                            'onMenuShareAppMessage',
                            'onMenuShareQQ',
                            'onMenuShareWeibo',
                            'onMenuShareQZone'
                        ]
                    });

                    //分享到...
                    wx.ready(function() {
                        wx.onMenuShareTimeline({
                            title: shareTimeline,
                            link: link,
                            imgUrl: img,
                            success: function() {
                                if (cb) { cb() }
                            },
                            cancel: function() {}
                        });
                        wx.onMenuShareAppMessage({
                            title: title,
                            desc: desc,
                            link: link,
                            imgUrl: img,
                            type: '',
                            dataUrl: '',
                            success: function() {
                                if (cb) { cb() }
                            },
                            cancel: function() {}
                        });
                        wx.onMenuShareQQ({
                            title: title,
                            desc: desc,
                            link: link,
                            imgUrl: img,
                            success: function() {
                                if (cb) { cb() }
                            },
                            cancel: function() {}
                        });
                        wx.onMenuShareQZone({
                            title: title,
                            desc: desc,
                            link: link,
                            imgUrl: img,
                            success: function() {
                                // 用户确认分享后执行的回调函数
                                if (cb) { cb() }
                            },
                            cancel: function() {
                                // 用户取消分享后执行的回调函数
                            }
                        });
                        wx.onMenuShareWeibo({
                            title: title,
                            desc: desc,
                            link: link,
                            imgUrl: img,
                            success: function() {
                                if (cb) { cb() }
                            },
                            cancel: function() {}
                        });
                    });

                })
            },
            error: function(xhr, type) {
                console.log('Ajax error!')
            }
        });
    },
    setWxData: function(wxData) {
        this.wxData = wxData;
    }

};

//替换系统默认对话框
window.alert = pet.alert;
window.confirm = pet.confirm;
window.prompt = pet.prompt;


