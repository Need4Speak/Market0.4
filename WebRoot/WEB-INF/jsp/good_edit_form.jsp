<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link href="main.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <div class="container">
    	<%@ include file="bar/categories_bar.jsp"%>
    	<div class="row clearfix" style="margin-top: 50px;">
            <div class="col-md-12 column">
            <form:form commandName="good" action="goodUpdateController" method="post">
                <fieldset>
                    <legend>修改商品信息</legend>
                    <form:hidden path="goodId" />
                    <form:hidden path="status" />
                    <form:hidden path="pictures" />
                    <p>
                        <label for="name">商品名: </label>
                        <form:input id="name" path="name" />
                    </p>
                    <p>
                        <label for="price">价格： </label>
                        <form:input id="price" path="price" />
                    </p>
                    <p>
                        <label for="freight">运费: </label>
                        <form:input id="freight" path="freight" />
                    </p>
                    <p>
                        <label for="description">详细介绍: </label>
                        <form:input id="description" path="description" />
                    </p>
                    <p id="buttons">
                        <input id="reset" type="reset" tabindex="4">
                        <input id="submit" type="submit" tabindex="5" value="确认修改">
                    </p>
                </fieldset>
            </form:form>
        	</div>
        </div>
        <%@ include file="bar/foot_bar.jsp"%>
    </div>
</body>

</html>

