<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>我的发布</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    body {
        background-color: #efefef;
        padding-right: 20px;
        padding-top: 10px;
    }
    
    div {
        background-color: #ffffff;
    }
    
    div.clearfix {
        margin-bottom: 15px;
    }
    
    img {
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
    	<c:forEach items="${goods}" var="good">
			<c:if test="${good.status == 1}"> 
		        <div class="row clearfix" style="margin-top: 50px;">
		            <div class="col-md-4 column">
		            	<c:set var="first_pic" value="${fn:split(good.pictures, ', ')[0]}" />
		                <img src="images/${good.user.userName}/goodPics/${first_pic}" class="img-thumbnail">
		            </div>
		            <div class="col-md-8 column">
		                <p class="discribtion">${good.name}</p>
		                <p class="price">￥${good.price}</p>
		                <p class="time">${good.addTime}</p>
		            </div>
		            <hr/>
		            <button type="button" class="btn btn-default btn-sm red" onclick="{location.href='goodDeleteController/${good.goodId}'}">删除</button>
		            <button type="button" class="btn btn-default btn-sm" onclick="{location.href='goodEditController/${good.goodId}'}">编辑</button>
		        </div>
		     </c:if>
		 </c:forEach>

    </div>
    <%@ include file="bar/foot_bar.jsp"%>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
