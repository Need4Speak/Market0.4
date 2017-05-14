<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page language="java" import="com.pancake.entity.*,com.pancake.dao.*, java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
    img {
        width: 100%;
        height: auto;
        margin-bottom: 20px;
    }
    
    img.head {
        width: 50px;
        height: 50px;
        float: left;
        border-radius: 20%;
    }
    
    .name {
        text-align: left;
        font-size: 12px;
        display: inline;
        margin-top: 20px;
    }
    
    .price {
        font-size: 16px;
        color: red;
        font-style: bold;
        text-align: right;
    }
    
    .detail {
        font-size: 15px;
    }
    
    hr {
        height: 1px;
        border: none;
        border-top: 1px solid #555555;
    }
    </style>
</head>

<body>
    <div class="container">
    	<%@ include file="bar/categories_bar.jsp"%>
        <div class="row clearfix" style="margin-top: 50px;">
            <div class="col-md-12 column">
                <img class="head" src="images/${goodForm.userName}/head/${userPhoto}" alt="我是头像">
            </div>
            <div class="col-md-12 column">
                <p class="name">卖家：${goodForm.userName}</p>
            </div>
            <div class="col-md-12 column">
                <p class="tel">手机：110</p>
            </div>
            <hr>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <p class="detail">商品名： ${goodForm.goodName}</p>
                <p>价格：￥${goodForm.price}</p>
                <hr>
                <p class="detail">详情：</p>
                <p class="detail">${goodForm.description}</p>
                <hr>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <c:forEach items="${goodForm.pictures}" var="picture">
                    <img class="productphoto" src="images/${goodForm.userName}/goodPics/${picture}" alt="我是产品图片">
                </c:forEach>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column" style="margin-bottom: 50px;">
                <c:choose>
                    <c:when test="${userName != null}">
                        <c:choose>
                            <c:when test="${collection == null || collection.status == 0 || collection.status == null}">
                                <form action="collectController?goodId=${goodForm.goodId}" method="post">
                                    <input type="submit" class="btn btn-default btn-block active btn-danger" value="收藏">
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="collectionCancelController/${collection.orderId}?page=good_info" method="post">
                                    <% request.setAttribute("page", "good_info"); %>
                                        <input type="submit" class="btn btn-default btn-block active btn-danger" value="取消收藏">
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <form action="loginBarController" method="post">
                            <input type="submit" class="btn btn-default btn-block active btn-danger" value="登录后收藏">
                        </form>
                    </c:otherwise>
                </c:choose>
                </form>
            </div>
        </div>
    </div>
    <%@ include file="bar/foot_bar.jsp"%>
</body>

</html>
