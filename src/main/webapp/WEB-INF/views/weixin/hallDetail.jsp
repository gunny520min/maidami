<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
    <title>${hall.typeName}</title>
    <link rel="shortcut icon" href="${shost}/weixin/images/favicon.ico"/>
    <link rel="stylesheet" href="${shost}/weixin/css/base.css"/>
    <link rel="stylesheet" href="${shost}/weixin/css/app.css"/>
  </head>
  <body class="details bg-muted">
    <div class="banner">
      <div class="slider swipe">
        <div class="swipe-wrap">
          <c:forEach var="item" items="${carHallPics }">
            <a><img src="${ item.img }"></a>
          </c:forEach>
        </div>
      </div>
    </div>
    <div class="name">
      <h1 class="large">${hall.typeName}</h1>
      <span class="small">参考最低价：<em class="text-warning">${hall.priceLowest}-${hall.priceMost}</em></span>
    </div>
    <div class="list">
      <c:forEach var="item" items="${carHallModels}">
        <a class="item item-oneline item-icon-right" href="/wx/view/carParam?id=${item.id }">
          <span>${item.carModelName}</span>
          <i class="icon icon-more"></i>
        </a>  
      </c:forEach>
    </div>
    
    <footer class="bar fixed bar-button">
      <c:choose>
        <c:when test="${wxuser !=null and wxuser.id != null}">
          <a class="button button-primary button-block" href="/wx/view/appointKanche?name=<c:out value='${hall.typeName}' />">预约看车</a>
        </c:when>
        <c:otherwise>
          <a class="button button-primary button-block action login-required">预约看车</a>
        </c:otherwise>
      </c:choose>
    </footer>

    <script id="loginRequired" type="text/swig-template">
      <div class="masklayer flex">
        <div class="modal col">
          <div class="wrap">
            <h3 class="title text-center">温馨提示</h3>
            <div class="content text-center small">您需要先注册成为会员才可以哟~</div>
          </div>
          <div class="footer">
            <button class="text-center button text-primary cancel">取消</button>
            <a class="text-center button text-primary confirm" href="/wx/view/wxuserEdit">确定</a>
          </div>
        </div>
      </div>
    </script>
    <script src="${shost}/weixin/js/base.js"></script>
    <script src="${shost}/weixin/js/hall.js"></script>
  </body>
</html>