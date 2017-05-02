<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<h1>已买</h1>
<a href="showGoodsController">返回首页</a><br/>
<a href="SellerOrderListController?orderStatus=1">待支付</a>    
<a href="SellerOrderListController?orderStatus=2">已支付</a>    
<a href="SellerOrderListController?orderStatus=0">已取消</a>    
<a href="SellerOrderListController?orderStatus=-1">全部订单</a>
<c:forEach items="${orderList}" var="order">
<table>
    <tr>
    	<td><img src="images/${order.userByBuyerId.userName}/goodPics/${order.good.pictures}" border="0" width="120px" height="90px" /></td>
        <td>创建时间：<br>${order.creationTime}</td>
        <td>${order.good.name}</td>
        <td>${order.good.price + order.good.freight}</td>
        <td><a href="orderDetailController/${order.orderId}">查看</a></td>
        <c:choose>
		    <c:when test="${order.status == 0}">
		       	<td>订单已取消</td>
		       	<td>取消时间：<br>${order.cancelTime} </td>
		    </c:when>
		    <c:when test="${order.status == 1}">
		       	<td>买家未支付</td>
		       	<td><a href="orderCancelController/${order.orderId}">取消</a></td>
		    </c:when>
		    <c:when test="${order.status == 2}">
		       	<td>已支付</td>
		    </c:when>
		</c:choose>
		
    </tr>
</table>
<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
</c:forEach>
</div>
</body>
</html>
