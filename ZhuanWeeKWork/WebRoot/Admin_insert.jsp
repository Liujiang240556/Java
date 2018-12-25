<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Admin_insert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#33CCCC">
    <form action="AdminServlet?action=insert" method="post">
    	<table border="1" align="center">
    	
    		<tr>
    			<td>书本名称</td>
    			<td><input type="text" name="book_name"></td>
    		</tr>
    		<tr>
    			<td>书本作者</td>
    			<td><input type="text" name="book_author"></td>
    		</tr>
    		<tr>
    			<td>书本价格</td>
    			<td><input type="text" name="book_price"></td>
    		</tr>
    		<tr>
    			<td>书本描述</td>
    			<td><input type="text" name="book_des"></td>
    		</tr>
    		<tr>
    			<td>书本图片</td>
    			<td><input type="text" name="book_img"></td>
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
