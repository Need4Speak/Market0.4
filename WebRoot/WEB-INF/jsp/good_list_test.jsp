<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="com.pancake.entity.*, com.pancake.dao.*, java.util.Iterator"%>
<%@page import="com.pancake.service.impl.ShowGoodServiceImpl"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order_list_test.jsp' starting page</title>
    
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
  		<div>
  	    <c:forEach items="${page.list}" var="good">
    	<c:if test="${good.status == 1}"> 
	    	<a href="goodInfoController?goodId=${good.goodId}">  
			<table width="250px" height="150px" border="1" cellspacing="0" cellpadding="0">
			  <tr height="20px">
			    <td >卖家昵称:${good.user.userName}</td>
			    <td>价格:${good.price}</td>
			  </tr>
			  <tr>
			    <td width="125px"><img src="images/${fn:split(good.pictures, ', ')[0]}}" border="0" width="120px" height="90px" /></td>
			  </tr>
			  <tr height="50px">
			    <td colspan="2">商品名:${good.name}</td>
			  </tr>
			</table>
			</a>
		</c:if>
	 </c:forEach> 
	 </div>
	 <div>
	  <tr>
	  	<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页<br>
	                
                <a href="showGoods?pageNo=${page.topPageNo }"><input type="button" name="fristPage" value="首页" /></a>
                <c:choose>
                  <c:when test="${page.pageNo!=1}">
                    
                      <a href="showGoodsl?pageNo=${page.previousPageNo }"><input type="button" name="previousPage" value="上一页" /></a>
                    
                  </c:when>
                  <c:otherwise>
                    
                      <input type="button" disabled="disabled" name="previousPage" value="上一页" />
                    
                  </c:otherwise>
                </c:choose>
                <c:choose>
                  <c:when test="${page.pageNo != page.totalPages}">
                    <a href="showGoods?pageNo=${page.nextPageNo }"><input type="button" name="nextPage" value="下一页" /></a>
                  </c:when>
                  <c:otherwise>
                    
                      <input type="button" disabled="disabled" name="nextPage" value="下一页" />
                    
                  </c:otherwise>
                </c:choose>
                <a href="showGoods?pageNo=${page.bottomPageNo }"><input type="button" name="lastPage" value="尾页" /></a>
            </td>
        </tr>
        </div>
  </body>
</html>
