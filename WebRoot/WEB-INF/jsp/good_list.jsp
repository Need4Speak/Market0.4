<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>我的发布</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="main.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">   
	div.container{
		background-color: #ffffff;
        width: 100%;
        padding: 20px;
        margin-bottom: 5px;
	}
    
    .good_img {
        width: 100px;
        height: 100px;
        padding: auto auto;
        float: left;
        margin-right: 20px;
    }
    
    p.discribtion {
        font-size: 12px;
        height: 40px;
        width: auto;
        text-overflow: ellipsis;
        overflow: hidden;
    }
    
    p.price {
        color: red;
        font-size: 15px;
        font-style: bold;
    }
    
    p.time {
        color: #708090;
    }
    
    hr {
        border-width: 1px;
        border-color: #efefef;
        margin-top: -5px;
    }
    
    button {
        float: right;
        margin-left: 10px;
        margin-top: -12px;
    }
    
    button.red {
        border-color: red;
    }
    </style>
</head>

<body>
    <div class="container">
        <%@ include file="bar/categories_bar.jsp"%>
            <c:forEach items="${page.list}" var="good">
                <c:if test="${good.status == 1}">
                    <div class="row clearfix" style="margin-top: 50px;">
                        <div class="col-md-4 column">
                            <c:set var="first_pic" value="${fn:split(good.pictures, ', ')[0]}" />
                            <img src="images/${good.user.userName}/goodPics/${first_pic}" class="img-thumbnail good_img">
                        </div>
                        <div class="col-md-8 column">
                            <p class="discribtion">${good.name}</p>
                            <p class="price">￥${good.price}</p>
                            <p class="time">${good.addTime}</p>
                        </div>
                        <hr />
                        <button type="button" class="btn btn-default btn-sm red" onclick="{location.href='goodDeleteController/${good.goodId}'}">删除</button>
                        <button type="button" class="btn btn-default btn-sm" onclick="{location.href='goodEditController?goodId=${good.goodId}'}">编辑</button>
                    </div>
                </c:if>
            </c:forEach>
            <div class="row clearfix" style="margin-bottom: 50px;text-align: center;">
                <div class="col-md-12 column">
                    <p>共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页</p>
                </div>
                <div class="col-md-12 column">
                    <div class="btn-group btn-group-lg">
                        <button class="btn btn-default" type="button" onclick="{location.href='goodListController?pageNo=${page.topPageNo}'}">
                            <em class="glyphicon glyphicon-align-justify"></em> 首页
                        </button>
                        <c:choose>
                            <c:when test="${page.pageNo!=1}">
                                <button class="btn btn-default" type="button" onclick="{location.href='goodListController?pageNo=${page.previousPageNo}'}">
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
                                <button class="btn btn-default" type="button" onclick="{location.href='goodListController?pageNo=${page.nextPageNo}'}">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-default" type="button" disabled="disabled">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:otherwise>
                        </c:choose>
                        <button class="btn btn-default" type="button" onclick="{location.href='goodListController?pageNo=${page.bottomPageNo}'}">
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


