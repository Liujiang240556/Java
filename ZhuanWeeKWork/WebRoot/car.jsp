<%@page import="com.sicnu.model.BookModel"%>
<%@ page language="java" import="java.util.*,com.sicnu.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'car.jsp' starting page</title>
    
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
    

   <center><h1>我的购物车</h1></center>
   
   <table width="100%" align="center" border="1px">
     <tr>
         <th>书本编号</th>
        <th>书本名称</th>
         <th>书本单价</th>
         <th>书本数量</th>
         <th>书本小计</th>
     </tr>
     <%
         //1:将添加到购物车里面的物品显示出来
         Map<Integer,CartItem> map=(Map<Integer,CartItem>)session.getAttribute("cart");
         if(map==null){
         
         }else{
        //2:将购物车里面的内容遍历出来
        double count=0;//显示出总价格
         for(Map.Entry<Integer,CartItem> entry : map.entrySet()){
            //计算出每一样的书籍一共花了多少钱
             double price=entry.getValue().getBook().getPrice() * entry.getValue().getQuantity();    
            //计算出一共花了多少钱
             count=count+price;
             
     %>
     <tr align="center">    
         <td><%=entry.getKey() %></td>
        <td><%=entry.getValue().getBook().getName() %></td>
         <td><%=entry.getValue().getBook().getPrice() %></td>
         <td><%=entry.getValue().getQuantity() %></td>
         <td><%=entry.getValue().getBook().getPrice() * entry.getValue().getQuantity()%></td>
         
     </tr>
     <%} %>
    <tr>
        <td colspan="4" align="right">价格总计</td>
         <td><%=count %></td>
    </tr>
    
    
    <%} %>
 </table>
 <div style="text-align:center;font-size:36px;">
    <a href="index.jsp">图书列表</a>
 </div>    
  </body>
</html>
