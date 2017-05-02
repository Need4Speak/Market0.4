<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<!-- Set jstl var userNameInSession -->
  	<c:set var="userNameInSession" value="${sessionScope.userName}"/>
    <c:choose>
	    <c:when test="${userNameInSession == null}">
	    	<a href="loginBarController">登录</a>
	    </c:when>
	    <c:otherwise>
	    	${userNameInSession}已登录，
	    	<a href="managementController">管理</a>
	    	<a href="logoutController?userName=${userNameInSession}">注销</a>
	    </c:otherwise>
	</c:choose>  	