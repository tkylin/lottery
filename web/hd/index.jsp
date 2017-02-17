<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    request.setAttribute("ctx", path);
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${tumEvent.title}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no"/>
    <link rel="stylesheet" href="${ctx}/resoures/css/global.css"/>
    <link rel="stylesheet" href="${ctx}/resoures/css/lottery.css"/>
    <script>var ctx = '${ctx}';</script>
</head>
<body style="background: url(${ctx}/resoures/images/10.png) no-repeat center;">

<div class="container">
    <div class="input-div">
        <input class="text" type="text" name="uniqueCode" id="uniqueCode" placeholder="输入中奖编号"
               onfocus="this.placeholder=''" onblur="this.placeholder='输入中奖编号'"/>
        <input id="lottery" class="button" type="button" value="查询"/>
    </div>
    <div class="lottery">
        <div class="popup popup-prize" style="margin-top:-300px;">
            <div class="info">
            </div>
            <div class="matter" style="text-align: center;"><input id="expiry" class="expiry" type="button" value="兑奖"/>
            </div>
        </div>

    </div>
</div>

</body>
<script src="${ctx}/resoures/js/zepto.min.js"></script>
<script>
    $(document).ready(function () {
        $(".lottery").hide();
        $("#lottery").on("click", check);
        $("#expiry").on("click", expiry);
    });
    function check() {
        var uniqueCode = $("#uniqueCode").val();
        $.ajax({
            dataType: "json",
            url: ctx + '/admin/check',
            data: {uniqueCode: uniqueCode},
            success: function (json) {
                console.log(json);
                if (json.status === 200) {
                    $(".info").html('<div class="photo"><img src="' + ctx + '/resoures/images/' + json.prize.icon + '"></div>\
                        <div class="name ell">' + json.prize.name + '</div>\
                        <div class="name ell" style="width:300px;">ID:' + json.prize.uid + '[' + json.prize.uniqueCode + ']</div>');
                    if (json.prize.status === 2) {
                        $("#expiry").hide();
                    } else {
                        $("#expiry").show();
                    }
                    $(".lottery").show();
                } else {
                    alert(json.desc);
                }
            }
        });
    }

    function expiry() {
        var uniqueCode = $("#uniqueCode").val();
        $.ajax({
            dataType: "json",
            url: ctx + '/admin/expiry',
            data: {uniqueCode: uniqueCode},
            success: function (json) {
                check();
                console.log(json);
                alert("兑奖成功!");
            }
        });
    }


</script>
</html>
