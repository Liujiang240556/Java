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

 <center><h1>搜索结果</h1></center>
     <%if(session.getAttribute("u_name")==null){%>
           <jsp:forward page="login.jsp"></jsp:forward>
    <%} else{%>
   
    
    <%}%>
    
    
  <center>
      <form action="" method="post">
        <input  type="button" value="返回" style="height: 40px; width: 96px; " onclick="location.href='index.jsp'"></input>
      </form>
  </center>
  <center>
     <table   border="1"  width="100%"  style="table-layout:fixed" cellpadding="0" cellspacing="0">
      <tr>
      <td>书本编号</td><td>书本名称</td><td>书本作者</td><td>书本价格</td><td>书本描述</td><td>书本图片</td><td>书本类别</td><td>操作</td>
      </tr>
  
      <%
     String keyword=request.getParameter("keyword").trim();
     keyword=new String(keyword.getBytes("iso8859-1"),"utf-8");
			DB db=new DB();
			db.openDB();
	  String sql="select * from book where name like '%"+keyword+"%'";
	    Object[] params={};
	  ResultSet rs=db.executeQuery(sql, params);
	  while(rs.next()){
       %>
   <tr>
    <td><%=rs.getString("id")%></td>
	   <td><%=rs.getString("name")%></td>
	     <td><%=rs.getString("author") %></td>
	       <td><%=rs.getString("price") %></td>
	         <td><%=rs.getString("description") %></td>
	          <td>  <img alt=""   src= <%=rs.getString("image")%>  style="width:100px;height:130px;">  </td>
	          <td><%=rs.getString("category_id") %></td>
	         <td><a href="CartServlet?id=<%=rs.getString("id")%>">加入购物车</a></td>
	         
	</tr>
	
	  <%}%>
	  
	 
	  
	  
	   </table>

  </body>
</html>
