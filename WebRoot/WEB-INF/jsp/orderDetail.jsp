<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderDetail.jsp' starting page</title>
    
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
    卖家：${order.userBySellerId.userName} <br>
    <hr>
	<img src="images/${goodForm.userName}/goodPics/${goodForm.pictures[0]}" border="0" width="120px" height="90px" />
	<br>
	${goodForm.goodName}
	${goodForm.price+goodForm.freight} (含运费： ${goodForm.freight})
	<br>
	<hr>
	卖家昵称：${order.userBySellerId.userName} <br>
	订单编号： ${order.orderId} <br>
	支付宝交易号：<br>
	成交时间：${order.creationTime}
	<br>
	付款    
	<a href="orderCancelController/${order.orderId}">取消交易</a>
	
  </body>
</html>
