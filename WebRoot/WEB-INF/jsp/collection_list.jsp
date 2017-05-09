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
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
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
		<c:forEach items="${page.list}" var="collection">
			<c:if test="${collection.status == 1}">
				<div class="row clearfix" style="margin-top: 50px;">
					<div class="col-md-4 column">
						<c:set var="first_pic"
							value="${fn:split(collection.good.pictures, ', ')[0]}" />
						<img
							src="images/${collection.good.user.userName}/goodPics/${first_pic}"
							class="img-thumbnail">
					</div>
					<div class="col-md-8 column">
						<p class="discribtion">${collection.good.name}</p>
						<p class="price">￥${collection.good.price}</p>
						<p class="time">
							<fmt:formatDate value="${collection.good.addTime}" type="both" />
						</p>
					</div>
					<hr />
					<button type="button" class="btn btn-default btn-sm red"
						onclick="{location.href='goodInfoController?goodId=${collection.good.goodId}'}">查看</button>
					<c:choose>
						<c:when test="${collection.status == 1}">
							<button type="button" class="btn btn-default btn-sm"
								onclick="{location.href='collectionCancelController/${collection.orderId}?page=collection_list'}">取消收藏</button>
						</c:when>
					</c:choose>
				</div>
			</c:if>
		</c:forEach>

		<div class="row clearfix" style="margin-bottom: 50px;">
			<div class="col-md-12 column">
				<table align="center">
					<tr>
						<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录
							共${page.totalPages}页 当前第${page.pageNo}页<br> <a
							href="collectionListController?pageNo=${page.topPageNo }"><input
								type="button" name="fristPage" value="首页" /></a> <c:choose>
								<c:when test="${page.pageNo!=1}">

									<a href="collectionListController?pageNo=${page.previousPageNo }"><input
										type="button" name="previousPage" value="上一页" /></a>

								</c:when>
								<c:otherwise>

									<input type="button" disabled="disabled" name="previousPage"
										value="上一页" />

								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${page.pageNo != page.totalPages}">
									<a href="collectionListController?pageNo=${page.nextPageNo }"><input
										type="button" name="nextPage" value="下一页" /></a>
								</c:when>
								<c:otherwise>

									<input type="button" disabled="disabled" name="nextPage"
										value="下一页" />

								</c:otherwise>
							</c:choose> <a href="collectionListController?pageNo=${page.bottomPageNo }"><input
								type="button" name="lastPage" value="尾页" /></a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="bar/foot_bar.jsp"%>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>

