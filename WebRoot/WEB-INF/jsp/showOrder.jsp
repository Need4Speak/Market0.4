<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
<form action="showGoodsController" method="post">
    <fieldset>
        <legend>订单详情</legend>
            <img src="images/${goodForm.pictures[0]}" border="0" width="120px" height="90px" /> <br/>
           	商品名称: ${goodForm.goodName} <br/>
           	总价: ${goodForm.price + goodForm.freight} ( 含${goodForm.freight}元运费 ) <br/>
           	<br/>
		        收货人: ${orderForm.userByBuyerId.userName} <br/>
		        联系方式: <br/>
		        收货地址： ${orderForm.deliveryAddress} <br/>
		        订单描述：${orderForm.description} <br/>
		    <br/>
		       卖家昵称：${goodForm.userName} <br/>
		       联系方式: <br/>
		       订单编号：${orderForm.orderId} <br/>
		       下单时间：${orderForm.creationTime} <br/>
		    
		    <c:choose>
			    <c:when test="${orderForm.status == 0}">
			       	订单已取消  <a href="showGoodsController">返回首页</a> <br>
			    </c:when>
			    <c:when test="${orderForm.status == 1}">
			       	去支付  <a href="showGoodsController">返回首页</a> <br>
			    </c:when>
			    <c:when test="${orderForm.status == 2}">
			       	已支付  <a href="showGoodsController">返回首页</a> <br>
			    </c:when>
			</c:choose>
		        
    </fieldset>
</form>
</div>
</body>
</html>