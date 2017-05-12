<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>发布商品</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link href="main.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">    
    input {
        border-width: 0px;
        font-size: 14px;
        width: 98%;
    }
    
    input.right {
        width: 70%;
        float: right;
        text-align: right;
        color: red;
    }
    
    .word {
        font-size: 15px;
        color: #000000;
    }
    
    button {
        font-size: 13px;
        letter-spacing: 5px;
        margin-top: 20px;
    }
    </style>
</head>

<body>
    <div class="container">
        <%@ include file="bar/categories_bar.jsp"%>
            <form:form commandName="good" action="good_save" method="post" enctype="multipart/form-data">
                <div class="row clearfix" style="margin-top: 50px;">
                    <div class="col-md-12 column">
                        <form:input id="name" path="name" type="text" name="head" placeholder="标题 品类品牌型号都是买家喜欢搜索的" />
                    </div>
                </div>
                <hr/>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form:input id="description" path="description" type="text" name="description" placeholder="描述一下你的宝贝" />
                    </div>
                </div>
                <hr/>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <span class="word">价格</span>
                        <form:input id="price" path="price" class="right" type="text" name="price" placeholder="￥0" />
                    </div>
                </div>
                <hr/>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <span class="word">分类:</span>
                        <br>
                        <label>
                            <input name="classification_id" type="radio" value="2" />电子产品 </label>
                        <label>
                            <input name="classification_id" type="radio" value="3" />服装 </label>
                        <label>
                            <input name="classification_id" type="radio" value="4" />化妆品 </label>
                        <label>
                            <input name="classification_id" type="radio" value="5" />食品 </label>
                        <label>
                            <input name="classification_id" type="radio" value="6" />图书 </label>
                        <label>
                            <input name="classification_id" type="radio" value="1" checked="checked" />其它 </label>
                    </div>
                </div>
                <hr/>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <span class="word">图片1:</span>
                        <input type="file" name="pictures[0]" />
                        <br>
                        <span class="word">图片2:</span>
                        <input type="file" name="pictures[1]" />
                        <br>
                        <span class="word">图片3:</span>
                        <input type="file" name="pictures[2]" />
                        <br>
                    </div>
                </div>
                <hr/>
                <div class="row clearfix">
                    <div class="col-md-12 column" style="margin-bottom: 50px;">
                        <input type="submit" class="btn btn-default btn-block active btn-danger" value="发布商品">
                    </div>
                </div>
            </form:form>
            
        <%@ include file="bar/foot_bar.jsp"%>
    </div>
    
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>

