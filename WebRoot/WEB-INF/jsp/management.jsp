<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
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
        <legend>信息管理</legend>
            <a href="good_list">发布管理</a> <br>
            <a href="orderListController?orderStatus=1">买到的商品</a> <br>
            <a href="SellerOrderListController?orderStatus=1">卖出的商品</a> <br>
            <a href="userInfoController">我的信息</a> <br>
            
    </fieldset>
</form>
</div>
</body>
</html>