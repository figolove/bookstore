<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台左侧导航页面</title>
    
     <style type="text/css">
      .dc { 
      		display: none; 
      		margin-left: 10px;
      	  }
	</style>
	
	<script language="javascript">
	      function test(e) {
	            e.style.display = e.style.display == 'block' ? 'none' : 'block' ;       
	      }
	</script>
  </head>
  
  <body>
    <ul>
    	<li>
    		<a href="#" onclick="test(children[0])">分类管理
    			<div class="dc">
	    			 <a href="${pageContext.request.contextPath }/manager/addcategory.jsp"  target="right">添加分类</a><br/>
	    			 <a href="${pageContext.request.contextPath }/manager/ListCategoryServlet"  target="right">查看分类</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">图书管理
    			<div class="dc">
	    				<a href="${pageContext.request.contextPath }/manager/ForAddBookServlet"  target="right">添加图书</a><br/>
	    				<a href="#"  onclick="test(children[0])">查看图书
		    				<div class="dc">
		    					<c:forEach var="category" items="${categorys}">
			    					<a href="${pageContext.request.contextPath }/manager/ListBookByPage?category_id=${category.id }"  target="right">${category.name }</a><br/>
			    				</c:forEach>
		    				</div>
	    				</a>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">订单管理
	    		<div class="dc">
	    			<a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=false"  target="right">待处理订单</a><br/>
	    			<a href="${pageContext.request.contextPath }/manager/ListOrderServlet?state=true"  target="right">已发货订单</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    </ul>
  </body>
</html>
