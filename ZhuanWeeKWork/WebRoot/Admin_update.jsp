<%@page import="com.sicnu.dao.BookDao"%>
<%@page import="com.sicnu.model.BookModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Admin_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  String book_id=request.getParameter("book_id");
  BookModel bm=new BookModel();
  BookDao bd=new BookDao();
  bm=bd.findByID(Integer.valueOf(book_id));
   %>
  <body bgcolor="#33CCCC">
        <form action="AdminServlet?action=updatebook&book_id=<%=book_id %>" method="post">
    	<table border="1" align="center">
    	
    		<tr>
    			<td>书本名字</td>
    			<td><input type="text" name="book_name" value="<%=bm.getName() %>"></td>
    		</tr>
    		<tr>
    			<td>书本作者</td>
    			<td><input type="text" name="book_author" value="<%=bm.getAuthor() %>"></td>
    		</tr>
    		<tr>
    			<td>书本价格</td>
    			<td><input type="text" name="book_price" value="<%=bm.getPrice() %>"></td>
    		</tr>
    		<tr>
    			<td>书本描述</td>
    			<td><input type="text" name="book_des"value="<%=bm.getDescripte() %>"></td>
    		</tr>
    			<tr>
    			<td>书本图片</td>
    			<td><input type="text" name="book_img"value="<%=bm.getImage() %>"></td>
    		</tr>
    	
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="提交">
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    		
    	</table>
    </form>
  </body>
</html>
