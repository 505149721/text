<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"></link>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript"></script>
<style type="text/css">
.li{
background-color:#BDD7CE;
color:black;
font-family:STSong;
}
html,body{
height:100%;
}
.container-fluid{
height:100%;
}
.up{
height:10%;
}
.down{
height:90%;
}
.left{
height:100%;

}
.right{
height:100%;

}
.logo{
width:100px;
opacity:0.7;
}
#ll{
height:20%;
}
nav{
background-color:#B7CDDE;
}
</style>
<title>主页</title>
</head>

<%
String username=(String)session.getAttribute("username");
%>
<body>
<div class="container-fluid">
    <nav class="row up navbar">
    <div class="navbar-header">
      <a class="navbar-brand" href="welcome.jsp">
        <img class="logo" alt="Brand" src="img/hua.jpg">
      </a>
    </div>
    <div id="user" class="navbar-header dropdown col-xs-2 col-xs-offset-8">
  <a class="navbar-brand dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    <%=username %>
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">账户管理</a></li>
    <li role="separator" class="divider"></li>
    <li><a href="loginout.jsp">退出登录</a></li>
  </ul>
</div>
</nav>
  <div class="row down">
    <div class="col-xs-2 left">
    <div id="ll"></div>
    <div class="text-center">
    <a class="row li" href="books/BookServlet?op=findallbypage&curpage=1&pagesize=6" target="findall"><em>&nbsp;&nbsp;书单管理&nbsp;&nbsp;</em></a>
    <a class="row li" href="authors/AuthorServlet?op=findallbypage&curpage=1&pagesize=6" target="findall"><em>&nbsp;&nbsp;作者管理&nbsp;&nbsp;</em></a>
    
    </div>
    
    </div>
    <div class="col-xs-10 right" >
    <iframe id="showall" width="100%" height="95%" src="welcome.jsp" frameborder="0" name="findall"></iframe>
    </div>
</div>
  </div>
</body>
</html>