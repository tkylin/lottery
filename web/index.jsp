<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
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
  <script>var ctx='${ctx}';</script>
</head>
<body style="background: url(${ctx}/resoures/images/10.png) no-repeat center;">

<div class="container">
  <div class="lottery">
    <div class="logo"><img src="${ctx}/resoures/images/2.png"></div>
    <%--<div class="slogan"><img src="${ctx}/resoures/images/1.png" alt="转盘活动"></div>--%>
    <div class="plate" data-sum="10">
      <img src="${ctx}/resoures/images/3.png" alt="转盘">
      <div class="pointer">
        <img src="${ctx}/resoures/images/11.png" alt="开始抽奖">
        <a class="btn-rotate" data-count="0" title="开始抽奖">剩余
          3次</a>
      </div>
    </div>
    <div class="explain">
      <div class="input-div">
        <input class="text" type="text" name="userId" id="userId" placeholder="输入ID即可抽奖"
               onfocus="this.placeholder=''" onblur="this.placeholder='输入ID即可抽奖'"/>
        <input id="lottery" class="button" type="button" value="抽奖"/>
      </div>

      <div>
        <p>注意事项：本次活动仅限于天天玩麻将</p>
        <p>用户参与哦，输入ID即可兑奖成功</p>
        <p>本次抽奖活动最终解释权归天天玩麻将所有</p>
      </div>
    </div>
  </div>
</div>

<c:if test="${prizeDesc != null}">
  <script>
    var prize = ${prizeDesc};
  </script>
</c:if>
<script src="${ctx}/resoures/js/zepto.min.js"></script>
<script src="${ctx}/resoures/js/common.js"></script>
<script src="${ctx}/resoures/js/turntable.js"></script>
<script src="${ctx}/resoures/js/lottery.js"></script>

</body>
</html>
