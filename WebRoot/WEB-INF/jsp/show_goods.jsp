<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<style type="text/css">
body {
	font-family: Arial;
	padding: 20px;
	background-color: #efefef;
}

a {
	color: #000000;
	text-decoration: none;
}

img {
	width: 32%;
	height: 32%;
	border-radius: 10%;
}

img.head {
	width: 23%;
	height: 23%;
	margin-bottom: 20px;
	float: left;
}

img.productphoto {
	display: inline;
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
		<c:forEach items="${goodForms}" var="goodForm">
			<div class="row clearfix" style="margin-top: 50px;">
				<div class="col-md-2 column">
					<img class="head" src="images/${goodForm.userName}/head/${goodForm.userPhoto}" alt="我是头像">
				</div>
				<div class="col-md-2 column">
					<p class="name">卖家昵称:${goodForm.userName}</p>
				</div>
				<div class="col-md-6 column"></div>
				<div class="col-md-2 column">
					<p class="price">￥${goodForm.price}</p>
				</div>
			</div>

			<div class="row clearfix">
				<a href="goodInfoController?goodId=${goodForm.goodId}">
					<div class="col-md-12 column">
						<img class="productphoto"
							src="images/${goodForm.userName}/goodPics/${goodForm.pictures[0]}"
							alt="我是产品图片"> <img class="productphoto"
							src="images/${goodForm.userName}/goodPics/${goodForm.pictures[1]}"
							alt="我是产品图片"> <img class="productphoto"
							src="images/${goodForm.userName}/goodPics/${goodForm.pictures[2]}"
							alt="我是产品图片">
					</div>
				</a>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<p class="detail">${goodForm.goodName}</p>
				</div>
			</div>
			<hr />
			<div class="row clearfix">
				<div class="col-md-12 column">
					<p class="location">来自成都</p>
				</div>
			</div>
		</c:forEach>
		<%@ include file="bar/foot_bar.jsp"%>
	</div>
</body>

</html>
