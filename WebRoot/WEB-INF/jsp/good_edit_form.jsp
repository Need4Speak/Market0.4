<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form commandName="good" action="../good_update" method="post">
    <fieldset>
        <legend>修改商品信息</legend>
        <form:hidden path="goodId"/>
        <form:hidden path="status"/>
        <form:hidden path="pictures"/>
        <p>
            <label for="name">商品名: </label>
            <form:input id="name" path="name"/>
        </p>
        <p>
            <label for="price">价格： </label>
            <form:input id="price" path="price"/>
        </p>
       	<p>
            <label for="freight">运费: </label>
            <form:input id="freight" path="freight"/>
        </p>
        <p>
            <label for="description">详细介绍: </label>
            <form:input id="description" path="description"/>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="确认修改">
        </p>
    </fieldset>
</form:form>
</div>
<%@ include file="bar/foot_bar.jsp"%>
</body>
</html>
