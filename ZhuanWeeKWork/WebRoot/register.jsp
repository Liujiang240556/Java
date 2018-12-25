<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="css/regist.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body>
  <div class="wrapper">
        <article>
            <h1><span style="color:#000;font-size:40px;">网上书店管理系统</span></h1>
            <div class="main">
                <form action="UsrServlet?action=register" method="post">
                    <div class="tel">
                        <input type="text" name="username_register" placeholder="用户名"><em>由5-8个字符组成！</em>
                    </div>
                    <div class="userName">
                        <input type="password" name="register_mima" placeholder="密码"><em>使用字母数字或者下划线，8-12个字符</em>
                    </div>
                    <div class="userName">
                        <input type="text" name="address" placeholder="地址"><em>只用写市级即可。</em>
                    </div>
                    <div class="password">
                        <input type="text" name="tel" placeholder="手机号"><em>由11个字符组成！</em>
                    </div>
                    <div class="againpwd">
                        <input type="text" name="email" placeholder="请输入邮箱！">
                    </div>
                    <button>注册</button>
                </form>
            </div>
        </article>
    
    </div>
  </body>
</html>
