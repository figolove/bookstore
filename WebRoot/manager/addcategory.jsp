<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加分类页面</title>
  </head>
  
  <body>
    <br/><br/>
    <form action="${pageContext.request.contextPath }/manager/AddCategoryServlet" method="post">
    	<table width="500px;">
    	
    	<tr>
    		<td>分类名称：</td>
    		<td><input type="text" name="name" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>分类描述：</td>
    		<td><textarea rows="4" cols="40" name="description"></textarea></td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="添加分类"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>
