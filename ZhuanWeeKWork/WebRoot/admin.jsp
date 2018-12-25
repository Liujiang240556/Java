<%@ page language="java" import="java.util.*,com.sicnu.util.*,java.sql.*,com.sicnu.dao.*,com.sicnu.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'andmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
$("tr:even").css("background","#CCCCCC");
$("tr:odd").css("background","#CCFFCC");
})
</script>
  </head>
  
  <body bgcolor="#33CCCC">
    
   <center><h1>网上书店后台管理系统</h1></center>
       <%if(session.getAttribute("u_name")==null){%>
           <jsp:forward page="login.jsp"></jsp:forward>
    <%} else{%>
   <span style="font-size:30px">欢迎：</span><span style="font-size:30px"> ${sessionScope.u_name}</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;        
   <a href="UsrServlet?action=logout"> <span style="font-size:30px;float:right;margin-right: 30px;">退出</span></a>      
    <%}%>
    

   <center>
     <table   border="1"  width="100%"  style="table-layout:fixed" cellpadding="0" cellspacing="0">
      <tr>
      <th style="width: 70px; ">书本编号</th><th style="width: 90px; ">书本名称</th><th style="width: 90px; ">书本作者</th><th style="width: 72px; ">书本价格</th>  <th style="width: 100px; ">书本图片</th> <th style="width: 700px; ">书本描述</th> <th>操作</th>
      </tr>
  
      <%
      BookDao bdao=new BookDao();
      ArrayList<BookModel>  books=bdao.findAllBooks();
      for(int i=0;i<books.size();i++){
         BookModel bm=books.get(i);
       %>
   <tr>
    <td><%=bm.getId()%></td>
	   <td><%=bm.getName()%></td>
	     <td><%=bm.getAuthor() %></td>
	       <td><%=bm.getPrice()%></td>
	         <td>  <img alt=""   src= <%=bm.getImage()%>  style="width:100px;height:130px;">  </td>
	        <p> <td><%=bm.getDescripte() %> </td></p>
	         <td style="text-align: center;margin: 0 auto;"><a href="Admin_insert.jsp">增加书本</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Admin_update.jsp?book_id=<%=bm.getId() %>">修改书本</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="AdminServlet?action=deletebook&id=<%=bm.getId() %>">删除书本</a></td>
	</tr>
	  <%}%>
	   </table>
<center>
  </body>
</html>
