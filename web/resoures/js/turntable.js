/**
 * 转盘抽奖
 * 适用于移动端，如需要支持IE9及以下，推荐jquery.rotate
 */


var turntable = function (options) {
    if (options.elem.getAttribute("data-rotated")) return;
    var elem = options.elem,    //选择的元素 （必填）
        sum = options.sum,  //总共多少个 （必填）
        num = options.num,  //旋转到第几个 （必填）
        average = 360 / sum,    //每个奖品占用的角度（平均值）
        angle = average * num + 5400,   //最终旋转角度
        duration = options.duration || angle / 1080 * 1000, //旋转持续时间 xx毫秒 （选填）
        callback = options.callback,  //回调函数 （选填）
        timer;
    elem.setAttribute("data-rotated", "1");
    //console.log(num + 1);
    elem.style.cssText = "\
            -webkit-transition:-webkit-transform " + duration + "ms;\
            transition:transform " + duration + "ms;\
            -webkit-transform:rotate(" + angle + "deg);\
            transform:rotate(" + angle + "deg)\
        ";
    clearTimeout(timer);
    timer = setTimeout(function () {
        elem.style.cssText = "\
            -webkit-transition:none;\
            transition:none;\
            -webkit-transform:rotate(" + angle % 360 + "deg);\
            transform:rotate(" + angle % 360 + "deg)\
        ";
        if (callback) {
            callback();
        }
        elem.removeAttribute("data-rotated");
    }, duration);
};







