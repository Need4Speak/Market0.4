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
<h1>商品列表</h1>
<a href="<c:url value="/good_input"/>">发布商品</a>
<a href="showGoodsController">返回首页</a>
<table>
<tr>
    <th>名字</th>
    <th>价格</th>
    <th>运费</th>
    <th>发布时间</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${goods}" var="good">
<c:if test="${good.status == 1}"> 
    <tr>
        <td>${good.name}</td>
        <td>${good.price}</td>
        <td>${good.freight}</td>
        <td>${good.addTime}</td>
        <td><a href="good_edit/${good.goodId}">修改</a></td>
        <td><a href="good_delete/${good.goodId}">删除</a></td>
    </tr>
</c:if>
</c:forEach>
</table>
</div>
</body>
</html>
