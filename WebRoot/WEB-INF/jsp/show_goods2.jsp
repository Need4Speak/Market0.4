<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link href="main.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">  
    div.container {
        width: 100%;
        padding: 20px;
        background-color: #ffffff;
        margin-bottom: 5px;
    }
    
    img.head {
        width: 23%;
        height: 23%;
        margin-bottom: 20px;
        float: left;
        margin-right: 20px;
    }
    
    img.img-rounded {
        width: 70%;
        height: 35%;
    }
    
    .name {
        text-align: left;
        font-size: 12px;
        display: inline;
    }
    
    .price {
        font-size: 16px;
        color: red;
        font-style: bold;
        text-align: right;
    }
    
    .detail {
        margin-top: 20px;
        font-size: 15px;
    }
    
    .location {
        text-align: right;
        color: blue;
        font-size: 10px;
    }
    </style>
</head>

<body>
    <div class="container">
        <%@ include file="bar/categories_bar.jsp"%>
            <c:forEach items="${page.list}" var="good">
                <div class="row clearfix" style="margin-top: 50px;">
                    <div class="col-md-2 column">
                        <img class="img-rounded" src="images/${good.user.userName}/head/${good.user.userPhoto}" alt="我是头像">
                    </div>
                    <div class="col-md-2 column">
                        <p class="name">卖家昵称:${good.user.userName}</p>
                    </div>
                    <div class="col-md-6 column"></div>
                    <div class="col-md-2 column">
                        <p class="price">￥${good.price}</p>
                    </div>
                </div>
                <div class="row clearfix">
                    <a href="goodInfoController?goodId=${good.goodId}">
                        <div class="col-md-12 column">
                            <img class="productphoto" src="images/${good.user.userName}/goodPics/${fn:split(good.pictures, ', ')[0]}" alt="我是产品图片">
                        </div>
                    </a>
                </div>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <p class="detail">${good.name}</p>
                    </div>
                </div>
                <hr />
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <p class="location">望江校区</p>
                    </div>
                </div>
            </c:forEach>
            <div class="row clearfix" style="margin-bottom: 50px;text-align: center;">
                <div class="col-md-12 column">
                    <p>共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页</p>
                </div>
                <div class="col-md-12 column">
                    <div class="btn-group btn-group-lg">
                        <button class="btn btn-default" type="button" onclick="{location.href='showGoodsController?pageNo=${page.topPageNo}'}">
                            <em class="glyphicon glyphicon-align-justify"></em> 首页
                        </button>
                        <c:choose>
                            <c:when test="${page.pageNo!=1}">
                                <button class="btn btn-default" type="button" onclick="{location.href='showGoodsController?pageNo=${page.previousPageNo}'}">
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
                                <button class="btn btn-default" type="button" onclick="{location.href='showGoodsController?pageNo=${page.nextPageNo}'}">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-default" type="button" disabled="disabled">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:otherwise>
                        </c:choose>
                        <button class="btn btn-default" type="button" onclick="{location.href='showGoodsController?pageNo=${page.bottomPageNo}'}">
                            <em class="glyphicon glyphicon-align-justify"></em> 尾页
                        </button>
                    </div>
                </div>
            </div>
            <%@ include file="bar/foot_bar.jsp"%>
    </div>
</body>

</html>

