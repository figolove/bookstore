<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listcategory.jsp' starting page</title>
  </head>
  
  <body style="text-align: center">
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>书籍分类信息</h2></caption>
   		
   		<tr>
   			<td>分类名称</td>
   			<td>分类描述</td>
   			<td>操作</td>
   		</tr>
   		
   		<c:forEach var="category" items="${categorys}">
   			<tr>
   				<td>${category.name }</td>
	   			<td>${category.description }</td>
	   			<td>
	   				<a href="${pageContext.request.contextPath }/manager/DeleteCategoryServlet?category_name=${category.name }">删除</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	
   	</table>
   	
  </body>
</html>
