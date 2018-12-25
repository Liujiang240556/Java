<%@page import="com.sicnu.dao.BookDao"%>
<%@page import="com.sicnu.model.BookModel"%>
<%@ page language="java" import="java.util.*,com.sicnu.util.*,java.sql.*" pageEncoding="utf-8" isELIgnored="false"%>
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
	
	
	
	<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
$("tr:even").css("background","#CCCCCC");
$("tr:odd").css("background","#CCFFCC");
})
</script>
  </head>
  
  <body bgcolor="#33CCCC">
  
     <center><h1>欢迎光临网上书店</h1></center>
     <%if(session.getAttribute("u_name")==null){%>
           <jsp:forward page="login.jsp"></jsp:forward>
    <%} else{%>
   <span style="font-size:30px">欢迎：</span><span style="font-size:30px"> ${sessionScope.u_name}</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;        
   <a href="UsrServlet?action=logout"> <span style="font-size:30px">退出</span></a>     <a href="car.jsp">  <span style="font-size:30px;float:right;margin-right: 30px;">我的购物车</span></a> 
    <%}%>
  <center>
      <form action="search.jsp" method="post" accept-charset="utf-8" >
        <input  type="text" name="keyword" style="height: 38px; width: 283px; " placeholder="支持书本名称搜索"></input> 
        <input  type="submit" value="搜索" style="height: 38px; width: 78px; "></input>
      </form>
  </center>
 
  <center>
     <table   border="1"  width="100%"  style="table-layout:fixed" cellpadding="0" cellspacing="0">
      <tr>
      <th style="width: 70px; ">书本编号</th><th style="width: 90px; ">书本名称</th><th style="width: 90px; ">书本作者</th><th style="width: 72px; ">书本价格</th>  <th style="width: 100px; ">书本图片</th> <th style="width: 570px; ">书本描述</th> <th>书本所属类别</th><th>书本类别说明</th><th>操作</th>
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
	        <td><%=bm.getType() %></td>
	        <td><%=bm.getCategory_description() %></td>
	         <td style="text-align: center;margin: 0  auto;"><a href="CartServlet?id=<%=bm.getId() %>" style="font-size:20px;">加入购物车</a></td>
	</tr>
	  <%}%>
	   </table>
<center>
  </body>
</html>
