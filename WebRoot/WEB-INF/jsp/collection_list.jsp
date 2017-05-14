<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>我的收藏</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <style type="text/css">

    
    .price {
        font-size: 16px;
        color: red;
        font-style: bold;
        text-align: right;
    }
    
    button {
        float: right;
        margin-left: 10px;
        margin-top: -20px;
    }
    
    hr {
        border-width: 3px;
        border-color: #efefef;
        margin-top: 0px;
    }
    </style>
</head>

<body>
    <div class="container">
        <%@ include file="bar/categories_bar.jsp"%>
            <c:forEach items="${page.list}" var="collection">
                <c:if test="${collection.status == 1}">
                    <div class="row clearfix divcss5">
                        <div class="col-xs-4 column">
                            <c:set var="first_pic" value="${fn:split(collection.good.pictures, ', ')[0]}" />
                            <img src="images/${collection.good.user.userName}/goodPics/${first_pic}" class="img-rounded imgcss5">
                        </div>
                        <div class="col-xs-4 column">
                            <div class="div-heighthalf">
                                <p class="text-left center-vertical">
                                    <strong>${collection.good.name}</strong>
                                    <span class="discribtion price">￥${collection.good.price}</span>
                                </p>
                            </div>
                            <div class="div-heighthalf">
                                <p class="text-left center-vertical">
                                    <fmt:formatDate value="${collection.good.addTime}" type="both" />
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4 column">
                            <div class="div-heighthalf">
                                <p class="text-right center-vertical price">
                                    <button type="button" class="btn btn-default btn-sm red" onclick="{location.href='goodInfoController?goodId=${collection.good.goodId}'}">查看</button>
                                </p>
                            </div>
                            <div class="div-heighthalf">
                                <p class="text-right center-vertical">
                                    <c:choose>
                                        <c:when test="${collection.status == 1}">
                                            <button type="button" class="btn btn-default btn-sm" onclick="{location.href='collectionCancelController/${collection.orderId}?page=collection_list'}">取消收藏</button>
                                        </c:when>
                                    </c:choose>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
            <div class="row clearfix" style="margin-bottom: 60px;margin-top: 20px;text-align: center;">
                <div class="col-xs-12 column" style="height: 50px">
                    <p>共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页
                    </p>
                </div>
                <div class="col-xs-12 column">
                    <div class="btn-group btn-group-md">
                        <button class="btn btn-default" type="button" onclick="{location.href='collectionListController?pageNo=${page.topPageNo}'}">
                            <em class="glyphicon glyphicon-align-justify"></em> 首页
                        </button>
                        <c:choose>
                            <c:when test="${page.pageNo!=1}">
                                <button class="btn btn-default" type="button" onclick="{location.href='collectionListController?pageNo=${page.previousPageNo}'}">
                                    <em class="glyphicon glyphicon-align-left"></em> 上一页
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-default" type="button" disabled="disabled">
                                    <em class="glyphicon glyphicon-align-left"></em> 上一页
                                </button>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${page.pageNo != page.totalPages}">
                                <button class="btn btn-default" type="button" onclick="{location.href='collectionListController?pageNo=${page.nextPageNo}'}">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-default" type="button" disabled="disabled">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:otherwise>
                        </c:choose>
                        <button class="btn btn-default" type="button" onclick="{location.href='collectionListController?pageNo=${page.bottomPageNo}'}">
                            <em class="glyphicon glyphicon-align-justify"></em> 尾页
                        </button>
                    </div>
                </div>
            </div>
            <%@ include file="bar/foot_bar.jsp"%>
    </div>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>

