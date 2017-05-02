<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>我的收藏</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<h1>我的收藏</h1>
<c:forEach items="${collectionList}" var="collection">
<table>
    <tr>
    	<td><img src="images/${collection.userByBuyerId.userName}/goodPics/${collection.good.pictures}" border="0" width="120px" height="90px" /></td>
        <td>收藏时间：<br>${collection.creationTime}</td>
        <td>${collection.good.name}</td>
        <td>${collection.good.price + collection.good.freight}</td>
        <td><a href="goodInfoController?goodId=${collection.good.goodId}">查看</a></td>
        <c:choose>
		    <c:when test="${collection.status == 1}">
		       	<td><a href="collectionCancelController/${collection.orderId}">取消收藏</a></td>
		    </c:when>
		</c:choose>
		
    </tr>
</table>
<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
</c:forEach>
</div>
<%@ include file="bar/foot_bar.jsp"%>
</body>
</html>
