<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


     <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".name input").focus(function(){
                $(this).prev("i").css({"background-image":"url(img/user2.png)"});
            });
            $(".name input").blur(function(){
                $(this).prev("i").css({"background-image":"url(img/user1.png)"});
            });
            $(".password input").focus(function(){
                $(this).prev("i").css({"background-image":"url(img/password2.png)"});
            });
            $(".password input").blur(function(){
                $(this).prev("i").css({"background-image":"url(img/password1.png)"});
            });
        });
    </script>
  </head>
  
  <body>

  
  <div class="container">
        <div class="wrap">
            <center><header><span><h1>网上书店管理系统</h1></span></header></center>
            <article>
                <section>
                    <aside>
                        <em>
                            <img src="img/user.png">
                        </em>
                         <form action="UsrServlet?action=login" method="post">
                            <p class="name">
                            <i></i>
                            <input type="text" name="userName"  class="userName" placeholder="请输入用户名">
                            </p>
                            <p class="password">
                            <i></i>
                            <input type="password" name="password" class="pwd" placeholder="请输入密码"></p>
                             <p class="password"> <i></i> <input type="text" name="rnd"  placeholder="请输入验证码" style="width: 139px;heigth:20px;" maxlength="4">
                	         <img src="Random.jsp" style="height: 35px; width: 97px;"></p>
                	         <select name="u_type" class="userName" style="width: 125px; height: 39px;margin-top:5px;">
                    	<option value="0">普通用户</option>
                        <option value="1"> 管理员</option>
                    </select></br>
                    <input type="submit" class="loginsss"   value="登录">
              
                            <p class="remember"><input type="checkbox" name="remember">记住密码</p>
                            <p class="regist"><span>没有账号?</span><a href="register.jsp">立即注册</a></p>
                            <div class="clear"></div>
                        </form>
                    </aside>
                   
                </section>               
            </article>
            
        </div>
    </div>
  </body>
</html>
