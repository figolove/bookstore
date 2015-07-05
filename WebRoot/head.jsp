<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>head</title>
  </head>
  
  <body style="text-align: center">
    <h1>网上书店</h1>
    
    
    <div style="margin-left: 40%;float: left">
    
    <a href="${pageContext.request.contextPath }/client/WelcomeServlet"  target="body">首页</a>
	<a href="${pageContext.request.contextPath }/client/ListCartServlet"  target="body">查看购物车</a>
	<a href="${pageContext.request.contextPath }/client/ListUserOrderServlet"  target="body">查看自己的订单</a>
	 
  	</div>
  	
  	<div style="float: right;">
  		<c:if test="${sessionScope.user==null}">
  			<form action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
	  			用户名：<input type="text" name="name" style="width: 50px">
	  			密码：<input type="password" name="password" style="width: 50px">
	  			<input type="submit" value="登陆">
	  			<input type="button" value="注册" onclick="javascript:window.parent.body.location.href='${pageContext.request.contextPath }/client/register.jsp'">
  			</form>
  			${requestScope.message }
  		</c:if>
  		
  		<c:if test="${sessionScope.user!=null}">
  			欢迎您：${user.name }&nbsp;&nbsp;&nbsp;&nbsp;
  		</c:if>
  	</div>
  	<div style="clear: both"></div>
  
  </body>
</html>
