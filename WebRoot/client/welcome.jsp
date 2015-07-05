<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'welcome.jsp' starting page</title>
  </head>
  
  <body style="text-align: center">
    <div id="content" style="width: 800px;">
    	
    	<div id="categorys" style="float: left;width: 200px;text-align:left;border: 1px solid #0000FF; height: 200px">
    		书籍分类：
    		<ul>
    		<c:forEach var="category" items="${categorys}">
    			<li><a href="${pageContext.request.contextPath }/client/WelcomeServlet?category_id=${category.id }">${category.name }</a></li>
    		</c:forEach>
    		</ul>
    	</div>
    	
    	<div id="books" style="float: left;text-align:left;padding-left: 100px">
    		<c:forEach var="book" items="${page.list}">
    			<div id="book">
    				<div style="float: left">
    					<img src="${pageContext.request.contextPath }/images/${book.image }">
    				</div>
    				<div  style="float: left">
	    				<ul>
	    					<li>${book.name }</li>
	    					<li>${book.author }</li>
	    					<li>${book.price }</li>
	    					<li><a href="${pageContext.request.contextPath }/client/BuyServlet?bookid=${book.id }">购买</a></li>
	    				</ul>
    				</div>
    				<div style="clear: both"></div>
    				<br/><br/>
    			</div>
    		</c:forEach>
    	</div>
    	<div style="clear: both"></div>
    	<div id="listpagenum">
    			当前第[${page.pagenum }]页&nbsp;&nbsp;
   	
   		<c:forEach var="pageNum" begin="${page.foreachbegin}" end="${page.foreachend}">
   			[<a href="${pageContext.request.contextPath }/client/WelcomeServlet?pageNum=${pageNum }&category_id=${current_category_id }">${pageNum }</a>]
   		</c:forEach>
   	
   		&nbsp;&nbsp;共[${page.totalpage }]页,共[${page.totalrecord }]条记录
    	</div>
    </div>
  </body>
</html>
