<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<a href="logoutController?userName=${userNameInSession}">注销</a>
  	<form action="userUpdateController" method="post" enctype="multipart/form-data">
  		<input type="hidden" name="userId" value="${user.userId}">
	    用户名：<input type="text" name="userName" value="${user.userName}">  <br>
	    联系方式：<input type="text" name="phoneNumber" value="${user.phoneNumber}"> <br>
	    性别：<input type="text" name="gender" value="${user.gender}"> <br>
	    头像：	<img src="images/${sessionScope.userName}/head/${user.userPhoto}" border="0" width="120px" height="90px" />
	  <input type="file" value="上传图片" name="userPhoto"/> <br>
	  <input id="submit" type="submit" tabindex="5" value="确认修改">
    </form>
  </body>
</html>
