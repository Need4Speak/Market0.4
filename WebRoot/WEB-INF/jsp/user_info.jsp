<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>个人资料</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="main.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    .head {
        text-align: center;
    }
    
    .usr-img {
        width: 100px;
        height: 100px;
        padding: auto auto;
        float: right;
        margin-right: 20px;
    }
    
    input {
        border-width: 0px;
        float: right;
        text-align: right;
    }
    
    button {
        letter-spacing: 5px;
        margin-top: 20px;
    }
    </style>
</head>

<body>
    <div class="container">
        <%@ include file="bar/categories_bar.jsp"%>
            <form action="userUpdateController" method="post" enctype="multipart/form-data">
                <div class="row clearfix">
                    <div class="col-xs-12 column">
                        <input type="hidden" name="userId" value="${user.userId}">
                        <span class="head">头像</span> <img src="images/${sessionScope.userName}/head/${user.userPhoto}" class="img-rounded usr-img">
                    </div>
                </div>
                <hr />
                <div class="row clearfix">
                    <div class="col-xs-12 column">
                        修改头像：
                        <input type="file" value="上传图片" name="userPhoto" />
                    </div>
                </div>
                <hr />
                <div class="row clearfix">
                    <div class="col-xs-12 column">
                        <span class="name">用户名</span>
                        <input type="text" name="userName" value="${user.userName}">
                    </div>
                </div>
                <hr />
                <div class="row clearfix ">
                    <div class="col-xs-12 column ">
                        <span class="contact ">联系方式</span>
                        <input type="text" name="phoneNumber" value="${user.phoneNumber}">
                    </div>
                </div>
                <hr />
                <div class="row clearfix ">
                    <div class="col-xs-12 column ">
                        <span class="sex ">性别</span>
                        <input type="text" name="gender" value="${user.gender}">
                    </div>
                </div>
                <hr />
                <div class="row clearfix">
                    <div class="row clearfix">
                        <div class="col-xs-6 column">
                            <button type="submit" class="btn btn-success btn-lg btn-block active">确认修改</button>
                        </div>
                        <div class="col-xs-6 column" style="margin-bottom: 50px;">
                            <button type="button" class="btn btn-danger btn-lg btn-block active" onclick="{location.href='logoutController?userName=${userNameInSession}'}">注 销
                            </button>
                        </div>
                    </div>
                </div>
            </form>
            <%@ include file="bar/foot_bar.jsp"%>
    </div>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>


